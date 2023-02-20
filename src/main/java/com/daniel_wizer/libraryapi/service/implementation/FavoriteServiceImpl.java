package com.daniel_wizer.libraryapi.service.implementation;

import com.daniel_wizer.libraryapi.models.Book;
import com.daniel_wizer.libraryapi.models.Favorites;
import com.daniel_wizer.libraryapi.models.users.UserEntity;
import com.daniel_wizer.libraryapi.payload.request.FavoriteRequest;
import com.daniel_wizer.libraryapi.payload.response.Response;
import com.daniel_wizer.libraryapi.repositories.BookRepository;
import com.daniel_wizer.libraryapi.repositories.FavoriteRepository;
import com.daniel_wizer.libraryapi.repositories.users.UserRepository;
import com.daniel_wizer.libraryapi.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoritesRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public List<Favorites> addToFavorites(FavoriteRequest favoritesRequest) {
        Book book = bookRepository.findById(favoritesRequest.getBookId()).get();
        UserEntity user = userRepository.findByEmail(favoritesRequest.getEmail()).get();

        Favorites favorites = new Favorites();
        favorites.setBook(book);
        favorites.setUser(user);
        favoritesRepository.save(favorites);
        return favoritesRepository.findAllByUser(user);
    }
}
