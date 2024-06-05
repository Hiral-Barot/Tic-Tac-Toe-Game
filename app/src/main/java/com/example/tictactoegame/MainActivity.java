package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView tvResult;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0;
    int count = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        tvResult = findViewById(R.id.tvResult);
    }

    public void check(View view) {
        Button btnCurrent = (Button) view;
        if (btnCurrent.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                btnCurrent.setText("X");
                flag = 1;
            } else {
                btnCurrent.setText("0");
                flag = 0;
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                // Check for winning conditions
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    showWinner(b1);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    showWinner(b1);
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    showWinner(b2);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    showWinner(b3);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    showWinner(b4);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    showWinner(b7);
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    showWinner(b1);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    showWinner(b3);
                } else if (count == 9) {
                    showDraw();
                }
            }
        }
    }

    private void showWinner(String winner) {
        tvResult.setText("WINNER IS: " + winner);
        resetTextViewAfterDelay();
    }

    private void showDraw() {
        tvResult.setText("Oops,Match is draw!");
        resetTextViewAfterDelay();
    }

    private void resetTextViewAfterDelay() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("Tic Tac Toe");
                newGame();
            }
        }, 3000); // 5 seconds delay
    }

    public void newGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
    }
}
