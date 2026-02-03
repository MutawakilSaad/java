import java.util.Scanner;

public class LibrarySystem {

    static String[] books = new String[100];
    static String[] authors = new String[100];
    static int count = 0;

    // ================== Add Book ==================
    public static void addBook(Scanner input) {

        if (count >= books.length) {
            System.out.println("Library is full");
            return;
        }

        System.out.print("Enter book title: ");
        String title = input.nextLine();

        System.out.print("Enter author name: ");
        String author = input.nextLine();

        books[count] = title;
        authors[count] = author;
        count++;

        System.out.println("Book added successfully");
    }

    // ================== Display Books ==================
    public static void displayBooks() {

        if (count == 0) {
            System.out.println("No books in the library");
            return;
        }

        System.out.println("\nLibrary Books:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i] + " - " + authors[i]);
        }
    }

    // ================== Search Book ==================
    public static void searchBook(Scanner input) {

        if (count == 0) {
            System.out.println("Book not found");
            return;
        }

        System.out.print("Enter book title to search: ");
        String searchTitle = input.nextLine();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(searchTitle)) {
                System.out.println("Book found:");
                System.out.println("Title: " + books[i]);
                System.out.println("Author: " + authors[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }

    // ================== Remove Book ==================
    public static void removeBook(Scanner input) {

        if (count == 0) {
            System.out.println("No books in the library");
            return;
        }

        System.out.print("Enter book title to remove: ");
        String removeTitle = input.nextLine();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].equalsIgnoreCase(removeTitle)) {

                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                    authors[j] = authors[j + 1];
                }

                books[count - 1] = null;
                authors[count - 1] = null;
                count--;

                System.out.println("Book removed successfully");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }

    // ================== Main Menu ==================
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine(); // تنظيف الـ buffer

           

        } while (choice != 5);

        input.close();
    }
}
