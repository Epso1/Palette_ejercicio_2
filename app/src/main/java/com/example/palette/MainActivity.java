package com.example.palette;

import android.os.Bundle;
import android.transition.Slide;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_main);

        // Indica la animación de reentrada en este caso Slide
        Slide in = new Slide();
        in.setDuration(1000);
        getWindow().setReenterTransition(in);

        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        ArrayList<Tarjeta> items = new ArrayList<>();
        items.add(new Tarjeta(R.drawable.image1));
        items.add(new Tarjeta(R.drawable.image2));
        items.add(new Tarjeta(R.drawable.image3));
        items.add(new Tarjeta(R.drawable.image4));
        items.add(new Tarjeta(R.drawable.image5));
        items.add(new Tarjeta(R.drawable.image6));
        items.add(new Tarjeta(R.drawable.image7));
        items.add(new Tarjeta(R.drawable.image8));

        RecyclerView recView = findViewById(R.id.recview);

        recView.setHasFixedSize(true);

        CardsAdapter adaptador = new CardsAdapter(items);
        recView.setAdapter(adaptador);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}
