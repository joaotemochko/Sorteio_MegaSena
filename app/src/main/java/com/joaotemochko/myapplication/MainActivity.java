package com.joaotemochko.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

private Button botaoIniciar, botaoCreditos, botaoHistorico;
private AlertDialog creditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        inicializarComponentes();

        //Criando função para o botão INICIAR: ir para próxima activity
        botaoIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aqui estou mandando ele para outra Activity
                Intent intent = new Intent(getApplicationContext(), SorteioActivity.class);

                //Chama a próxima Activity

                startActivity(intent);
                finish();
            }
        });

        botaoCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                builder.setTitle("Créditos");
                builder.setMessage("Criado por: joaotemochko");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                creditos = builder.create();
                creditos.show();


            }
        });

        botaoHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityHistorico = new Intent(getApplicationContext(), ActivityHistorico.class);

                startActivity(activityHistorico);
                finish();}

        });
    }

    private void inicializarComponentes(){

        botaoIniciar = findViewById(R.id.btnIniciar);
        botaoCreditos = findViewById(R.id.btnCreditos);
        botaoHistorico = findViewById(R.id.btnHistorico);
    }
}
