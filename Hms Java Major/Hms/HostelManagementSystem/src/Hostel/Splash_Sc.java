package Hostel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Splash_Sc implements ActionListener
{
    JFrame f1;
    JLabel image;
    JButton next;

    public Splash_Sc() {
        f1 = new JFrame();
        f1.setSize(740, 440);
        f1.setResizable(false);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLocationRelativeTo(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/sp_sc.jpg"));
//        Image i2=i1.getImage().getScaledInstance(730,415,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i1);
        image=new JLabel(i1);
        image.setBounds(0,0,730,415);
        f1.add(image);
        Font fnt1=new Font("Charter BT",Font.BOLD,25);
        next=new JButton("Continue");
        next.setFont(fnt1);
        next.setBounds(560,330,160,40);
        next.setForeground(Color.BLACK);
        image.add(next);
        next.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            Login r=new Login();
            f1.dispose();
        }
    }
}
