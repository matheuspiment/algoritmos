package br.ufg.inf.es.construcao.cpf;

import br.ufg.inf.es.construcao.matematica.Mod;

/**
 * Implementação do algoritmo que verifica a validade de um CPF.
 */
public class Cpf {

    /**
     * Verifica a validade de um CPF
     * por meio dos dígitos verificadores d[10] e d[11].
     *
     * @param d Algarismos numéricos do CPF(11 dígitos).
     *
     * @return Retorna true caso o CPF seja válido e false, caso contrário.
     *
     * @throws IllegalArgumentException Caso o tamanho
     * do vetor(quantidades de dígitos) ou seus valores sejam inválidos.
     * O tamanho do vetor deve ser d + 1.
     * Cada valor no de ser de apenas um dígito, ou seja, maior que -1
     * ou menor que 10.
     */
    public static boolean verifica(int[] d) {
        if(d.length < 12) {
            throw new IllegalArgumentException("vetor inválido");
        }

        for (int i = 1; i < 12; i++) {
            if (d[i] < 0 || d[i] > 9) {
                throw new IllegalArgumentException("valores inválidos");
            }
        }

        int c = 8;
        int p = d[9]; // p iniciando com o dígito i.
        int s = d[9]; // s iniciando com o dígito i.

        while (c >= 1) {
            p = p + d[c];
            s = s + p;
            c = c - 1;
        }

        int j = Mod.mod(Mod.mod(s, 11), 10);
        int k = Mod.mod(Mod.mod(s - p + 9 * j, 11), 10);

        return (j == d[10] && k == d[11]);
    }
}
