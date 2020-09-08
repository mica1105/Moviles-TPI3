package com.mika.conversordemoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etDolares, etEuros, etCambio;
    private RadioButton rbDolar, rbEuro;
    private Button btConvetir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor);
        etDolares= findViewById(R.id.etDolares);
        etEuros= findViewById(R.id.etEuros);
        etCambio= findViewById(R.id.etCambio);
        rbDolar= findViewById(R.id.rbDolar);
        rbEuro= findViewById(R.id.rbEuro);
        btConvetir= findViewById(R.id.btConvertir);
    }

    public void comprobarMoneda(View view){
        if(rbDolar.isChecked()){
            etDolares.setEnabled(false);
            etEuros.setEnabled(true);
            etEuros.requestFocus();
        }
        if (rbEuro.isChecked()){
            etEuros.setEnabled(false);
            etDolares.setEnabled(true);
            etDolares.requestFocus();
        }
    }

    public void convertir(View view){
        double valor;
        if(rbDolar.isChecked()){
            double euro= Double.parseDouble(etEuros.getText().toString());
            valor= euro * 1.18;
            etCambio.setText(valor+"",TextView.BufferType.EDITABLE);
            etEuros.setText("");
        }
        if(rbEuro.isChecked()){
            double dolar= Double.parseDouble(etDolares.getText().toString());
            valor= dolar * 0.85;
            etCambio.setText(valor+"",TextView.BufferType.EDITABLE);
            etDolares.setText("");
        }
    }

}