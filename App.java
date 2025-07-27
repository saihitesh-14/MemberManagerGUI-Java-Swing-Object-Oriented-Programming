import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MemberManager manager = new MemberManager();
        Scanner sc = new Scanner(System.in);

        manager.loadFromFile("members.txt");

        while (true) {
            System.out.println("\n1. Add Member\n2. List Members\n3. Save\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();

                Member m = new Member(name, email);
                manager.addMember(m);
            } else if (choice == 2) {
                manager.listMembers();
            } else if (choice == 3) {
                manager.saveToFile("members.txt");
            } else {
                manager.saveToFile("members.txt");
                System.out.println("Goodbye!");
                break;
            }
        }

        sc.close();
    }
}
