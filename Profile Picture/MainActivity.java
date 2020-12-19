package com.pf.tutorial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewProfilePicture, imageViewGallery, imageViewCamera;
    private final int PermissionRequestId= 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewProfilePicture = findViewById(R.id.imageViewMainActivityProfilePicture);
        imageViewGallery = findViewById(R.id.imageViewMainActivityGallery);
        imageViewCamera = findViewById(R.id.imageViewMainActivityCamera);

        imageViewGallery.setOnClickListener(view -> {
            takePictureFromGallery();
        });

        imageViewCamera.setOnClickListener(view -> {
            if (checkAndRequestPermissions())
                takePictureFromCamera();
        });
    }

    private  void takePictureFromGallery(){
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 1);
    }

    private void takePictureFromCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK) {
                    Uri selectedImageUri = data.getData();
                    imageViewProfilePicture.setImageURI(selectedImageUri);
                }
            break;
            case 2:
                if(resultCode == RESULT_OK){
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    imageViewProfilePicture.setImageBitmap(imageBitmap);
                }
            break;
        }
    }

    private boolean checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            int camera = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
            if (camera != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, PermissionRequestId);
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionRequestId && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            takePictureFromCamera();
        }
        else{
            Toast.makeText(MainActivity.this, "Permission not Granted...", Toast.LENGTH_SHORT).show();
        }
    }
}
