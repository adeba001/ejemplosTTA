package com.example.adeba001.ejemplotta_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends ModelActivity {
    public final static String EXTRA_PREFF="es.tta.ejemplo_tta.preff";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent =getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        String login=intent.getStringExtra(MainActivity.EXTRA_LOGIN);
        textLogin.setText(("Bienvenido "+login));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }




}
