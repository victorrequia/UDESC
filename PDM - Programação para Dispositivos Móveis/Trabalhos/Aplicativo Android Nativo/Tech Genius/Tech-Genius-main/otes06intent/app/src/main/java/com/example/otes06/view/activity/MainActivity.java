package com.example.otes06.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;

import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import android.content.Intent;
import android.view.View;

import com.example.otes06.R;
import com.example.otes06.models.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");

        // Cria um layout principal
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        // Cria o TextView com o texto "Tech"
        TextView textView = new TextView(this);
        textView.setText("Tech Genius");
        textView.setTextSize(32);

        // Adiciona o TextView ao layout principal com configurações de layout
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.gravity = Gravity.CENTER;
        textParams.setMargins(0,0,0,380);
        layout.addView(textView, textParams);

        // Cria os botões em estilo de hambúrguer
        Button button1 = new Button(this);
        button1.setText("Jogar");
        button1.setBackgroundResource(R.drawable.button_background);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Inicia a tela de seleção de dificuldade e passa o nome de usuário como extra
                Intent difficultyIntent = new Intent(MainActivity.this, LoginActivity.class);
                //System.out.println(user.getName().toString());
                startActivity(difficultyIntent);
            }
        });

        Button button2 = new Button(this);
        button2.setText("Ver Ranking");
        button2.setBackgroundResource(R.drawable.button_background);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia a tela de seleção de dificuldade e passa o nome de usuário como extra
                Intent rankingIntent = new Intent(MainActivity.this, RankingActivity.class);
                startActivity(rankingIntent);
            }
        });

        // Configura a largura dos botões
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.setMargins(0,100,0,0);
        buttonParams.width = getResources().getDimensionPixelSize(R.dimen.button_width);

        // Adiciona os botões ao layout principal com configurações de layout
        layout.addView(button1, buttonParams);
        layout.addView(button2, buttonParams);

        // Define o layout principal como o layout da atividade
        setContentView(layout);
    }

}