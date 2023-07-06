package com.example.otes06.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.example.otes06.R;
import com.example.otes06.controllers.GameController;
import com.example.otes06.models.User;

public class LoginActivity extends AppCompatActivity {

    private  User user = new User();
    private EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GameController gc = new GameController();

        // Obtém uma referência para o EditText do nome de usuário
        usernameEditText = findViewById(R.id.usernameEditText);

        // Obtém uma referência para o botão "Próximo"
        Button nextButton = findViewById(R.id.nextButton);

        // Configura um ouvinte de clique para o botão "Próximo"
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém o texto do EditText do nome de usuário
                String username = usernameEditText.getText().toString();

                // Verifica se o campo do nome de usuário está vazio
                if (username.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Por favor, insira seu nome de usuário", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    // Se o campo do nome de usuário não estiver vazio, inicia a MainActivity e
                    // passa o nome de usuário como extra
                    Intent optionView = new Intent(LoginActivity.this, DifficultyActivity.class);
                    user.setName(username);
                    user.setScore(0);
                    optionView.putExtra("user",user);
                    startActivity(optionView);
                }
            }
        });
    }

}