package by.makarevich.type;

public enum PostcardType {
    CONGRATULATORY("congratulatory"),
    USUAL("usual"),
    ADVERTISING("advertising");

    private String value;

    PostcardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
