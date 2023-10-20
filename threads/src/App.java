import br.com.escuderodev.fiap.models.Acumulador;

public class App {
    public static void main(String[] args) {
        Acumulador thread = new Acumulador();

        System.out.println("O valor atual de ACC é: " + thread.getAcc());
        System.out.println("O valor atual de valorSomar é: " + thread.getValorSomar());

        for (int i = 1; i <= 100; i++) {
            Acumulador threadTemp = new Acumulador();
            threadTemp.start();
            System.out.println("Thread " + i + ": O valor atual de ACC após execução é: " + thread.getAcc());
        }

        System.out.println("\nO valor final de ACC após execução é: " + thread.getAcc());

    }
}
