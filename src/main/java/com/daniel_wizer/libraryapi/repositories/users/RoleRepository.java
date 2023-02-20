package com.daniel_wizer.libraryapi.repositories.users;


import com.daniel_wizer.libraryapi.models.users.Role;
import com.daniel_wizer.libraryapi.models.users.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
