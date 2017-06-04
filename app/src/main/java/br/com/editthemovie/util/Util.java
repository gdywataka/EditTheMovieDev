package br.com.editthemovie.util;

import android.content.BroadcastReceiver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.List;

import br.com.editthemovie.model.Empresa;
import br.com.editthemovie.model.Endereco;
import br.com.editthemovie.model.Genero;
import br.com.editthemovie.model.Profissional;
import br.com.editthemovie.model.Usuario;
import br.com.editthemovie.model.Video;

/**
 * Created by Diogo on 24/04/2017.
 */

public class Util {


    public static String webToString(InputStream inputStream) {
        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localString;
    }

    //Profissional
    public static Profissional JSONTProfissional(String jsonFile){

        JSONObject mainObj;
        Profissional profissional = null;

        try {
            mainObj = new JSONObject(jsonFile);
            JSONObject profissionalObject=  mainObj.getJSONObject("profissional");


            profissional.setId(profissionalObject.getInt("id"));
            profissional.setCpf(profissionalObject.getString("cpf"));
            profissional.setNivel(profissionalObject.getString("nivel"));
            profissional.setDescricao(profissionalObject.getString("descricao"));
            profissional.setAvaliacao(profissionalObject.getInt("avaliacao"));

            profissional.getUsuario().setId(profissionalObject.getJSONObject("usuario").getInt("id"));
            profissional.getUsuario().setNome(profissionalObject.getJSONObject("usuario").getString("nome"));
            profissional.getUsuario().setEmail(profissionalObject.getJSONObject("usuario").getString("email"));
            profissional.getUsuario().setNascimento(profissionalObject.getJSONObject("usuario").getString("nascimento"));
            profissional.getUsuario().setTelefone(profissionalObject.getJSONObject("usuario").getString("telefone"));
            profissional.getUsuario().setNascimento(profissionalObject.getJSONObject("usuario").getString("senha"));

            profissional.getUsuario().getEndereco().setId(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getInt("id"));
            profissional.getUsuario().getEndereco().setEstado(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getString("estado"));
            profissional.getUsuario().getEndereco().setCidade(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getString("cidade"));
            profissional.getUsuario().getEndereco().setBairro(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getString("bairro"));
            profissional.getUsuario().getEndereco().setRua(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getString("rua"));
            profissional.getUsuario().getEndereco().setNumero(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getInt("numero"));


        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            return profissional;
        }
    }

    public static List<Profissional> JSONProfissionalLista(String jsonFile)
    {
        JSONObject mainObject;
        Profissional profissional= null;
        List<Profissional> profissionais = null;
        try
        {
            mainObject= new JSONObject(jsonFile);
            JSONArray listObj = mainObject.getJSONArray("lista");

            for(int i = 0 ; i <= listObj.length();i++)
            {
                JSONObject profissionalObject=(JSONObject) listObj.get(i);

                profissional.setId(profissionalObject.getInt("id"));
                profissional.setCpf(profissionalObject.getString("cpf"));
                profissional.setNivel(profissionalObject.getString("nivel"));
                profissional.setDescricao(profissionalObject.getString("descricao"));
                profissional.setAvaliacao(profissionalObject.getInt("avaliacao"));

                profissional.getUsuario().setId(profissionalObject.getJSONObject("usuario").getInt("id"));
                profissional.getUsuario().setNome(profissionalObject.getJSONObject("usuario").getString("nome"));
                profissional.getUsuario().setEmail(profissionalObject.getJSONObject("usuario").getString("email"));
                profissional.getUsuario().setNascimento(profissionalObject.getJSONObject("usuario").getString("nascimento"));
                profissional.getUsuario().setTelefone(profissionalObject.getJSONObject("usuario").getString("telefone"));
                profissional.getUsuario().setNascimento(profissionalObject.getJSONObject("usuario").getString("senha"));

                profissional.getUsuario().getEndereco().setId(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getInt("id"));
                profissional.getUsuario().getEndereco().setEstado(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getString("estado"));
                profissional.getUsuario().getEndereco().setCidade(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getString("cidade"));
                profissional.getUsuario().getEndereco().setBairro(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getString("bairro"));
                profissional.getUsuario().getEndereco().setRua(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getString("rua"));
                profissional.getUsuario().getEndereco().setNumero(profissionalObject.getJSONObject("usuario").getJSONObject("endereco").getInt("numero"));


                profissionais.add(profissional);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        finally {
            return profissionais;
        }
    }

    //Usuario
    public static Usuario JSONUsuario(String jsonFile)
    {
        JSONObject mainObj ;
        Usuario usuario=null;
        try
        {
            mainObj = new JSONObject(jsonFile);
            JSONObject usuarioObj= mainObj.getJSONObject("usuario");
            usuario.setId(usuarioObj.getInt("id"));
            usuario.setNome(usuarioObj.getString("nome"));
            usuario.setEmail(usuarioObj.getString("email"));
            usuario.setNascimento(usuarioObj.getString("nascimento"));
            usuario.setTelefone(usuarioObj.getString("telefone"));
            usuario.setSenha(usuarioObj.getString("senha"));

            usuario.getEndereco().setId(usuarioObj.getInt("id"));
            usuario.getEndereco().setEstado(usuarioObj.getString("estado"));
            usuario.getEndereco().setCidade(usuarioObj.getString("cidade"));
            usuario.getEndereco().setBairro(usuarioObj.getString("bairro"));
            usuario.getEndereco().setRua(usuarioObj.getString("rua"));
            usuario.getEndereco().setNumero(usuarioObj.getInt("numero"));

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        finally
        {
            return usuario;
        }
    }

    public static List<Usuario>JSONListaUsuario(String jsonFile)
    {
     JSONObject mainObj = null;
     Usuario usuario = null;
        List<Usuario>usuarios= null;

        try
        {
            mainObj = new JSONObject(jsonFile);
            JSONArray listObj = mainObj.getJSONArray("lista");

            for(int i = 0 ; i <= listObj.length();i++ )
            {
                JSONObject usuarioObj = (JSONObject) listObj.get(i);

                usuario.setId(usuarioObj.getInt("id"));
                usuario.setNome(usuarioObj.getString("nome"));
                usuario.setEmail(usuarioObj.getString("email"));
                usuario.setNascimento(usuarioObj.getString("nascimento"));
                usuario.setTelefone(usuarioObj.getString("telefone"));
                usuario.setSenha(usuarioObj.getString("senha"));

                usuario.getEndereco().setId(usuarioObj.getInt("id"));
                usuario.getEndereco().setEstado(usuarioObj.getString("estado"));
                usuario.getEndereco().setCidade(usuarioObj.getString("cidade"));
                usuario.getEndereco().setBairro(usuarioObj.getString("bairro"));
                usuario.getEndereco().setRua(usuarioObj.getString("rua"));
                usuario.getEndereco().setNumero(usuarioObj.getInt("numero"));

                usuarios.add(usuario);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();

    }
        finally {
        return usuarios;
        }
        }

    //Endereco
    public static Endereco JSONEndereco(String jsonFile) {
        JSONObject mainObj = null;
        Endereco endereco = null;

        try {
            mainObj = new JSONObject(jsonFile);
            JSONObject enderecoObjeto = mainObj.getJSONObject("endereco");
            endereco.setId(enderecoObjeto.getInt("id"));
            endereco.setEstado(enderecoObjeto.getString("estado"));
            endereco.setCidade(enderecoObjeto.getString("cidade"));
            endereco.setBairro(enderecoObjeto.getString("bairro"));
            endereco.setRua(enderecoObjeto.getString("rua"));
            endereco.setNumero(enderecoObjeto.getInt("numero"));

        } catch (JSONException e) {
            e.printStackTrace();
        } finally {

            return endereco;
        }

    }

    public static List<Endereco> JSONEnderecoLista(String jsonFile)
    {
        JSONObject mainObj = null;
        Endereco endereco= null;
        List<Endereco>enderecos = null;
        try
        {
        mainObj= new JSONObject(jsonFile);
            JSONArray listaEndereco = mainObj.getJSONArray("lista");

            for (int i = 0; i <= listaEndereco.length();i++)
            {
                JSONObject enderecoObjeto = (JSONObject) listaEndereco.get(i);

                endereco.setId(enderecoObjeto.getInt("id"));
                endereco.setEstado(enderecoObjeto.getString("estado"));
                endereco.setCidade(enderecoObjeto.getString("cidade"));
                endereco.setBairro(enderecoObjeto.getString("bairro"));
                endereco.setRua(enderecoObjeto.getString("rua"));
                endereco.setNumero(enderecoObjeto.getInt("numero"));

                enderecos.add(endereco);
            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        finally {
            return enderecos;
        }
    }

    //Genero
    public static Genero JSONGenero(String jsonFile)
    {
        JSONObject mainObj = null;
        Genero genero = null;

        try
        {
            JSONObject generoObjeto = mainObj.getJSONObject("genero");
            genero.setId(generoObjeto.getInt("id"));
            genero.setNome(generoObjeto.getString("nome"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        finally {
            return genero;
        }
    }

    public static List<Genero> JSONGeneroLista(String jsonFile)
    {
        JSONObject mainObj = null;
        Genero genero = null;
        List<Genero>generos = null;

        try
        {
            mainObj = new JSONObject(jsonFile);
            JSONArray listaGenero = mainObj.getJSONArray("lista");

            for (int i = 0; i <= listaGenero.length(); i++ )
            {
                JSONObject generoObjeto = (JSONObject) listaGenero.get(i);
                genero.setId(generoObjeto.getInt("id"));
                genero.setNome(generoObjeto.getString("nome"));

                generos.add(genero);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        finally {
            return generos;
        }
    }

    public static Video JSONVideo(String jsonFile)
    {

        JSONObject mainObj = null;
        Video video = null;
        List<Genero>generos;
        try{
            JSONObject videoObj = mainObj.getJSONObject("video");
            JSONArray generoOBJ = videoObj.getJSONArray("generos");
            for(int i = 0; i<= generoOBJ.length();i++)
            {
                
            }
            video.setId(videoObj.getInt("id"));
            video.getProfissional().setId(videoObj.getJSONObject("profissional").getInt("id"));
            video.getEmpresa().setId(videoObj.getJSONObject("empresa").getInt("id"));
            video.setAvaliacao(mainObj.getInt("avaliacao"));
            video.setLink(mainObj.getString("descricao"));


        }
        catch (JSONException e)
        {
        e.printStackTrace();
        }
        finally {
            return video;
        }
    }

}
