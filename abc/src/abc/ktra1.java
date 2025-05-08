package abc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.Color;

public class ktra1 extends JFrame {
    private JTextField txtName, txtDOB, txtHometown;
    private JButton btnShow;
    private JTable table;
    private DefaultTableModel model;

    public ktra1() {
    	getContentPane().setBackground(new Color(131, 252, 242));
        setTitle("Thông tin sinh viên");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Họ và tên:");
        lblName.setBounds(30, 30, 80, 25);
        getContentPane().add(lblName);

        txtName = new JTextField();
        txtName.setBounds(120, 30, 150, 25);
        getContentPane().add(txtName);

        JLabel lblDOB = new JLabel("Ngày sinh:");
        lblDOB.setBounds(30, 70, 80, 25);
        getContentPane().add(lblDOB);

        txtDOB = new JTextField();
        txtDOB.setBounds(120, 70, 150, 25);
        getContentPane().add(txtDOB);

        JLabel lblHometown = new JLabel("Quê quán:");
        lblHometown.setBounds(30, 110, 80, 25);
        getContentPane().add(lblHometown);

        txtHometown = new JTextField();
        txtHometown.setBounds(120, 110, 150, 25);
        getContentPane().add(txtHometown);

        btnShow = new JButton("Hiển thị");
        btnShow.setBackground(new Color(255, 128, 128));
        btnShow.setBounds(120, 150, 100, 30);
        getContentPane().add(btnShow);

        model = new DefaultTableModel();
        model.addColumn("Họ và tên");
        model.addColumn("Ngày sinh");
        model.addColumn("Quê quán");

        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(30, 200, 400, 150);
        getContentPane().add(pane);

        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String dob = txtDOB.getText();
                String hometown = txtHometown.getText();
                model.addRow(new Object[]{name, dob, hometown});
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ktra1().setVisible(true);
        });
    }
}