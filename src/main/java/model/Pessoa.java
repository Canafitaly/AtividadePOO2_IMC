package model;

public class Pessoa {
    private String nome, saude, cpf;
    private double altura,peso,imc;
    private int idade;


    public Pessoa(String nome, double altura, double peso,int idade, String cpf){
        this.nome=nome;
        this.altura=altura;
        this.cpf=cpf;
        this.peso=peso;
        this.idade=idade;
        this.imc=calcularIMC();
        this.saude=estadoSaude();
    }
    public double calcularIMC(){
        return this.peso/(this.altura*this.altura);
    }

    public String estadoSaude(){
        String resposta;
        if(this.imc<=18.5){
            resposta="magra";
        }else if(this.imc<=24.9){
            resposta="saldavel";
        }else if(this.imc<=29.9){
            resposta="obesidade 1";
        }else if(this.imc<=39){
            resposta="obesidade 2";
        }else{
            resposta="obesidade 3";
        }
        return resposta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSaude() {
        return saude;
    }

    public void setSaude(String saude) {
        this.saude = saude;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

