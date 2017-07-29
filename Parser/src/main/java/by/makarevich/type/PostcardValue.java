package by.makarevich.type;

public enum PostcardValue {
    HISTORICAL("historical"),
    COLLECTIBLE("collectible"),
    THEMATIC("thematic");

    private String value;

    PostcardValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
