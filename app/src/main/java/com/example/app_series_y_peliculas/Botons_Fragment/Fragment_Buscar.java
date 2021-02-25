package com.example.app_series_y_peliculas.Botons_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_series_y_peliculas.RecyclerViews.ListAdapter;
import com.example.app_series_y_peliculas.RecyclerViews.PeliculaSerie;
import com.example.app_series_y_peliculas.R;
import com.example.app_series_y_peliculas.fetchData;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Buscar extends Fragment {
    public List<PeliculaSerie> elements = new ArrayList<>();
    Button GuardarPeli;
    EditText et_buscar;
    View Fragment_Buscar;
    boolean prueba = false;
    public Fragment_Buscar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Fragment_Buscar = inflater.inflate(R.layout.fragment__buscar, container, false);

        et_buscar = Fragment_Buscar.findViewById(R.id.et_buscar);

        GuardarPeli= Fragment_Buscar.findViewById(R.id.btn_BuscarPeli);

        GuardarPeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Peli_Serie = et_buscar.getText().toString();
                fetchData process = new fetchData(Peli_Serie, getActivity());
                process.execute();

            }
        });

        return Fragment_Buscar;
    }

}