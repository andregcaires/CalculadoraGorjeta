package com.andregcaires.calculadoragorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;

    private TextView txtValor;
    private TextView txtPercent;
    private TextView txtGorjeta;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        txtPercent = findViewById(R.id.txtPercent);
        txtValor = findViewById(R.id.txtValor);
        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtTotal = findViewById(R.id.txtTotal);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtPercent.setText(seekBar.getProgress() +"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(txtValor.getText().length() == 0){
                    Toast.makeText(MainActivity.this, "Selecione um valor!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                double result = 0;
                Double valor = Double.parseDouble(txtValor.getText().toString());
                if(txtValor.getText().length() > 0){

                    double percent = seekBar.getProgress();
                    if(percent > 0){
                        result = (valor * percent) / 100;
                    }
                }

                txtGorjeta.setText("R$"+result);
                txtTotal.setText("R$"+ (valor + result));
            }
        });
    }
}
