package com.example.adeba001.ejemplotta_1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class ExerciseActivity extends ModelActivity {

    public final static int READ_REQUEST_CODE=1;
    public final static int VIDEO_REQUEST_CODE=2;
    public final static int AUDIO_REQUEST_CODE=3;
    public final static int PICTURE_REQUEST_CODE=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    private Uri pictureUri;

    public void subirFichero(View view){


        Toast toast = Toast.makeText(this, "No implementada la accion de subirFichero", Toast.LENGTH_SHORT);
        toast.show();

    }

    public void sacarFoto(View view){

        Toast.makeText(this,"Entramos en sacar foto",Toast.LENGTH_SHORT).show();
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this,R.string.no_camera,Toast.LENGTH_SHORT).show();
        else{
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager())!=null)
            {
                File dir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                try {
                    Toast.makeText(this,"entramos en try",Toast.LENGTH_SHORT).show();
                    File file = File.createTempFile("tta",".jpg", dir);
                    pictureUri=Uri.fromFile(file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                    Toast.makeText(this,"Todo bien",Toast.LENGTH_SHORT).show();
                    startActivityForResult(intent,PICTURE_REQUEST_CODE);

                }catch (IOException e){
                    Toast.makeText(this,"Excepcion!!!!",Toast.LENGTH_SHORT);
                }
            }
            else{Toast.makeText(this,R.string.no_app,Toast.LENGTH_SHORT).show();}

        }
    }

    public void recordAudio(View view)
    {
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
            Toast.makeText(this,R.string.no_micro,Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
            else
                Toast.makeText(this, R.string.no_app, Toast.LENGTH_SHORT).show();

            }
    }

    public void recordVideo(View view)
    {

        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this,R.string.no_camera,Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivityForResult(intent, VIDEO_REQUEST_CODE);
            else
                Toast.makeText(this, R.string.no_app, Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if (resultCode!= Activity.RESULT_OK)
        return;
        switch (requestCode)
        {
            case READ_REQUEST_CODE:
            case VIDEO_REQUEST_CODE:
            case AUDIO_REQUEST_CODE:
                //sendFile(data.getData());
                break;
            case PICTURE_REQUEST_CODE:
                //sendFile(pictureUri);

        }

    }
    public void sendFile(View view)
    {

    }
    protected <T> void startModelActivity(Class<T> cls){
        Intent intent= newIntent(cls);
        startActivity(intent);
    }

    protected <T> void startModelActivityForResult(Class<T> cls,int requestCode)
    {
        Intent intent=newIntent(cls);
        startActivityForResult(intent,requestCode);
    }

    protected <T> Intent newIntent(Class<T> cls){

        Intent intent= new Intent(getApplicationContext(),cls);
        intent.putExtras(data.getBundle());// metemos los datos de la actividad a si la nueva clase
        //que se crea coge los datos de la actividad, propagamos los datos
        return intent;
    }

}
