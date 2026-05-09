package com.exp5.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Experiment 5: GridLayout Demo
 * Displays a calculator-style grid of buttons using GridLayout.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int[] buttonIds = {
        R.id.btn1, R.id.btn2, R.id.btn3, R.id.btnAdd,
        R.id.btn4, R.id.btn5, R.id.btn6, R.id.btnSub,
        R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnMul,
        R.id.btnClear, R.id.btn0, R.id.btnEquals, R.id.btnDiv
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach click listener to all grid buttons
        for (int id : buttonIds) {
            Button btn = findViewById(id);
            if (btn != null) btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        String label = btn.getText().toString();
        Toast.makeText(this, "Pressed: " + label, Toast.LENGTH_SHORT).show();
    }
}
