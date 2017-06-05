package br.com.editthemovie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Kelvyn on 04/06/2017.
 */

public class TelaLoginActivity extends Activity
{

    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button btnLogar;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        EditText editTextSenha = (EditText)findViewById(R.id.editTextSenha);
        Button btnLogar = (Button)findViewById(R.id.btnLogar);
        Button btnCadastrar = (Button)findViewById(R.id.btnCadastrar);


    }
}
