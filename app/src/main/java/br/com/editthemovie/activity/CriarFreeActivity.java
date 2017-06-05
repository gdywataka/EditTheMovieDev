package br.com.editthemovie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.editthemovie.model.Empresa;
import br.com.editthemovie.model.Profissional;

/**
 * Created by Kelvyn on 04/06/2017.
 */

public class CriarFreeActivity extends Activity {

    private EditText editNomeFree;
    private EditText editDataFree;
    private EditText editTelefoneFree;
    private EditText editEmailFree;
    private EditText editSenhaFree;
    private EditText editCidadeFree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        EditText editNomeFree = (EditText)findViewById(R.id.editNomeFree);
        EditText editDataFree = (EditText)findViewById(R.id.editDataFree);
        EditText editTelefoneFree = (EditText)findViewById(R.id.editTelefoneFree);
        EditText editEmailFree = (EditText)findViewById(R.id.editEmailFree);
        EditText editSenhaFree = (EditText)findViewById(R.id.editSenhaFree);
        EditText editCidadeFree = (EditText)findViewById(R.id.editCidadeFree);

    }

    public void cadastrarFree(View v){
        Profissional profissional = new Profissional();
        profissional.getUsuario().setNome(editNomeFree.getText().toString());
        profissional.getUsuario().setNascimento(editDataFree.getText().toString());
        profissional.getUsuario().setTelefone(editTelefoneFree.getText().toString());
        profissional.getUsuario().setEmail(editEmailFree.getText().toString());
        profissional.getUsuario().setSenha(editSenhaFree.getText().toString());
        profissional.getUsuario().getEndereco().setCidade(editCidadeFree.getText().toString());
        if(isConnected())
            new UploadToMyAPI().execute(empresa);
        else
            Toast.makeText(this, "Verifique a conexão com a internet...", Toast.LENGTH_SHORT).show();
    }
}
