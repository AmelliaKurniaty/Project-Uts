package com.example.mobile_uts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class PertandinganActivity extends AppCompatActivity {
    private TextView nama1, nama2, djRed, djBlue;
    private ImageView imgRed, imgBlue;
    Uri uri1, uri2;
    Bitmap bitmap1, bitmap2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertandingan);
        imgRed = findViewById(R.id.red);
        imgBlue = findViewById(R.id.blue);
        nama1 = findViewById(R.id.nama1);
        nama2 = findViewById(R.id.nama2);
        djRed = findViewById(R.id.dojang1);
        djBlue = findViewById(R.id.dojang2);

        Bundle extras = getIntent().getExtras();


        try {
            bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri1);
            bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri1);
        }catch (IOException e){
            e.printStackTrace();
        }
//        nama1.setText();
//        nama2.setText(nameBlue);

    }

    public void HandleResult(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
