package com.example.roomdagger.repository;

import androidx.lifecycle.LiveData;

import com.example.roomdagger.data.Product;

import java.util.List;

import io.reactivex.Completable;

public interface ProductRepository {
    int delete(Product product);

    //    long insert(Product product);
    Completable insert(Product product);

    LiveData<Product> findById(int id);

    LiveData<List<Product>> findAll();
}
