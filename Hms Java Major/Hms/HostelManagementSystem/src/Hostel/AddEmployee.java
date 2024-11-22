package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
public class AddEmployee implements ActionListener,KeyListener {
    JFrame f1;String date;
    JLabel Block, name, F_name, M_name, Par_add, A_number,Mobile_number, Designation,Salary;
    JTextField Tfname, TfF_name, TfM_name, TfAdd, TfA_number, TfMobile_number,Tf_Sal,Designation_Combo;
    JComboBox Block_Combo;
    JButton b1, b2;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps;
    public AddEmployee() {
        date = LocalDate.now().getMonth().toString();
        f1 = new JFrame(" Add New Employee ");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        Block = new JLabel("Block");
        name = new JLabel("Name");
        String value[] = {"A", "B"};
        Block_Combo = new JComboBox(value);
        Block_Combo.setFont(ft2);
        F_name = new JLabel("Father's Name");
        M_name = new JLabel("Mother's Name");
        Mobile_number = new JLabel("Mobile Number");
        Par_add = new JLabel("Address");
        A_number = new JLabel("Aadhar Number");
        Designation=new JLabel("Designation");
        Salary=new JLabel("Salary");
        Tfname = new JTextField();
        TfF_name = new JTextField("");
        TfM_name = new JTextField("");
        TfMobile_number = new JTextField("");
        TfAdd = new JTextField("");
        TfA_number = new JTextField("");
        Tfname.setOpaque(false);
        TfAdd.setOpaque(false);
        TfA_number.setOpaque(false);
        TfF_name.setOpaque(false);
        TfM_name.setOpaque(false);
        TfMobile_number.setOpaque(false);
        Tfname.setBorder(border);
        TfAdd.setBorder(border);
        TfA_number.setBorder(border);
        TfF_name.setBorder(border);
        TfM_name.setBorder(border);
        TfMobile_number.setBorder(border);
        Designation_Combo=new JTextField();
        Designation_Combo.setFont(ft2);
        String value3[]={"Working","Not Working"};
        Tf_Sal=new JTextField();
        Tf_Sal.setOpaque(false);
        Tf_Sal.setBorder(border);
        b1 = new JButton("Add");
        b2 = new JButton("Reset");
        ft1 = new Font("Monospaced", Font.BOLD, 20);
        ft2 = new Font("Monospaced", Font.BOLD, 17);
        Tf_Sal.setFont(ft2);
        f1.setSize(950, 650);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.getContentPane().setBackground(Color.WHITE);
        Block.setBounds(80, 10, 200, 30);
        Block.setFont(ft1);
        Block_Combo.setBounds(310, 10, 200, 30);
        Block_Combo.setFont(ft2);
        name.setBounds(80, 70, 200, 30);
        name.setFont(ft1);
        Tfname.setBounds(310, 70, 200, 30);
        Tfname.setFont(ft2);
        Tfname.addKeyListener(this);
        F_name.setBounds(80, 130, 200, 30);
        F_name.setFont(ft1);
        TfF_name.setBounds(310, 130, 200, 30);
        TfF_name.setFont(ft2);
        TfF_name.addKeyListener(this);
        M_name.setBounds(80, 190, 200, 30);
        M_name.setFont(ft1);
        TfM_name.setBounds(310, 190, 200, 30);
        TfM_name.setFont(ft2);
        TfM_name.addKeyListener(this);
        Mobile_number.setBounds(80, 250, 200, 30);
        Mobile_number.setFont(ft1);
        TfMobile_number.setBounds(310, 250, 200, 30);
        TfMobile_number.setFont(ft2);
        TfMobile_number.addKeyListener(this);
        Par_add.setBounds(80, 310, 200, 30);
        Par_add.setFont(ft1);
        TfAdd.setBounds(310, 310, 200, 30);
        TfAdd.setFont(ft2);
        A_number.setBounds(80, 370, 200, 30);
        A_number.setFont(ft1);
        TfA_number.setBounds(310, 370, 200, 30);
        TfA_number.setFont(ft2);
        TfA_number.addKeyListener(this);
        Designation.setBounds(80, 430, 200, 30);
        Designation.setFont(ft1);
        Designation_Combo.setBounds(310, 430, 200, 30);
        Designation_Combo.setFont(ft1);
        Salary.setBounds(80, 490, 200, 30);
        Tf_Sal.setBounds(310, 490, 200, 30);
        Salary.setFont(ft1);
        b1.setBounds(100, 550, 150, 30);
        b2.setBounds(300, 550, 150, 30);
        b1.setFont(ft1);
        b2.setFont(ft1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/7.jpg"));
        Image i2=i1.getImage().getScaledInstance(950,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        Tf_Sal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'){
                }
                else {
                    e.consume();
                }
            }
        });
        image.setBounds(0,0,950,700);
        Designation_Combo.setBorder(border);
        Designation_Combo.setOpaque(false);
        f1.add(image);
        image.add(Tf_Sal);
        image.add(Salary);
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
        image.add(Designation_Combo);
        image.add(Block_Combo);
        image.add(b1);
        image.add(b2);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String bl = (String) Block_Combo.getSelectedItem();
            String nm = Tfname.getText();
            String fname = TfF_name.getText();
            String Mname = TfM_name.getText();
            String address = TfAdd.getText();
            String Mnumber = TfMobile_number.getText();
            String aadhar = TfA_number.getText();
            String desig = (String) Designation_Combo.getText();
            String workingStatus = "Working";
            String Month=date;
            if (bl.trim().isEmpty() || nm.trim().isEmpty() || fname.trim().isEmpty() || Mname.trim().isEmpty() || Mnumber.trim().isEmpty() || aadhar.trim().isEmpty() || desig.trim().isEmpty() || workingStatus.trim().isEmpty() || Month.trim().isEmpty()||Tf_Sal.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "All the Textfields are Mandatory");
            } else if (Mnumber.length()<10) {
                JOptionPane.showMessageDialog(null,"Phone no. cannot be less than 10 digits");
            } else if (aadhar.length()<12) {
                JOptionPane.showMessageDialog(null,"Aadhar cannot be less than 12 digits");
            }else {
                try {
                    con = DBConnection.createDBConnection();
                    PreparedStatement p1= con.prepareStatement("select * from employee where Aadhar=?");
                    p1.setString(1,aadhar);
                    ResultSet rs = p1.executeQuery();
                    if(!rs.next()) {
                        ps = con.prepareStatement("insert into employee(Block,Name,FName,MName,MobileNo,Aadhar,Address,Designation,WorkingStatus,Month,salary)values(?,?,?,?,?,?,?,?,?,?,?)");
                        ps.setString(1, bl);
                        ps.setString(2, nm);
                        ps.setString(3, fname);
                        ps.setString(4, Mname);
                        ps.setString(5, Mnumber);
                        ps.setString(6, aadhar);
                        ps.setString(7, address);
                        ps.setString(8, desig);
                        ps.setString(9, workingStatus);
                        ps.setString(10, Month);
                        ps.setString(11,Tf_Sal.getText());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, " New Employee Added Successfully");
                        f1.dispose();
                        AddEmployee hp = new AddEmployee();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Employee already exists \n(check Aadhar no.)");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }   else if (ae.getSource() == b2) {
            Tfname.setText("");
            TfF_name.setText("");
            TfM_name.setText("");
            TfAdd.setText("");
            TfMobile_number.setText("");
            TfA_number.setText("");
            Tf_Sal.setText("");
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
        if(ke.getSource()==Tfname)
        {
            int l=(Tfname.getText().length());
            if(l<=40)
            {
                char c=ke.getKeyChar();
                if((c>='a'&&c<='z')||(c>='A'&&c<='Z')|| c==' ')
                {
                }//if
                else
                {
                    ke.consume();
                }//else
            }//if
            else
            {
                JOptionPane.showMessageDialog(null,"Cannot add more than 40 Characters");
                ke.consume();
            }//else
        }//if
        else if(ke.getSource()==TfF_name)
        {
            int l=(TfF_name.getText().length());
            if(l<=40)
            {
                char c=ke.getKeyChar();
                if((c>='a'&&c<='z')||(c>='A'&&c<='Z')|| c==' ')
                {
                }//if
                else
                {
                    ke.consume();
                }//else
            }//if
            else
            {
                JOptionPane.showMessageDialog(null,"Cannot add more than 40 Characters");
                ke.consume();
            }//else
        }
        else if(ke.getSource()==TfM_name)
        {
            int l=(TfM_name.getText().length());
            if(l<=40)
            {
                char c=ke.getKeyChar();
                if((c>='a'&&c<='z')||(c>='A'&&c<='Z')|| c==' ')
                {
                }//if
                else
                {
                    ke.consume();
                }//else
            }//if
            else
            {
                JOptionPane.showMessageDialog(null,"Cannot add more than 40 Characters");
                ke.consume();
            }//else
        }
        else if(ke.getSource()==TfMobile_number)
        {
            int l=(TfMobile_number.getText().length());
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
        else if(ke.getSource()==TfA_number)
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
                JOptionPane.showMessageDialog(null,"Cannot add more than 12 Digits");
                ke.consume();
            }//else
        }
    }//key typed
}


