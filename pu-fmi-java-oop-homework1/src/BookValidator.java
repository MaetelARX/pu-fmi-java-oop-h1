public class BookValidator {

    public static boolean validateTitle(String title) {
        return title != null && !title.isBlank() && title.length() <= 100;
    }

    public static boolean validateGenre(String genre) {
        return genre != null && !genre.isBlank();
    }

    public static boolean validateAuthor(String author) {
        return author != null && !author.isBlank() && author.length() <= 50;
    }

    public static boolean validatePublisher(String publisher) {
        return publisher != null && !publisher.isBlank() && publisher.length() <= 50;
    }

    public static boolean validateYear(int year) {
        int currentYear = java.time.LocalDate.now().getYear();
        return year >= 0 && year <= currentYear;
    }

    public static boolean validateISBN(String ISBN) {
        return ISBN != null && !ISBN.isBlank() && ISBN.length() <= 10;
    }

    public static boolean validatePages(int pages) {
        return pages > 0;
    }

    public static boolean validateAvailability(Boolean availability) {
        return availability != null; // boolean не може да е null, но се проверява ако е обект Boolean
    }
}
