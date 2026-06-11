import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ChatBotGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("AI ChatBot");

        JTextArea chatArea = new JTextArea();
        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.add(panel, BorderLayout.SOUTH);

        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        chatArea.append("Bot: Hello! 😊\n");

        sendButton.addActionListener(e -> respond(chatArea, inputField));
        inputField.addActionListener(e -> respond(chatArea, inputField));
    }

    public static void respond(JTextArea chatArea, JTextField inputField) {

        String input = inputField.getText().toLowerCase();
        chatArea.append("You: " + input + "\n");

        String response;

        if (input.contains("hello") || input.contains("hi")) {
            response = "Hello! How can I help you?";
        } else if (input.contains("how are you")) {
            response = "I'm doing great 😄";
        } else if (input.contains("your name")) {
            response = "I'm Smart ChatBot 🤖";
        } else if (input.contains("time")) {
            response = java.time.LocalTime.now().toString();
        } else if (input.contains("date")) {
            response = java.time.LocalDate.now().toString();
        } else if (input.contains("bye")) {
            response = "Goodbye! 👋";
        } else {
            String[] replies = {
                    "Interesting 🤔",
                    "Tell me more!",
                    "I see!",
                    "Okay 👍"
            };

            Random rand = new Random();
            response = replies[rand.nextInt(replies.length)];
        }

        chatArea.append("Bot: " + response + "\n\n");
        inputField.setText("");
    }
}