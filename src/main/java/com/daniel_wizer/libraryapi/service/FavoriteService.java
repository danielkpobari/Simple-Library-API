package com.daniel_wizer.libraryapi.service;

import com.daniel_wizer.libraryapi.models.Favorites;
import com.daniel_wizer.libraryapi.payload.request.FavoriteRequest;

import java.util.List;

public interface FavoriteService {
   List<Favorites> addToFavorites(FavoriteRequest favoritesRequest);
}
