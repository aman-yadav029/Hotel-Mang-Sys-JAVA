package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
public class AddUser implements ActionListener {
    JFrame f1;
    JLabel l1, l2, l3, l4,image,warning;
    JTextField t1, t2, t3;
    JPasswordField p1;
    JButton b1;
   // JPanel panel;
    Font ft1, ft2;
    Connection con;
    public AddUser() {

        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        f1 = new JFrame("Add User ");
        l1 = new JLabel("Username ");
        l2 = new JLabel("Password ");
        l3 = new JLabel("Mail ");
        l4 = new JLabel("Phone No. ");
        t1 = new JTextField("");
        p1 = new JPasswordField("");
        t2 = new JTextField("");
        t3 = new JTextField("");
        b1 = new JButton("Add User");
        ft1 = new Font("courier", Font.BOLD, 18);
        ft2 = new Font("lucida sans", Font.BOLD, 18);
        f1.setSize(800, 450);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.getContentPane().setBackground(Color.WHITE);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/2.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(300,0,500,450);
        f1.add(image);
        l1.setBounds(30, 80, 120, 30);
        t1.setBounds(145, 80, 150, 25);
        l2.setBounds(30, 140, 120, 30);
        p1.setBounds(145, 140, 150, 25);
        l3.setBounds(30, 200, 120, 30);
        t2.setBounds(145, 200, 150, 25);
        l4.setBounds(30, 260, 120, 30);
        t3.setBounds(145, 260, 150, 25);
        b1.setBounds(100, 330, 100, 30);
        JCheckBox show = new JCheckBox("Show Password");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setEchoChar(show.isSelected()?'\u0000':(Character)UIManager.get("PasswordField.echoChar"));
            }
        });
        show.setBounds(25,165,200,30);
        show.setFont(new Font("Calibri", Font.PLAIN, 15));
        show.setOpaque(false);
        t1.setBorder(border);
        t2.setBorder(border);
        t3.setBorder(border);
        p1.setBorder(border);
        l1.setFont(ft1);
        l2.setFont(ft1);
        l3.setFont(ft1);
        l4.setFont(ft1);
        t1.setFont(ft2);
        t2.setFont(ft2);
        t3.setFont(ft2);
        warning= new JLabel();
        warning.setBounds(145,170,160,15);
        warning.setFont(new Font("monospaced",1,12));
        f1.add(warning);
        p1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(p1.getText().length()<=4){
                    warning.setText("*atleast 6 characters");
                    warning.setForeground(Color.RED);
                } else if (p1.getText().length()>=4 ) {
                    warning.setText("");
                } else if(p1.getText().length()==0){
                    warning.setText("");
                }
            }
        });
        t3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                int l=(t3.getText().length());
                if(l<=9)
                {
                    char c=ke.getKeyChar();
                    if((c>='0'&& c<='9'))
                    {
                    }//if
                    else
                    {
                        ke.consume();
                    }//else
                }//if
                else
                {
                    JOptionPane.showMessageDialog(null,"Cannot add more than 10 Digits");
                    ke.consume();
                }//else
            }
        });
        p1.setFont(ft2);
        b1.setFont(ft1);
        b1.addActionListener(this);
        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(p1);
        f1.add(b1);
        f1.add(show);
        f1.setVisible(true);
        }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            if (t1.getText().trim().isEmpty() && p1.getText().trim().isEmpty() && t2.getText().trim().isEmpty() && t3.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "All the Textfields are Empty");
            } else if (t1.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username is empty");
            } else if (p1.getText().length()<5) {
                JOptionPane.showMessageDialog(null, "Password Should be more than 5 characters");
            }else if (p1.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password is empty");
            } else if (t2.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email  is empty");
            } else if (!(t2.getText().contains("@") && t2.getText().contains(".com"))) {
                JOptionPane.showMessageDialog(null,"Invalid Email !...");
            } else if (t3.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phone no. is empty");
            }else if (t3.getText().length()<10) {
                JOptionPane.showMessageDialog(null, "Phone no. cannot be less than 10 digits");
            }  else {
                try{
                    String nm=t1.getText();
                    String pwd=p1.getText();
                    String email=t2.getText();
                    String phn=t3.getText();
                    con=DBConnection.createDBConnection();
                    PreparedStatement p1=con.prepareStatement("select User_name from user where User_name=?");
                    p1.setString(1,nm);
                    ResultSet rs = p1.executeQuery();
                    if (!rs.next()) {
                        PreparedStatement ps = con.prepareStatement("insert into user (User_Name,Password,Email,Phone_No)values(?,?,?,?)");
                        ps.setString(1, nm);
                        ps.setString(2, pwd);
                        ps.setString(3, email);
                        ps.setString(4, phn);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, " Registered Successfully");
                        f1.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, " Username Already Exists");
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}



