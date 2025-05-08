package abc;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.FlowLayout;
import java.awt.Font;

public class b34 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					b34 frame = new b34();
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
	public b34() {
		setTitle("JSpinner Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50,200,300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPane.setLayout(new FlowLayout()); // Dễ sắp xếp các thành phần

		setContentPane(contentPane);

		// Tạo JSpinner với giá trị từ 1 đến 100
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner spinner = new JSpinner(spinnerModel);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));

		// Tạo JLabel để hiển thị giá trị
		JLabel valueLabel = new JLabel("Giá trị: 1");
		valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// Xử lý sự kiện khi spinner thay đổi
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				valueLabel.setText("Giá trị: " + spinner.getValue());
			}
		});

		// Thêm vào contentPane
		contentPane.add(spinner);
		contentPane.add(valueLabel);
	}
}
