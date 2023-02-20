package com.daniel_wizer.libraryapi.models;

import com.daniel_wizer.libraryapi.models.audit.DateAudit;
import com.daniel_wizer.libraryapi.models.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Favorites extends DateAudit {
    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private Book book;
}
