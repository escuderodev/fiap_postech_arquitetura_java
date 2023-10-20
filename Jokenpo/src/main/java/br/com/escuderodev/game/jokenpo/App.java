package br.com.escuderodev.game.jokenpo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int player1;
        int player2;

        System.out.println("=== Bem vindo ao Jokenpô ===");

        System.out.print("\nPlayer 1: digite 1 - Pedra, 2 - papel ou 3 - Tesoura: ");
        player1 = scan.nextInt();

        while(player1 < 1 || player1 > 3) {
            System.out.print("\nOpção inválida! digite 1 - Pedra, 2 - papel ou 3 - Tesoura: ");
            player1 = scan.nextInt();
        }

        System.out.print("\nPlayer 2: digite 1 - Pedra, 2 - papel ou 3 - Tesoura: ");
        player2 = scan.nextInt();

        while(player2 < 1 || player2 > 3) {
            System.out.print("\nOpção inválida! digite 1 - Pedra, 2 - papel ou 3 - Tesoura: ");
            player2 = scan.nextInt();
        }

        if (player1 == 1 && player2 == 3) {
            System.out.println("\nPlayer 1 escolheu Pedra e Player 2 Tesoura. Player 1 venceu!");
        } else if (player1 == 3 && player2 == 2) {
            System.out.println("\nPlayer 1 escolheu Tesoura e Player 2 Papel. Player 1 venceu!");
        } else if (player1 == 2 && player2 == 1) {
            System.out.println("\nPlayer 1 escolheu Papel e Player 2 Pedra. Player 1 venceu!");
        } else if (player1 == 3 && player2 == 1) {
            System.out.println("\nPlayer 1 escolheu Tesoura e Player 2 Pedra. Player 2 venceu!");
        } else if (player1 == 1 && player2 == 2) {
            System.out.println("\nPlayer 1 escolheu Pedra e Player 2 Papel. Player 2 venceu!");
        } else if (player1 == 2 && player2 == 3) {
            System.out.println("\nPlayer 1 escolheu Papel e Player 2 Tesoura. Player 2 venceu!");
        } else if (player1 == 1 && player2 == 1) {
            System.out.println("\nPlayer 1 escolheu Pedra e Player 2 Pedra. Empate!");
        } else if (player1 == 2 && player2 == 2) {
            System.out.println("\nPlayer 1 escolheu Papel e Player 2 Papel. Empate!");
        } else {
            System.out.println("\nPlayer 1 escolheu Tesoura e Player 2 Tesoura. Empate!");
        }

        System.out.println("\n=== Fim do Jogo! ===");
    }
}
