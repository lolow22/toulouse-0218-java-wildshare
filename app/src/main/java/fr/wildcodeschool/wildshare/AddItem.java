package fr.wildcodeschool.wildshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AddItem extends AppCompatActivity {

    ImageView imgChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        EditText nameItem = findViewById(R.id.et_newItemName);
        EditText nameDesc = findViewById(R.id.et_description);
        final EditText edLink = findViewById(R.id.editText_link);
        Button btnCamera = findViewById(R.id.button_camera);
        Button btnGallery = findViewById(R.id.button_gallery);
        Button btnLink = findViewById(R.id.button_link);
        Button addItem = findViewById(R.id.b_addToData);
        final Button btnOK = findViewById(R.id.button_ok);
        imgChoose = findViewById(R.id.iv_img_choose);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, 0);
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
                startActivityForResult(galleryIntent, 1);
            }
        });


        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edLink.setVisibility(View.VISIBLE);
                btnOK.setVisibility(View.VISIBLE);

            }
        });


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String link = edLink.getText().toString();
                Glide.with(AddItem.this).load(link) .into(imgChoose);
            }
        });
        /*Button buttonvalid = findViewById(R.id.button_ok);
        buttonvalid.setOnClickListener();*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap) imageReturnedIntent.getExtras().get("data");
                    imgChoose.setImageBitmap(bitmap);
                }
                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imgChoose.setImageURI(selectedImage);
                }
                break;
        }
    }

}