package br.com.aulabancosqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class pedido extends Activity {
    ListView lista;
    String hora = "";
    String data = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        List<ConsultasModelo> listaConsultas = null ;
        listaConsultas = consultarTodasConsultas();

        ConsultasAdapter adaptador = new ConsultasAdapter(this,  listaConsultas);

        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(adaptador);
    }


    public List<ConsultasModelo> consultarTodasConsultas() {
        List<ConsultasModelo> lista = new LinkedList<ConsultasModelo>();

        BancoController bd = new BancoController(getBaseContext());
        //Cursor dados = bd.consultaAgendaHora(data, hora) ;
        Cursor dados = bd.consultaAgenda() ;
        if(dados != null) {
            do  {
                ConsultasModelo item = new ConsultasModelo();
                item.setCodigo(dados.getInt(0));
                item.setNome(dados.getString(1));
                item.setHora(dados.getString(3));
                item.setData(dados.getString(2));
                lista.add(item);
            } while(dados.moveToNext());
        }else{
            String msg= "Não há nenhuma consulta cadastrada!!";
            mensagemConvenio(msg);
        }
        return  lista ;
    }

    public void mensagemConvenio(String msg) {
        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, msg, duracao);
        toast.show();
    }
}