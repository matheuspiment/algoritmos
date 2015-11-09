package br.ufg.inf.es.construcao.array;

/**
 * Implementação do algoritmo que soma os n primeiros elementos do array.
 */
public class SomaArray {

    /**
     * Soma os n primeiros elementos de um dado array.
     *
     * @param A Elementos do array.
     * @param n Indica os n primeiros elementos que serão somados.
     *
     * @return A soma dos elementos n primeiros elementosdos array.
     *
     * @throws IllegalArgumentException Caso o parâmetro de entrada seja inválido.
     * O parâmetro n deve ser maior que -1.
     */
    public static int somaArray(int[] A, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n inválido");
        }

        if (A.length < (n + 1)) {
            throw new IllegalArgumentException("tamanho do vetor");
        }

        int s = 0; // Acumula os valores dos elementos do array.
        int i = 1;

        while (i <= n) {
            s = s + A[i];
            i = i + 1;
        }

        return s;
    }
}
