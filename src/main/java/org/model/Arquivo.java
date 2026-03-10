package org.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Arquivo {
    Path caminhodoarquivo;
    public Arquivo(String nomeArquivo,String nome,String saude,double peso,double altura,double imc, int idade ) throws IOException {
        caminhodoarquivo= Paths.get(nomeArquivo);
        String texto=escrever(nome,saude,peso,altura,imc,idade);
        Files.writeString(caminhodoarquivo,texto);
    }
    public String escrever(String nome,String saude,double peso, double altura, double imc, int idade){
        String texto="Nome "+nome+"\n"+"Saude "+saude+"\n"+"peso "+peso+"\n"+"altura "+altura+"\n"+"IMC "+imc+"\n"+"idade "+idade;
        return texto;
    }
}
