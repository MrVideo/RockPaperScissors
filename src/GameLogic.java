import java.security.InvalidParameterException;
import java.util.Scanner;

public class GameLogic {

    private static int playerWins = 0;
    public static void begin() {
        while (true) {
            Opponent.updateOpponentMove();
            char playerMove;
            try {
                playerMove = getPlayerMove();
                if(playerMove == 'X') {
                    System.out.println("See you next time!");
                    return;
                } else {
                    gameResults(playGame(Opponent.getOpponentMove(), playerMove));
                    printStats();
                }
            } catch (InvalidParameterException e) {
                System.out.println("You selected an invalid character.");
            }
        }
    }

    private static char getPlayerMove() throws InvalidParameterException {
        System.out.print("Select your move (R/P/S - X to quit): ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        char sel = Character.toUpperCase(inputString.charAt(0));
        if(sel != 'R' && sel != 'P' && sel != 'S' && sel != 'X') throw new InvalidParameterException();
        else return sel;
    }

    private static int playGame(PlayerChoice choice, char playerMove) {
        if(choice.asChar() == playerMove) return 0;
        else if(choice == PlayerChoice.ROCK && playerMove == 'P' ||
                choice == PlayerChoice.PAPER && playerMove == 'S' ||
                choice == PlayerChoice.SCISSORS && playerMove == 'R')
            return 1;
        return -1;
    }

    private static void gameResults(int gameResult) {
        if (gameResult == -1) {
            System.out.println("You lost!");
            Opponent.incrementWinCounter();
        } else if (gameResult == 1) {
            System.out.println("You won!");
            playerWins++;
        } else System.out.println("Tie!");
    }

    private static void printStats() {
        System.out.println("--- STATS ---");
        System.out.println("Your wins: " + playerWins);
        System.out.println("CPU wins: " + Opponent.getWins());
    }
}
