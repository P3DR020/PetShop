package app;

import java.util.ArrayList;
import java.util.Scanner;
import model.Cachorro;
import model.Cliente;
import model.Gato;
import model.Produto;
import model.Servico;
import service.AnimalService;
import service.ClienteService;
import service.CompraService;

public class Programa {

  public static void main(String[] args) {

    // Services
    try (Scanner in = new Scanner(System.in)) {
      // Services
      ClienteService cs = new ClienteService();
      AnimalService as = new AnimalService();
      CompraService compraService = new CompraService();

      // Lista para produtos
      ArrayList<Produto> produtos = new ArrayList<>();

      // Cadastro automático obrigatório P1
      cadastrarAutomatico(cs, as, produtos);

      int opc;

      do {
        System.out.println("\n==== PETSHOP ====");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Animal ");
        System.out.println("3 - Listar Clientes (com Animais)");
        System.out.println("4 - Listar Animais");
        System.out.println("5 - Remover Cliente");
        System.out.println("6 - Buscar Animal por Nome");
        System.out.println("7 - Buscar Cliente (Nome ou CPF)");
        System.out.println("8 - Realizar Compra");
        System.out.println("9 - Listar Compras");
        System.out.println("10 - Listar Animais de um Cliente");
        System.out.println("11 - Sair");
        System.out.print("Opção: ");

        opc = in.nextInt();
        in.nextLine();

        switch (opc) {

          case 1 -> cs.cadastrar(in);

          case 2 -> as.cadastrar(in, cs.getLista());

          case 3 -> cs.listarOrdenado(as.getLista());

          case 4 -> as.listar();

          case 5 -> {
            System.out.print("CPF do cliente: ");
            String cpf = in.nextLine();
            cs.remover(cpf, in);
          }

          case 6 -> {
            System.out.print("Nome do animal: ");
            String nome = in.nextLine();
            var animal = as.buscar(nome);
            if (animal != null)
              System.out.println(animal);
            else
              System.out.println("Animal não encontrado.");
          }

          case 7 -> {
            System.out.println("Buscar Cliente por:");
            System.out.println("1 - Nome");
            System.out.println("2 - CPF");
            int tipo = in.nextInt();
            in.nextLine();

            if (tipo == 1) {
              System.out.print("Nome: ");
              String nome = in.nextLine();
              var cliente = cs.buscarPorNome(nome);
              if (cliente != null)
                System.out.println(cliente);
              else
                System.out.println("Cliente não encontrado.");
            } else {
              System.out.print("CPF: ");
              String cpfBusca = in.nextLine();
              var cliente = cs.buscarPorCpf(cpfBusca);
              if (cliente != null)
                System.out.println(cliente);
              else
                System.out.println("Cliente não encontrado.");
            }
          }

          case 8 -> compraService.realizarCompra(in, cs.getLista(), produtos);

          case 9 -> compraService.listarCompras();

          case 10 -> {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = in.nextLine();
            Cliente cliente = cs.buscarPorCpf(cpf);

            if (cliente != null) {
              cs.listarAnimaisDoCliente(cliente, as.getLista());
            } else {
              System.out.println("Cliente não encontrado.");
            }
          }

          case 11 -> System.out.println("Saindo...");

          default -> System.out.println("Opção inválida.");
        }

      } while (opc != 11);
    }
  }

  // Cadastro Automático — obrigatório pela P1
  private static void cadastrarAutomatico(ClienteService cs, AnimalService as, ArrayList<Produto> produtos) {

    // 2 CLIENTES
    Cliente c1 = new Cliente("Maria", 30, "12345678900", "99999-1111", "Rua A");
    Cliente c2 = new Cliente("João", 22, "98765432100", "98888-2222", "Rua B");

    cs.getLista().add(c1);
    cs.getLista().add(c2);

    // 3 ANIMAIS (com herança + DONO vinculado)
    as.getLista().add(new Cachorro("Rex", 2018, "Macho", "Pastor Alemão", c1));
    as.getLista().add(new Gato("Luna", 2020, "Fêmea", "Cinza", c2));
    as.getLista().add(new Cachorro("Bob", 2017, "Macho", "Poodle", c1));

    // 1 SERVIÇO (só para exibir)
    Servico servicoPadrao = new Servico("Banho e Tosa");
    System.out.println("Serviço carregado: " + servicoPadrao);

    // 1 PRODUTO obrigatório
    produtos.add(new Produto("Ração Premium", 79.90, 20));

    // Produtos extras
    produtos.add(new Produto("Shampoo Pet", 25.00, 30));
    produtos.add(new Produto("Osso de Brinquedo", 19.90, 50));

    System.out.println("Produtos carregados automaticamente!");
  }
}