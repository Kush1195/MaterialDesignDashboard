package com.example.kushal.materialdesigndashboard;

import android.content.Intent;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    ImageView camera,gallery,filemanager,bluetooth,setting;

    public static final int REQUEST_CAMERA = 1;
    public static final int REQUEST_GALLERY = 0;
    public static final int REQUEST_FILE_MANAGER = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = (ImageView) findViewById(R.id.camera);
        gallery = (ImageView) findViewById(R.id.albums);
        filemanager = (ImageView) findViewById(R.id.filemanager);
        bluetooth = (ImageView) findViewById(R.id.bluetooth);
        setting = (ImageView) findViewById(R.id.setting);

        camera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CAMERA);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,REQUEST_GALLERY);
            }
        });

        filemanager.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,REQUEST_FILE_MANAGER);
            }
        });

        bluetooth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
            }
        });

        setting.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
    }
}
