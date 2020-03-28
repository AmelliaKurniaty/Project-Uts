package com.example.mobile_uts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile_uts.Models.Fight;

public class IsiDataActivity  extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();

    private RadioGroup typeRadioGroup;
    private Fight item;
    Uri imageUri1, getImageUri2;
    Bitmap bitmap1, bitmap2;
    ImageView imgMerah, imageBiru;
    EditText nameRed, nameBlue, djRed, djBlue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isidata);
        imgMerah = findViewById(R.id.img_merah);
        imageBiru = findViewById(R.id.img_biru);
        nameRed = findViewById(R.id.nama1);
        nameBlue = findViewById(R.id.nama2);
        djRed = findViewById(R.id.dojang1);
        djBlue = findViewById(R.id.dojang2);
        typeRadioGroup = findViewById(R.id.group_type);
    }

    public void handleMerah(View view) {
    }

    public void handleBiru(View view) {
    }

    public void handleTambah(View view) {
        Intent intent = new Intent(this, PertandinganActivity.class);
        startActivity(intent);
    }
}
