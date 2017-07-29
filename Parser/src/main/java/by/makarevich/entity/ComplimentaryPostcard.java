package by.makarevich.entity;

public class ComplimentaryPostcard extends Postcard {
    private String place;
    private int menCount;

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMenCount() {
        return this.menCount;
    }

    public void setMenCount(int menCount) {
        this.menCount = menCount;
    }

    @Override
    public String toString() {
        return " ID " + getId() + "\\n" + " Theme " + getTheme() + "\n" + " PostcardType " + getType() + "\n" +
                " Country" + getCountry() + "\n" + " Year " + getYear() + "\n" + " Author Info " + "\n" +
                " Is known " + getAuthorInformation().getIsKnown() + "\n" + " Author " + getAuthorInformation().getAuthor() +
                "\n" + " Value " + getValue() + "\n" + " Was send " + isWasSend() + "\n" +
                " Place " + place + "\n" + " MenCount " + menCount + "\n";
    }
}
