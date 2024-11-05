package LAB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp extends JFrame implements ActionListener {
    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public ToDoListApp() {
        setTitle("To-Do List Application");
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));
        
        taskField = new JTextField();
        taskField.setPreferredSize(new Dimension(250, 30));
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JButton addButton = new JButton("Add Task");
        JButton completeButton = new JButton("Complete Task");
        JButton deleteButton = new JButton("Delete Task");

        addButton.addActionListener(this);
        completeButton.addActionListener(this);
        deleteButton.addActionListener(this);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(completeButton);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Add Task")) {
            String task = taskField.getText().trim();
            if (!task.isEmpty() && !taskListModel.contains(task)) {
                taskListModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input or duplicate task.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (command.equals("Complete Task")) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                String completedTask = taskListModel.get(selectedIndex);
                taskListModel.set(selectedIndex, completedTask + " ✔️"); // Marking the task as complete
                taskList.clearSelection();
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to mark as complete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (command.equals("Delete Task")) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoListApp app = new ToDoListApp();
            app.setVisible(true);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
