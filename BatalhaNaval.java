import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {
    public static void main(String[] args) {
        Random gerador = new Random();
        Scanner in = new Scanner(System.in);       
        int [][] tabuleiroJogador = new int [10][10];
        int [][] tabuleiroIa = new int [10][10];
        boolean[][] jogadasJogador = new boolean[10][10];
        boolean[][] jogadasIa = new boolean[10][10];

        gerarTabuleiro(tabuleiroJogador);
        gerarTabuleiro(tabuleiroIa);
        int acertosIa = 0;
        int acertos = 0;
        int ataqueC = 0;
        int ataqueL = 0;

        while (true) {
            // jogador jogando

            plotarTabuleiro(tabuleiroJogador, jogadasJogador);
            while(true){
                System.out.print("Informe a coluna que deseja jogar: ");
                ataqueC = in.nextInt();

                System.out.print("Informe a linha que deseja jogar: ");
                ataqueL = in.nextInt();
                if(ataqueC>9 || ataqueL>9 || ataqueC<0 || ataqueL<0){
                    System.out.println("jogada invalida tente novamente");

                }
            
                else if( jogadasJogador[ataqueC][ataqueL] == false){
                    jogadasJogador[ataqueC][ataqueL] = true;
                    if(tabuleiroJogador[ataqueC][ataqueL]!=0){
                        acertos++;
                    }
                    break;
                
                }
                else{
                    System.out.println("jogada invalida tente novamente");

                }
            }
            System.out.println("=========================================");
            if(acertos == 20){
                break;
            }
            // Ia joga
           
            while(true){
                ataqueC= gerador.nextInt(10);
                ataqueL= gerador.nextInt(10);
                if( jogadasIa[ataqueC][ataqueL] == false){
                    jogadasIa[ataqueC][ataqueL] = true;
                    if(tabuleiroIa[ataqueC][ataqueL]!=0){
                        acertosIa++;
                    }
                    System.out.println("Ia Jogou : (" + ataqueC + ", "+ ataqueL +")");
                    break;              
                }                
            } 
           
            plotarTabuleiro(tabuleiroIa, jogadasIa);
            System.out.println("=========================================");
            if(acertosIa == 20){
                break;
            }      
        }
        if(acertos == 20){
         System.out.print("venceu!!!");
        }
        else{
            System.out.print("Perdeu!!!");
        }
    }
    
    public static void gerarTabuleiro(int[][] tabuleiro){
        Random gerador = new Random();
        int linha = 0;
        int coluna = 0;
        int vertical = 0;
        int contadorDosBarcos = 0;
                //porta aviao
        while(contadorDosBarcos <1) { 
            linha = gerador.nextInt(7) ;
            coluna = gerador.nextInt(7);
            vertical = gerador.nextInt(2);

            if(tabuleiro[coluna][linha] == 0 ) {
                
                if(vertical==1) {

                    if(tabuleiro[coluna][linha+1] == 0 && tabuleiro[coluna][linha+2] == 0 && tabuleiro[coluna][linha+3] == 0){
                        tabuleiro [coluna][linha]=4;
                        tabuleiro [coluna][linha+1]=4;
                        tabuleiro [coluna][linha+2]=4;
                        tabuleiro [coluna][linha+3]=4;
                        contadorDosBarcos++;
                    }
                }
                else{
                    if(tabuleiro[coluna+1][linha] == 0 && tabuleiro[coluna+2][linha] == 0 && tabuleiro[coluna+3][linha] == 0){
                        tabuleiro [coluna][linha]=4;
                        tabuleiro [coluna+1][linha]=4;
                        tabuleiro [coluna+2][linha]=4;
                        tabuleiro [coluna+3][linha]=4;
                        contadorDosBarcos++;
                    }
                }
            } 
        }
        contadorDosBarcos=0;

                // barco grande
        while(contadorDosBarcos <2) { 
            linha = gerador.nextInt(8) ;
            coluna = gerador.nextInt(8);
            vertical = gerador.nextInt(2);

            if(tabuleiro[coluna][linha] == 0 ) {
                
                if(vertical==1) {

                    if(tabuleiro[coluna][linha+1] == 0 && tabuleiro[coluna][linha+2] == 0){
                        tabuleiro [coluna][linha]=3;
                        tabuleiro [coluna][linha+1]=3;
                        tabuleiro [coluna][linha+2]=3;
                        contadorDosBarcos++;
                    }
                }
                else{
                    if(tabuleiro[coluna+1][linha] == 0 && tabuleiro[coluna+2][linha] == 0){
                        tabuleiro [coluna][linha]=3;
                        tabuleiro [coluna+1][linha]=3;
                        tabuleiro [coluna+2][linha]=3;
                        contadorDosBarcos++;
                    }
                }
            } 
        }
        
        contadorDosBarcos=0;
        //barco medio
         while(contadorDosBarcos <3) { 
            linha = gerador.nextInt(9) ;
            coluna = gerador.nextInt(9);
            vertical = gerador.nextInt(2);

            if(tabuleiro[coluna][linha] == 0 ) {
                
                if(vertical==1) {

                    if(tabuleiro[coluna][linha+1] == 0){
                        tabuleiro [coluna][linha]=2;
                        tabuleiro [coluna][linha+1]=2;
                        contadorDosBarcos++;
                    }
                }
                else{
                    if(tabuleiro[coluna+1][linha] == 0){
                        tabuleiro [coluna][linha]=2;
                        tabuleiro [coluna+1][linha]=2;
                        contadorDosBarcos++;
                    }
                }
            }
        }
         contadorDosBarcos=0;
        //barco pequeno
         while(contadorDosBarcos <4) { 
            linha = gerador.nextInt(10) ;
            coluna = gerador.nextInt(10);
            vertical = gerador.nextInt(2);

            if(tabuleiro[coluna][linha] == 0 ) {
                tabuleiro[coluna][linha] = 1;
                contadorDosBarcos++;
            }
         }
        
    }

    public static void plotarTabuleiro(int[][] tabuleiro,boolean[][] jogadas){
         System.out.print("  ");
            for (int i = 0; i < 10; i++){
                System.out.print(i + " ");
            }
            System.out.println();
            for (int L = 0; L < 10; L++){
                System.out.print(L + "|");
                for (int C = 0; C < 10; C++){
                    if(jogadas[C][L] ==  false){
                        System.out.print("X" + " ");
                    }
                    else{
                        System.out.print(tabuleiro[C][L] + " ");

                    }
                }
                System.out.println();
            }

    }
}
