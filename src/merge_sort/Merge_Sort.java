package merge_sort;

import java.util.Scanner;

public class Merge_Sort {

    public static void main(String[] args) {
        int X[] = new int[10];
        int i;
        Scanner entrada = new Scanner(System.in);

        //carregando os números no vetor
        for (i = 0; i <= 9; i++) {
            System.out.println("Digite o " + (i + 1) + "º número: ");
            X[i] = entrada.nextInt();
        }

        //ordenando de forma crescente
        merge(X, 0, 9);

        //mostrando o vetor ordenado
        for (i = 0; i <= 9; i++) {
            System.out.println((i + 1) + "º número: " + X[i]);
        }
    }

    private static void merge(int[] X, int inicio, int fim) {
        int meio;
        if (inicio < fim) {
            meio = (inicio + fim) / 2;
            merge(X, inicio, meio);
            merge(X, meio + 1, fim);
            intercala(X, inicio, fim, meio);
        }
    }

    private static void intercala(int[] X, int inicio, int fim, int meio) {
        int poslivre, inicio_vetor1, inicio_vetor2, i;
        int aux[] = new int[10];
        inicio_vetor1 = inicio;
        inicio_vetor2 = meio + 1;
        poslivre = inicio;
        while (inicio_vetor1 <= meio && inicio_vetor2 <= fim) {
            if (X[inicio_vetor1] <= X[inicio_vetor2]) {
                aux[poslivre] = X[inicio_vetor1];
                inicio_vetor1 = inicio_vetor1 + 1;
            } else {
                aux[poslivre] = X[inicio_vetor2];
                inicio_vetor2 = inicio_vetor2 + 1;
            }
            poslivre = poslivre + 1;
        }

        //se ainda existem números no primeiro vetor
        //que não foram intercalados
        for (i = inicio_vetor1; i <= meio; i++) {
            aux[poslivre] = X[i];
            poslivre = poslivre + 1;
        }

        //retorna os valores do vetor aux para o vetor x
        for(i=inicio; i<=fim; i++){
            X[i] = aux[i];
        }
    }
}