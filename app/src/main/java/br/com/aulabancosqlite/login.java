package br.com.aulabancosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity implements View.OnClickListener {

    Button btnAcessar, btnCadastrese;
    EditText txtLogin, txtSenhaLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnAcessar = (Button) findViewById(R.id.btnAcessar);
        btnCadastrese = (Button) findViewById(R.id.btnCadastrar);
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenhaLogin = (EditText) findViewById(R.id.txtSenhaLogin);

        btnAcessar.setOnClickListener(this);
        btnCadastrese.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.btnCadastrar) {
            Intent telaCadastreSe = new Intent(this, cadastrese.class);
            startActivity(telaCadastreSe);
        }
        if (v.getId() == R.id.btnAcessar) {
            consultaUsuarioLogin();
        }
    }

    public void consultaUsuarioLogin()
    {
        String Login = txtLogin.getText().toString();
        String SenhaLogin = txtSenhaLogin.getText().toString();

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadosLogin(Login, SenhaLogin) ;

        if(dados.moveToFirst()){
            // levando parametros (nome do usuario) para a tela de login
            Intent tela = new Intent(this, menu.class);
            String nome = dados.getString(1);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            tela.putExtras(parametros);
            startActivity(tela);
        }else{
            String msg= "Dados não encontrados no sistema, digite outro!!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            limpar();
        }
    }
    public void limpar(){
        txtLogin.setText("");
        txtSenhaLogin.setText("");
        txtLogin.requestFocus();
    }
}
