package model;

public class Animal {
    protected String nome;
    protected int anoNascimento;
    protected String sexo;

    public Animal(String nome, int anoNascimento, String sexo) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.sexo = sexo;
    }

    public String getNome() { return nome; }
    public int getAnoNascimento() { return anoNascimento; }
    public String getSexo() { return sexo; }

    @Override
    public String toString() {
        return String.format("Animal: %s | Ano: %d | Sexo: %s", nome, anoNascimento, sexo);
    }
}
