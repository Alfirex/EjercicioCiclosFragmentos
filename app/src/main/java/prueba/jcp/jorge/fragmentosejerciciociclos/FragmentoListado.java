package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static android.support.v4.app.ActivityCompat.startActivityForResult;


public class FragmentoListado extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String LISTADO_FINAL = "listado final";

    // TODO: Rename and change types of parameters
    private ArrayList<CicleFlorida> listadoRecibidoPorParametros;

    private RecyclerView recyclerView;
    private Adaptador adaptador;
    private LinearLayoutManager linear_Layout_Manager;
    private ImageButton btnAñadir;





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
        btnAñadir = v.findViewById(R.id.imageButtonAñadir);

        recyclerView.setLayoutManager(linear_Layout_Manager);
        recyclerView.setAdapter(adaptador);
        btnAñadir.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.imageButtonAñadir){
            Intent intento = new Intent(view.getContext(), AnyadirCardSubActivity.class);
            startActivityForResult(intento , 1);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Comprueba que subactivity es, ya que asignamos un número cuando vamos a tal subactivity
        if (requestCode == 1) {
            // En el caso de que hay ido todo bien
            if (resultCode == RESULT_OK) {
                Bundle params = data.getExtras();
                CicleFlorida oCiclesFlorida = params.getParcelable("objecte_ciclesFlorida");

                String sTitulo = oCiclesFlorida.getTitol();
                String sTipo = oCiclesFlorida.getTipus();
                String sDescripcion = oCiclesFlorida.getDescripcio();
                String sFamilia = oCiclesFlorida.getFamiliaProfessional();

                Log.d("Prueba",sTitulo);
                Log.d("Prueba",sTipo);
                Log.d("Prueba",sDescripcion);
                Log.d("Prueba",sFamilia);
                listadoRecibidoPorParametros.add(new CicleFlorida(sFamilia, sTipo,sTitulo,sDescripcion));

                for (CicleFlorida p : listadoRecibidoPorParametros) {
                    Log.d("Prueba", "Muestra Array"+p.getTipus());
                }

            }
        }
    }
}
