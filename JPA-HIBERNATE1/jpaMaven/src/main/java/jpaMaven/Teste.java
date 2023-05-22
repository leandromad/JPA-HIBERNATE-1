package jpaMaven;
import java.util.Scanner;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Principal principal = Principal.getInstance();

        int opcao = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Remover");
            System.out.println("3 - Procurar por ID");
            System.out.println("4 - Mostrar BD");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    inserirPessoa(scanner, principal);
                    break;
                case 2:
                    removerPessoa(scanner, principal);
                    break;
                case 3:
                    procurarPessoa(scanner, principal);
                    break;
                case 4:
                    mostrarTodosCadastros(principal);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void inserirPessoa(Scanner scanner, Principal principal) {
        System.out.println("Digite o nome da pessoa:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email da pessoa:");
        String email = scanner.nextLine();

        System.out.println("Digite o cargo da pessoa:");
        String cargo = scanner.nextLine();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setEmail(email);
        pessoa.setCargo(cargo);

        principal.persist(pessoa);

        System.out.println("Pessoa persistida com sucesso!");
    }

    private static void removerPessoa(Scanner scanner, Principal principal) {
        System.out.println("Digite o ID da pessoa a ser removida:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        Pessoa pessoa = principal.getById(id);

        if (pessoa != null) {
            principal.remove(pessoa);
            System.out.println("Pessoa removida com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada!");
        }
    }

    private static void procurarPessoa(Scanner scanner, Principal principal) {
        System.out.println("Digite o ID da pessoa a ser procurada:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        Pessoa pessoa = principal.getById(id);

        if (pessoa != null) {
            System.out.println("Pessoa encontrada: " + pessoa);
        } else {
            System.out.println("Pessoa não encontrada!");
        }
    }
    
    private static void mostrarTodosCadastros(Principal principal) {
        List<Pessoa> pessoas = principal.findAll();

        System.out.println("Todos os cadastros:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }

}
