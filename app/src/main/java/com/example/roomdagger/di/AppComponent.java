package com.example.roomdagger.di;

import android.app.Application;

import com.example.roomdagger.MainActivity;
import com.example.roomdagger.data.ProductDao;
import com.example.roomdagger.repository.DatabaseSchema;
import com.example.roomdagger.repository.ProductRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    Application application();

    ProductDao productDao();

    DatabaseSchema databaseSchema();

    ProductRepository productRepository();


}
