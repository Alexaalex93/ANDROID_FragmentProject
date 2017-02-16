package com.example.cice.fragmentproject;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        FragmentListado fragmentListado = (FragmentListado) fm.findFragmentById(R.id.FragmentListado);

        fragmentListado.setLibrosListener(this);
    }

    public void onLibroSeleccionado (Libro l){

        //TODO colocar el resumen del libro en otro fragment

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentDetalle fd = (FragmentDetalle) fragmentManager.findFragmentById(R.id.FragmentDetalle);

        fd.mostrarDetalle(l.getResumen());
    }
}
