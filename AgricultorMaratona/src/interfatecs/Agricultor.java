package interfatecs;
import java.util.Scanner;

public class Agricultor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero de leituras: ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("\n--- LEITURA " + (i + 1) + " ---");
                
                System.out.print("Temperatura (pode usar ponto ou virgula): ");
                String tempInput = sc.next().replace(',', '.');
                double t = Double.parseDouble(tempInput);
                
                System.out.print("Umidade do solo (pode usar ponto ou virgula): ");
                String umidInput = sc.next().replace(',', '.');
                double u = Double.parseDouble(umidInput);
                
                System.out.print("Previsao de chuva (0 ou 1): ");
                int p = sc.nextInt();

                if (p == 1) {
                    System.out.println("RESULTADO: NAO REGAR");
                } else if (t > 30.0 && u < 50.0) {
                    System.out.println("RESULTADO: REGAR");
                } else {
                    System.out.println("RESULTADO: NAO REGAR");
                }
            }
        }
        sc.close();
    }
}