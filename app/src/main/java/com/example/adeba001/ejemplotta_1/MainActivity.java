package com.example.adeba001.ejemplotta_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.example.adeba001.ejemplotta_1.presentation.Preferences;
import java.util.ArrayList;

public class MainActivity extends ModelActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<String> log=new ArrayList<>();
        log=preff.loadlogin();
        EditText editLogin=(EditText)findViewById(R.id.login);
    }

    public void login (View view){

        EditText editLogin=(EditText)findViewById(R.id.login);
        EditText editPasswd=(EditText)findViewById(R.id.passwd);
        ArrayList<String> log=new ArrayList<>();
        log.add(0,editLogin.getText().toString());
        log.add(1,editLogin.getText().toString());
        preff.savelogin(log);
        Intent intent=new Intent (this, MenuActivity.class);
        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
