package com.joaotemochko.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;

public class SorteioActivity extends AppCompatActivity {

    //Criando as variáveis
    private Button btnVoltar;
    private ListView lista;
    private ArrayList numeros = new ArrayList();
    private static ArrayList guardar = new ArrayList();
    private ArrayList escolhidos = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);

        //Inicializa os componentes
        inicializarComponentes();
        //Chama o geraNumeros e escolheNumeros
        geraNumeros();
        escolheNumeros();


        //Aqui começamos a gravar a lista para mostrarmos
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, escolhidos);
        //Exibimos a lista
        lista.setAdapter(adapter);

        //Configuração do botão
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aqui estou mandando ele de volta para a antiga Activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                guardaNumeros();
                //starta a antiga Activity
                startActivity(intent);
            }
        });




    }
        //Faz a chamada para pegar as id's da activity
        public void inicializarComponentes () {
            lista = (ListView) findViewById(R.id.Lista);
            btnVoltar = findViewById(R.id.btnVoltar);
        }

    //Criamos um metodo geraNumeros
    public void geraNumeros() {

        //Adicionamos 60 números na lista
        for (int i = 1; i < 61; i++) { //Sequencia da mega sena
            numeros.add(i);
        }

        //int i[] = new int[54];

        /* CODIGO ANTES DE OTIMIZAR */
        /*for (int j = i.length-1; j >= 0; j--) {
            //Embaralhamos os números:
            Collections.shuffle(numeros);
            //Removemos um número depois de embaralhado da lista
            //numeros.remove(i[j]);

        }*/
    }

    /*Código OTIMIZADO*/
    //Criamos um método para escolherNumeros
    public void escolheNumeros(){
        Collections.shuffle(numeros);

        while (escolhidos.size() < 6){
            for (int i =1; i<7; i++)
                escolhidos.add(numeros.get(i));
        }
        Collections.sort(escolhidos);
    }

    //Metodo guardaNumeros, usado para guardar numeros na variável estatica guardar
    public ArrayList guardaNumeros(){
        if (escolhidos.size() == 6) {
            guardar.add(escolhidos);
        }
        return guardar;
    }
}
