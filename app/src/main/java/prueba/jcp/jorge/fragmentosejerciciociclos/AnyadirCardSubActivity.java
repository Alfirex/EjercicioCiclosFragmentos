package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnyadirCardSubActivity extends AppCompatActivity {
    private EditText etTitulo, etTipo, etDescripcion, etFamilia;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadir_card_sub);

        etTitulo = (EditText)findViewById(R.id.etTitulo);
        etTipo = (EditText)findViewById(R.id.etTipo);
        etDescripcion = (EditText)findViewById(R.id.etDescripcion);
        etFamilia = (EditText) findViewById(R.id.etFamilia);


    }


    // Metodo para enviar Informacion
    public void Enviar(View view){
        String sTitulo = etTitulo.getText().toString();
        String sTipo = etTipo.getText().toString();
        String sDescripcion = etDescripcion.getText().toString();
        String sFamilia = etFamilia.getText().toString();


        CicleFlorida usu = new CicleFlorida(sFamilia,sTipo,sTitulo,sDescripcion );

        Intent intento = new Intent(view.getContext(), FragmentoListado.class);

        intento.putExtra("objecte_ciclesFlorida",usu);


        setResult(RESULT_OK, intento);
        finish();


    }
}
