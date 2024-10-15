import javax.swing.*;
import java.awt.*;

public class SortingPanel extends JPanel {
    private int[] array = { 10, 5, 2, 8, 7, 1, 3 };

    public SortingPanel() {
        setLayout(new BorderLayout());

        // Dropdown for choosing sorting algorithm
        String[] algorithms = { "Bubble Sort", "Insertion Sort", "Merge Sort" };
        JComboBox<String> algorithmComboBox = new JComboBox<>(algorithms);

        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(e -> {
            String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
            if (selectedAlgorithm.equals("Bubble Sort")) {
                SortAlgorithms.bubbleSort(array);
            } else if (selectedAlgorithm.equals("Insertion Sort")) {
                SortAlgorithms.insertionSort(array);
            } else if (selectedAlgorithm.equals("Merge Sort")) {
                array = SortAlgorithms.mergeSort(array);
            }
            repaint(); // Refresh the panel to show sorted array
        });

        add(algorithmComboBox, BorderLayout.NORTH);
        add(sortButton, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            g.fillRect(50 * i + 10, 300 - array[i] * 20, 40, array[i] * 20);
        }
    }
}
