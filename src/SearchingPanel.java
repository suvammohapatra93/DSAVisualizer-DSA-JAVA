import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SearchingPanel extends JPanel {
    private int[] array = {10, 5, 2, 8, 7, 1, 3};
    private JTextField searchField;
    private JLabel resultLabel;

    public SearchingPanel() {
        setLayout(new BorderLayout());

        // Search input field
        searchField = new JTextField();
        JButton linearSearchButton = new JButton("Linear Search");
        JButton binarySearchButton = new JButton("Binary Search");

        // Result label to display search outcome
        resultLabel = new JLabel("Result: ");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter a number to search: "));
        topPanel.add(searchField);
        topPanel.add(linearSearchButton);
        topPanel.add(binarySearchButton);

        add(topPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        // Add action listeners for buttons
        linearSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int target = Integer.parseInt(searchField.getText());
                int index = SearchAlgorithms.linearSearch(array, target);
                resultLabel.setText("Result: " + (index >= 0 ? "Found at index " + index : "Not Found"));
                repaint();
            }
        });

        binarySearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(array); // Binary search requires sorted array
                int target = Integer.parseInt(searchField.getText());
                int index = SearchAlgorithms.binarySearch(array, target);
                resultLabel.setText("Result: " + (index >= 0 ? "Found at index " + index : "Not Found"));
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        int xOffset = 10;
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect(xOffset + i * 50, 300 - array[i] * 20, 40, array[i] * 20);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(array[i]), xOffset + i * 50 + 15, 300 - array[i] * 20 - 5);
        }
    }
}
