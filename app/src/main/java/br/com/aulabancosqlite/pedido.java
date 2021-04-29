package br.com.aulabancosqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pedido extends AppCompatActivity implements View.OnClickListener {
    TextView txtqtdBolacha, txtqtdLeite, txtqtdCafe, txtTotalPedido;
    Button  btnMaisBolacha, btnMenosBolacha, btnMaisLeite, btnMenosLeite;
    Button  btnMaisCafe, btnMenosCafe, btnGravarPedido;
    String nome ="";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        nome = parametros.getString("nome");

        txtqtdBolacha = (TextView) findViewById(R.id.txtqtdBolacha);
        txtqtdLeite = (TextView) findViewById(R.id.txtqtdLeite);
        txtqtdCafe = (TextView) findViewById(R.id.txtqtdCafe);
        txtTotalPedido= (TextView) findViewById(R.id.txtTotalPedido);

        btnMaisBolacha = (Button) findViewById(R.id.btnMaisBolacha);
        btnMenosBolacha = (Button) findViewById(R.id.btnMenosBolacha);
        btnMaisLeite = (Button) findViewById(R.id.btnMaisLeite);
        btnMenosLeite = (Button) findViewById(R.id.btnMenosLeite);
        btnMaisCafe = (Button) findViewById(R.id.btnMaisCafe);
        btnMenosCafe = (Button) findViewById(R.id.btnMenosCafe);
        btnGravarPedido = (Button) findViewById(R.id.btnGravarPedido);

        btnMaisBolacha.setOnClickListener(this);
        btnMenosBolacha.setOnClickListener(this);
        btnMaisLeite.setOnClickListener(this);
        btnMenosLeite.setOnClickListener(this);
        btnMaisCafe.setOnClickListener(this);
        btnMenosCafe.setOnClickListener(this);
        btnGravarPedido.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        int qtdBolacha = 0, qtdLeite = 0, qtdCafe = 0;
        float valorBolacha = (float) 2.89;
        float valorLeite = (float) 3.45;
        float valorCafe = (float) 10.80;
        float subTotalBolacha = 0;
        float subTotalLeite = 0;
        float subTotalCafe = 0;
        qtdBolacha = Integer.parseInt(txtqtdBolacha.getText().toString());
        qtdLeite = Integer.parseInt(txtqtdLeite.getText().toString());
        qtdCafe = Integer.parseInt(txtqtdCafe.getText().toString());

        if (v.getId() == R.id.btnMaisBolacha) {
            qtdBolacha += 1;
            txtqtdBolacha.setText(""+qtdBolacha);
        }
        if (v.getId() == R.id.btnMenosBolacha) {
            qtdBolacha -= 1;
            if (qtdBolacha<=0)
            {
                qtdBolacha = 0;
            }
            txtqtdBolacha.setText(""+qtdBolacha);
        }

        if (v.getId() == R.id.btnMaisLeite) {
            qtdLeite += 1;
            txtqtdLeite.setText(""+qtdLeite);
        }
        if (v.getId() == R.id.btnMenosLeite) {
            qtdLeite -= 1;
            if (qtdLeite<=0)
            {
                qtdLeite = 0;
            }
            txtqtdLeite.setText(""+qtdLeite);
        }

        if (v.getId() == R.id.btnMaisCafe) {
            qtdCafe += 1;
            txtqtdCafe.setText(""+qtdCafe);
        }
        if (v.getId() == R.id.btnMenosCafe) {
            qtdCafe -= 1;
            if (qtdCafe<=0)
            {
                qtdCafe = 0;
            }
            txtqtdCafe.setText(""+qtdCafe);
        }
        subTotalBolacha = qtdBolacha * valorBolacha;
        subTotalLeite = qtdLeite * valorLeite;
        subTotalCafe = qtdCafe * valorCafe;

        float total = subTotalBolacha + subTotalLeite + subTotalCafe;
        txtTotalPedido.setText("" + total);

        if (v.getId() == R.id.btnGravarPedido) {
            gravarPedido();
        }
    }

    public void gravarPedido()
    {
        float valorBolacha = (float) 2.89;
        float valorLeite = (float) 3.45;
        float valorCafe = (float) 10.80;

        int qtdBolacha = Integer.parseInt(txtqtdBolacha.getText().toString());
        int qtdLeite = Integer.parseInt(txtqtdLeite.getText().toString());
        int qtdCafe = Integer.parseInt(txtqtdCafe.getText().toString());

        float subTotalBolacha = qtdBolacha * valorBolacha;
        float subTotalLeite = qtdLeite * valorLeite;
        float subTotalCafe = qtdCafe * valorCafe;

        float total = subTotalBolacha + subTotalLeite + subTotalCafe;

        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereDadosPedido(nome, qtdBolacha, qtdLeite, qtdCafe, valorBolacha, valorLeite, valorCafe, total );

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();

    }
    public void limpar()
    {
        txtqtdBolacha.setText("0");
        txtqtdCafe.setText("0");
        txtqtdLeite.setText("0");
        txtTotalPedido.setText("0");
    }
}
