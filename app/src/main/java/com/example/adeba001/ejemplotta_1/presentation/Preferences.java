package com.example.adeba001.ejemplotta_1.presentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.adeba001.ejemplotta_1.R;

import java.util.ArrayList;

/**
 * Created by alumno on 13/01/16.
 */
public class Preferences
{
    public final static String EXTRA_LOGIN="es.tta.ejemplo_tta.login";
    public final static String EXTRA_PASSWD="es.tta.ejemplo_tta.passwd";
    public final static String EXTRA_PREFF="es.tta.ejemplo_tta.preff";
    private SharedPreferences prefs;





    public Preferences(Context context) {
        prefs=context.getSharedPreferences(EXTRA_PREFF, context.MODE_PRIVATE);
    }

    public ArrayList<String> loadlogin()
    {
    ArrayList<String> login=new ArrayList<>();
        login.add(0,prefs.getString(EXTRA_LOGIN,null));
        login.add(1,prefs.getString(EXTRA_PASSWD,null));

        return login;
    }
    public void savelogin(ArrayList<String> login)
    {

        SharedPreferences.Editor editor=prefs.edit();
        editor.putString(EXTRA_LOGIN,login.get(0));
        editor.putString(EXTRA_LOGIN,login.get(1));
        editor.commit();
    }

}
