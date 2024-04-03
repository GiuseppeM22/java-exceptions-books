package org.model;

public class Book {

    private String title; //non puo essere vuoto
    private int numberOfPages; //non puo essere <= a 0
    private String author; //non puo essere vuoto
    private String publisher; //non puo essere vuoto

    public Book(String title, int numberOfPages, String author, String publisher) throws IllegalArgumentException {
        if (title == null || title.isEmpty()){
            throw new IllegalArgumentException("Il campo titolo non può essere vuoto");
        }
        this.title = title;

        if (numberOfPages <= 0){
            throw new IllegalArgumentException("Il campo numero di pagine non può essere minore o uguale a 0");
        }
        this.numberOfPages = numberOfPages;

        if (author == null || author.isEmpty()){
            throw new IllegalArgumentException("Il campo autore non può essere vuoto");
        }
        this.author = author;

        if (publisher == null || publisher.isEmpty()){
            throw new IllegalArgumentException("Il campo editore non può essere vuoto");
        }
        this.publisher = publisher;
    }

    //getter

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    //setter

    public void setTitle(String title) throws IllegalArgumentException {
        if (title == null || title.isEmpty()){
            throw new IllegalArgumentException("Il campo titolo non può essere vuoto");
        }
        this.title = title;
    }

    public void setNumberOfPages(int numberOfPages) throws IllegalArgumentException {
        if (numberOfPages <= 0){
            throw new IllegalArgumentException("Il campo numero di pagine non può essere minore o uguale a 0");
        }
        this.numberOfPages = numberOfPages;
    }

    public void setAuthor(String author) throws IllegalArgumentException {
        if (author == null || author.isEmpty()){
            throw new IllegalArgumentException("Il campo autore non può essere vuoto");
        }
        this.author = author;
    }

    public void setPublisher(String publisher) throws IllegalArgumentException {
        if (publisher == null || publisher.isEmpty()){
            throw new IllegalArgumentException("Il campo editore non può essere vuoto");
        }
        this.publisher = publisher;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
