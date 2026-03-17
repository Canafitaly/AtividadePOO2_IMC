package org.model;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    public Path caminhodoarquivo;
    public String campos = "nome; saude; peso; altura; imc; idade";

    public Arquivo(String nomeArquivo, String nome, String saude, double peso, double altura, double imc, int idade) throws IOException {
        //criar caso não exista o arquivo
        caminhodoarquivo = Paths.get(nomeArquivo);

        //salvando o progresso e vendo se as colunas existem
        List<String> gravados=verificandoSalvos();

        // Adiciona novo registro
        String texto = organizar(nome, saude, peso, altura, imc, idade);
        gravados.add(texto);

        //escrevendo no .txt
        escrever(gravados);
    }
    public List<String> verificandoSalvos() throws IOException{
        List<String> gravados = Files.exists(caminhodoarquivo) ? new ArrayList<>(Files.readAllLines(caminhodoarquivo)) : new ArrayList<>();
        // Adiciona cabeçalho se não existir
        if (!gravados.contains(this.campos)) {
            gravados.add(campos);
        }
        return gravados;
    }

    public String organizar(String nome, String saude, double peso, double altura, double imc, int idade) {
        return nome + "; " + saude + "; " + peso + "; " + altura + "; " + imc + "; " + idade;
    }
    public void escrever(List<String> gravados) throws IOException{
        // Reescreve o arquivo inteiro
        Files.write(caminhodoarquivo, gravados, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
