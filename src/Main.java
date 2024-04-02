import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JPanel panel = new JPanel();
    static void addObject(JComponent component,int n){
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(component);
        panel.add(Box.createVerticalStrut(n));
    }
    public static void main(String[] args) {
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));
        JFrame frame = new JFrame("JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Желтый");
        comboBox.addItem("Черный");
        comboBox.addItem("Синий");
        comboBox.setMaximumSize(new Dimension(100,30));
        addObject(comboBox,10);

        JCheckBox checkBox = new JCheckBox("Свой вариант");
        addObject(checkBox,10);

        JTextField textField = new JTextField();
        textField.setEnabled(false);
        textField.setMaximumSize(new Dimension(100,30));
        addObject(textField, 10);

        JButton button = new JButton("Ответить");
        addObject(button,10);

        JLabel label = new JLabel("Ответ: ");
        addObject(label,10);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Ответ: " + (checkBox.isSelected()?
                        textField.getText():comboBox.getSelectedItem().toString()));
            }
        });
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setEnabled(checkBox.isSelected());
                comboBox.setEnabled(!checkBox.isSelected());
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}