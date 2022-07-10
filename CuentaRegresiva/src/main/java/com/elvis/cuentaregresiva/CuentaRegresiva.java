package com.elvis.cuentaregresiva;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CuentaRegresiva extends LinearLayout{

    public CuentaRegresiva(Context context){
        super(context);
        LayoutInflater.from(context).inflate(R.layout.cuentaregresiva, this, true);
    }

    public CuentaRegresiva(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        LayoutInflater.from(context).inflate(R.layout.cuentaregresiva, this, true);
    }

    public void inicializar(String year,String mes,String dia){
        TextView diaT = findViewById(R.id.tvDia);
        TextView horaT = findViewById(R.id.tvHora);
        TextView minutoT = findViewById(R.id.tvMin);
        TextView segundoT = findViewById(R.id.tvSeg);
        FechaEsperada fechaEsperada=new FechaEsperada(diaT, horaT, minutoT, segundoT);
        fechaEsperada.iniciarCuentaAtras(year,mes,dia);
    }

}
