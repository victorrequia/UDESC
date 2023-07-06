package org.udesc.otes06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {
    private Button buttons[][];
    private boolean x = true;

    private static final int TABLE_SIZE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        TableLayout table = new TableLayout(this);
        table.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        buttons = new Button[TABLE_SIZE][];

        for (int i = 0; i < TABLE_SIZE; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT));

            buttons[i] = new Button[TABLE_SIZE];

            for (int j = 0; j < TABLE_SIZE; j++) {
                Button button = new Button(this);
                button.setText("?");
                button.setOnClickListener(view -> markCell(view));
                row.addView(button);

                buttons[i][j] = button;
            }

            table.addView(row);
        }

        Button button = new Button(this);
        button.setText("New game");
        button.setOnClickListener(view -> newGame());

        layout.addView(table);
        layout.addView(button);

        setContentView(layout);
    }

    public void markCell(View view) {
        Button button = (Button) view;

        if (button.getText().equals("?")) {
            String mark = x ? "X" : "O";
            button.setText(mark);
            checkWin(mark);
            x = !x;
        }
    }

    public void newGame() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setText("?");
            }
        }
    }

    public void checkWin(String mark) {
        boolean upperDiag = true;
        boolean lowerDiag = true;

        boolean row = true;
        boolean column = true;

        for (int i = 0; i < TABLE_SIZE; i++) {
            row = true;
            column = true;

            for (int j = 0; j < TABLE_SIZE; j++) {
                if (!buttons[i][j].getText().equals(mark)) {
                    row = false;
                }

                if (!buttons[j][i].getText().equals(mark)) {
                    column = false;
                }
            }

            if (row || column) break;
        }

        for (int i = 0; i < TABLE_SIZE; i++) {
            if (!buttons[i][i].getText().equals(mark)) {
                upperDiag = false;
            }
            if (!buttons[i][(TABLE_SIZE - 1) - i].getText().equals(mark)) {
                lowerDiag = false;
            }
        }

        if (row || column || upperDiag || lowerDiag) {
            for (int i = 0; i < TABLE_SIZE; i++) {
                for (int j = 0; j < TABLE_SIZE; j++) {
                    buttons[i][j].setEnabled(false);
                }
            }
        }
    }
}