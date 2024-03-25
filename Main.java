public class Main {
    private static Library library = new Library();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            Console.writeLine("\nGestión de Biblioteca");
            Console.writeLine("1. Agregar un libro");
            Console.writeLine("2. Eliminar un libro");
            Console.writeLine("3. Prestar un libro");
            Console.writeLine("4. Devolver un libro");
            Console.writeLine("5. Mostrar libros disponibles");
            Console.writeLine("6. Salir");
            Console.write("Seleccione una opción: ");
            int choice = Integer.parseInt(Console.readLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    // Implementar función para eliminar un libro
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    displayAvailableBooks();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    Console.writeLine("Opción inválida. Por favor, seleccione un número entre 1 y 6.");
            }
        }
        Console.writeLine("¡Gracias por usar nuestro sistema de gestión de bibliotecas!");
    }

    private static void addBook() {
        Console.writeLine("\nAgregar un libro:");
        Console.write("Título: ");
        String title = Console.readLine();
        Console.write("Autor: ");
        String author = Console.readLine();
        Console.write("Año de Publicación: ");
        int publicationYear = Integer.parseInt(Console.readLine());
        Console.write("Número de páginas: ");
        int numberOfPages = Integer.parseInt(Console.readLine());
        library.addBook(new Book(title, author, publicationYear, numberOfPages));
        Console.writeLine("Libro agregado con éxito.");
    }

    private static void borrowBook() {
        Console.writeLine("\nPrestar un libro:");
        Console.write("Ingrese el título del libro que desea prestar: ");
        String title = Console.readLine();
        Console.write("Ingrese el autor del libro: ");
        String author = Console.readLine();
        Book bookToBorrow = findBook(title, author);
        if (bookToBorrow != null) {
            library.borrowBook(bookToBorrow);
        } else {
            Console.writeLine("El libro no está disponible en la biblioteca.");
        }
    }

    private static void returnBook() {
        Console.writeLine("\nDevolver un libro:");
        Console.write("Ingrese el título del libro que desea devolver: ");
        String title = Console.readLine();
        Console.write("Ingrese el autor del libro: ");
        String author = Console.readLine();
        Book bookToReturn = findBook(title, author);
        if (bookToReturn != null) {
            library.returnBook(bookToReturn);
        } else {
            Console.writeLine("No se puede devolver un libro que no se ha prestado.");
        }
    }

    private static void displayAvailableBooks() {
        Console.writeLine("\nLibros disponibles en la biblioteca:");
        library.displayAvailableBooks();
    }

    private static Book findBook(String title, String author) {
        for (Book book : library.getAllBooks()) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }
}
