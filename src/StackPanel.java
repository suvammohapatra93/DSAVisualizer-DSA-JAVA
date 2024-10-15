import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackPanel extends JPanel {
    private Stack<Integer> stack;
    private JTextField inputField;
    private JLabel resultLabel;

    public StackPanel() {
        setLayout(new BorderLayout());
        stack = new Stack<>();

        inputField = new JTextField(5);
        JButton pushButton = new JButton("Push");
        JButton popButton = new JButton("Pop");
        JButton peekButton = new JButton("Peek");

        resultLabel = new JLabel("Result: ");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter a number: "));
        topPanel.add(inputField);
        topPanel.add(pushButton);
        topPanel.add(popButton);
        topPanel.add(peekButton);

        add(topPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                stack.push(value);
                resultLabel.setText("Result: " + value + " pushed.");
                repaint();
            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!stack.isEmpty()) {
                    int value = stack.pop();
                    resultLabel.setText("Result: " + value + " popped.");
                } else {
                    resultLabel.setText("Stack is empty.");
                }
                repaint();
            }
        });

        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!stack.isEmpty()) {
                    int value = stack.peek();
                    resultLabel.setText("Result: " + value + " is on top.");
                } else {
                    resultLabel.setText("Stack is empty.");
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        int xOffset = 10;
        int height = 20; // Height of each box

        for (int i = 0; i < stack.size(); i++) {
            g.setColor(Color.GREEN);
            g.fillRect(xOffset, 300 - (i + 1) * height, 40, height);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(stack.get(i)), xOffset + 10, 300 - (i + 1) * height - 5);
        }
    }
}
