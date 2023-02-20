package com.daniel_wizer.libraryapi.service.implementation;

import com.daniel_wizer.libraryapi.exceptions.BadRequestException;
import com.daniel_wizer.libraryapi.security.Service.UserDetailService;
import com.daniel_wizer.libraryapi.service.UserService;
import com.daniel_wizer.libraryapi.models.users.Address;
import com.daniel_wizer.libraryapi.models.users.UserEntity;
import com.daniel_wizer.libraryapi.models.users.enums.ERole;
import com.daniel_wizer.libraryapi.payload.request.LoginRequest;
import com.daniel_wizer.libraryapi.payload.request.RegistrationRequest;
import com.daniel_wizer.libraryapi.payload.response.LoginResponse;
import com.daniel_wizer.libraryapi.payload.response.RegistrationResponse;
import com.daniel_wizer.libraryapi.repositories.users.AddressRepository;
import com.daniel_wizer.libraryapi.repositories.users.UserRepository;
import com.daniel_wizer.libraryapi.utility.JWTUtils;
import com.daniel_wizer.libraryapi.utility.Utility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailService userDetailService;
    private final AddressRepository addressRepository;
    private final JWTUtils jwtUtil;
    private final Utility utility;

//    NEW STUFF
    @Override
    public RegistrationResponse registration(RegistrationRequest userRegistrationRequest, ERole eRole) {

        if(existsByMail(userRegistrationRequest.getEmail())){
            throw new BadRequestException("Error: Email is already taken!");
        }

        if(!isValidEmail(userRegistrationRequest.getEmail())){
            throw new BadRequestException("Error: Email must be valid");
        }

        if(!(userRegistrationRequest.getPassword().equals(userRegistrationRequest.getConfirmPassword()))){
            throw new BadRequestException("Error: Password does not match");
        }

        if(userRegistrationRequest.getPassword().length() < 8 || userRegistrationRequest.getConfirmPassword().length() < 8 ){
            throw new BadRequestException("Error: Password is too short");
        }

        if(!isValidPassword(userRegistrationRequest.getPassword())){
            throw new BadRequestException("Error: password must contain at least 8 characters, Uppercase, LowerCase and Number");
        }

        Address address = new Address(userRegistrationRequest.getAddress());
        addressRepository.save(address);

        UserEntity user = new UserEntity(
                userRegistrationRequest.getFirstName(),
                userRegistrationRequest.getLastName(),
                userRegistrationRequest.getEmail(),
                bCryptPasswordEncoder.encode(userRegistrationRequest.getPassword()),
                address);

        user.setRoles(utility.assignRole(eRole));
        saveUser(user);

        return RegistrationResponse.build(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        log.info("User logging in: UserServiceImplementation");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailService.loadUserByUsername(loginRequest.getEmail());

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        String role = null;
        for (String r : roles) if (r != null) role = r;

        final String jwtToken = jwtUtil.generateToken(userDetails);
        return new LoginResponse(jwtToken, role);
    }

    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
//        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            throw new BadRequestException("Error: Password cannot be null");
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }


    private boolean isValidEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        if (email == null) {
            throw new BadRequestException("Error: Email cannot be null");
        }
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private void saveUser(UserEntity user) {
         userRepository.save(user);
    }


    private boolean existsByMail(String email) {
        return userRepository.existsByEmail(email);
    }



}
