import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] vetor = new int[10];

        System.out.println("Digite 10 números inteiros:");

        for (int i = 0; i < 10; i++) {
            vetor[i] = input.nextInt();
        }

        while (true) {
            System.out.println("\nDigite o número a ser pesquisado:");
            int numero = input.nextInt();

            System.out.println("Qual algoritmo de busca deseja utilizar?");
            System.out.println("1 - Sequencial");
            System.out.println("2 - Sequencial com Sentinela");
            int opcao = input.nextInt();

            int comparacoes = 0;
            int posicao = -1;

            switch (opcao) {
                case 1:
                    for (int i = 0; i < vetor.length; i++) {
                        comparacoes++;
                        if (vetor[i] == numero) {
                            posicao = i;
                            break;
                        }
                    }
                    break;
                case 2:
                    int ultimoElemento = vetor[vetor.length - 1];
                    vetor[vetor.length - 1] = numero;

                    int i = 0;
                    while (vetor[i] != numero) {
                        i++;
                        comparacoes++;
                    }

                    vetor[vetor.length - 1] = ultimoElemento;

                    if (i < vetor.length - 1 || vetor[vetor.length - 1] == numero) {
                        posicao = i;
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            if (posicao == -1) {
                System.out.println("Número não encontrado.");
            } else {
                System.out.println("Número encontrado na posição " + posicao + ".");
            }

            System.out.println("Comparações realizadas: " + comparacoes);

            System.out.println("\nDeseja pesquisar outro número? (s/n)");
            String resposta = input.next();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }

        input.close();
    }
}