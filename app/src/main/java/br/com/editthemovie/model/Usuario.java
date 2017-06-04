package br.com.editthemovie.model;

/**
 * Created by Diogo on 03/06/2017.
 */

public class Usuario {

    private int       id;
    private String    nome;
    private String    email;
    private String 	  nascimento;
    private String	  telefone;
    private String	  senha;
    private Endereco  endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String pNome)
    {
        nome = pNome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }


    public String getNascimento()
    {
        return nascimento;
    }

    public void setNascimento(String pNascimento)
    {
        nascimento = pNascimento;
    }


    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String pTelefone)
    {
        telefone = pTelefone;
    }



    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String pSenha)
    {
        senha = pSenha;
    }



}
