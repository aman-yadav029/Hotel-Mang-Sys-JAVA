package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Employee_Payment implements ActionListener, KeyListener {
    JFrame f1;
    JLabel Block, Adhar, Name, MobileNo,Des, Month, Amt;
    JTextField TfA_number, Tfname, TfMobile_No, TfDes, TfAmt;
    JButton check, pay, clear;
    JComboBox Block_Combo,Month_Choice;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Employee_Payment() {
        f1 = new JFrame("Employee Payment  Details ");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        f1.setSize(850, 550);
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
        Des = new JLabel("Designation");
        Des.setFont(ft1);
        Month = new JLabel("Month");
        Month.setFont(ft1);
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
        Amt = new JLabel("Payable Amount");
        Amt.setFont(ft1);
        TfA_number = new JTextField();
        TfA_number.setFont(ft2);
        TfA_number.addKeyListener(this);
        Tfname = new JTextField();
        Tfname.setFont(ft2);
        TfMobile_No = new JTextField();
        TfMobile_No.setFont(ft2);
        TfDes = new JTextField();
        TfDes.setFont(ft2);
        TfAmt = new JTextField();
        TfAmt.setFont(ft2);
        check = new JButton("Check");
        check.setFont(ft1);
        pay = new JButton("Pay");
        pay.setFont(ft1);
        clear = new JButton("Clear");
        clear.setFont(ft1);
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
        Des.setBounds(80, 270, 200, 30);
        TfDes.setBounds(310, 270, 200, 30);
        Month.setBounds(80, 330, 200, 30);
        Month_Choice.setBounds(310, 330, 200, 30);
        Amt.setBounds(80, 390, 200, 30);
        TfAmt.setBounds(310, 390, 200, 30);
        pay.setBounds(140, 440, 100, 30);
        pay.addActionListener(this);
        clear.setBounds(300, 440, 100, 30);
        clear.addActionListener(this);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/13.jpg"));
        Image i2=i1.getImage().getScaledInstance(850,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,850,550);
        f1.add(image);
        Tfname.setOpaque(false);
        TfAmt.setOpaque(false);
        TfDes.setOpaque(false);
        TfA_number.setOpaque(false);
        TfMobile_No.setOpaque(false);
        Tfname.setBorder(border);
        TfMobile_No.setBorder(border);
        TfAmt.setBorder(border);
        TfDes.setBorder(border);
        TfA_number.setBorder(border);
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
        TfMobile_No.addKeyListener(this);
        TfAmt.addKeyListener(this);
        image.add(Adhar);
        image.add(TfA_number);
        image.add(Name);
        image.add(Tfname);
        image.add(MobileNo);
        image.add(TfMobile_No);
        image.add(Des);
        image.add(TfDes);
        image.add(Month);
        image.add(Month_Choice);
        image.add(Amt);
        image.add(TfAmt);
        image.add(Block);
        image.add(Block_Combo);
        image.add(check);
        image.add(pay);
        image.add(clear);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==check) {if (TfA_number.getText().isEmpty()||TfA_number.getText().length()<12){
            JOptionPane.showMessageDialog(null,"Please enter a correct aadhar no.");
        }else {
            String bl = (String) Block_Combo.getSelectedItem();
            String aadhar = TfA_number.getText();
            try {
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("select * from employee where Aadhar=? and Block=?");
                ps.setString(1, aadhar);
                ps.setString(2, bl);
                rs = ps.executeQuery();
                if(rs.next()) {
                    if (rs.getString("workingStatus").equals("Working"))
                    {
                        TfA_number.setEditable(false);
                        Tfname.setText(rs.getString("Name"));
                        TfMobile_No.setText(rs.getString("MobileNo"));
                        TfDes.setText(rs.getString("Designation"));
                        TfAmt.setText(rs.getString("salary"));
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Employee does not Exist");
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
            TfDes.setText("");

            TfAmt.setText("");
            TfA_number.setEditable(true);
        }
        else if (ae.getSource()==pay) {if(TfA_number.getText().isEmpty()||TfAmt.getText().isEmpty()||TfDes.getText().isEmpty()||Tfname.getText().isEmpty()||TfMobile_No.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"All Fields are Mandatory");
        }else {
            String bl = (String) Block_Combo.getSelectedItem();
            String ar = TfA_number.getText();
            String nm = Tfname.getText();
            String des= TfDes.getText();
            String month = Month_Choice.getSelectedItem().toString();
            String amt = TfAmt.getText();
            String mobNo = TfMobile_No.getText();
            try {
                con = DBConnection.createDBConnection();
                ps= con.prepareStatement("select * from employee where Aadhar=?");
                ps.setString(1,ar);
                rs=ps.executeQuery();
                if(rs.next()){
                    ps = con.prepareStatement("select * from employee_payment where AadharNumber=? and Month=?");
                    ps.setString(1, ar);
                    ps.setString(2, month);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Employee Payment Has Already Paid for this Month ");
                    } else {
                        ps = con.prepareStatement("insert into employee_payment (Block,AadharNumber,Name,MobileNo,Designation,Month,payment) values (?,?,?,?,?,?,?)");
                        ps.setString(1, bl);
                        ps.setString(2, ar);
                        ps.setString(3, nm);
                        ps.setString(4, mobNo);
                        ps.setString(5, des);
                        ps.setString(6, month);
                        ps.setString(7, amt);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Employee Salary Paid Succesfully of this Month");
                    }
                    Tfname.setText("");
                    TfA_number.setText("");
                    TfMobile_No.setText("");
                    TfDes.setText("");
                    TfAmt.setText("");
                    TfA_number.setEditable(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect aadhar number");
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
            if(l<=11)
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
                JOptionPane.showMessageDialog(null,"Cannot add more than 12 Digits");
                ke.consume();
            }//else
        } else if ( ke.getSource()==TfMobile_No) {
            int l=(TfMobile_No.getText().length());
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
            }
        } else if (ke.getSource()==TfAmt) {
            char c=ke.getKeyChar();
            if((c>='0'&& c<='9'))
            {
            }//if
            else
            {
                ke.consume();
            }
        }
    }//key typed
}



