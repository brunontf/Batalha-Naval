package enums;

public enum Emojis {
    EXPLOSION("\uD83D\uDCA5", "#"),
    WAVE("\uD83C\uDF0A", "~"),
    BOAT("\u26F5", "+"),
    HOLE("🕳️", "o");
    private String emojiCode;
    private String symbol;
    public static boolean isEmoji;

    private Emojis(String emojiCode, String symbol){
        this.emojiCode = emojiCode;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        if (isEmoji){
            return this.emojiCode;
        }
        return this.symbol;
    }
}
