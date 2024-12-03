import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String ISBN;
    boolean availability;

    public Book(String title, String author, String ISBN, boolean availability) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availability = availability;
    }
}

class Member {
    String name;
    String memberID;

    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
    }
}

class Staff {
    String name;
    String staffID;

    public Staff(String name, String staffID) {
        this.name = name;
        this.staffID = staffID;
    }
}

class Library {
    ArrayList<Book> books;
    ArrayList<Member> members;
    ArrayList<Staff> staffs;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        staffs = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.ISBN.equals(ISBN));
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.title + " by " + book.author);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(String memberID) {
        members.removeIf(member -> member.memberID.equals(memberID));
    }

    public void searchMember(String memberName) {
        for (Member member : members) {
            if (member.name.equalsIgnoreCase(memberName)) {
                System.out.println("Member found: " + member.name + " with ID " + member.memberID);
                return;
            }
        }
        System.out.println("Member not found!");
    }

    public void addStaff(Staff staff) {
        staffs.add(staff);
    }

    public void removeStaff(String staffID) {
        staffs.removeIf(staff -> staff.staffID.equals(staffID));
    }

    public void searchStaff(String staffName) {
        for (Staff staff : staffs) {
            if (staff.name.equalsIgnoreCase(staffName)) {
                System.out.println("Staff found: " + staff.name + " with ID " + staff.staffID);
                return;
            }
        }
        System.out.println("Staff not found!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Default login
        String defaultLoginID = "admin";
        String defaultPassword = "password123";

        System.out.print("Enter login ID: ");
        String loginID = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (loginID.equals(defaultLoginID) && password.equals(defaultPassword)) {
            System.out.println("Login successful!");

            boolean continueProgram = true;
            while (continueProgram) {
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Search Book");
                System.out.println("4. Add Member");
                System.out.println("5. Remove Member");
                System.out.println("6. Search Member");
                System.out.println("7. Add Staff");
                System.out.println("8. Remove Staff");
                System.out.println("9. Search Staff");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String ISBN = scanner.nextLine();
                        System.out.print("Enter availability (true/false): ");
                        boolean availability = scanner.nextBoolean();
                        scanner.nextLine(); // Consume the newline character
                        library.addBook(new Book(title, author, ISBN, availability));
                        System.out.println("Book added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter ISBN to remove: ");
                        ISBN = scanner.nextLine();
                        library.removeBook(ISBN);
                        System.out.println("Book removed successfully!");
                        break;
                    case 3:
                        System.out.print("Enter book title to search: ");
                        title = scanner.nextLine();
                        library.searchBook(title);
                        break;
                    case 4:
                        System.out.print("Enter member name: ");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter member ID: ");
                        String memberID = scanner.nextLine();
                        library.addMember(new Member(memberName, memberID));
                        System.out.println("Member added successfully!");
                        break;
                    case 5:
                        System.out.print("Enter member ID to remove: ");
                        memberID = scanner.nextLine();
                        library.removeMember(memberID);
                        System.out.println("Member removed successfully!");
                        break;
                    case 6:
                        System.out.print("Enter member name to search: ");
                        memberName = scanner.nextLine();
                        library.searchMember(memberName);
                        break;
                    case 7:
                        System.out.print("Enter staff name: ");
                        String staffName = scanner.nextLine();
                        System.out.print("Enter staff ID: ");
                        String staffID = scanner.nextLine();
                        library.addStaff(new Staff(staffName, staffID));
                        System.out.println("Staff added successfully!");
                        break;
                    case 8:
                        System.out.print("Enter staff ID to remove: ");
                        staffID = scanner.nextLine();
                        library.removeStaff(staffID);
                        System.out.println("Staff removed successfully!");
                        break;
                    case 9:
                        System.out.print("Enter staff name to search: ");
                        staffName = scanner.nextLine();
                        library.searchStaff(staffName);
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

                System.out.print("Do you want to continue? (yes/no): ");
                String continueChoice = scanner.nextLine();
                if (continueChoice.equalsIgnoreCase("no")) {
                    continueProgram = false;
                }
            }
        } else {
            System.out.println("Invalid login credentials.");
        }

        scanner.close();
    }
}
