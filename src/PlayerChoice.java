public enum PlayerChoice {
    ROCK('R'), PAPER('P'), SCISSORS('S');
    private final char asChar;

    PlayerChoice(char asChar) {
        this.asChar = asChar;
    }

    public char asChar() {
        return asChar;
    }
}
