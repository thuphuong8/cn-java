package abc;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class abc extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                abc frame = new abc();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public abc() {
        setTitle("Chọn màu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);

        contentPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        String[] colors = {"Red", "Blue", "Green", "Yellow", "Cyan"};
        JComboBox<String> comboBox = new JComboBox<>(colors);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBox.setBackground(Color.WHITE);
        contentPane.add(comboBox);

        comboBox.addActionListener(e -> {
            String selectedColor = (String) comboBox.getSelectedItem();
            switch (selectedColor) {
                case "Red":
                    contentPane.setBackground(Color.RED);
                    break;
                case "Blue":
                    contentPane.setBackground(Color.BLUE);
                    break;
                case "Green":
                    contentPane.setBackground(Color.GREEN);
                    break;
                case "Yellow":
                    contentPane.setBackground(Color.YELLOW);
                    break;
                case "Cyan":
                    contentPane.setBackground(Color.CYAN);
                    break;
            }
        });
    }
}
