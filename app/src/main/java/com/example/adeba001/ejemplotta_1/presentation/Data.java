package com.example.adeba001.ejemplotta_1.presentation;

import android.os.Bundle;

import com.example.adeba001.ejemplotta_1.modelo.Exercise;
import com.example.adeba001.ejemplotta_1.modelo.Test;

/**
 * Created by Miren on 17/12/2015.
 */
public class Data {

    private final static String EXTRA_USER = "es.tta.example.user";
    private final static String EXTRA_AUTH = "es.tta.example.auth";
    private final static String EXTRA_NAME = "es.tta.example.name";
    private final static String EXTRA_EXERCISE_ID = "es.tta.example.exerciseId";
    private final static String EXTRA_EXERCISE_WORDING = "es.tta.example.exerciseWording";


    private final Bundle bundle;

    public Data(Bundle extras)
    {
        if (extras==null)
            extras=new Bundle();
        this.bundle=extras;

    }

    public Bundle getBundle()
    {
        return bundle;
    }
    public void putUserID(int id)
    {
        bundle.putInt(EXTRA_USER,id);
    }
    public int getUserID()
    {return bundle.getInt(EXTRA_USER);}

    public void putAuthToken(String auth){bundle.putString(EXTRA_AUTH,auth);}

    public String getAuthToken(){return bundle.getString(EXTRA_AUTH);}

    public void putUserName(String name){bundle.putString(EXTRA_NAME,name);}

    public String getUserName(){return bundle.getString(EXTRA_NAME);}

    public void putExcercise(Exercise exercise)
    {
        bundle.putInt(EXTRA_EXERCISE_ID,exercise.getID());
        bundle.putString(EXTRA_EXERCISE_WORDING,exercise.getWording());
    }

    public Exercise getExercise()
    {
        Exercise exercise=new Exercise();
        exercise.setID(bundle.getInt(EXTRA_EXERCISE_ID));
        exercise.setExercise(bundle.getString(EXTRA_EXERCISE_WORDING));
        return exercise;


    }

    public Test getTest(){

        return new Test();

    }


}

