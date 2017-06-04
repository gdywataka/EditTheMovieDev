package br.com.editthemovie.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

import br.com.editthemovie.model.Empresa;
import br.com.editthemovie.model.Profissional;

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
    public static Empresa JSONTEmpresa(String jsonFile){
        JSONObject mainObj;
        Empresa empresa = null;

        try {
            mainObj = new JSONObject(jsonFile);
            JSONObject cityObj = mainObj.getJSONObject("city");
            String nome_cidade = cityObj.getString("name");
            JSONArray listObj = mainObj.getJSONArray("list");
            JSONObject elementObj = (JSONObject) listObj.get(0);
            double temperatura = elementObj.getJSONObject("temp").getDouble("day");
            tempo = new Tempo();
            tempo.setCidade(nome_cidade);
            tempo.setTemperatura(temperatura);
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            return tempo;
        }
    }

    public static Profissional JSONTProfissional(String jsonFile){
        JSONObject mainObj;
        Profissional profissional = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            mainObj = new JSONObject(jsonFile);
            JSONObject empresaJason = mainObj.getJSONObject("profissional");
            profissional =objectMapper.readValues(empresaJason , profissional.class);
            JSONArray listaObj = mainObj.getJSONArray("lista");
            JSONObject boolJson = mainObj.getJSONObject("ok");

            Profissional obj =
            empresa.
            empresa = new Empresa();
            tempo.setCidade(nome_cidade);
            tempo.setTemperatura(temperatura);
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            return tempo;
        }
    }





}
