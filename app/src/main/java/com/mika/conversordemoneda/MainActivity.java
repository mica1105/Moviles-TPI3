package com.mika.conversordemoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etDolares, etEuros;
    private RadioButton rbDolar, rbEuro;
    private TextView tvMostrar;
    private Button btConvetir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor);
        etDolares= findViewById(R.id.etDolares);
        etEuros= findViewById(R.id.etEuros);
        rbDolar= findViewById(R.id.rbDolar);
        rbEuro= findViewById(R.id.rbEuro);
        tvMostrar= findViewById(R.id.tvMostrar);
        btConvetir= findViewById(R.id.btConvertir);
    }

    public void comprobarMoneda(View view){
        if(rbDolar.isChecked()){
            etDolares.setEnabled(false);
            etEuros.setEnabled(true);
            etEuros.requestFocusFromTouch();
            tvMostrar.setText("");
        } else {
            etEuros.setEnabled(false);
            etDolares.setEnabled(true);
            etDolares.requestFocusFromTouch();
            tvMostrar.setText("");
        }
    }

    public void convertir(View view){
        double valor;
        if(rbDolar.isChecked()){
            double euro= Double.parseDouble(etEuros.getText().toString());
            valor= euro * 1.18;
            tvMostrar.setText(valor+" USD");
            etEuros.setText("");
        } else {
            double dolar= Double.parseDouble(etDolares.getText().toString());
            valor= dolar * 0.85;
            tvMostrar.setText(valor+" EUR");
            etDolares.setText("");
        }
    }

}