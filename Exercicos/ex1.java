import java.util.Scanner;
public class ex1{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("informe o angulo");
        double angulo = in.nextDouble();
        System.out.println("o cosseno é: "+ calculaCosseno(angulo));
        in.close();
    }
    public static double calculaRadianos(double angulo){
        return ((angulo/180)*Math.PI);
    }
    public static int calculaFatorial(int a){
        int resposta =1;
        for(int i = a; i>0;i--){
            resposta = resposta*i;
        }
        return resposta;
    }
    public static double calculaCosseno(double angulo){
        double resposta = 0;
        for(int i  =0; i<15; i++){
            resposta = resposta + (Math.pow(-1, i)/calculaFatorial(i*2))*Math.pow(calculaRadianos(angulo),2*i);
        }
        return resposta;
    }
}