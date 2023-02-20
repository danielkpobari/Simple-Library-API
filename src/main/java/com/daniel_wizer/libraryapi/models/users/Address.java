package com.daniel_wizer.libraryapi.models.users;

import com.daniel_wizer.libraryapi.models.audit.DateAudit;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address extends DateAudit {

    @Column(nullable = false)
    @NotBlank(message = "Address cannot be empty")
    private String addresss;

    //    @Field("city")
//    private String city;

//    private UserEntity user;
}
