package com.example.cice.fragmentproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by cice on 16/2/17.
 */

public class FragmentDetalle extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container, false);//Parametros: lo que quieres inflar, donde(el padre) y false
    }


    public void mostrarDetalle(String resumen){

        TextView resumenText = (TextView) getView().findViewById(R.id.texto_detalle);
        resumenText.setText(resumen);

    }
}
