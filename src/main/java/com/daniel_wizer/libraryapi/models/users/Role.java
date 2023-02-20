package com.daniel_wizer.libraryapi.models.users;

import com.daniel_wizer.libraryapi.models.users.enums.ERole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ERole", nullable = false)
    @NotBlank(message = "Role cannot be empty")
    @Enumerated(EnumType.STRING)
    private ERole name;
}
