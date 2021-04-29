package br.com.aulabancosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class meusdados extends AppCompatActivity {
    String nome = "";
    EditText txtNomeMeusDados, txtEmailMeusDados, txtSenhaMeusDados, txtCpfMeusDados, txtNumeroMeusDados, txtConvenioMeusDados;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meusdados);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        nome = parametros.getString("nome");

        txtNomeMeusDados = (EditText) findViewById(R.id.txtNomeMeusDados);
        txtCpfMeusDados= (EditText) findViewById(R.id.txtCpfMeusDados);
        txtNumeroMeusDados= (EditText) findViewById(R.id.txtNumeroMeusDados);
        txtConvenioMeusDados= (EditText) findViewById(R.id.txtConvenioMeusDados);
        txtEmailMeusDados= (EditText) findViewById(R.id.txtEmailMeusDados);
        txtSenhaMeusDados= (EditText) findViewById(R.id.txtSenhaMeusDados);

        consultaUsuarioNome();
    }

    public void consultaUsuarioNome()
    {
        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadoPeloNome(nome) ;

        if(dados.moveToFirst()){
            txtNomeMeusDados.setText( dados.getString(1));
            txtCpfMeusDados.setText(dados.getString(2));
            txtNumeroMeusDados.setText(dados.getString(3));
            txtConvenioMeusDados.setText(dados.getString(4));
            txtEmailMeusDados.setText( dados.getString(5));
            txtSenhaMeusDados.setText(dados.getString(6));

        }else{
            String msg= "Nome não cadastrado";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

}
