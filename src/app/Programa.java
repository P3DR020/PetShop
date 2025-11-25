package app;

// Importações necessárias
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

    // Scanner dentro de try-with-resources → fecha automaticamente no final
    try (Scanner sc = new Scanner(System.in)) {

      // Instância dos serviços principais do sistema
      ClienteService cs = new ClienteService();   // gerencia clientes
      AnimalService as = new AnimalService();     // gerencia animais
      CompraService compraService = new CompraService(); // gerencia compras

      // Lista onde os produtos do PetShop serão armazenados
      ArrayList<Produto> produtos = new ArrayList<>();

      // Chamada do método que cadastra dados automáticos obrigatórios da P1
      cadastrarAutomatico(cs, as, produtos);

      int opc; // variável que controla o menu

      // Loop principal (menu)
      do {
          System.out.println("\n╔════════════════════════════════════╗");
          System.out.println("║             PETSHOP                ║");
          System.out.println("╠════════════════════════════════════╣");
          System.out.println("║  1  ▸  Cadastrar Cliente           ║");
          System.out.println("║  2  ▸  Cadastrar Animal            ║");
          System.out.println("║  3  ▸  Listar Clientes c/ Animais  ║");
          System.out.println("║  4  ▸  Listar Animais              ║");
          System.out.println("║  5  ▸  Remover Cliente             ║");
          System.out.println("║  6  ▸  Buscar Animal por Nome      ║");
          System.out.println("║  7  ▸  Buscar Cliente (Nome/CPF)   ║");
          System.out.println("║  8  ▸  Realizar Compra             ║");
          System.out.println("║  9  ▸  Listar Compras              ║");
          System.out.println("║ 10 ▸  Listar Animais de Cliente    ║");
          System.out.println("║ 11 ▸  Serviços Pet                 ║");
          System.out.println("║ 12 ▸  Sair                         ║");
          System.out.println("╚════════════════════════════════════╝");
          System.out.print("\n▶ Opção: ");

        // Lendo a opção
        opc = sc.nextInt();
        sc.nextLine(); // consome ENTER

        // Processamento da opção escolhida
        switch (opc) {

          // Cadastro de cliente
          case 1 -> cs.cadastrar(sc);

          // Cadastro de animal (cliente deve existir)
          case 2 -> as.cadastrar(sc, cs.getLista());

          // Lista clientes ordenados + animais
          case 3 -> cs.listarOrdenado(as.getLista());

          // Lista todos os animais cadastrados
          case 4 -> as.listar();

          // Remoção de cliente pelo CPF
          case 5 -> {
            System.out.print("CPF do cliente: ");
            String cpf = sc.nextLine();
            cs.remover(cpf, sc);
          }

          // Busca animal por nome
          case 6 -> {
            System.out.print("Nome do animal: ");
            String nome = sc.nextLine();
            var animal = as.buscar(nome);

            if (animal != null)
              System.out.println(animal);
            else
              System.out.println("Animal não encontrado.");
          }

          // Busca cliente por nome ou CPF
          case 7 -> {
            System.out.println("Buscar Cliente por:");
            System.out.println("1 | Nome");
            System.out.println("2 | CPF");
            int tipo = sc.nextInt();
            sc.nextLine();

            if (tipo == 1) {
              System.out.print("Nome: ");
              String nome = sc.nextLine();
              var cliente = cs.buscarPorNome(nome);

              if (cliente != null)
                System.out.println(cliente);
              else
                System.out.println("Cliente não encontrado.");

            } else {
              System.out.print("CPF: ");
              String cpfBusca = sc.nextLine();
              var cliente = cs.buscarPorCpf(cpfBusca);

              if (cliente != null)
                System.out.println(cliente);
              else
                System.out.println("Cliente não encontrado.");
            }
          }

          // Realizar compra (produto + cliente escolhido)
          case 8 -> compraService.realizarCompra(sc, cs.getLista(), produtos);

          // Listar todas as compras registradas
          case 9 -> compraService.listarCompras();

          // Lista animais pertencentes a um cliente específico
          case 10 -> {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = sc.nextLine();
            Cliente cliente = cs.buscarPorCpf(cpf);

            if (cliente != null) {
              cs.listarAnimaisDoCliente(cliente, as.getLista());
            } else {
              System.out.println("Cliente não encontrado.");
            }
          }
          // Listar serviços 
          case 11 -> System.out.println("Em desenvolvimento...");
          // Sair do programa
          case 12 -> System.out.println("Saindo...");

          // Opção inválida
          default -> System.out.println("Opção inválida.");
        }

      } while (opc != 11); // repete até o usuário escolher sair
    }
  }

  // Método que cadastra dados automaticamente (exigência da P1)
  private static void cadastrarAutomatico(ClienteService cs, AnimalService as, ArrayList<Produto> produtos) {

    // === CLIENTES PADRÃO ===
    Cliente c1 = new Cliente("Maria", 30, "12345678900", "99999-1111", "Rua A");
    Cliente c2 = new Cliente("João", 22, "98765432100", "98888-2222", "Rua B");

    // Adicionando clientes na lista
    cs.getLista().add(c1);
    cs.getLista().add(c2);

    // === ANIMAIS PADRÃO (com vinculação ao dono) ===
    as.getLista().add(new Cachorro("Rex", 2018, "Macho", "Pastor Alemão", c1));
    as.getLista().add(new Gato("Luna", 2020, "Fêmea", "Cinza", c2));
    as.getLista().add(new Cachorro("Bob", 2017, "Macho", "Poodle", c1));

    // Serviço padrão (apenas demonstração)
    Servico servicoPadrao = new Servico("Banho e Tosa", 89.90);
    System.out.println("Serviço carregado: " + servicoPadrao);

    // === PRODUTOS PADRÃO ===
    produtos.add(new Produto("Ração Premium", 79.90, 20)); // obrigatório
    produtos.add(new Produto("Shampoo Pet", 25.00, 30));
    produtos.add(new Produto("Osso de Brinquedo", 19.90, 50));

    System.out.println("Produtos carregados automaticamente!");
  }
}
