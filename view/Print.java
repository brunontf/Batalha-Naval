package view;

public class Print {
    
    public static void imprimirTabuleiro(String [][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        // IMPRIMIR OS NOMES DAS LINHAS/COLUNAS
    }
}
