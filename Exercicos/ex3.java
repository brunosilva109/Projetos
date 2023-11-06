import java.util.Scanner;
public class ex3{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("informe L da Matriz:");
        int l = in.nextInt();
        System.out.println("informe C da Matriz:");
        int c = in.nextInt();
        int [][] matriz = new int[c][l];
        for(int i  = 0 ; i<matriz.length; i++){
            for(int j = 0; j<matriz[0].length; j++){
                System.out.println("informe o elemento ( "+i + ", "+ j+" ) da matriz");
                matriz[i][j] = in.nextInt();
            }
        }
        printaMatriz(matriz);
        printaMatriz(transposta(matriz));
        in.close();
    }
    public static void printaMatriz(int[][] matriz){
        for(int i  = 0 ; i<matriz[0].length; i++){
            for(int j = 0; j<matriz.length; j++){
                System.out.print(matriz[j][i]+ " ");
            }
            System.out.println("");
        }
    }
    public static int[][] transposta(int[][] matriz){
        int[][] transposta = new int[matriz[0].length][matriz.length];
        for(int i  = 0 ; i<matriz[0].length; i++){
                for(int j = 0; j<matriz.length; j++){
                   transposta[i][j] = matriz[j][i];
                }
            }

        return transposta;
    }
}