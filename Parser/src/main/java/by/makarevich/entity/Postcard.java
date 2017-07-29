package by.makarevich.entity;

import by.makarevich.constant.Constant;
import by.makarevich.type.PostcardType;
import by.makarevich.type.PostcardValue;

public abstract class Postcard {
    private String postcardId;
    private String theme;
    private PostcardType postcardType;
    private String country;
    private int year;
    private AuthorInformation authorInformation;
    private PostcardValue value;
    private boolean wasSend;

    public String getId() {
        return this.postcardId;
    }

    public void setId(String postcardId) {
        this.postcardId = postcardId;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public PostcardType getType() {
        return this.postcardType;
    }

    public void setType(PostcardType postcardType) {
        this.postcardType = postcardType;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public AuthorInformation getAuthorInformation() {
        return this.authorInformation;
    }

    public void setAuthorInformation(AuthorInformation authorInformation) {
        this.authorInformation = authorInformation;
    }

    public PostcardValue getValue() {
        return this.value;
    }

    public void setValue(PostcardValue value) {
        this.value = value;
    }

    public boolean isWasSend() {
        return this.wasSend;
    }

    public void setWasSend(boolean wasSend) {
        this.wasSend = wasSend;
    }

    public static class AuthorInformation {
        private boolean isKnown;
        private String author;

        public boolean getIsKnown() {
            return this.isKnown;
        }

        public void setIsKnown(boolean isKnown) {
            this.isKnown = isKnown;
        }

        public String getAuthor() {
            return this.author == null ? Constant.UNKNOWN_AUTHOR : author;
        }

        public void setAuthor(String author) {
            if (author == null) {
                this.author = Constant.UNKNOWN_AUTHOR;
            } else {
                this.author = author;
            }
        }
    }
}
