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

    try (Scanner sc = new Scanner(System.in)) {

      ClienteService cs = new ClienteService();
      AnimalService as = new AnimalService();
      CompraService compraService = new CompraService();

      ArrayList<Produto> produtos = new ArrayList<>();
      ArrayList<Servico> servicosPet = carregarServicosPet();

      cadastrarAutomatico(cs, as, produtos);

      int opc;

      do {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║             PETSHOP                ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║  1  -  Cadastrar Cliente           ║");
        System.out.println("║  2  -  Cadastrar Animal            ║");
        System.out.println("║  3  -  Listar Clientes c/ Animais  ║");
        System.out.println("║  4  -  Listar Animais              ║");
        System.out.println("║  5  -  Remover Cliente             ║");
        System.out.println("║  6  -  Buscar Animal por Nome      ║");
        System.out.println("║  7  -  Buscar Cliente (Nome/CPF)   ║");
        System.out.println("║  8  -  Abrir Carrinho (Nova Compra)║");
        System.out.println("║  9  -  Listar Compras              ║");
        System.out.println("║ 10  -  Listar Animais de Cliente   ║");
        System.out.println("║ 11  -  Serviços do Animal          ║");
        System.out.println("║ 12  -  Sair                        ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("\n▶ Opção: ");

        opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {

          case 1 ->
            cs.cadastrar(sc);

          case 2 ->
            as.cadastrar(sc, cs.getLista());

          case 3 ->
            cs.listarOrdenado(as.getLista());

          case 4 ->
            as.listar();

          case 5 -> {
            System.out.print("CPF do cliente: ");
            String cpf = sc.nextLine();
            cs.remover(cpf, sc);
          }

          case 6 -> {
            System.out.print("Nome do animal: ");
            String nome = sc.nextLine();
            var animal = as.buscar(nome);

            if (animal != null)
              System.out.println(animal);
            else
              System.out.println("Animal não encontrado.");
          }

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
          case 8 ->
            compraService.abrirCarrinho(
                sc,
                cs.getLista(),
                produtos,
                as.getLista(),
                servicosPet);

          case 9 ->
            compraService.listarCompras();

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

          case 11 -> {
            System.out.println("\n=== SERVIÇOS DO ANIMAL ===");
            System.out.println("1 - Aplicar Serviço no Animal");
            System.out.println("2 - Listar Serviços do Animal");

            int serv = sc.nextInt();
            sc.nextLine();

            if (serv == 1) {
              as.aplicarServico(sc);
            } else if (serv == 2) {
              as.listarServicosDoAnimal(sc);
            } else {
              System.out.println("Opção inválida.");
            }
          }

          case 12 -> {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║       SAINDO DO SISTEMA      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("Obrigado por usar o PetShop!");
            System.out.println("Volte sempre!");
          }

          default ->
            System.out.println("Opção inválida.");
        }

      } while (opc != 12);
    }
  }

  // SERVIÇOS PET LISTA
  private static ArrayList<Servico> carregarServicosPet() {

    ArrayList<Servico> lista = new ArrayList<>();

    lista.add(new Servico("Banho", 35));
    lista.add(new Servico("Tosa", 50));
    lista.add(new Servico("Vacina", 80));
    lista.add(new Servico("Hidratação", 45));
    lista.add(new Servico("Corte de Unhas", 20));
    lista.add(new Servico("Limpeza de Ouvido", 30));
    lista.add(new Servico("Desembolo de Pelo", 60));
    lista.add(new Servico("Tratamento Anti-Pulgas", 70));
    lista.add(new Servico("Escovação de Dentes", 25));
    lista.add(new Servico("Banho Medicamentoso", 55));

    return lista;
  }

  private static void cadastrarAutomatico(
      ClienteService cs,
      AnimalService as,
      ArrayList<Produto> produtos) {

    Cliente c1 = new Cliente("Maria", 30, "12345678900", "99999-1111", "Rua A");
    Cliente c2 = new Cliente("João", 22, "98765432100", "98888-2222", "Rua B");

    cs.getLista().add(c1);
    cs.getLista().add(c2);

    as.getLista().add(new Cachorro("Rex", 2018, "Macho", "Pastor Alemão", c1));
    as.getLista().add(new Gato("Luna", 2020, "Fêmea", "Cinza", c2));
    as.getLista().add(new Cachorro("Bob", 2017, "Macho", "Poodle", c1));

    produtos.add(new Produto("Ração Premium", 79.90, 20));
    produtos.add(new Produto("Shampoo Pet", 25.00, 30));
    produtos.add(new Produto("Osso de Brinquedo", 19.90, 50));

    System.out.println("Dados carregados automaticamente!");
  }
}
