package br.com.editthemovie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.editthemovie.model.Empresa;
import br.com.editthemovie.model.Usuario;

/**
 * Created by Kelvyn on 04/06/2017.
 */

public class CriarUsuarioActivity extends Activity {

    private EditText editNomeUsuario;
    private EditText editDataUsuario;
    private EditText editTelefoneUsuario;
    private EditText editEmailUsuario;
    private EditText editSenhaUsuario;
    private EditText editCidadeUsuario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        EditText editNomeUsuario = (EditText) findViewById(R.id.editNomeUsuario);
        EditText editDataUsuario = (EditText) findViewById(R.id.editDataUsuario);
        EditText editTelefoneUsuario = (EditText) findViewById(R.id.editTelefoneUsuario);
        EditText editEmailUsuario = (EditText) findViewById(R.id.editEmailUsuario);
        EditText editSenhaUsuario = (EditText) findViewById(R.id.editSenhaUsuario);
        EditText editCidadeUsuario = (EditText) findViewById(R.id.editCidadeUsuario);
    }

    public void cadastrarUsuario(View v){
        Usuario usuario = new Usuario();
        usuario.setNome(editNomeUsuario.getText().toString());
        usuario.setNascimento(editDataUsuario.getText().toString());
        usuario.setTelefone(editTelefoneUsuario.getText().toString());
        usuario.setEmail(editEmailUsuario.getText().toString());
        usuario.setSenha(editSenhaUsuario.getText().toString());
        usuario.getEndereco().setCidade(editCidadeUsuario.getText().toString());
        if(isConnected())
            new UploadToMyAPI().execute(usuario);
        else
            Toast.makeText(this, "Verifique a conexão com a internet...", Toast.LENGTH_SHORT).show();
    }
}
