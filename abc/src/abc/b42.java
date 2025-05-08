package abc;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class b42 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					b42 frame = new b42();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public b42() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200); // chỉnh lại kích thước đúng yêu cầu
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);

		// Tạo và thêm các màu
		String[] colors = {"Red", "Blue", "Green", "Yellow", "Cyan"};
		JComboBox<String> comboBox = new JComboBox<>(colors);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(comboBox);

		// Bắt sự kiện chọn
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedColor = (String) comboBox.getSelectedItem();
				JOptionPane.showMessageDialog(null, "Bạn đã chọn màu: " + selectedColor);
			}
		});
		
	}
}


