package interfatecs;
import java.util.Scanner;

public class TheMayans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Conversor de Numeros Maias ---");
        System.out.println("Regras: . vale 1, - vale 5, * vale 0");
        System.out.println("Use espaco para separar os grupos (ex: . .. ---)");
        System.out.println("Digite apenas * para ver o resultado 0 e sair");

        while (sc.hasNextLine()) {
            System.out.print("\nDigite os simbolos maias: ");
            String linha = sc.nextLine().trim();
            
            if (!linha.isEmpty()) {
                String[] partes = linha.split("\\s+");

                if (partes.length == 1 && partes[0].equals("*")) {
                    System.out.println("Resultado: 0");
                    break;
                }

                long total = 0;
                long p = 1;
                
                for (int i = 0; i < partes.length; i++) {
                    String s = partes[i];
                    int val = 0;
                    
                    if (!s.equals("*")) {
                        for (int j = 0; j < s.length(); j++) {
                            char c = s.charAt(j);
                            if (c == '.') {
                                val += 1;
                            } else if (c == '-') {
                                val += 5;
                            }
                        }
                    }
                    
                    total += (long) val * p;
                    p *= 20;
                }
                
                System.out.println("Valor em Decimal: " + total);
            }
        }
        sc.close();
    }
}