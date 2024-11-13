import java.time.LocalDate;

public class Book {
    private String title;
    private String genre;
    private String author;
    private String publisher;
    private int year;
    private String ISBN;
    private int pages;
    private String language;
    private boolean isAvaible;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;
    private int borrowedTimes;
    private int returnedTimes;

    public Book(String title, String genre, String author, String publisher, int year, String ISBN, int pages, String language,
                boolean isAvaible) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.ISBN = ISBN;
        this.pages = pages;
        this.language = language;
        this.isAvaible = isAvaible;
        this.borrowedTimes = 0;
        this.returnedTimes = 0;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isAvaible() {
        return isAvaible;
    }

    public void setAvaible(boolean avaible) {
        isAvaible = avaible;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public int getBorrowedTimes() {
        return borrowedTimes;
    }

    public void incrementBorrowedTimes() {
        this.borrowedTimes++;
    }

    public int getReturnedTimes() {
        return returnedTimes;
    }

    public void incrementReturnedTimes() {
        this.returnedTimes++;
    }
    @Override
    public String toString() {
        return String.format("Заглавие: %s\nАвтор: %s\nГодина: %d\nISBN: %s\nНалична: %b",
                title, author, year, ISBN, isAvaible);
    }
}
