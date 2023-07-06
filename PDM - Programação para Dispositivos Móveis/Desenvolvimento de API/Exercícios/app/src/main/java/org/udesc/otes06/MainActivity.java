package org.udesc.otes06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(view -> doAction());

        text = findViewById(R.id.text);
    }

    private void doAction() {
        Intent intent = new Intent(this, OtherActivity.class);
        Thread t = new Thread() {
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    String cep = text.getText().toString();
                    Request request = new Request.Builder()
                            .url(String.format("https://viacep.com.br/ws/%s/json/", cep))
                            .build();

                    Call call = client.newCall(request);
                    Response response = call.execute();

                    Gson gson = new Gson();
                    Map map = gson.fromJson(response.body().string(), Map.class);

                    Bundle bundle = new Bundle();

                    String address = map.get("logradouro") +
                            ", " + map.get("bairro") +
                            ", " + map.get("localidade") +
                            ", " + map.get("uf");

                    bundle.putString("address", address);
                    intent.putExtra("bundle", bundle);

                    startActivity(intent);


                } catch(IOException e) {

                }
            }
        };

        t.start();
    }
}