package com.example.mobile_uts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile_uts.Models.Fight;

import java.io.IOException;

public class IsiDataActivity  extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final String FIGHT = "fights";
    private static final String INDEX_KEY = "index";
    private static final int LOGIN_ADD = 1;
    private static final int IMAGE_ADD = 2;

    private RadioGroup typeRadioGroup;
    private Fight item;
    private int index;
    Uri imageUri1, imageUri2;
    Bitmap bitmap1, bitmap2;
    ImageView imgMerah, imgBiru;
    EditText nameRed, nameBlue, djRed, djBlue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isidata);

        imgMerah = findViewById(R.id.img_merah);
        imgBiru = findViewById(R.id.img_biru);
        nameRed = findViewById(R.id.nama1);
        nameBlue = findViewById(R.id.nama2);
        djRed = findViewById(R.id.dojang1);
        djBlue = findViewById(R.id.dojang2);
        typeRadioGroup = findViewById(R.id.group_type);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            item = extras.getParcelable(MainActivity.FIGHT_KEY);
            index = extras.getInt(MainActivity.INDEX_KEY,0);

//            imgMerah = extras.getParcelable(IMG_1);
//            imgBiru = extras.getParcelable(IMG_2);

            nameRed.setText(item.getNama1());
            nameBlue.setText(item.getNama2());
            djRed.setText(item.getDojang1());
            djBlue.setText(item.getDojang2());

            if (imageUri1 != null){
                try {
                    Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), item.getImg1());
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), item.getImg2());
                    imgMerah.setImageBitmap(bitmap1);

                }catch (IOException e){
                    Toast.makeText(this, "Cant load image", Toast.LENGTH_SHORT).show();
                    Log.e("Image Insert", e.getMessage());
                }
            }
            if (item.getType() == Fight.Type.MALE){
                typeRadioGroup.check(R.id.radio_male);
            }else if (item.getType() == Fight.Type.FEMALE){
                typeRadioGroup.check(R.id.radio_female);
            }
        }
    }
    private Fight.Type getCheckedType(){
        if (typeRadioGroup.getCheckedRadioButtonId() == R.id.radio_male) {
            return Fight.Type.MALE;
        } else if (typeRadioGroup.getCheckedRadioButtonId() == R.id.radio_female) {
            return Fight.Type.FEMALE;
        }
        return Fight.Type.EMPTY;
    }

    public void handleMerah(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void handleBiru(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);
    }

    public void submit(View view){
        String name1 = nameRed.getText().toString().trim();
        String name2 = nameBlue.getText().toString().trim();
        String dj1 = djRed.getText().toString().trim();
        String dj2 = djBlue.getText().toString().trim();

        item.setNama1(name1);
        item.setNama2(name2);
        item.setDojang1(dj1);
        item.setDojang2(dj2);
        if (this.imageUri1 == null){
            item.setImg1(item.getImg1());
        }else if (this.imageUri2 == null){
            item.setImg2(item.getImg2());
        }

        Intent intent = new Intent();
        intent.putExtra(FIGHT, item);
        intent.putExtra(INDEX_KEY, index);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (data != null) {
                try {
                    imageUri1 = data.getData();
                    Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri1);
                    imgMerah.setImageBitmap(bitmap1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == 2) {
            if (data != null){
                try {
                    imageUri2 = data.getData();
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri2);
                    imgBiru.setImageBitmap(bitmap2);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}