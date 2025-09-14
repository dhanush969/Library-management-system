package Library;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Library myLibrary = new Library();
        Scanner input = new Scanner(System.in);

        boolean keepRunning = true;

        while (keepRunning) {

            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Add a new book");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Books list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choiceStr = input.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (Exception e) {
                System.out.println("Oops! That’s not a number. Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Book Name: ");
                    String title = input.nextLine();

                    System.out.print("Author Name: ");
                    String author = input.nextLine();

                    System.out.print("ISBN Number: ");
                    String isbn = input.nextLine();

                    myLibrary.addBook(title, author, isbn);
                    break;

                case 2:
                    System.out.print("Enter ISBN to receive: ");
                    String borrowIsbn = input.nextLine();
                    boolean issued = myLibrary.issueBook(borrowIsbn);
                    if (!issued) {
                        System.out.println("Cannot issue book. Either it doesn’t exist or it’s already issued.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = input.nextLine();
                    boolean returned = myLibrary.returnBook(returnIsbn);
                    if (!returned) {
                        System.out.println("Cannot return book. Either it wasn’t issued or doesn’t exist.");
                    }
                    break;

                case 4:
                    myLibrary.listBooks();
                    break;

                case 5:
                    System.out.println("Exiting program... Have a great day");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Incorrect choice.");
            }
        }

        input.close();
    }
}
