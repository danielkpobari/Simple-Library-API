package com.daniel_wizer.libraryapi.controllers;

import com.daniel_wizer.libraryapi.payload.request.FavoriteRequest;
import com.daniel_wizer.libraryapi.service.FavoriteService;
import com.daniel_wizer.libraryapi.service.implementation.FavoriteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/favorites")
public class FavoriteController {
    FavoriteService favoriteService;


    @PostMapping("/add-to-favorites")
    public ResponseEntity<?> addToFavorites(@Valid @RequestBody FavoriteRequest favoriteRequest) {
       return new ResponseEntity<>(favoriteService.addToFavorites(favoriteRequest), HttpStatus.CREATED);
    }
}
