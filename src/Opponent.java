import java.util.concurrent.ThreadLocalRandom;

public class Opponent {
    private static PlayerChoice opponentMove;
    private static int wins = 0;

    public static int getWins() {
        return wins;
    }

    public static void incrementWinCounter() {
        wins++;
    }

    public static PlayerChoice getOpponentMove() {
        return opponentMove;
    }

    public static void updateOpponentMove() {
        int rand = ThreadLocalRandom.current().nextInt(0, 3);
        PlayerChoice[] moves = PlayerChoice.values();
        opponentMove = moves[rand];
    }
}
