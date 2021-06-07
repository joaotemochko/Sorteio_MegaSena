package com.joaotemochko.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ActivityHistorico extends AppCompatActivity {

    //Declaração de variaveis
    private Button botaoVoltar;
    private ListView listaHistorico;
    SorteioActivity sorteio = new SorteioActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);


        inicializarComponentes();

            //Aqui começamos a gravar a lista para mostrarmos o geraNumeros do SorteioActivity
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sorteio.guardaNumeros());
            //Exibimos a lista
            listaHistorico.setAdapter(adapter);

        //Configuração do botão voltar
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent VoltarActivityMain = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(VoltarActivityMain);
            }
        });

    }

    //pegando o botao e a lista da activity
    public void inicializarComponentes() {
        botaoVoltar = findViewById(R.id.btnVOltar2);
        listaHistorico = (ListView) findViewById(R.id.listHistorico);
    }
}
