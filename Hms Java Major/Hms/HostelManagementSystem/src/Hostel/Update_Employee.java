package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Update_Employee implements ActionListener,KeyListener {
    JFrame f1;
    JLabel Block, name, F_name, M_name, Par_add, A_number,Working_Status,Mobile_number, Designation;
    JTextField Tfname, TfF_name, TfM_name, TfAdd, TfA_number, TfMobile_number,TfDesignation,status;
    //JRadioButton Gender_Radio1,Gender_Radio2;
    JComboBox Block_Combo;
    JButton b1, b2,b3,b4;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Update_Employee() {
        f1 = new JFrame(" Update Employee Details ");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        Block = new JLabel("Block");
        String value[] = {"A", "B"};
        Block_Combo = new JComboBox(value);
        Block_Combo.setFont(ft2);
        name = new JLabel("Name");
        F_name = new JLabel("Father's Name");
        M_name = new JLabel("Mother's Name");
        Mobile_number = new JLabel("Mobile Number");
        Par_add = new JLabel("Address");
        A_number = new JLabel("Aadhar Number");
        Designation=new JLabel("Designation");
        Working_Status=new JLabel("Salary");
        Tfname = new JTextField();
        TfF_name = new JTextField("");
        TfM_name = new JTextField("");
        TfMobile_number = new JTextField("");
        TfAdd = new JTextField("");
        TfA_number = new JTextField("");
        TfDesignation = new JTextField("");
        status = new JTextField();

        b1 = new JButton("Update");
        b2 = new JButton("Delete");
        b3 = new JButton("Check");
        b4 = new JButton("Reset");
        ft1 = new Font("Monospaced", Font.BOLD, 20);
        ft2 = new Font("Monospaced", Font.BOLD, 17);
        status.setFont(ft2);
        f1.setSize(800, 650);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.WHITE);
        Block.setBounds(80, 10, 200, 30);
        Block.setFont(ft1);
        Block_Combo.setBounds(310, 10, 200, 30);
        Block_Combo.setFont(ft2);
        A_number.setBounds(80, 70, 200, 30);
        A_number.setFont(ft1);
        TfA_number.setBounds(310, 70, 200, 30);
        TfA_number.setFont(ft2);
        TfA_number.addKeyListener(this);
        name.setBounds(80, 130, 200, 30);
        name.setFont(ft1);
        Tfname.setBounds(310, 130, 200, 30);
        Tfname.setFont(ft2);
        F_name.setBounds(80, 190, 200, 30);
        F_name.setFont(ft1);
        TfF_name.setBounds(310, 190, 200, 30);
        TfF_name.setFont(ft2);
        M_name.setBounds(80, 250, 200, 30);
        M_name.setFont(ft1);
        TfM_name.setBounds(310, 250, 200, 30);
        TfM_name.setFont(ft2);
        Mobile_number.setBounds(80, 310, 200, 30);
        Mobile_number.setFont(ft1);
        TfMobile_number.setBounds(310, 310, 200, 30);
        TfMobile_number.setFont(ft2);
        Par_add.setBounds(80, 370, 200, 30);
        Par_add.setFont(ft1);
        TfAdd.setBounds(310, 370, 200, 30);
        TfAdd.setFont(ft2);
        Designation.setBounds(80, 430, 200, 30);
        Designation.setFont(ft1);
        TfDesignation.setBounds(310, 430, 200, 30);
        TfDesignation.setFont(ft1);
        Working_Status.setBounds(80, 490, 200, 30);
        Working_Status.setFont(ft1);
        status.setBounds(310, 490, 200, 30);
        b1.setBounds(100, 550, 150, 30);
        b2.setBounds(270, 550, 150, 30);
        b3.setBounds(530, 10, 150, 30);
        b4.setBounds(450, 550, 150, 30);
        b1.setFont(ft1);
        b2.setFont(ft1);
        b3.setFont(ft1);
        b4.setFont(ft1);
        status.setOpaque(false);
        status.setBorder(border);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        status.addKeyListener(this);
        TfMobile_number.addKeyListener(this);
        Tfname.addKeyListener(this);
        TfF_name.addKeyListener(this);
        TfM_name.addKeyListener(this);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/14.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,650);
        f1.add(image);
        Tfname.setOpaque(false);
        TfMobile_number.setOpaque(false);
        TfM_name.setOpaque(false);
        TfF_name.setOpaque(false);
        TfDesignation.setOpaque(false);
        TfA_number.setOpaque(false);
        TfAdd.setOpaque(false);
        Tfname.setBorder(border);
        TfMobile_number.setBorder(border);
        TfM_name.setBorder(border);
        TfF_name.setBorder(border);
        TfDesignation.setBorder(border);
        TfA_number.setBorder(border);
        TfAdd.setBorder(border);
        image.add(name);
        image.add(F_name);
        image.add(M_name);
        image.add(Mobile_number);
        image.add(Par_add);
        image.add(A_number);
        image.add(Block);
        image.add(Tfname);
        image.add(TfF_name);
        image.add(TfM_name);
        image.add(TfMobile_number);
        image.add(TfAdd);
        image.add(TfA_number);
        image.add(Designation);
        image.add(TfDesignation);
        image.add(Working_Status);
        image.add(Block_Combo);
        image.add(b1);
        image.add(b2);
        image.add(b3);
        image.add(b4);
        image.add(status);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b3) {if(TfA_number.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Enter Aadhar number first");
        }else{
            String bl = (String) Block_Combo.getSelectedItem();
            String aadhar = TfA_number.getText();
            try {
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("select * from employee where Aadhar=? and Block=?");
                ps.setString(1, aadhar);
                ps.setString(2, bl);
                rs = ps.executeQuery();
                if(rs.next()) {
                    TfA_number.setEditable(false);
                    Tfname.setText(rs.getString("Name"));
                    TfF_name.setText(rs.getString("Fname"));
                    TfM_name.setText(rs.getString("Mname"));
                    TfMobile_number.setText(rs.getString("MobileNo"));
                    TfAdd.setText(rs.getString("Address"));
                    TfDesignation.setText(rs.getString("Designation"));
                    status.setText(rs.getString("salary"));
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
        else if (ae.getSource() == b1) { if(TfF_name.getText().isEmpty()||TfA_number.getText().isEmpty()||Tfname.getText().isEmpty()||TfM_name.getText().isEmpty()||TfAdd.getText().isEmpty()||TfMobile_number.getText().isEmpty()||TfDesignation.getText().isEmpty()||status.getText().isEmpty()||Integer.parseInt(status.getText())==0){
            JOptionPane.showMessageDialog(null,"All Fields are Mandatory");
        } else if (TfMobile_number.getText().length()<10) {
            JOptionPane.showMessageDialog(null,"Mobile no. cannot be less than 10 digits");
        } else {
            String bl = (String) Block_Combo.getSelectedItem();
            String nm = Tfname.getText();
            String fname = TfF_name.getText();
            String Mname = TfM_name.getText();
            String address = TfAdd.getText();
            String aadhar=TfA_number.getText();
            String Mnumber = TfMobile_number.getText();
            String des= TfDesignation.getText();
            String sal = status.getText();
            try{
                con=DBConnection.createDBConnection();
                ps =con.prepareStatement("select * from employee where Aadhar=?");
                ps.setString(1,aadhar);
                rs=ps.executeQuery();
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                if (rs.next()){
                    con = DBConnection.createDBConnection();
                    ps = con.prepareStatement("update employee set Block=?,Name=?,FName=?,MName=?,MobileNo=?,Address=?,Designation=?,salary=? where Aadhar=?");
                    ps.setString(1, bl);
                    ps.setString(2, nm);
                    ps.setString(3, fname);
                    ps.setString(4, Mname);
                    ps.setString(5, Mnumber);
                    ps.setString(6, address);
                    ps.setString(7, des);
                    ps.setString(8,sal);
                    ps.setString(9,aadhar);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    Tfname.setText("");
                    TfF_name.setText("");
                    TfM_name.setText("");
                    TfA_number.setText("");
                    TfMobile_number.setText("");
                    TfAdd.setText("");
                    status.setText("");
                    TfDesignation.setText("");
                    TfA_number.setEditable(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect aadhar number entered");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        }
        else if(ae.getSource()==b2)
        {
            try{
                con=DBConnection.createDBConnection();
                ps =con.prepareStatement("select * from employee where Aadhar=?");
                ps.setString(1,TfA_number.getText());
                rs=ps.executeQuery();
            }catch (Exception e){
                e.printStackTrace();
            }
            String aadhar = TfA_number.getText();
            try{if (rs.next()){
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("update employee set WorkingStatus=? where Aadhar=?");
                ps.setString(1, "Not Working");
                ps.setString(2, aadhar);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
                Tfname.setText("");
                TfF_name.setText("");
                TfM_name.setText("");
                TfA_number.setText("");
                TfMobile_number.setText("");
                TfAdd.setText("");
                TfDesignation.setText("");
                status.setText("");

                TfA_number.setEditable(true);
            }else {
                JOptionPane.showMessageDialog(null,"Incorrect aadhar number entered");
            }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else if(ae.getSource()==b4)
        {
            Tfname.setText("");
            TfF_name.setText("");
            TfM_name.setText("");
            TfA_number.setText("");
            TfMobile_number.setText("");
            TfAdd.setText("");
            TfDesignation.setText("");
            status.setText("");
            TfA_number.setEditable(true);
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
                JOptionPane.showMessageDialog(null,"Cannot Exceed 12 Digits");
                ke.consume();
            }//else
        }else if (ke.getSource()==TfMobile_number){
            int l=(TfMobile_number.getText().length());
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
                JOptionPane.showMessageDialog(null,"Cannot Exceed 10 Digits");
                ke.consume();
            }
        } else if (ke.getSource()==status) {
                char c=ke.getKeyChar();
                if((c>='0'&& c<='9'))
                {
                }//if
                else
                {
                    ke.consume();
                }//else
        } else if (ke.getSource()==TfF_name) {
            int l = (TfF_name.getText().length());
            if (l <= 40) {
                char c = ke.getKeyChar();
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')|| c==' ') {
                }//if
                else {
                    ke.consume();
                }//else
            }//if
            else {
                JOptionPane.showMessageDialog(null, "Cannot add more than 40 Characters");
                ke.consume();
            }//else
        }else if (ke.getSource()==TfM_name) {
            int l = (TfM_name.getText().length());
            if (l <= 40) {
                char c = ke.getKeyChar();
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')|| c==' ') {
                }//if
                else {
                    ke.consume();
                }//else
            }//if
            else {
                JOptionPane.showMessageDialog(null, "Cannot add more than 40 Characters");
                ke.consume();
            }//else
        }else if (ke.getSource()==Tfname) {
            int l = (Tfname.getText().length());
            if (l <= 40) {
                char c = ke.getKeyChar();
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')|| c==' ') {
                }//if
                else {
                    ke.consume();
                }//else
            }//if
            else {
                JOptionPane.showMessageDialog(null, "Cannot add more than 40 Characters");
                ke.consume();
            }//else
        }
    }//key typed
}


