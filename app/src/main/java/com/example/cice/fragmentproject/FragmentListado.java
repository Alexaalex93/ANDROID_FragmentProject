package com.example.cice.fragmentproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by cice on 16/2/17.
 */

public class FragmentListado extends Fragment{


    private Libro[] datos = new Libro[]{

            new Libro("Libro 1", "Autor 1", "Resumen 1"),
            new Libro("Libro 2", "Autor 2", "Resumen 2"),
            new Libro("Libro 3", "Autor 3", "Resumen 3"),
            new Libro("Libro 4", "Autor 4", "Resumen 4"),
            new Libro("Libro 5", "Autor 5", "Resumen 5")
    };

    private ListView listado;
    private MainActivity actividad_principal;



    /**
     * Sección de inicializacion(1)
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) { //Para inicializar nuestro listado, para que el fragment no se dibuje vacio
        super.onActivityCreated(savedInstanceState);

        listado = (ListView) getView().findViewById(R.id.lista_libros);
        listado.setAdapter(new AdapterLibros(this));

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //LLMAR A LA ACTIVIDAD PRINCIPAL Y PASARLE LOS DATOS DEL LIBRO TOCADO
                 Libro libroTocado = datos[i];
                actividad_principal.onLibroSeleccionado(libroTocado);
            }
        });
    }
    public void setLibrosListener(MainActivity actividad_principal){

        this.actividad_principal = actividad_principal;

    }

    class AdapterLibros extends ArrayAdapter<Libro> {

        Activity context;

        AdapterLibros (Fragment context){

            super(context.getActivity(), R.layout.list_itemlibro,datos);
            this.context = context.getActivity();

        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_itemlibro, null);

            TextView titulo = (TextView) item.findViewById(R.id.titulo);
            titulo.setText(datos[position].getTitulo());

            TextView autor = (TextView) item.findViewById(R.id.autor);
            titulo.setText(datos[position].getAutor());

            return item;

        }
    }
    /**
     * Se ejecuta despues de llamar al onActivityCreated
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);//Parametros: lo que quieres inflar, donde(el padre) y false
    }


}
