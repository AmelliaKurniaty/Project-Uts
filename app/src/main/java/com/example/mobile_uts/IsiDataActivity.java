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

    private RadioGroup typeRadioGroup;
    private Fight item;
    private int index;
    Uri imageUri1, imageUri2;
    Bitmap bitmap1, bitmap2;
    ImageView imgMerah, imageBiru;
    EditText nameRed, nameBlue, djRed, djBlue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isidata);

//        imgMerah = findViewById(R.id.img_merah);
//        imageBiru = findViewById(R.id.img_biru);
        nameRed = findViewById(R.id.nama1);
        nameBlue = findViewById(R.id.nama2);
        djRed = findViewById(R.id.dojang1);
        djBlue = findViewById(R.id.dojang2);
        typeRadioGroup = findViewById(R.id.group_type);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            item = extras.getParcelable(MainActivity.FIGHT_KEY);
            index = extras.getInt(MainActivity.INDEX_KEY,0);

//            imgMerah.setImageBitmap(item.getImg1());
//            imgMerah.setImageBitmap(item.getImg2());
            nameRed.setText(item.getNama1());
            nameBlue.setText(item.getNama2());
            djRed.setText(item.getDojang1());
            djBlue.setText(item.getDojang2());

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
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void handleBiru(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);
    }

    public void handleTambah(View view) {
        int eror = 3;
        if (typeRadioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Jenis Kelamin tidak boleh kosong", Toast.LENGTH_SHORT).show();
            if (nameRed.getText().toString().isEmpty() && nameBlue.getText().toString().isEmpty()){
                nameRed.setError("Nama tidak boleh kosong");
                nameBlue.setError("Nama tidak boleh Kosong");
                if (djRed.getText().toString().isEmpty() && djBlue.getText().toString().isEmpty()){
                    djRed.setError("Dojang tidak boleh kosong");
                    djBlue.setError("Dojang tidak boleh kosong");
                }else {
                    eror = -1;
                }
            }else {
                eror = -1;
            }
        }else {
            String name1 = nameRed.getText().toString();
            String name2 = nameBlue.getText().toString();
            String dj1 = djRed.getText().toString();
            String dj2 = djBlue.getText().toString();
//            Uri img1 = imageUri1.toString();
//            Uri img2 = imageUri2.toString();
            Fight.Type type = getCheckedType();

            item.setNama1(name1);
            item.setNama2(name2);
            item.setDojang1(dj1);
            item.setDojang2(dj2);
            //image 1
            //image 2
            item.setType(type);

            Intent intent = new Intent();
            intent.putExtra(MainActivity.FIGHT_KEY, item);
            intent.putExtra(MainActivity.INDEX_KEY, index);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if (requestCode == 1) {
            if (data != null) {
                try {
                    imageUri1 = data.getData();
                    bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri1);
                    imgMerah.setImageBitmap(bitmap1);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't Load Image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        } else if (requestCode == 2) {
            if (data != null) {
                try {
                    imageUri2 = data.getData();
                    bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri2);
                    imageBiru.setImageBitmap(bitmap2);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't Load Image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}
