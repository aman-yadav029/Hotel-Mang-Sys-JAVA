package Hostel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete_User extends JFrame implements ActionListener {
    JFrame f1;
    JLabel l1,head;
    JTextField t1;
    JButton btn1,btn2;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Delete_User() {
        f1 = new JFrame("Delete user");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        head = new JLabel("Delete User");
        head.setBounds(150,40,240,50);
        head.setFont(new Font("Monospaced",1,35));
        head.setBorder(border);
        l1 = new JLabel("Username");
        t1 = new JTextField("");
        btn1 = new JButton("Delete");
        btn2 = new JButton("Close");
        btn1.setForeground(Color.RED);
        ft1 = new Font("Monospaced", Font.PLAIN, 16);
        ft2 = new Font("Monospaced", Font.BOLD, 20);
        f1.setSize(500, 550);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.WHITE);
        l1.setBounds(100, 200, 150, 20);
        t1.setBounds(100, 215, 300, 30);
        btn1.setBounds(185, 312, 120, 30);
        btn2.setBounds(130, 382, 240, 30);
        JLabel image=new JLabel(new ImageIcon(ClassLoader.getSystemResource("Hostel/22.jpeg")));
        image.setBounds(0,0,500,550);
        f1.add(image);
        t1.setOpaque(false);
        t1.setBorder(border);
        l1.setFont(ft1);
        t1.setFont(ft2);
        btn1.setFont(new Font("Monospace",Font.BOLD,22));
        btn2.setFont(new Font("Monospace",Font.BOLD,22));
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.add(l1);
        image.add(t1);
        image.add(btn1);
        image.add(btn2);
        image.add(head);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            String nm;
            nm=t1.getText();
            if (nm.length()==0) {
                JOptionPane.showMessageDialog(null, "Please Enter Username");
            } else {
                try {
                    con = DBConnection.createDBConnection();
                    ps = con.prepareStatement("select * from user where User_Name=?");
                    ps.setString(1, nm);
                    rs = ps.executeQuery();
                    if (rs.next()){
                        ps = con.prepareStatement("delete from user where User_Name=?");
                        ps.setString(1, nm);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Deleted Successfully");
                    }else {
                        JOptionPane.showMessageDialog(null,"User does not Exists");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }}
        }
        else if (ae.getSource()==btn2)
        {
            f1.dispose();
        }
    }
}
