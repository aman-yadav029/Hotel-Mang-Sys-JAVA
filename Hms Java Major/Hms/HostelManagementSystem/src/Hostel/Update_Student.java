package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Update_Student implements ActionListener, KeyListener {
    JFrame f1;int rent;String ren;
    JLabel Block, Living_Sta,name, F_name, M_name, Par_add, College_name, A_number, Room_number, Mobile_number,image;
    JTextField Tfname, TfF_name,TfRoom,TfM_name, TfAdd, TfColl_name, TfA_number, TfMobile_number,status;
    JComboBox Block_Combo;
    JButton b1,b2,b3,b4;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Update_Student() {
        f1 = new JFrame("Update Student Details ");
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
        College_name = new JLabel("College Name");
        A_number = new JLabel("Aadhar Number");
        Room_number = new JLabel("Room Number");
        Living_Sta = new JLabel("Rent");
        Tfname = new JTextField("");
        TfF_name = new JTextField("");
        TfM_name = new JTextField("");
        TfMobile_number = new JTextField("");
        TfAdd = new JTextField("");
        TfColl_name = new JTextField("");
        TfA_number = new JTextField("");
        TfA_number.addKeyListener(this);
        TfRoom = new JTextField("");
        status = new JTextField("");
        b1 = new JButton("Update");
        b2 = new JButton("Delete");
        b3 = new JButton("clear");
        b4 = new JButton("Check");
        ft1 = new Font("Monospaced", Font.BOLD, 20);
        ft2 = new Font("Monospaced", Font.BOLD, 17);
        status.setFont(ft2);
        f1.setSize(800, 700);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.WHITE);
        Block.setBounds(80, 30, 200, 30);
        Block.setFont(ft1);
        Block_Combo.setBounds(310, 30, 200, 30);
        Block_Combo.setFont(ft2);
        b4.setBounds(550, 30, 180, 30);
        A_number.setBounds(80, 90, 200, 30);
        A_number.setFont(ft1);
        TfA_number.setBounds(310, 90, 200, 30);
        TfA_number.setFont(ft2);
        name.setBounds(80, 150, 200, 30);
        name.setFont(ft1);
        Tfname.setBounds(310, 150, 200, 30);
        Tfname.setFont(ft2);
        F_name.setBounds(80, 210, 200, 30);
        F_name.setFont(ft1);
        TfF_name.setBounds(310, 210, 200, 30);
        TfF_name.setFont(ft2);
        M_name.setBounds(80, 270, 200, 30);
        M_name.setFont(ft1);
        TfM_name.setBounds(310, 270, 200, 30);
        TfM_name.setFont(ft2);
        Mobile_number.setBounds(80, 330, 200, 30);
        Mobile_number.setFont(ft1);
        TfMobile_number.setBounds(310, 330, 200, 30);
        TfMobile_number.setFont(ft2);
        Par_add.setBounds(80, 390, 200, 30);
        Par_add.setFont(ft1);
        TfAdd.setBounds(310, 390, 200, 30);
        TfAdd.setFont(ft2);
        College_name.setBounds(80, 450, 200, 30);
        College_name.setFont(ft1);
        TfColl_name.setBounds(310, 450, 200, 30);
        TfColl_name.setFont(ft1);
        Room_number.setBounds(80, 510, 200, 30);
        Room_number.setFont(ft1);
        TfRoom.setBounds(310, 510, 200, 30);
        TfRoom.setFont(ft2);
        Living_Sta.setBounds(80, 570, 200, 30);
        Living_Sta.setFont(ft1);
        status.setBounds(310, 570, 200, 30);
        b1.setBounds(80, 620, 150, 25);
        b2.setBounds(260, 620, 150, 25);
        b3.setBounds(440, 620, 150, 25);
        b1.setFont(ft1);
        b2.setFont(ft1);
        b3.setFont(ft1);
        b4.setFont(ft1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/12.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,800,700);
        Tfname.setOpaque(false);
        TfMobile_number.setOpaque(false);
        TfM_name.setOpaque(false);
        TfF_name.setOpaque(false);
        TfRoom.setOpaque(false);
        TfA_number.setOpaque(false);
        TfAdd.setOpaque(false);
        TfColl_name.setOpaque(false);
        TfColl_name.setBorder(border);
        Tfname.setBorder(border);
        TfMobile_number.setBorder(border);
        TfM_name.setBorder(border);
        TfF_name.setBorder(border);
        TfRoom.setBorder(border);
        TfA_number.setBorder(border);
        TfAdd.setBorder(border);
        status.setOpaque(false);
        status.setBorder(border);
        status.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'){
                }else {
                    e.consume();
                }
            }
        });
        f1.add(image);
        image.add(name);
        image.add(F_name);
        image.add(M_name);
        image.add(Mobile_number);
        image.add(Par_add);
        image.add(College_name);
        image.add(A_number);
        image.add(Room_number);
        image.add(Block);
        image.add(Tfname);
        image.add(TfF_name);
        image.add(TfM_name);
        image.add(TfMobile_number);
        image.add(TfAdd);
        image.add(TfColl_name);
        image.add(TfA_number);
        image.add(TfRoom);
        image.add(Block_Combo);
        image.add(Living_Sta);
        image.add(status);
        image.add(b1);
        image.add(b2);
        image.add(b3);
        image.add(b4);TfMobile_number.addKeyListener(this); Tfname.addKeyListener(this);TfM_name.addKeyListener(this);TfF_name.addKeyListener(this);TfColl_name.addKeyListener(this);



        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b4) {if (!TfA_number.getText().isEmpty()){
            String bl = Block_Combo.getSelectedItem().toString();
            String aadhar = TfA_number.getText();
            try {
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("select * from student where Aadhar=? and Block=? and LivingStatus=?" );
                ps.setString(1, aadhar);
                ps.setString(2, bl);
                ps.setString(3,"Living");
                rs = ps.executeQuery();
                if(rs.next()) {
                    TfA_number.setEditable(false);
                    Tfname.setText(rs.getString("Name"));
                    TfF_name.setText(rs.getString("Fname"));
                    TfM_name.setText(rs.getString("Mname"));
                    TfMobile_number.setText(rs.getString("MobileNo"));
                    TfAdd.setText(rs.getString("Address"));
                    TfColl_name.setText(rs.getString("CollegeName"));
                    TfRoom.setText(rs.getString("RoomNumber"));
                    status.setText(rs.getString("rent"));
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Student does not Exist");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }}else {
            JOptionPane.showMessageDialog(null,"Please Enter aadhar no. first");
        }
        }
        else if (ae.getSource() == b1) {
            if (TfA_number.getText().isEmpty()||status.getText().isEmpty()||TfRoom.getText().isEmpty()||TfColl_name.getText().isEmpty()||Tfname.getText().isEmpty()||TfF_name.getText().isEmpty()||TfM_name.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"All Fields are mandatory");
        }else {
            String nm = Tfname.getText();
            String fname = TfF_name.getText();
            String Mname = TfM_name.getText();
            String address = TfAdd.getText();
            String clname = TfColl_name.getText();
            String Mnumber = TfMobile_number.getText();
            String aadhar = TfA_number.getText();
             ren =status.getText();
                try {
                    con = DBConnection.createDBConnection();
                    ps = con.prepareStatement("select * from student where aadhar=?");
                    ps.setString(1,aadhar);
                    rs = ps.executeQuery();
                    if (rs.next()){
                        ps = con.prepareStatement("select price from room where room_no=? and block=?");
                        ps.setString(1,TfRoom.getText() );
                        ps.setString(2, Block_Combo.getSelectedItem().toString());
                        rs =ps.executeQuery();
                        if (rs.next()){
                            rent = Integer.parseInt(rs.getString("price"));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (rent>=Integer.parseInt(ren)){
                    try {
                        con = DBConnection.createDBConnection();

                        ps = con.prepareStatement("update student set Name=?,Fname=?,Mname=?,MobileNo=?,Address=?,CollegeName=?,rent=? where Aadhar=?");
                        ps.setString(1, nm);
                        ps.setString(2, fname);
                        ps.setString(3, Mname);
                        ps.setString(4, Mnumber);
                        ps.setString(5, address);
                        ps.setString(6, clname);
                        ps.setString(7, aadhar);
                        ps.setString(8,status.getText());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Student Detail Updated Successfully");
                        Tfname.setText("");
                        TfF_name.setText("");
                        TfM_name.setText("");
                        TfA_number.setText("");
                        TfMobile_number.setText("");
                        TfColl_name.setText("");
                        TfAdd.setText("");
                        TfRoom.setText("");
                        status.setText("");
                        TfA_number.setEditable(true);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,e);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Rent cannot exceed Scheduled limit");
                }

        }

        }
        else if(ae.getSource()==b2)
        {
            int Totalbed=0;
            String bl = (String) Block_Combo.getSelectedItem();
            String aadhar = TfA_number.getText();
            String room = TfRoom.getText();
            try{
                con = DBConnection.createDBConnection();
                ps = con.prepareStatement("update student set LivingStatus=? where Aadhar=?");
                ps.setString(1,"Leaved");
                ps.setString(2, aadhar);
                ps.executeUpdate();
                ps = con.prepareStatement("select TotalBeds from room where Block=? and Room_No=?");
                ps.setString(1, bl);
                ps.setString(2, room);
                rs=ps.executeQuery();
                if(rs.next())
                {
                    Totalbed=Integer.parseInt(rs.getString("TotalBeds"));
                    Totalbed++;
                }

                ps = con.prepareStatement("update room set TotalBeds=? where Block=? and Room_No=?");
                ps.setInt(1, Totalbed);
                ps.setString(2, bl);
                ps.setString(3, room);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Student Details Deleted Successfully");
                Tfname.setText("");
                TfF_name.setText("");
                TfM_name.setText("");
                TfA_number.setText("");
                TfMobile_number.setText("");
                TfColl_name.setText("");
                TfAdd.setText("");
                TfRoom.setText("");
                status.setText("");
                TfA_number.setEditable(true);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else if(ae.getSource()==b3)
        {
            Tfname.setText("");
            TfF_name.setText("");
            TfM_name.setText("");
            TfA_number.setText("");
            TfMobile_number.setText("");
            TfColl_name.setText("");
            TfAdd.setText("");
            TfRoom.setText("");
            status.setText("");
            TfA_number.setEditable(true);
            Block_Combo.setEnabled(true);
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
                JOptionPane.showMessageDialog(null,"Cannot add more than 12 Digits");
                ke.consume();
            }//else

        } else if (ke.getSource()==TfColl_name||ke.getSource()==Tfname||ke.getSource()==TfF_name||ke.getSource()==TfM_name) {
            char c=ke.getKeyChar();
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')|| c==' ')
            {
            }//if
            else
            {
                ke.consume();
            }
        } else if (ke.getSource()==TfMobile_number) {
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
                ke.consume();
                JOptionPane.showMessageDialog(null,"Cannot add more than 10 Digits");

            }
        } else if (ke.getSource()==TfRoom) {
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



