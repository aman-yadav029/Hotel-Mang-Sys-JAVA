package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;

public class AddStudent implements ActionListener, ItemListener,KeyListener {
    JFrame f1;String date;int rent;
    JLabel Gender, Block, Living, name, F_name, M_name, Par_add, College_name, A_number, Room_number, Mobile_number, Rent;
    JTextField TfBlock, Tfname, TfF_name, TfM_name, TfAdd, TfColl_name, TfA_number, TfMobile_number,Tfrent;
    Choice Room_Choice;
    JRadioButton Gender_Radio1, Gender_Radio2;
    ButtonGroup bg;
    JButton b1, b2;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps,p1;
    ResultSet rs;
    public AddStudent() {
        f1 = new JFrame(" Add New Student ");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        Gender = new JLabel("Gender");
        Gender_Radio1 = new JRadioButton("Male");
        Gender_Radio2 = new JRadioButton("Female");
        bg = new ButtonGroup();
        bg.add(Gender_Radio1);
        bg.add(Gender_Radio2);
        Block = new JLabel("Block");
        TfBlock = new JTextField("");
        name = new JLabel("Name");
        F_name = new JLabel("Father's Name");
        M_name = new JLabel("Mother's Name");
        Mobile_number = new JLabel("Mobile Number");
        Par_add = new JLabel("Address");
        College_name = new JLabel("College Name");
        A_number = new JLabel("Aadhar Number");
        Room_number = new JLabel("Room Number");
        Living = new JLabel("Living Status");
        Rent= new JLabel("Rent");
        Tfname = new JTextField();
        Tfname.addKeyListener(this);
        TfF_name = new JTextField("");
        TfF_name.addKeyListener(this);
        TfM_name = new JTextField("");
        TfM_name.addKeyListener(this);
        TfMobile_number = new JTextField("");
        TfMobile_number.addKeyListener(this);
        TfAdd = new JTextField("");
        TfColl_name = new JTextField();
        TfColl_name.addKeyListener(this);
        TfA_number = new JTextField("");
        TfA_number.addKeyListener(this);
        String value2[] = {"Living", "Leaved"};
        b1 = new JButton("Add");
        b2 = new JButton("Reset");
        ft1 = new Font("Monospaced", Font.BOLD, 19);
        ft2 = new Font("Monospaced", Font.BOLD, 17);
        f1.setSize(950, 740);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.getContentPane().setBackground(Color.WHITE);
        Gender.setBounds(80, 10, 200, 30);
        Gender.setFont(ft1);
        Gender_Radio1.setBounds(310, 10, 90, 30);
        Gender_Radio1.setFont(ft2);
        Gender_Radio1.addActionListener(this);
        Gender_Radio1.setOpaque(false);
        Gender_Radio2.setBounds(400, 10, 100, 30);
        Gender_Radio2.setFont(ft2);
        Gender_Radio2.setOpaque(false);
        Gender_Radio2.addActionListener(this);
        Tfrent = new JTextField("");
        Tfrent.addKeyListener(this);
        Tfrent.setBorder(border);
        Tfrent.setOpaque(false);
        Tfrent.setFont(ft2);
        Block.setBounds(80, 70, 200, 30);
        Block.setFont(ft1);
        TfBlock.setBounds(310, 70, 200, 30);
        TfBlock.setFont(ft2);
        name.setBounds(80, 120, 200, 30);
        name.setFont(ft1);
        Tfname.setBounds(310, 120, 200, 30);
        Tfname.setFont(ft2);
        F_name.setBounds(80, 170, 200, 30);
        F_name.setFont(ft1);
        TfF_name.setBounds(310, 170, 200, 30);
        TfF_name.setFont(ft2);
        M_name.setBounds(80, 220, 200, 30);
        M_name.setFont(ft1);
        TfM_name.setBounds(310, 220, 200, 30);
        TfM_name.setFont(ft2);
        Mobile_number.setBounds(80, 270, 200, 30);
        Mobile_number.setFont(ft1);
        TfMobile_number.setBounds(310, 270, 200, 30);
        TfMobile_number.setFont(ft2);
        Par_add.setBounds(80, 320, 200, 30);
        Par_add.setFont(ft1);
        TfAdd.setBounds(310, 320, 200, 30);
        TfAdd.setFont(ft2);
        College_name.setBounds(80, 370, 200, 30);
        College_name.setFont(ft1);
        TfColl_name.setBounds(310, 370, 200, 30);
        TfColl_name.setFont(ft1);
        A_number.setBounds(80, 420, 200, 30);
        A_number.setFont(ft1);
        Room_Choice = new Choice();
        TfA_number.setBounds(310, 420, 200, 30);
        TfA_number.setFont(ft2);
        Room_number.setBounds(80, 470, 200, 30);
        Room_number.setFont(ft1);
        Room_Choice.setBounds(310, 470, 200, 30);
        Room_Choice.setFont(ft2);
        Tfrent.setBounds(310,520,200,30);
        Rent.setBounds(80, 520, 200, 30);
        Rent.setFont(ft1);
        b1.setBounds(100, 630, 150, 30);
        b2.setBounds(270, 630, 150, 30);
        b1.setFont(ft1);
        b2.setFont(ft1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        Room_Choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(!(Room_Choice.getSelectedItem()=="<None>")){
                    try{
                        con = DBConnection.createDBConnection();
                        ps= con.prepareStatement("select price from room where room_no=? and block=?");
                        ps.setString(1,Room_Choice.getSelectedItem());
                        ps.setString(2,TfBlock.getText());
                        rs = ps.executeQuery();
                        rs.next();
                        Tfrent.setText(rs.getString("price"));
                        rent = Integer.parseInt(Tfrent.getText());
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }else {
                    Tfrent.setText("0");
                }
            }
        });
        Tfrent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'){
                }
                else {
                    e.consume();
                }
            }
        });
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hostel/8.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 740, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 950, 740);
        f1.add(image);
        Tfname.setOpaque(false);
        TfBlock.setOpaque(false);
        TfAdd.setOpaque(false);
        TfColl_name.setOpaque(false);
        TfA_number.setOpaque(false);
        TfF_name.setOpaque(false);
        TfM_name.setOpaque(false);
        TfMobile_number.setOpaque(false);
        Tfname.setBorder(border);
        TfBlock.setBorder(border);
        TfAdd.setBorder(border);
        TfColl_name.setBorder(border);
        TfA_number.setBorder(border);
        TfF_name.setBorder(border);
        TfM_name.setBorder(border);
        TfMobile_number.setBorder(border);
        date = LocalDate.now().getMonth().toString();
        image.add(name);
        image.add(F_name);
        image.add(M_name);
        image.add(Mobile_number);
        image.add(Gender);
        image.add(Par_add);
        image.add(College_name);
        image.add(A_number);
        image.add(Room_number);
        image.add(Block);
        image.add(Tfname);
        image.add(TfF_name);
        image.add(TfM_name);
        image.add(TfMobile_number);
        image.add(Gender_Radio1);
        image.add(Gender_Radio2);
        image.add(TfAdd);
        image.add(TfColl_name);
        image.add(TfA_number);
        image.add(Room_Choice);
        image.add(TfBlock);
        image.add(Living);
        image.add(Rent);
        image.add(b1);
        image.add(b2);
        image.add(Tfrent);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Gender_Radio1) {
            TfBlock.setText("A");
            TfBlock.setEditable(false);
            String b = TfBlock.getText();
            Room_Choice.removeAll();
            if (b.equals("A")) {
                try {
                    con = DBConnection.createDBConnection();
                    ps = con.prepareStatement("select * from room where Block=?");
                    ps.setString(1, b);
                    rs = ps.executeQuery();
                    Room_Choice.addItem("<None>");
                    while (rs.next()) {
                        int val = rs.getInt("TotalBeds");
                        if (val != 0) {
                            Room_Choice.add(rs.getString("Room_No"));//Dynamic adding the value
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == Gender_Radio2) {
            TfBlock.setText("B");
            TfBlock.setEditable(false);
            String b = TfBlock.getText();
            Room_Choice.removeAll();
            if (b.equals("B")) {
                try {
                    con = DBConnection.createDBConnection();
                    ps = con.prepareStatement("select * from room where Block=?");
                    ps.setString(1, b);
                    rs = ps.executeQuery();
                    Room_Choice.addItem("<None>");
                    while (rs.next()) {
                        int val = (int) rs.getInt("TotalBeds");
                        if (val != 0) {
                            Room_Choice.add(rs.getString("Room_No"));//Dynamic adding the value
                        }
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == b1) {
            String bl = TfBlock.getText();
            String nm = Tfname.getText();
            String fname = TfF_name.getText();
            String Mname = TfM_name.getText();
            String address = TfAdd.getText();
            String clname = TfColl_name.getText();
            String Mnumber = TfMobile_number.getText();
            String aadhar = TfA_number.getText();
            String room = Room_Choice.getSelectedItem();
            String liv = "Living";
            String gender;
            if (Gender_Radio1.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            if ((!Gender_Radio1.isSelected()) && (!Gender_Radio2.isSelected()) || room == null || bl.trim().isEmpty() || nm.trim().isEmpty() || fname.trim().isEmpty() || Mname.trim().isEmpty() || Mnumber.trim().isEmpty() || aadhar.trim().isEmpty() || clname.trim().isEmpty() || liv.trim().isEmpty()||Room_Choice.getSelectedItem()=="<None>"||Tfrent.getText().isEmpty()||Integer.parseInt(Tfrent.getText())==0) {
                JOptionPane.showMessageDialog(null, "All the Entries are Mandatory");
            } else if (rent<Integer.parseInt(Tfrent.getText())) {
                JOptionPane.showMessageDialog(null,"Rent cannot be more than Scheduled rent");
            } else if (Mnumber.length()<10) {
                JOptionPane.showMessageDialog(null,"Phone no. cannot be less than 10 digits");
            } else if (aadhar.length()<12) {
                JOptionPane.showMessageDialog(null,"Aadhar cannot be less than 12 digits");
            } else {
                try {
                        PreparedStatement p1 =con.prepareStatement("select Aadhar from student where Aadhar=?");
                        p1.setString(1,aadhar);
                        ResultSet r1 = p1.executeQuery();
                        if (!r1.next()) {
                            ps = con.prepareStatement("select TotalBeds from room where Room_No=?");
                            ps.setString(1, room);
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                int val = rs.getInt("TotalBeds");
                                val--;
                                ps = con.prepareStatement("update room set TotalBeds=? where Room_No=? and Block=?");
                                ps.setInt(1, val);
                                ps.setString(2, room);
                                ps.setString(3, bl);
                                ps.executeUpdate();
                                ps = con.prepareStatement("insert into student (Block,Name,Fname,Mname,MobileNo,Aadhar,Address,CollegeName,RoomNumber,LivingStatus,JoingMonth,Gender,rent)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                ps.setString(1, bl);
                                ps.setString(2, nm);
                                ps.setString(3, fname);
                                ps.setString(4, Mname);
                                ps.setString(5, Mnumber);
                                ps.setString(6, aadhar);
                                ps.setString(7, address);
                                ps.setString(8, clname);
                                ps.setString(9, room);
                                ps.setString(10, liv);
                                ps.setString(11, date);
                                ps.setString(12, gender);
                                ps.setString(13,Tfrent.getText());
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Student Added Successfully");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Student Already Exists\n(check Aadhar no.)");
                        }
                        f1.dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == b2) {
            Tfname.setText("");
            TfF_name.setText("");
            TfM_name.setText("");
            TfAdd.setText("");
            TfColl_name.setText("");
            TfMobile_number.setText("");
            TfA_number.setText("");
        }
    }
    public void itemStateChanged(ItemEvent ae) {
    }

    public void keyPressed(KeyEvent ke) {
    }//key pressed

    public void keyReleased(KeyEvent ke) {
    }//key released

    public void keyTyped(KeyEvent ke) {
        if (ke.getSource() == Tfname) {
            int l = (Tfname.getText().length());
            if (l <= 40) {
                char c = ke.getKeyChar();
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c==' ') {
                }//if
                else {
                    ke.consume();
                }//else
            }//if
            else {
                JOptionPane.showMessageDialog(null, "Cannot add more than 40 Characters");
                ke.consume();
            }//else
        }//if
        else if (ke.getSource() == TfF_name) {
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
        } else if (ke.getSource() == TfM_name) {
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
        } else if (ke.getSource() == TfMobile_number) {
            int l = (TfMobile_number.getText().length());
            if (l < 10) {
                char c = ke.getKeyChar();
                if ((c >= '0' && c <= '9')) {
                }//if
                else {
                    ke.consume();
                }//else
            }//if
            else {
                JOptionPane.showMessageDialog(null, "Cannot add more than 10 Digits");
                ke.consume();
            }//else
        } else if (ke.getSource() == TfColl_name) {
            int l = (TfColl_name.getText().length());
            if (l <= 500) {
                char c = ke.getKeyChar();
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')|| c==' ') {
                }//if
                else {
                    ke.consume();
                }//else
            }//if
            else {
                JOptionPane.showMessageDialog(null, "Cannot add more than 500 Characters");
                ke.consume();
            }//else
        } else if (ke.getSource() == TfA_number) {
            int l = (TfA_number.getText().length());
            if (l <= 11) {
                char c = ke.getKeyChar();
                if ((c >= '0' && c <= '9')) {
                }//if
                else {
                    ke.consume();
                }//else
            }//if
            else {
                JOptionPane.showMessageDialog(null, "Cannot add more than 12 Digits");
                ke.consume();
            }//else
        }
    }//key typed
}


