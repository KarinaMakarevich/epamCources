package by.makarevich.type;

public enum PostcardEnum {
    OLD_CARDS("old-cards"),
    BIRTHDAY_POSTCARD("birthday-postcard"),
    COMPLIMENTARY_POSTCARD("complimentary-postcard"),
    POSTCARD_ID("postcard-id"),
    THEME("theme"),
    POSTCARD_TYPE("postcard-type"),
    COUNTRY("country"),
    YEAR("year"),
    AUTHOR_INFORMATION("author-information"),
    IS_KNOWN("is-known"),
    AUTHOR("author"),
    VALUE("value"),
    WAS_SEND("was-send"),
    NAME("name"),
    YEAR_COUNT("year-count"),
    CONTENT("content"),
    TEXT("text"),
    IS_IN_VERSE("is-in-verse"),
    PLACE("place"),
    MEN_COUNT("men-count");
    private String value;

    PostcardEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
