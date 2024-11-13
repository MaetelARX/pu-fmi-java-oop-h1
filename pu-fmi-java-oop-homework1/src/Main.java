import java.time.LocalDate;

public class Main {
    private static Library library;

    public static void main(String[] args) {
        initializeLibrary();
        mainMenu();
    }

    private static void initializeLibrary() {
        System.out.println("Създаване на нова библиотека:");
        String name = LibraryValidator.promptString("Наименование на библиотеката", 100);
        String address = LibraryValidator.promptString("Адрес", 500);
        int staffCount = LibraryValidator.promptInt("Брой служители", 1, 49);
        library = new Library(name, address, staffCount);
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("""
                \nИзберете опция:
                1. Добавяне на книга
                2. Премахване на книга
                3. Търсене на книга
                4. Обновяване на книга
                5. Пълен списък с книги
                6. Изход
            """);
            int choice = LibraryValidator.promptInt("Избор", 1, 6);
            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchBooks();
                case 4 -> updateBook();
                case 5 -> library.displayBooks();
                case 6 -> exitProgram();
            }
        }
    }

    private static void addBook() {
        System.out.println("Добавяне на нова книга:");

        String title;
        do {
            title = LibraryValidator.promptString("Заглавие", 100);
            if (!BookValidator.validateTitle(title)) {
                System.out.println("Некоректно заглавие! Моля, опитайте отново.");
            }
        } while (!BookValidator.validateTitle(title));

        String genre;
        do {
            genre = LibraryValidator.promptString("Жанр", 50);
            if (!BookValidator.validateGenre(genre)) {
                System.out.println("Некоректен жанр! Моля, опитайте отново.");
            }
        } while (!BookValidator.validateGenre(genre));

        String author;
        do {
            author = LibraryValidator.promptString("Автор", 50);
            if (!BookValidator.validateAuthor(author)) {
                System.out.println("Некоректен автор! Моля, опитайте отново.");
            }
        } while (!BookValidator.validateAuthor(author));

        String publisher;
        do {
            publisher = LibraryValidator.promptString("Издателство", 50);
            if (!BookValidator.validatePublisher(publisher)) {
                System.out.println("Некоректно издателство! Моля, опитайте отново.");
            }
        } while (!BookValidator.validatePublisher(publisher));

        int year;
        do {
            year = LibraryValidator.promptInt("Година на издаване", 0, LocalDate.now().getYear());
            if (!BookValidator.validateYear(year)) {
                System.out.println("Некоректна година! Моля, опитайте отново.");
            }
        } while (!BookValidator.validateYear(year));

        String ISBN;
        do {
            ISBN = LibraryValidator.promptString("ISBN", 10);
            if (!BookValidator.validateISBN(ISBN)) {
                System.out.println("Некоректен ISBN! Моля, опитайте отново.");
            }
        } while (!BookValidator.validateISBN(ISBN));

        int pages;
        do {
            pages = LibraryValidator.promptInt("Брой страници", 1, Integer.MAX_VALUE);
            if (!BookValidator.validatePages(pages)) {
                System.out.println("Некоректен брой страници! Моля, опитайте отново.");
            }
        } while (!BookValidator.validatePages(pages));

        boolean available = LibraryValidator.promptBoolean("Налична ли е книгата?");
        if (!BookValidator.validateAvailability(available)) {
            System.out.println("Некоректна наличност! Моля, опитайте отново.");
        }

        Book book = new Book(title, genre, author, publisher, year, ISBN, pages, "BG", available);
        library.AddBook(book);
        System.out.println("Книгата е успешно добавена!");
    }


    private static void removeBook() {
        String query = LibraryValidator.promptString("Въведете заглавие или ISBN за премахване", 100);
        Book book = library.findBookByTitleOrISBN(query);
        if (book != null) {
            library.RemoveBook(book);
            System.out.println("Книгата е успешно премахната.");
        } else {
            System.out.println("Книгата не беше намерена.");
        }
    }

    private static void searchBooks() {
        String keyword = LibraryValidator.promptString("Търсете по заглавие, автор или ISBN", 100);
        var results = library.searchBooks(keyword);
        if (results.isEmpty()) {
            System.out.println("Няма намерени книги.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void updateBook() {
        String ISBN = LibraryValidator.promptString("Въведете ISBN за обновяване", 10);
        Book book = library.findBookByTitleOrISBN(ISBN);
        if (book != null) {
            boolean available = LibraryValidator.promptBoolean("Обновете наличността");
            book.setAvaible(available);
            System.out.println("Информацията за книгата е успешно обновена.");
        } else {
            System.out.println("Книгата не беше намерена.");
        }
    }

    private static void exitProgram() {
        System.out.println("Довиждане!");
        System.exit(0);
    }
}
