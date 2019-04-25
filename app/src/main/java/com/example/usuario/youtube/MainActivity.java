package com.example.usuario.youtube;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends permision implements per {
    VideoView miVideo1, miVideo2,miVideo3;
    int oldCurrentPosition=-1;
    private static final int permission_stor=1;
    @Override
    protected void onPause() {
        super.onPause();
        oldCurrentPosition=miVideo1.getCurrentPosition();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (oldCurrentPosition!=-1){
            miVideo1.seekTo(oldCurrentPosition);
            miVideo1.start();
        }
    }
    @Override
    public  void onRequestPermission(int requestCode,String permissions[], int []grantResults){
        switch (requestCode){
            case permission_stor:{
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){

                }else{

                }
                return;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miVideo1 = (VideoView) findViewById(R.id.videoView);
        miVideo2 = (VideoView) findViewById(R.id.videoView2);
        miVideo3 = (VideoView) findViewById(R.id.videoView3);
        String vid1="android.resource://"+getPackageName()+"/"+R.raw.vid1;
        String mdoz ="android.resource://"+getPackageName()+"/"+R.raw.mdoz;
        String fp ="android.resource://"+getPackageName()+"/"+R.raw.fp;
        miVideo1.setVideoURI(Uri.parse(vid1));
        MediaController control= new MediaController(this);
        miVideo1.setMediaController(control);
        control.setAnchorView(miVideo1);
        final Button like=findViewById(R.id.like);
        Button dislike=findViewById(R.id.dislike);
        Button  share =findViewById(R.id.share);
        Button save = findViewById(R.id.save);
        Button download = findViewById(R.id.download);
        Button sus= findViewById(R.id.subscribe);
        Button next=findViewById(R.id.button5);
        Button next2=findViewById(R.id.button6);
        final Intent intent=new Intent(this,Drawer_Activity.class);
        int permissioncheck = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //si nos concede el permiso, lanza la llamada y lanza el toast
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){

            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},permission_stor);
            }
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mdoz ="android.resource://"+getPackageName()+"/"+R.raw.mdoz;
                miVideo1.setVideoURI(Uri.parse(mdoz));
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fp ="android.resource://"+getPackageName()+"/"+R.raw.fp;
                miVideo1.setVideoURI(Uri.parse(fp));
            }
        });
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "LIKE!!", Toast.LENGTH_SHORT).show();
            }
        });
        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "DISLIKE!!", Toast.LENGTH_SHORT).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ENVIADO!!!", Toast.LENGTH_SHORT).show();
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "DESCARGADO!!", Toast.LENGTH_SHORT).show();

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "GUARDADO!!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                intent.putExtra("Videoid","123abc");
            }
        });
        sus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "SUSCRITO!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
