import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class QueuePanel extends JPanel {
    private Queue<Integer> queue;
    private JTextField inputField;
    private JLabel resultLabel;

    public QueuePanel() {
        setLayout(new BorderLayout());
        queue = new LinkedList<>();

        inputField = new JTextField(5);
        JButton enqueueButton = new JButton("Enqueue");
        JButton dequeueButton = new JButton("Dequeue");
        JButton peekButton = new JButton("Peek");

        resultLabel = new JLabel("Result: ");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter a number: "));
        topPanel.add(inputField);
        topPanel.add(enqueueButton);
        topPanel.add(dequeueButton);
        topPanel.add(peekButton);

        add(topPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        enqueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                queue.offer(value);
                resultLabel.setText("Result: " + value + " enqueued.");
                repaint();
            }
        });

        dequeueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!queue.isEmpty()) {
                    int value = queue.poll();
                    resultLabel.setText("Result: " + value + " dequeued.");
                } else {
                    resultLabel.setText("Queue is empty.");
                }
                repaint();
            }
        });

        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!queue.isEmpty()) {
                    int value = queue.peek();
                    resultLabel.setText("Result: " + value + " is at front.");
                } else {
                    resultLabel.setText("Queue is empty.");
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

        int i = 0;
        for (int value : queue) {
            g.setColor(Color.ORANGE);
            g.fillRect(xOffset, 300 - (i + 1) * height, 40, height);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(value), xOffset + 10, 300 - (i + 1) * height - 5);
            i++;
        }
    }
}
