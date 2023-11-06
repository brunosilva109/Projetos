import java.util.Scanner;
public class ex2{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("informe o tamanho do vetor");
        int n  = in.nextInt();
        int [] vetor = new int[n];
        for(int i  = 0; i<n; i++){
            System.out.println("informe o elemento ( "+i+" ) do vetor: ");
            vetor[i] = in.nextInt();
        }
        System.out.println(verificaRepetidos(vetor));
        in.close();
    }
    public static String verificaRepetidos(int[]vetor){
        int n = vetor.length;
        int aux = 0;
        String resposta = "";
        boolean passou = true;
        int[] vetAxu = new int[n];
        for(int i  =  0; i<n; i++){
            passou =true;
            for(int j = i+1; j<n; j++){
                if(vetor[i]==vetor[j]){
                    for(int z = 0; z<aux; z++){
                        if(vetor[i] == vetAxu[z]){
                            passou = false;
                            break;
                        }
                    }
                    if(passou == true){
                    vetAxu[aux] = vetor[i];
                    resposta = resposta + vetor[i] + " ";
                    aux++;
                }
                }
            }
        }
        return resposta;
    }
}