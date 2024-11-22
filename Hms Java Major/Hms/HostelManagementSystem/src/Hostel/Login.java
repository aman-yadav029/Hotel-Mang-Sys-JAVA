package Hostel;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class Login extends JFrame implements ActionListener {
    JFrame f1;
    JLabel l1, l2;
    JTextField t1;
    JPasswordField p1;
    JButton btn1,btn2;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Login() {
        f1 = new JFrame("Login Page");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        t1 = new JTextField("");
        p1 = new JPasswordField("");
        btn1 = new JButton("Login");
        btn2 = new JButton("Forget Password");
        ft1 = new Font("Calibri", Font.PLAIN, 16);
        ft2 = new Font("Monospaced", Font.BOLD, 20);
        f1.setSize(500, 550);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.WHITE);
        l1.setBounds(100, 150, 150, 20);
        t1.setBounds(100, 165, 300, 30);
        l2.setBounds(100, 212, 150, 20);
        p1.setBounds(100, 225, 300, 30);
        btn1.setBounds(185, 312, 120, 35);
        btn2.setBounds(130, 382, 240, 35);
       JCheckBox show = new JCheckBox("Show Password");
       show.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               p1.setEchoChar(show.isSelected()?'\u0000':(Character)UIManager.get("PasswordField.echoChar"));
           }
       });
//       show.addActionListener(ae->{
//           JCheckBox c = (JCheckBox) ae.getSource();
//           p1.setEchoChar((c.isSelected()?'\u0000':(Character)UIManager.get("PasswordField.echoChar")));
//       });
        show.setBounds(95,260,200,30);
        show.setFont(ft1);
        show.setOpaque(false);
        l1.setBackground(Color.BLACK);
        l2.setBackground(Color.BLACK);
        Random rand = new Random();
        int[] arr={20,21,22,23,24};
        int str = arr[rand.nextInt(arr.length)];
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/"+str+".jpeg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,500,550);
        f1.add(image);
        t1.setOpaque(false);
        p1.setOpaque(false);
        t1.setBorder(border);
        p1.setBorder(border);
        l1.setFont(ft1);
        l2.setFont(ft1);
        t1.setFont(ft2);
        p1.setFont(ft2);
        btn1.setFont(new Font("Monospace",Font.BOLD,22));
        btn2.setFont(new Font("Monospace",Font.BOLD,22));
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.add(l1);
        image.add(l2);
        image.add(t1);
        image.add(p1);
        image.add(btn1);
        image.add(btn2);
        image.add(show);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            String nm;
            String pwd;
            nm=t1.getText();
            pwd=p1.getText();
            if (nm.length()==0 && pwd.length()==0){
                JOptionPane.showMessageDialog(null, "Please Enter Username and Password");
            } else if (nm.length()==0) {
                JOptionPane.showMessageDialog(null, "Please Enter Username");
            } else if (pwd.length()==0) {
                JOptionPane.showMessageDialog(null, "Please Enter Password");
            }else {
            try {
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("select * from user where User_Name=? and Password=?");
                ps.setString(1, nm);
                ps.setString(2, pwd);
                rs = ps.executeQuery();
                if (rs.next()) {
                    HomePage hp=new HomePage();
                    f1.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username and Password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }}
        }
        else if (ae.getSource()==btn2)
        {
            ForgetPwd fpwd=new ForgetPwd();
            f1.dispose();
        }
    }

}




