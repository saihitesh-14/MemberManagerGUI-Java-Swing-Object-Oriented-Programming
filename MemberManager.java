import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class MemberManager {
    private ArrayList<Member> members;
    private HashSet<String> emails;

    public MemberManager() {
        members = new ArrayList<>();
        emails = new HashSet<>();
    }

    public boolean addMember(Member m) {
        if (emails.contains(m.getEmail())) {
            System.out.println("Duplicate email.");
            return false;
        }
        members.add(new Member(m)); // Copy constructor
        emails.add(m.getEmail());
        return true;
    }

    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("No members yet.");
        } else {
            for (Member m : members) {
                System.out.println(m);
            }
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Member m : members) {
                writer.println(m.getName() + "," + m.getEmail());
            }
            System.out.println("Members saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    addMember(new Member(parts[0], parts[1]));
                }
            }
            System.out.println("Members loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
    public ArrayList<Member> getMemberList() {
        return new ArrayList<>(members);
    }

}
