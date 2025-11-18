package model;

public class Animal {

  protected String nome;
  protected int anoNascimento;
  protected String sexo;

  // Novo atributo: Dono do animal
  protected Cliente dono;

  public Animal(String nome, int anoNascimento, String sexo, Cliente dono) {
    this.nome = nome;
    this.anoNascimento = anoNascimento;
    this.sexo = sexo;
    this.dono = dono;
  }

  public Cliente getDono() {
    return dono;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return "Animal: " + nome +
        " | Ano: " + anoNascimento +
        " | Sexo: " + sexo +
        " | Dono: " + dono.getNome();
  }
}
