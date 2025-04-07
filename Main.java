import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Era uma vez, numa noite silenciosa e misteriosa...");
        System.out.println("Você, um explorador corajoso da floresta encantada de Zargon,");
        System.out.println("recebeu um alerta: um marciano travesso foi visto saltando de árvore em árvore.");
        System.out.println("Dizem que ele é rápido, imprevisível e adora se esconder nas sombras.");
        System.out.println("Sua missão é encontrá-lo antes que ele desapareça para sempre...");
        System.out.println("Mas cuidado! Ele muda de lugar com frequência e o tempo está contra você.");
        System.out.println("Pegue sua lanterna, prepare seus instintos... e boa sorte, caçador de marcianos!");
        System.out.println();
        System.out.println("Pressione ENTER para iniciar a caçada...");
        scanner.nextLine();

        int numeroMarciano = random.nextInt(100) + 1;
        int tentativa = 0;
        int tentativas = 0;
        boolean acertou = false;
        int limiteTentativas = 8;
        long tempoLimite = 30000;
        long tempoIniciar = System.currentTimeMillis();
        long tempoTrocarArvore = 20000;

        System.out.println("Adivinhe em qual árvore (1 a 100) o marciano está escondido!");
        System.out.println("Você tem " + limiteTentativas + " tentativas.");

        while (!acertou && tentativas < limiteTentativas) {
            long tempoAtual = System.currentTimeMillis();
            if (tempoAtual - tempoIniciar > tempoLimite) {
                System.out.println("⏳ Você ficou sem tempo! Game Over. O marciano capturou você.");
                break;
            }

            if (tempoAtual - tempoIniciar > tempoTrocarArvore) {
                numeroMarciano = random.nextInt(100) + 1;
                System.out.println("👾 O marciano mudou de árvore!");
                tempoIniciar = tempoAtual;
            }

            System.out.print("Digite seu palpite: ");
            long tempoPalpite = System.currentTimeMillis();

            if (scanner.hasNextInt()) {
                tentativa = scanner.nextInt();
                tentativas++;

                if (System.currentTimeMillis() - tempoPalpite > 30000) {
                    System.out.println("⏱️ Você demorou mais de 30 segundos para dar um palpite. Game Over!");
                    break;
                }

                System.out.println("Tentativa " + tentativas + ": " + tentativa);

                if (tentativa < numeroMarciano) {
                    System.out.println("🌳 O marciano está em uma árvore maior!");
                } else if (tentativa > numeroMarciano) {
                    System.out.println("🌲 O marciano está em uma árvore menor!");
                } else {
                    acertou = true;
                    System.out.println("🎉 Parabéns, você achou o marciano em " + tentativas + " tentativas!");
                }
            } else {
                System.out.println("⚠️ Por favor, digite um número válido.");
                scanner.next();
            }

            if (tentativas == limiteTentativas && !acertou) {
                System.out.println("❌ Você atingiu o limite de tentativas. O marciano estava na árvore " + numeroMarciano + ".");
            }
        }

        scanner.close();
    }
}
