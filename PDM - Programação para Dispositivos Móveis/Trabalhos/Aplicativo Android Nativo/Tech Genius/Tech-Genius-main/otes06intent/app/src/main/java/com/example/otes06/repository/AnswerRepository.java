package com.example.otes06.repository;

import android.util.Log;

import com.example.otes06.models.Answer;
import com.example.otes06.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.List;


public class AnswerRepository  {
    private List<Answer> answer;
    public String responseBody = "";

    public String getAnswers() throws Exception {
        try {
            OkHttpClient client = new OkHttpClient();

            String url = "https://swapi.dev/api/people/2/";
            Request request = new Request.Builder()
                    .url(url)
                    .build();

//            client.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    // Verifique se a resposta foi bem-sucedida
//                    if (response.isSuccessful()) {
//                        // Obtenha o corpo da resposta como uma string
//                        responseBody = response.body().string();
//
//                        Log.i("LOGD", responseBody);
//                        // Faça algo com a resposta
//                        // ...
//                    } else {
//                        // Trate a resposta de erro
//                    }
//                }
//
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    Log.i("TestRepo", e.toString());
//                    // Trate a falha na comunicação com a API
//                }
//            });

            Utils utils = new Utils();
            return utils.answers;



        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
