package com.example.roomdagger.repository;

import androidx.lifecycle.LiveData;

import com.example.roomdagger.data.Product;
import com.example.roomdagger.data.ProductDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

public class ProductDataSource implements ProductRepository {
    private ProductDao productDao;

    @Inject
    public ProductDataSource(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public int delete(Product product) {
        return productDao.delete(product);
    }

    @Override
    public Completable insert(Product product) {
        return productDao.insert(product);
    }


    @Override
    public LiveData<Product> findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public LiveData<List<Product>> findAll() {
        return productDao.findAll();
    }
}
