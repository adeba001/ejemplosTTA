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

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_LOGIN="es.tta.ejemplo_tta.login";
    public final static String EXTRA_PASSWD="es.tta.ejemplo_tta.passwd";
    public final static String EXTRA_PREFF="es.tta.ejemplo_tta.preff";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadlogin();
    }

    public void login (View view){

        EditText editLogin=(EditText)findViewById(R.id.login);
        EditText editPasswd=(EditText)findViewById(R.id.passwd);
        String log=editLogin.getText().toString();
        savelogin(log);
        Intent intent=new Intent (this, MenuActivity.class);

        intent.putExtra(EXTRA_LOGIN,log);
        intent.putExtra(EXTRA_PASSWD, editPasswd.getText().toString());
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
    public void loadlogin()
    {
        SharedPreferences preff= getPreferences(MODE_PRIVATE);
        EditText editLogin=(EditText)findViewById(R.id.login);
        editLogin.setText(preff.getString(EXTRA_PREFF,null));
    }
    public void savelogin(String log)
    {
        SharedPreferences preff= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=preff.edit();
        editor.putString(EXTRA_PREFF,log);
        editor.commit();
    }
}
