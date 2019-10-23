package com.example.roomdagger.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdagger.data.Product;
import com.example.roomdagger.data.ProductDao;

@Database(entities = {Product.class}, version = DatabaseSchema.VERSION)
public abstract class DatabaseSchema extends RoomDatabase {
    static final int VERSION = 1;

    public abstract ProductDao getProductDao();
}
