package model;

/**
 * Classe Cliente — herda de Pessoa.
 * Representa um cliente do PetShop com dados adicionais:
 * CPF, telefone e endereço.
 */
public class Cliente extends Pessoa {

  // CPF do cliente (identificação única)
  private final String cpf;

  // Telefone para contato
  private final String telefone;

  // Endereço do cliente
  private final String endereco;

  /**
   * Construtor do Cliente.
   * Recebe nome e idade (da classe Pessoa) + dados específicos do cliente.
   */
  public Cliente(String nome, int idade, String cpf, String telefone, String endereco) {
    super(nome, idade); // chama construtor da classe Pessoa
    this.cpf = cpf;
    this.telefone = telefone;
    this.endereco = endereco;
  }

  // Getters dos atributos específicos do Cliente
  public String getCpf() {
    return cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getEndereco() {
    return endereco;
  }

  /**
   * Representação em texto do cliente.
   * Usada nas listagens e buscas.
   */
  @Override
  public String toString() {
    return String.format(
      "Nome: %s\nIdade: %d\nCPF: %s\nTelefone: %s\nEndereço: %s",
      nome, idade, cpf, telefone, endereco
    );
  }
}
