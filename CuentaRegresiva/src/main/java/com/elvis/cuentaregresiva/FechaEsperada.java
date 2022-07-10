package com.elvis.cuentaregresiva;

import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaEsperada {
    private TextView dia, hora, minuto, segundo;
    private Handler handler;
    private Runnable runnable;

    public FechaEsperada(TextView dia,TextView hora,TextView minuto,TextView segundo){
        this.dia=dia;
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
    }
    public void iniciarCuentaAtras(String y, String m, String d) {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaEsperada = dateFormat.parse(y + "-" + m + "-" + d);
                    Date hoy = new Date();
                    if (!hoy.after(fechaEsperada)) {
                        long diferenciaRestante = fechaEsperada.getTime() - hoy.getTime();
                        long dias = diferenciaRestante / (24 * 60 * 60 * 1000);
                        diferenciaRestante -= dias * (24 * 60 * 60 * 1000);
                        long horas = diferenciaRestante / (60 * 60 * 1000);
                        diferenciaRestante -= horas * (60 * 60 * 1000);
                        long minutos = diferenciaRestante / (60 * 1000);
                        diferenciaRestante -= minutos * (60 * 1000);
                        long segundos = diferenciaRestante / 1000;

                        dia.setText("" + String.format("%02d", dias));
                        hora.setText("" + String.format("%02d", horas));
                        minuto.setText("" + String.format("%02d", minutos));
                        segundo.setText("" + String.format("%02d", segundos));

                    } else {
                        dia.setText("00");
                        hora.setText("00");
                        minuto.setText("00");
                        segundo.setText("00");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1000);
    }
}
