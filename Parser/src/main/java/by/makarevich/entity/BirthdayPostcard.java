package by.makarevich.entity;

public class BirthdayPostcard extends Postcard {
    private String name;
    private int yearCount;
    private Content content;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearCount() {
        return this.yearCount;
    }

    public void setYearCount(int yearCount) {
        this.yearCount = yearCount;
    }

    public Content getContent() {
        return this.content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public static class Content {

        private String text;
        private Boolean isInVerse;

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public boolean isIsInVerse() {
            return isInVerse == null ? false : isInVerse;
        }

        public void setIsInVerse(Boolean value) {
            this.isInVerse = value;
        }

    }
}

