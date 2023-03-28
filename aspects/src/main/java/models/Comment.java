package models;

public class Comment {
    private String text;
    private String author;

    // getters and setters

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
