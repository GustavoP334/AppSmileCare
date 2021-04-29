package br.com.aulabancosqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class cadastrese extends AppCompatActivity  implements View.OnClickListener {

    Button btnSalvar;
    EditText txtNomeCad, txtEmailCad, txtSenhaCad, txtConfSenhaCad, txtCPF, txtNumero, txtConvenio;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrese);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        txtNomeCad = (EditText) findViewById(R.id.txtNomeCad);
        txtCPF = (EditText) findViewById(R.id.txtCPF);
        txtNumero = (EditText) findViewById(R.id.txtNumero);
        txtConvenio = (EditText) findViewById(R.id.txtConvenio);
        txtEmailCad = (EditText) findViewById(R.id.txtEmailCad);
        txtSenhaCad = (EditText) findViewById(R.id.txtSenhaCad);
        txtConfSenhaCad = (EditText) findViewById(R.id.txtConfSenhaCad);

        btnSalvar.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        // quando clicou no botão salvar
        String NomeCad = txtNomeCad.getText().toString();
        String CPF = txtCPF.getText().toString();
        String Numero = txtNumero.getText().toString();
        String Convenio = txtConvenio.getText().toString();
        String EmailCad = txtEmailCad.getText().toString();
        String SenhaCad = txtSenhaCad.getText().toString();
        String ConfSenhaCad = txtConfSenhaCad.getText().toString();


        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        if (SenhaCad.equals(ConfSenhaCad)) {
            resultado = bd.insereDadosUsuario(NomeCad, EmailCad, SenhaCad, CPF, Numero, Convenio);

            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            limpar();
        }else{
            String msg = "As senhas digitadas não são iguais, digite novamente!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
    public void limpar()
    {
        txtNomeCad.setText("");
        txtCPF.setText("");
        txtNumero.setText("");
        txtConvenio.setText("");
        txtEmailCad.setText("");
        txtSenhaCad.setText("");
        txtConfSenhaCad.setText("");
        txtNomeCad.requestFocus();
    }
}
