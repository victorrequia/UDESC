package com.example.otes06.repository;

import com.example.otes06.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class QuestionRepository {
    // mudar retorno para List<Question>
    public String getQuestions() throws Exception {
        BufferedReader reader;
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

            // Fecha a conexão
            Utils utils = new Utils();
            return utils.questions;
        } catch (Exception e) {
            e.printStackTrace();
            return "deu ruim";
        }

    }
}
