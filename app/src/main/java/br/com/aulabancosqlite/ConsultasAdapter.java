package br.com.aulabancosqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ConsultasAdapter extends ArrayAdapter<ConsultasModelo>{

    private Context context;
    private List<ConsultasModelo> listaConsultas = null;

    public ConsultasAdapter(Context context, List<ConsultasModelo> listaConsultas) {
        super(context,0, listaConsultas);
        this.listaConsultas = listaConsultas;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ConsultasModelo alunos = listaConsultas.get(position);

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.consultas_item, null);
        }

        TextView textViewCodigo = (TextView) view.findViewById(R.id.codigoConsulta);
        textViewCodigo.setText(String.valueOf(alunos.getCodigo()));

        TextView textViewNome = (TextView) view.findViewById(R.id.nomeconsulta);
        textViewNome.setText(alunos.getNome());

        TextView textViewHora = (TextView) view.findViewById(R.id.horaconsulta);
        textViewHora.setText(alunos.getHora());

        TextView textViewData = (TextView)view.findViewById(R.id.dataConsulta);
        textViewData.setText(alunos.getData());

        return view;
    }
}
