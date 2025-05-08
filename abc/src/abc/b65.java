package abc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class b65 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel timeLabel;
	private JButton startButton, stopButton, resetButton;
	private Timer timer;
	private int elapsedSeconds = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				b65 frame = new b65();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public b65() {
		setTitle("Stopwatch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);

		// Label hiển thị thời gian
		timeLabel = new JLabel("Time: 00:00", SwingConstants.CENTER);
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(timeLabel, BorderLayout.CENTER);

		// Panel nút
		JPanel buttonPanel = new JPanel(new FlowLayout());
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		resetButton = new JButton("Reset");
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(resetButton);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		// Timer cập nhật mỗi giây
		timer = new Timer(1000, e -> {
			elapsedSeconds++;
			updateTimeLabel();
		});

		// Nút điều khiển
		startButton.addActionListener(e -> timer.start());
		stopButton.addActionListener(e -> timer.stop());
		resetButton.addActionListener(e -> {
			timer.stop();
			elapsedSeconds = 0;
			updateTimeLabel();
		});
	}

	private void updateTimeLabel() {
		int minutes = elapsedSeconds / 60;
		int seconds = elapsedSeconds % 60;
		timeLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
	}
}
