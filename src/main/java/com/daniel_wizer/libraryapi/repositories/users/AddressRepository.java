package com.daniel_wizer.libraryapi.repositories.users;


import com.daniel_wizer.libraryapi.models.users.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
