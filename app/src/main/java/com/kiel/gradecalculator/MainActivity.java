package com.kiel.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText n1, n2, n3, n4, numberFaults;
    private Button btCalculate;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.edit_grade_one);
        n2 = findViewById(R.id.edit_grade_two);
        n3 = findViewById(R.id.edit_grade_three);
        n4 = findViewById(R.id.edit_grade_four);
        numberFaults = findViewById(R.id.edit_number_of_faults);
        btCalculate = findViewById(R.id.bt_calculate);
        txtResult = findViewById(R.id.text_result);

        btCalculate.setOnClickListener(view -> {
            int nota1 = Integer.parseInt(n1.getText().toString());
            int nota2 = Integer.parseInt(n2.getText().toString());
            int nota3 = Integer.parseInt(n3.getText().toString());
            int nota4 = Integer.parseInt(n4.getText().toString());
            int numFaults = Integer.parseInt(numberFaults.getText().toString());

            double avg = (nota1 + nota2 + nota3 + nota4) / 4;

            if (numFaults > 20 || avg < 5) {
                txtResult.setText("Aluno Reprovado!\nMédia: " + avg);
                txtResult.setTextColor(getColor(R.color.red));
                Toast.makeText(this,"Reprovado!", Toast.LENGTH_SHORT).show();
            } else {
                txtResult.setText("Aluno aprovado!\nMédia: " + avg);
                txtResult.setTextColor(getColor(R.color.green));
                Toast.makeText(this, "Aprovado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}