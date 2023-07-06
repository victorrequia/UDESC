package org.udesc.otes06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        String name = bundle.getString("address");
        setContentView(R.layout.activity_other);

        TextView text = findViewById(R.id.other_text);
        text.setText(name);
    }
}