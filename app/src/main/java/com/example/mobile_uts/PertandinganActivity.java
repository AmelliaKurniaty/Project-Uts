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

import com.example.mobile_uts.Models.Fight;

import java.io.IOException;

public class PertandinganActivity extends AppCompatActivity {
    private TextView nama1, nama2, djRed, djBlue;
    private ImageView imgRed, imgBlue;
    Uri uri1, uri2;
    Bitmap bitmap1, bitmap2;
    private Fight item;
    private int index;
    private String nameRed, nameBlue;
//    public static final String FIGHT_KEY = "FIGHT";
//    public static final String INDEX_KEY = "INDEX";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertandingan);
//        imgRed = findViewById(R.id.red);
//        imgBlue = findViewById(R.id.blue);
//        nama1 = findViewById(R.id.nama1);
//        nama2 = findViewById(R.id.nama2);
//        djRed = findViewById(R.id.dojang1);
//        djBlue = findViewById(R.id.dojang2);
//
//        Bundle extras = getIntent().getExtras();
//        item = extras.getParcelable(MainActivity.FIGHT_KEY);
//        index = extras.getInt(MainActivity.INDEX_KEY, 0);
//
//        nameRed = nama1.getText().toString();
//        nameBlue = nama2.getText().toString();
//        String dj1 = djRed.getText().toString();
//        String dj2 = djBlue.getText().toString();


//        if (extras != null) {
//            uri1 = Uri.parse(extras.getString("logoRed"));
//            uri2 = Uri.parse(extras.getString("logoBlue"));
//            bitmap1 = null;
//            bitmap2 = null;
//            try {
//                bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri1);
//                bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri1);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//            item.setNama1(nameRed);
//            item.setNama1(nameBlue);
//            item.setDojang1(dj1);
//            item.setDojang2(dj2);
//            imgRed.setImageBitmap(bitmap1);
//            imgBlue.setImageBitmap(bitmap2);
        }
    }
