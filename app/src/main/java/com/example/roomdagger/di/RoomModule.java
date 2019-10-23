package com.example.roomdagger.di;

import android.app.Application;

import androidx.room.Room;

import com.example.roomdagger.data.ProductDao;
import com.example.roomdagger.repository.DatabaseSchema;
import com.example.roomdagger.repository.ProductDataSource;
import com.example.roomdagger.repository.ProductRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private DatabaseSchema databaseSchema;

    public RoomModule(Application mApplication) {
        databaseSchema = Room.databaseBuilder(mApplication, DatabaseSchema.class, "demo-db").build();
    }

    @Singleton
    @Provides
    ProductRepository productRepository(ProductDataSource productDataSource) {
        return productDataSource;
//                new ProductDataSource(productDao);
    }

    @Singleton
    @Provides
    ProductDao providesProductDao(DatabaseSchema databaseSchema) {
        return databaseSchema.getProductDao();
    }

    @Singleton
    @Provides
    DatabaseSchema providesRoomDatabase() {
        return databaseSchema;
    }
}
