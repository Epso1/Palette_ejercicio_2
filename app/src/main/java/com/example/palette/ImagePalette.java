package com.example.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;

public class ImagePalette extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_palette);

        // Configura la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtén la imagen seleccionada del Intent
        int selectedImage = getIntent().getIntExtra("image_resource", 0);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), selectedImage);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                // Obtiene la paleta de colores de la imagen
                int vibrantColor = palette.getVibrantColor(0);
                int darkVibrantColor = palette.getDarkVibrantColor(0);
                int lightVibrantColor = palette.getLightVibrantColor(0);
                int mutedColor = palette.getMutedColor(0);
                int darkMutedColor = palette.getDarkMutedColor(0);
                int lightMutedColor = palette.getLightMutedColor(0);

                toolbar.setBackgroundColor(vibrantColor);
                toolbar.setTitleTextColor(lightVibrantColor);

                getWindow().setStatusBarColor(darkVibrantColor);

                TextView lightVibrantTv = findViewById(R.id.light_vibrant_tv);
                lightVibrantTv.setBackgroundColor(lightVibrantColor);
                lightVibrantTv.setTextColor(vibrantColor);

                TextView mutedTv = findViewById(R.id.muted_tv);
                mutedTv.setBackgroundColor(mutedColor);
                mutedTv.setTextColor(darkMutedColor);

                TextView darkMutedTv = findViewById(R.id.dark_muted_tv);
                darkMutedTv.setBackgroundColor(darkMutedColor);
                darkMutedTv.setTextColor(mutedColor);

                TextView lightMutedTv = findViewById(R.id.light_muted_tv);
                lightMutedTv.setBackgroundColor(lightMutedColor);
                lightMutedTv.setTextColor(darkMutedColor);


            }
        });
        // Configura la imagen en el ImageView
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(selectedImage);
    }
}
