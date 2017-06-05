package br.com.editthemovie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.editthemovie.model.Empresa;

/**
 * Created by Kelvyn on 04/06/2017.
 */

public class CriarEmpresaActivity extends Activity {

    private EditText editNomeEmpresa;
    private EditText editSocialEmpresa;
    private EditText editTelefoneEmpresa;
    private EditText editEmailEmpresa;
    private EditText editSenhaEmpresa;
    private EditText editCidadeEmpresa;
    private EditText editCnpjEmpresa;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        EditText editNomeEmpresa = (EditText) findViewById(R.id.editNomeEmpresa);
        EditText editDataEmpresa = (EditText) findViewById(R.id.editSocialEmpresa);
        EditText editTelefoneEmpresa = (EditText) findViewById(R.id.editTelefoneEmpresa);
        EditText editEmailEmpresa = (EditText) findViewById(R.id.editEmailEmpresa);
        EditText editSenhaEmpresa = (EditText) findViewById(R.id.editSenhaEmpresa);
        EditText editCidadeEmpresa = (EditText) findViewById(R.id.editCidadeEmpresa);
        EditText editCnpjEmpresa = (EditText) findViewById(R.id.editCnpjEmpresa);

    }

    public void cadastrarEmpresa(View v){
        Empresa empresa = new Empresa();
        empresa.setNome_Curto(editNomeEmpresa.getText().toString());
        empresa.setRazao_Social(editSocialEmpresa.getText().toString());
        empresa.getUsuario().setTelefone(editTelefoneEmpresa.getText().toString());
        empresa.getUsuario().setEmail(editEmailEmpresa.getText().toString());
        empresa.getUsuario().setSenha(editSenhaEmpresa.getText().toString());
        empresa.getUsuario().getEndereco().setCidade(editCidadeEmpresa.getText().toString());
        empresa.setCnpj(editCnpjEmpresa.getText().toString());
        if(isConnected())
            new UploadToMyAPI().execute(empresa);
        else
            Toast.makeText(this, "Verifique a conexão com a internet...", Toast.LENGTH_SHORT).show();
    }
}