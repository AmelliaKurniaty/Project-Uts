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
import com.example.mobile_uts.Models.Account;

import java.io.IOException;

public class PertandinganActivity extends AppCompatActivity {
    private TextView nama1, nama2, djRed, djBlue;
    private ImageView imgRed, imgBlue;
    private Fight item;
    private int index;
    private Account account;
    public static final String FIGHT_KEY = "FIGHT";
    public static final String INDEX_KEY = "INDEX";
    public static final int UPDATE_REQUEST = 1;

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
        if (extras != null) {
            item = extras.getParcelable(FIGHT_KEY);
            index = extras.getInt(INDEX_KEY, 0);
            nama1.setText(item.getNama1());
            nama2.setText(item.getNama2());
            djRed.setText(item.getDojang1());
            djBlue.setText(item.getDojang2());
            Bitmap bitmap1 = null;
            Bitmap bitmap2 = null;

            try {
                bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), item.getImg1());
                bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), item.getImg2());
            } catch (IOException e) {
                e.printStackTrace();
            }
            imgRed.setImageBitmap(bitmap1);
            imgBlue.setImageBitmap(bitmap2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Fight fight = data.getParcelableExtra(FIGHT_KEY);
            if (requestCode == UPDATE_REQUEST){
                account.updateFight(index, fight);
                nama1.setText(item.getNama1());
                nama2.setText(item.getNama2());
                djRed.setText(item.getDojang1());
                djBlue.setText(item.getDojang2());

                Bitmap bitmap1 = null;
                Bitmap bitmap2 = null;

                try {
                    bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), item.getImg1());
                    bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), item.getImg2());
                }catch (IOException e){
                    e.printStackTrace();
                }
                imgRed.setImageBitmap(bitmap1);
                imgBlue.setImageBitmap(bitmap2);
            }
        }
    }
}
