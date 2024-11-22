package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
public class Update_Room implements ActionListener, KeyListener {
    JFrame f1;int oldrent;
    JLabel l1, l2, l3,Block,Rent;
    JTextField t1,t2;
    JButton b1,b2,clear;
    Font ft1, ft2;
    JComboBox Avail_Combo,Cl_Combo,Block_Combo;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Update_Room() {
        f1 = new JFrame("Update Room  ");
        ft1 = new Font("Monospaced", Font.BOLD, 20);
        ft2 = new Font("Monospaced", Font.BOLD, 17);
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        Block=new JLabel("Block");
        String Block_Values[]={"A","B"};
        Block_Combo=new JComboBox(Block_Values);
        Block_Combo.setBackground(Color.WHITE);
        Block_Combo.setToolTipText("A for Boys B for Girls ");
        String Avialable_Values[]={"Avialable","Occupied"};
        Avail_Combo=new JComboBox(Avialable_Values);
        Avail_Combo.setBackground(Color.WHITE);
        Avail_Combo.setFont(ft2);
        String cleaning_Values[]={"Cleaned","Dirty"};
        Cl_Combo=new JComboBox(cleaning_Values);
        //Cl_Combo.setBackground(Color.WHITE);
        Cl_Combo.setFont(ft2);
        l1 = new JLabel("Room Number");
        l2 = new JLabel("Availability");
        l3 = new JLabel("Cleaning Status");
        Rent = new JLabel("Rent");
        t1 = new JTextField("");
        t1.addKeyListener(this);
        t2=new JTextField();
        t2.addKeyListener(this);
        b1 = new JButton("Check");
        b2 = new JButton("Update");
        clear =new JButton("Clear");
        f1.setSize(700, 450);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setLayout(null);
        f1.getContentPane().setBackground(Color.WHITE);
        Block.setBounds(80, 50, 200, 30);
        Block_Combo.setBounds(320, 50, 150, 30);
        l1.setBounds(80, 110, 200, 30);
        t1.setBounds(320, 110, 150, 30);
        l2.setBounds(80, 170, 200, 30);
        Avail_Combo.setBounds(320, 170, 150, 30);
        l3.setBounds(80, 230, 200, 30);
        Cl_Combo.setBounds(320, 230, 150, 30);
        Rent.setBounds(80, 280, 150, 30);
        t2.setBounds(320, 280, 150, 30);
        b1.setBounds(80, 350, 150, 30);
        b2.setBounds(260, 350, 150, 30);
        clear.setBounds(440,350,150,30);
        l1.setFont(ft1);
        l2.setFont(ft1);
        l3.setFont(ft1);
        Rent.setFont(ft1);
        t1.setFont(ft2);
        t2.setFont(ft2);
        b1.setFont(ft1);
        b2.setFont(ft1);
        clear.setFont(ft1);
        Block.setFont(ft1);
        Block_Combo.setFont(ft2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        clear.addActionListener(this);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/16.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,450);
        f1.add(image);
        t1.setOpaque(false);
        t1.setBorder(border);
        t2.setOpaque(false);
        t2.setBorder(border);
        image.add(Rent);
        image.add(t2);
        image.add(l1);
        image.add(l2);
        image.add(l3);
        image.add(t1);
        image.add(Avail_Combo);
        image.add(Cl_Combo);
        image.add(b1);
        image.add(b2);
        image.add(Block);
        image.add(Block_Combo);
        image.add(clear);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {if(!t1.getText().isEmpty()){
            try {
                String rm = t1.getText();
                String bl = Block_Combo.getSelectedItem().toString();
                con = DBConnection.createDBConnection();
                PreparedStatement ps = con.prepareStatement("select * from room where Block=? and Room_No=?");
                ps.setString(1, bl);
                ps.setString(2, rm);
                rs=ps.executeQuery();
                if (rs.next()){
                    String val1 = rs.getString("Availability");
                    if (val1=="Available"){
                        Avail_Combo.removeAllItems();
                        Avail_Combo.addItem("Occupied"); Avail_Combo.addItem("Available");
                    }
                    else {
                        Avail_Combo.removeAllItems();
                        Avail_Combo.addItem("Available"); Avail_Combo.addItem("Occupied");

                    }
                    String val2 = rs.getString("Cleaning_Status");
                    if (val2=="Cleaned"){
                        Cl_Combo.removeAllItems();
                        Cl_Combo.addItem("Dirty");Cl_Combo.addItem("Cleaned");

                    }
                    else {
                        Cl_Combo.removeAllItems();
                        Cl_Combo.addItem("Cleaned");Cl_Combo.addItem("Dirty");
                    }
                    t2.setText(rs.getString("price"));
                    oldrent=Integer.parseInt(rs.getString("price"));
                }
                else {
                    JOptionPane.showMessageDialog(null,"Room does not exists\nor Mismatched with block");
                }
                Block_Combo.setEnabled(false);
                t1.setEnabled(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null,"Please Enter a Room Number");
        }

        }
        else if(ae.getSource()==b2) {if(t2.getText()!=""||!t2.getText().isEmpty()){
            String block = Block_Combo.getSelectedItem().toString();
            String room = t1.getText();
            String avail = Avail_Combo.getSelectedItem().toString();
            String cls = Cl_Combo.getSelectedItem().toString();
            String rent = t2.getText();
            try {
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("update room set Cleaning_Status=?, Availability=?,price=? where Block=? and Room_No=?");
                ps.setString(1, cls);
                ps.setString(2, avail);
                ps.setString(3, block);
                ps.setString(4, room);
                ps.setString(5,rent);
                ps.executeUpdate();

                    if (oldrent!=Integer.parseInt(rent)){
                        ps=con.prepareStatement("select * from student where roomnumber=? and block=?");
                        ps.setString(1,room);
                        ps.setString(2,block);
                        rs=ps.executeQuery();
                        while (rs.next()){
                            int discount = oldrent-Integer.parseInt(rs.getString("rent"));
                            int newRent = Integer.parseInt(rent)-discount;
                            ps=con.prepareStatement("update student set rent=? where roomnumber=? and block=?");
                            ps.setString(1,String.valueOf(newRent));
                            ps.setString(2,room);
                            ps.setString(3,block);
                            ps.executeUpdate();
                        }
                    }


                JOptionPane.showMessageDialog(null, "Room Status Updated Successfully");
                f1.dispose();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null,"Please enter a room number");
        }

        } else if (ae.getSource()==clear) {
            Block_Combo.setEnabled(true);
            t1.setText("");
            t2.setText("");
            t1.setEnabled(true);
        }
    }
    public void keyPressed(KeyEvent ke)
    {
    }//key pressed
    public void keyReleased(KeyEvent ke)
    {
    }//key released
    public void keyTyped(KeyEvent ke)
    {
        if(ke.getSource()==t1||ke.getSource()==t2)
        {
            int l=(t1.getText().length());
            if(l<=3)
            {
                char c=ke.getKeyChar();
                if((c>='0'&&c<='9'))
                {
                }//if
                else
                {
                    ke.consume();
                }//else
            }//if
            else
            {
                JOptionPane.showMessageDialog(null,"No Available Room");
                ke.consume();
            }//else
        }//if
    }//key typed
}



