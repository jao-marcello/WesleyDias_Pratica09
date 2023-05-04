import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vetor = new int[10];

        System.out.println("Informe os 10 números do vetor em ordem crescente: ");

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(vetor));

        while (true) {
            System.out.println("Informe o número a ser pesquisado (ou um número negativo para sair):");
            int numero = sc.nextInt();

            if (numero < 0) {
                break;
            }

            int resultado = pesquisaBinaria(vetor, numero);

            if (resultado == -1) {
                System.out.println("O número " + numero + " não foi encontrado no vetor.");
            } else {
                System.out.println("O número " + numero + " foi encontrado na posição " + resultado + " do vetor.");
            }
        }

        sc.close();
    }

    public static int pesquisaBinaria(int[] vetor, int numero) {
        int esquerda = 0;
        int direita = vetor.length - 1;

        int comparacoes = 0;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            comparacoes++;

            if (vetor[meio] == numero) {
                System.out.println("Número de comparações: " + comparacoes);
                return meio;
            } else if (vetor[meio] < numero) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        System.out.println("Número de comparações: " + comparacoes);
        return -1;
    }
}