package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class FragmentoListado extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String LISTADO_FINAL = "listado final";

    // TODO: Rename and change types of parameters
    private ArrayList<CicleFlorida> listadoRecibidoPorParametros;

    private RecyclerView recyclerView;
    private Adaptador adaptador;
    private LinearLayoutManager linear_Layout_Manager;



    public FragmentoListado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FragmentoListado.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoListado newInstance(ArrayList<CicleFlorida> listadoFinal) {
        FragmentoListado fragment = new FragmentoListado();
        Bundle args = new Bundle();
        args.putParcelableArrayList(LISTADO_FINAL, listadoFinal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listadoRecibidoPorParametros = getArguments().getParcelableArrayList(LISTADO_FINAL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String textoAMostrar=new String("");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_listado, container, false);

        recyclerView = v.findViewById(R.id.ReycclerView);
        linear_Layout_Manager = new LinearLayoutManager(v.getContext());
        adaptador = new Adaptador(listadoRecibidoPorParametros);

        recyclerView.setLayoutManager(linear_Layout_Manager);
        recyclerView.setAdapter(adaptador);

        return v;
    }



}
