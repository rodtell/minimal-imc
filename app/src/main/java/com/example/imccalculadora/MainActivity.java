package com.example.imccalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    // Variável de classe
    private TextView resultText;
    private Button calculateButton;
    private EditText alturaEditText;
    private EditText pesoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double imcResultado = calcularImc();
                displayResult(imcResultado);
            }
        });

    }
    // Button calcular setup
    private double calcularImc() {
        String alturaText = alturaEditText.getText().toString();
        String pesoText = pesoEditText.getText().toString();
    // Converter String para Int
        double altura = Double.parseDouble(alturaText) / 100; // Necessário converter altura cm para m
        int peso = Integer.parseInt(pesoText);
    // Calcular imc
        return peso / (altura * altura);
    }

    private void displayResult(double imc) {
        // Formato decimal
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String imcResultado = myDecimalFormatter.format(imc);
        // Condicional saudável
        String resultadoCompletoString;
        if (imc < 18.5) {
            resultadoCompletoString = imcResultado + " Você está abaixo do peso";
        } else if (imc > 25) {
            resultadoCompletoString = imcResultado + " Você está acima do peso";
        } else {
            resultadoCompletoString = imcResultado + " Você está saudável";
        }
        // Mostrar resultado do imc
        resultText.setText(resultadoCompletoString);
    }
    // ids Views
    private void findViews() {
        resultText = findViewById(R.id.text_view_result);
        alturaEditText = findViewById(R.id.edit_text_altura);
        pesoEditText = findViewById(R.id.edit_text_peso);
        calculateButton = findViewById(R.id.button_calculate);
    }
}