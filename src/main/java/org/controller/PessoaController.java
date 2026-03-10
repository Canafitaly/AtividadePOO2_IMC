package org.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.model.Arquivo;
import org.model.Pessoa;

import java.io.IOException;

public class PessoaController {

    Pessoa pessoa;
    //entradas
    @FXML
    private TextArea TextAltura;
    @FXML
    private TextArea TextPeso;
    @FXML
    private TextArea TextNome;
    @FXML
    private TextArea TextIdade;
    @FXML
    private TextArea TextCPF;

    //reativos
    @FXML
    private Button BotaoCalcular;
    @FXML
    private Button CriarArquivo;

    //saidas
    @FXML
    private Label SaidaNome;
    @FXML
    private Label SaidaResultado;
    @FXML
    private Label SaidaIMC;


    @FXML
    private void calcularPessoa(){
        try{
            String nome =TextNome.getText();
            String cpf =TextCPF.getText();
            double altura=Double.parseDouble(TextAltura.getText());
            double peso=Double.parseDouble(TextPeso.getText());
            int idade=Integer.parseInt(TextIdade.getText());

            pessoa = new Pessoa(nome, altura, peso, idade, cpf);

            SaidaNome.setText("Nome: " + pessoa.getNome() + " | CPF: " + cpf);
            SaidaResultado.setText("Idade: " + pessoa.getIdade() + " anos");
            SaidaIMC.setText("IMC: " + String.format("%.2f", pessoa.getImc()) +
                    " → " + pessoa.getSaude());
        }catch (NumberFormatException e) {
             SaidaResultado.setText("Erro: altura, peso e idade devem ser números!");
        }

    }
    @FXML
    private void criarArquivo(){
        try{
            Arquivo arquivo =new Arquivo("PessoaIMC.txt",pessoa.getNome(),pessoa.getSaude(),pessoa.getPeso(),pessoa.getAltura(), pessoa.getImc(), pessoa.getIdade());
            SaidaResultado.setText("Arquivo criado com sucesso");
        }catch (NumberFormatException | IOException e) {
            SaidaResultado.setText("problema na criação do arquivo");
        }
    }
}
