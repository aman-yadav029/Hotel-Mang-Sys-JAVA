package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
public class ForgetPwd implements ActionListener {
    JFrame f1;
    JLabel l1,l2,l3,image,support;
    JTextField t1;
    JPasswordField p1,p2;
    JButton b1,b2,Breach;
    Font ft1,ft2;
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    public ForgetPwd()
    {
        f1=new JFrame("Forget Password");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        f1.setSize(600,450);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ft1=new Font("Monospaced",Font.BOLD,20);
        ft2 = new Font("Monospaced", Font.BOLD, 17);
        l1=new JLabel("User Name");
        l1.setFont(ft1);
        l1.setBounds(75,50,230,30);
        t1=new JTextField();
        t1.setFont(ft2);
        t1.setBounds(280,50,140,30);
        t1.setOpaque(false);
        l2=new JLabel("New Password");
        l2.setFont(ft1);
        l2.setBounds(75,130,230,30);
        p1=new JPasswordField();
        p1.setFont(ft2);
        p1.setBounds(280,130,140,30);
        l3=new JLabel("Confirm Password");
        l3.setFont(ft1);
        l3.setBounds(75,210,230,30);
        p2=new JPasswordField();
        p2.setFont(ft2);
        p2.setBounds(280,210,140,30);
        p1.setOpaque(false);
        p2.setOpaque(false);
        b1=new JButton("Change");
        b1.setFont(ft1);
        b1.addActionListener(this);
        b1.setBounds(75,300,150,40);
        b2=new JButton("Close");
        b2.setFont(ft1);
        b2.addActionListener(this);
        b2.setBounds(280,300,150,40);
        Breach = new JButton("");
        Breach.setBounds(585,410,30,30);
        Breach.setForeground(Color.BLUE);
        Breach.addActionListener(this);
        Breach.setContentAreaFilled(false);
        Breach.setOpaque(false);
        Breach.setBorderPainted(false);
        support =new JLabel("Forgot Username?");
        support.setForeground(new Color(119,136,153));
        support.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                support.setForeground(Color.BLUE.darker());
            }

        });
        support.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                support.setForeground(new Color(119,136,153));
            }
        });
        support.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        support.setBounds(210,400,105,17);
        Border border1 = new MatteBorder(new Insets(0,0,1,0),new Color(119,136,153));
        support.setBorder(border1);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/5.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        f1.add(image);
        t1.setBorder(border);
        p2.setBorder(border);
        p1.setBorder(border);
        support.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               JOptionPane.showMessageDialog(null,"Contact Us \nContact no.: 7830330151\nE-mail: sn945626@gmail.com");
            }
        });
        image.setBounds(0,0,600,450);
        image.add(support);
        image.add(l1);
        image.add(l2);
        image.add(l3);
        image.add(t1);
        image.add(p1);
        image.add(p2);
        image.add(b1);
        image.add(b2);
        image.add(Breach);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==b2) {
            Login login = new Login();
            f1.dispose();
        } else if (ae.getSource()==Breach) {
            AddUser register=new AddUser();
            f1.dispose();
        } else if(ae.getSource()==b1)
        {
            String un,op,np,cp;
            un=t1.getText();
            np=p1.getText();
            cp=p2.getText();
            if(np.equals(cp))
            {
                try
                {
                    con=DBConnection.createDBConnection();
                    st=con.prepareStatement("select User_Name from user where User_Name=?");
                    st.setString(1,un);
                    rs=st.executeQuery();
                    rs.next();
                   // int co=rs.getInt(1);
                    if(rs!=null)
                    {
                        st=con.prepareStatement("update user set Password=? where User_Name=?");
                        st.setString(1,np);
                        st.setString(2,un);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Password changed Successfully");
                        t1.setText("");
                        p1.setText("");
                        p2.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Invalid UserName");
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"New password & Confirm Password does not match");
            }
        }
    }
}

