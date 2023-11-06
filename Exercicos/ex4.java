import java.util.Scanner;
public class ex4{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("informe p1");
        String p1 = in.nextLine();
        System.out.println("informe p2");
        String p2 = in.nextLine();
        if(vericaPalindromo(p1,p2)== true){
            System.out.println("são palindormos");
        }
        else{
           System.out.println("não palindormos"); 
        }
        in.close();
    }
    public static boolean vericaPalindromo(String p1, String p2){
        p1 = p1.toLowerCase();
        p2 = p2.toLowerCase();
        String resposta ="";
        char [] charArray = p2.toCharArray();
        for(int i = charArray.length-1; i>=0; i--){
            resposta= resposta+charArray[i];
        }
        return (p1.equals(resposta));
    }
}