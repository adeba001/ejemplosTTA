package com.example.adeba001.ejemplotta_1;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarException;

/**
 * Created by alumno on 13/01/16.
 */
public class RestClient
{
    private final static String AUTH="Authoritation";
    private final String baseURL;
    private final Map<String,String> properties=new HashMap<>();


    public RestClient(String url) {
        this.baseURL=url;
    }

    public void setBasicHttpAuth(String user,String pssw){}

    public String getAuth(){return properties.get(AUTH);}

    public void setProperties(String name,String value){properties.put(name,value);}

    public void setAuth(String auth) {properties.put(AUTH,auth);}

    private HttpURLConnection getConnection(String path) throws IOException {
        URL url=new URL(String.format("%s%s",baseURL,path));
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        for (Map.Entry<String,String> property :properties.entrySet())
            connection.setRequestProperty(property.getKey(),property.getValue());
        connection.setUseCaches(false);
        return connection;
    }

    public String getString(String path)throws IOException{
        return null;

    }

    public JSONObject getJSON() throws IOException,JSONException
    {
        return null;
    }

    public int postFile(String path,InputStream in,String filename)throws IOException{return 0;}
    public int postJSON(final JSONObject json,String path)throws IOException{return 0;}

}
