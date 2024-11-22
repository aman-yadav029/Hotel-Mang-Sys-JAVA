package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Student_Rent implements ActionListener, KeyListener {
    JFrame f1;
    JLabel Block, Adhar, Name, MobileNo, RoomNo, Month, Amt,image, TfAmt;
    JTextField TfA_number, Tfname, TfMobile_No, TfRoom_No;
    JButton check, pay, clear;
    JComboBox Block_Combo,Month_Choice;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Student_Rent() {
        f1 = new JFrame("student Rent Details ");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        f1.setSize(850, 530);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.getContentPane().setBackground(Color.WHITE);
        f1.setResizable(false);
        ft1 = new Font("Monospaced", Font.BOLD, 20);
        ft2 = new Font("Monospaced", Font.BOLD, 17);
        Block = new JLabel("Block");
        Block.setFont(ft1);
        String value[] = {"A", "B"};
        Block_Combo = new JComboBox(value);
        Block_Combo.setFont(ft2);
        Adhar = new JLabel("Aadhar");
        Adhar.setFont(ft1);
        Name = new JLabel("Name");
        Name.setFont(ft1);
        MobileNo = new JLabel("Mobile Number");
        MobileNo.setFont(ft1);
        RoomNo = new JLabel("Room Number");
        RoomNo.setFont(ft1);
        Month = new JLabel("Month");
        Month.setFont(ft1);
        Amt = new JLabel("Payable Amount");
        Amt.setFont(ft1);
        TfA_number = new JTextField();
        TfA_number.setFont(ft2);
        TfA_number.addKeyListener(this);
        Tfname = new JTextField();
        Tfname.setFont(ft2);
        TfMobile_No = new JTextField();
        TfMobile_No.setFont(ft2);
        TfRoom_No = new JTextField();
        TfRoom_No.setFont(ft2);
        TfAmt = new JLabel();
        TfAmt.setFont(ft2);
        check = new JButton("Check");
        check.setFont(ft1);
        pay = new JButton("Pay");
        pay.setFont(ft1);
        clear = new JButton("Clear");
        clear.setFont(ft1);
        Month_Choice = new JComboBox();
        Month_Choice.addItem("JANUARY");
        Month_Choice.addItem("FEBRUARY");
        Month_Choice.addItem("MARCH");
        Month_Choice.addItem("APRIL");
        Month_Choice.addItem("MAY");
        Month_Choice.addItem("JUNE");
        Month_Choice.addItem("JULY");
        Month_Choice.addItem("AUGUST");
        Month_Choice.addItem("SEPTEMBER");
        Month_Choice.addItem("OCTOBER");
        Month_Choice.addItem("NOVEMBER");
        Month_Choice.addItem("DECEMBER");
        Month_Choice.setFont(ft2);
        Block.setBounds(80, 30, 200, 30);
        Block_Combo.setBounds(310, 30, 200, 30);
        Adhar.setBounds(80, 90, 200, 30);
        TfA_number.setBounds(310, 90, 200, 30);
        check.setBounds(550, 30, 180, 30);
        check.addActionListener(this);
        Name.setBounds(80, 150, 200, 30);
        Tfname.setBounds(310, 150, 200, 30);
        MobileNo.setBounds(80, 210, 200, 30);
        TfMobile_No.setBounds(310, 210, 200, 30);
        RoomNo.setBounds(80, 270, 200, 30);
        TfRoom_No.setBounds(310, 270, 200, 30);
        Month.setBounds(80, 330, 200, 30);
        Month_Choice.setBounds(310, 330, 200, 30);
        Amt.setBounds(80, 390, 200, 30);
        TfAmt.setBounds(310, 390, 200, 30);
        pay.setBounds(140, 440, 100, 30);
        pay.addActionListener(this);
        clear.setBounds(300, 440, 100, 30);
        clear.addActionListener(this);
        TfAmt.setForeground(Color.BLACK.darker());
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/11.jpg"));
        Image i2=i1.getImage().getScaledInstance(850,530,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,850,530);
        Tfname.setOpaque(false);
        TfAmt.setOpaque(false);
        TfA_number.setOpaque(false);
        TfMobile_No.setOpaque(false);
        TfRoom_No.setOpaque(false);
        Tfname.setBorder(border);
        TfAmt.setBorder(border);
        TfA_number.setBorder(border);
        TfMobile_No.setBorder(border);
        TfRoom_No.setBorder(border);
        TfMobile_No.addKeyListener(this);
        TfRoom_No.addKeyListener(this);
        Tfname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if((c>='a'&&c<='z')||(c>='A'&&c<='Z')|| c==' ')
                {
                }//if
                else
                {
                    e.consume();
                }
            }
        });
        f1.add(image);
        image.add(Adhar);
        image.add(TfA_number);
        image.add(Name);
        image.add(Tfname);
        image.add(MobileNo);
        image.add(TfMobile_No);
        image.add(RoomNo);
        image.add(TfRoom_No);
        image.add(Month);
        image.add(Month_Choice);
        image.add(Amt);
        image.add(TfAmt);
        image.add(Block);
        image.add(Block_Combo);
        image.add(check);
        image.add(pay);
        image.add(clear);
        //TfAmt.setEnabled(false);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==check) {if (TfA_number.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Enter aadhar numbre first");
        }else {

            String aadhar = TfA_number.getText();
            try {
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("select * from student where Aadhar=? and livingstatus=?");
                ps.setString(1, aadhar);
                ps.setString(2,"Living");
                rs = ps.executeQuery();
                if(rs.next()) {

                        TfA_number.setEditable(false);
                        Tfname.setText(rs.getString("Name"));
                        TfMobile_No.setText(rs.getString("MobileNo"));
                        TfRoom_No.setText(rs.getString("RoomNumber"));
                        TfAmt.setText(rs.getString("rent"));

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Student does not Exist");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        }
        else if (ae.getSource()==clear)
        {
            Tfname.setText("");
            TfA_number.setText("");
            TfMobile_No.setText("");
            TfRoom_No.setText("");
            TfAmt.setText("");
            TfA_number.setEditable(true);
        }
        else if (ae.getSource()==pay) {if(TfAmt.getText().isEmpty()||Tfname.getText().isEmpty()||TfA_number.getText().isEmpty()||TfRoom_No.getText().isEmpty()||TfMobile_No.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"All Fields are Mandatory");
        }else {

            String bl = (String) Block_Combo.getSelectedItem();
            String ar = TfA_number.getText();
            String nm = Tfname.getText();
            String room = TfRoom_No.getText();
            String month = Month_Choice.getSelectedItem().toString();
            String amt = TfAmt.getText();
            String mobNo = TfMobile_No.getText();
            try {
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("select * from student where Aadhar=? and Livingstatus = Living");
                ps.setString(1,ar);
                rs= ps.executeQuery();
                if(rs.next()){
                    ps = con.prepareStatement("select * from student_rent where AadharNumber=? and Month=?");
                    ps.setString(1, ar);
                    ps.setString(2, month);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Student Fees Has Already Paid of this month ");
                        Tfname.setText("");
                        TfA_number.setText("");
                        TfMobile_No.setText("");
                        TfRoom_No.setText("");
                        TfAmt.setText("");
                        TfA_number.setEditable(true);
                    } else {
                        ps = con.prepareStatement("insert into student_rent (Block,AadharNumber,Name,MobileNo,RoomNo,Month,paid) values (?,?,?,?,?,?,?)");
                        ps.setString(1, bl);
                        ps.setString(2, ar);
                        ps.setString(3, nm);
                        ps.setString(4, mobNo);
                        ps.setString(5, room);
                        ps.setString(6, month);
                        ps.setString(7, amt);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Student Rent Paid Succesfully of this Month");
                        Tfname.setText("");
                        TfA_number.setText("");
                        TfMobile_No.setText("");
                        TfRoom_No.setText("");
                        TfAmt.setText("");
                        TfA_number.setEditable(true);
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

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
        if(ke.getSource()==TfA_number)
        {
            int l=(TfA_number.getText().length());
            if(l<12)
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
                ke.consume();
                JOptionPane.showMessageDialog(null,"Cannot add more than 12 Digits");

            }//else
        } else if (ke.getSource() == TfMobile_No) {
            int l=(TfMobile_No.getText().length());
            if(l<10)
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
                ke.consume();
                JOptionPane.showMessageDialog(null,"Cannot add more than 10 Digits");

            }
        } else if (ke.getSource()==TfRoom_No) {
                char c=ke.getKeyChar();
                if((c>='0'&& c<='9'))
                {
                }//if
                else
                {
                    ke.consume();
                }//else
            }//if
    }//key typed
}

