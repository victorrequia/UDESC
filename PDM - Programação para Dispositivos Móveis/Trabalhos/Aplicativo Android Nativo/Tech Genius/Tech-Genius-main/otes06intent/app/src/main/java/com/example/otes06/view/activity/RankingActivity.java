package com.example.otes06.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.otes06.R;
import com.example.otes06.controllers.GameController;
import com.example.otes06.models.User;

import java.util.List;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        LinearLayout parentContainer = findViewById(R.id.container);

        GameController gc = new GameController();
        List<User> users = gc.getRanking();
        for (int u = 0 ; u < users.size(); u++) {


            User user = users.get(u);
            String dots = "";
            String stringScore = String.valueOf(user.getScore());

            for (int i = 0; i < 50 - stringScore.length() - user.getName().length(); i++) {
                dots += ".";
            }

            TextView textView = new TextView(this);
            textView.setId(u);
            textView.setText(user.getName() + " " + dots + " " + stringScore);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setTextSize(20);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );


            layoutParams.setMargins(20, 0, 20, 50);

            textView.setLayoutParams(layoutParams);

            parentContainer.addView(textView);
        }
    }
}