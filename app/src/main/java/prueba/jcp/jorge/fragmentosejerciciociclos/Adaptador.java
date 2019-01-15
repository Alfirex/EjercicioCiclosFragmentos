package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ClientViewHolder> {
 private ArrayList<CicleFlorida> aListado_ciclos;

 // Contructor
 public Adaptador(ArrayList<CicleFlorida> listado){
     aListado_ciclos = listado;
 }
    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Creamos el View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_ciclos,parent,false);
        // Retornamos el view
        return new ClientViewHolder(v);
    }

    // Obtenemos la posicion de cada uno y se lo seteamos y le pasamos la clase interna
    @Override
    public void onBindViewHolder(ClientViewHolder holder, int position) {
        holder.tvTitulo.setText(aListado_ciclos.get(position).getTitol());
        holder.tvDesc.setText(aListado_ciclos.get(position).getDescripcio());
        holder.tvTipo.setText(aListado_ciclos.get(position).getTipus());
        holder.tvFam.setText(aListado_ciclos.get(position).getFamiliaProfessional());
    }

    @Override
    public int getItemCount() {
        return aListado_ciclos.size();
    }

    /**
     * Clase Interna : hereda de RecycleView
     */
    public class ClientViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitulo, tvDesc,tvTipo, tvFam;
        private ImageButton btnImage;
        private CardView card_view;
        private int pos;

        public ClientViewHolder(View itemView) {
            super(itemView);
            card_view = itemView.findViewById(R.id.CardViewListado);

            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDesc = itemView.findViewById(R.id.tvDescripcion);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvFam = itemView.findViewById(R.id.tvFamilia);

        }
    }
}
