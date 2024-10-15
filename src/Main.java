import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DSA Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Creating Menu
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Algorithms");
        JMenuItem sortingMenuItem = new JMenuItem("Sorting Algorithms");
        JMenuItem searchingMenuItem = new JMenuItem("Searching Algorithms");
        JMenuItem stackMenuItem = new JMenuItem("Stack Operations");
        JMenuItem queueMenuItem = new JMenuItem("Queue Operations");

        menu.add(sortingMenuItem);
        menu.add(searchingMenuItem);
        menu.add(stackMenuItem);
        menu.add(queueMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Adding Panels
        SortingPanel sortingPanel = new SortingPanel();
        SearchingPanel searchingPanel = new SearchingPanel();
        StackPanel stackPanel = new StackPanel();
        QueuePanel queuePanel = new QueuePanel();

        frame.setLayout(new CardLayout());
        frame.add(sortingPanel, "Sorting");
        frame.add(searchingPanel, "Searching");
        frame.add(stackPanel, "Stack");
        frame.add(queuePanel, "Queue");

        sortingMenuItem.addActionListener(e -> {
            ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "Sorting");
        });
        searchingMenuItem.addActionListener(e -> {
            ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "Searching");
        });
        stackMenuItem.addActionListener(e -> {
            ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "Stack");
        });
        queueMenuItem.addActionListener(e -> {
            ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), "Queue");
        });

        frame.setVisible(true);
    }
}
