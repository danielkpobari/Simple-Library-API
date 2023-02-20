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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoritesRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public Favorites addToFavorites(FavoriteRequest favoritesRequest) {
        UserEntity user = userRepository.findById(1L).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Book book = bookRepository.findById(favoritesRequest.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));

        Favorites favorites = favoritesRepository.findByUserAndBook(user, book);
        if (favorites != null) {
            throw new RuntimeException("Book already in favorites");
        }
        Favorites newFavorites = new Favorites();
        newFavorites.setBook(book);
        newFavorites.setUser(user);
        return favoritesRepository.save(newFavorites);
    }
}
