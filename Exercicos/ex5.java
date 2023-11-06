import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cpf ="";
        String nome ="";
        while (true) {
            System.out.println("informe seu nome:");
            nome = in.nextLine();
            if (verificaNome(nome) == true) {
                break;
            }
            System.out.println("Nome invalido!!!!!");
        }
        while (true) {
            System.out.println("informe seu CPF:");
            cpf = in.nextLine();
            if(verificaCpf(cpf)==true){
                break;
            }
            else{
                System.out.println("CPF invalido!!!!!");
            }
        }
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        in.close();
    }
    public static boolean verificaNome(String nome){
        return nome.matches("[A-Z][a-z]+");
    }
    public static boolean verificaCpf(String cpf){
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }
}