package by.makarevich.builder;

import by.makarevich.entity.Postcard;

import java.util.HashSet;

public abstract class PostcardParser {
    protected HashSet<Postcard> postcards;

    public PostcardParser() {
        this.postcards = new HashSet<Postcard>();
    }

    public PostcardParser(HashSet<Postcard> postcards) {
        this.postcards = postcards;
    }

    public HashSet<Postcard> getPostcards() {
        return this.postcards;
    }

    abstract public void buildPostcardSet(String fileName);
}
