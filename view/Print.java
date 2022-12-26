package view;

public class Print {
    
    public static void imprimirTabuleiro(String [][] tabuleiro) {
        // System.out.println(" "+" A "+"B "+"C "+"D "+"E "+"F "+"G "+"H "+"I "+"J");
        System.out.println(" "+" 0 "+"1 "+"2 "+"3 "+"4 "+"5 "+"6 "+"7 "+"8 "+"9");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(i+ " ");
            for (int j = 0; j < tabuleiro.length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        // IMPRIMIR OS NOMES DAS LINHAS/COLUNAS
    }
}
