package com.example.roomdagger.data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM Product WHERE id=:id")
    LiveData<Product> findById(int id);

    @Query("SELECT * FROM Product")
    LiveData<List<Product>> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(Product product);

    @Delete
    int delete(Product product);

}
