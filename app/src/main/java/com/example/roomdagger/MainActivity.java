package com.example.roomdagger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.roomdagger.data.Product;
import com.example.roomdagger.di.AppModule;
import com.example.roomdagger.di.DaggerAppComponent;
import com.example.roomdagger.di.RoomModule;
import com.example.roomdagger.repository.ProductDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    public ProductDataSource productDataSource;
//    public ProductRepository productRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);


        Button btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Product p = new Product("Nueva 001", "Pruebas");
                productDataSource.insert(p).subscribeOn(Schedulers.io()).subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

            }
        });


        getAll();

    }

    public void getAll() {
        productDataSource.findAll().observe(MainActivity.this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                Toast.makeText(MainActivity.this, String.format("Product  size: %s", products.size()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
