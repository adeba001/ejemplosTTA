package com.example.adeba001.ejemplotta_1.modelo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by alumno on 13/01/16.
 */
public abstract class NetWork
{
    ConnectivityManager conn=null;

    public Boolean isConnected(ConnectivityManager con)
    {
        Boolean isConn=false;
        this.conn=con;
        NetworkInfo net=con.getActiveNetworkInfo();
        if(net!=null&& net.isConnected())
        isConn=true;

        return isConn;
    }

}
