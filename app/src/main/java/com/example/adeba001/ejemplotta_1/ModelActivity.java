package com.example.adeba001.ejemplotta_1;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.adeba001.ejemplotta_1.NetInfoConnection.NetworkReciever;
import com.example.adeba001.ejemplotta_1.modelo.Bussines;
import com.example.adeba001.ejemplotta_1.presentation.Data;
import com.example.adeba001.ejemplotta_1.presentation.Preferences;

public abstract class ModelActivity extends AppCompatActivity {

    protected Preferences preff=null;
    protected Bussines server=null;
    protected RestClient restClient=null;
    protected Data data=null;
    protected NetworkReciever reciever=null;
    public static final String URL="http://u017633.ehu.eus:18080/AlumnoTta/rest/tta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        preff= new Preferences(this);
        data=new Data(getIntent().getExtras());
        restClient=new RestClient("URL");
        String auth=data.getAuthToken();
        if (auth!=null)
            restClient.setAuth(auth);
        server=new Bussines(restClient);
        //registrarse en un evento
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        reciever=new NetworkReciever();
        this.registerReceiver(reciever,intentFilter);

        setContentView(R.layout.activity_model);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }





    public void test(View view){

        Intent intent= new Intent(this, TestActivity.class);
        startActivity(intent);

    }

    public void ejercicio (View view){

        Intent intent= new Intent(this, ExerciseActivity.class);
        startActivity(intent);

    }

    public void seguimiento(View view){

        Toast toast = Toast.makeText(this, "No implementada la accion de seguimiento", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        //desregistrarse de un evento
        if (reciever!=null)
        this.unregisterReceiver(reciever);
    }

}
