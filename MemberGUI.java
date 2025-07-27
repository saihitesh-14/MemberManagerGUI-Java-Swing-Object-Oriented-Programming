import javax.swing.*;
import java.awt.event.*;

public class MemberGUI {
    private MemberManager manager;

    public MemberGUI() {
        manager = new MemberManager();
        manager.loadFromFile("members.txt");

        JFrame frame = new JFrame(" UA Table Tennis Club Signup");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 30, 200, 25);
        frame.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 25);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(100, 70, 200, 25);
        frame.add(emailField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 110, 100, 30);
        frame.add(submitButton);

        JButton viewButton = new JButton("View All");
        viewButton.setBounds(210, 110, 90, 30);
        frame.add(viewButton);

        JTextArea output = new JTextArea();
        output.setBounds(30, 150, 280, 50);
        output.setEditable(false);
        frame.add(output);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            if (!name.isEmpty() && !email.isEmpty()) {
                Member m = new Member(name, email);
                if (manager.addMember(m)) {
                    output.setText("Member added!");
                } else {
                    output.setText("Duplicate email.");
                }
                nameField.setText("");
                emailField.setText("");
            } else {
                output.setText("Fields can't be empty!");
            }
        });

        viewButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Member m : manager.getMemberList()) {
                sb.append(m).append("\n");
            }
            output.setText(sb.toString());
        });

        // Save on close
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                manager.saveToFile("members.txt");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MemberGUI();
    }
}
