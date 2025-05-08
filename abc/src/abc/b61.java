package abc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class b61 extends JFrame {

    private JLabel imageLabel;
    private JButton loadButton;

    public b61() {
        setTitle("Load Image from URL");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // căn giữa màn hình
        setLayout(new BorderLayout(10, 10));

        // Label để hiển thị ảnh
        imageLabel = new JLabel("Image will appear here", SwingConstants.CENTER);
        imageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(imageLabel, BorderLayout.CENTER);

        // Button để tải ảnh
        loadButton = new JButton("Load Image");
        add(loadButton, BorderLayout.SOUTH);

        // Sự kiện nút Load Image
        loadButton.addActionListener(e -> {
            loadButton.setEnabled(false);
            imageLabel.setText("Loading...");
            new ImageLoaderWorker().execute(); // gọi SwingWorker để tải ảnh
        });
    }

    // SwingWorker để tải ảnh từ URL ở background
    private class ImageLoaderWorker extends SwingWorker<Icon, Void> {
        @Override
        protected Icon doInBackground() throws Exception {
            // URL của ảnh
            String urlString = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/2048px-React-icon.svg.png";
            URL url = new URL(urlString);

            // Đọc ảnh từ URL
            BufferedImage image = ImageIO.read(url);

            // Resize ảnh cho vừa JLabel
            Image scaledImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);

            // Trả về Icon
            return new ImageIcon(scaledImage);
        }

        @Override
        protected void done() {
            try {
                Icon icon = get();
                imageLabel.setText(null);  // Xóa text cũ
                imageLabel.setIcon(icon);  // Hiển thị ảnh
            } catch (Exception ex) {
                imageLabel.setText("Failed to load image.");
                ex.printStackTrace();
            } finally {
                loadButton.setEnabled(true);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new b61().setVisible(true));
    }
}
