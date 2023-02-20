package com.daniel_wizer.libraryapi.repositories;

import com.daniel_wizer.libraryapi.models.Favorites;
import com.daniel_wizer.libraryapi.models.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorites, Long> {

    List<Favorites> findAllByUser(UserEntity user);

}
