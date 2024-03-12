package edu.eci.arep.ASE.app.apiExternal;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClient {

    private OkHttpClient httpClient;

    public HttpClient() {
        httpClient = new OkHttpClient();
    }

    public String call(String url, String data){
        HttpUrl httpUrl = HttpUrl.parse(url).newBuilder().addQueryParameter("cad", data).build();
        Request request = new Request.Builder().url(httpUrl).get().build();
        String dataAux = "";
        try(Response response = httpClient.newCall(request).execute()){
            dataAux = response.body().string();
        }catch(IOException e){
            e.printStackTrace();
        }

        return dataAux;

    }
}
