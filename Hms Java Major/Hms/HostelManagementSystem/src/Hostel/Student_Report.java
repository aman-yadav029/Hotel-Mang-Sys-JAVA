package Hostel;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Student_Report implements ActionListener,KeyListener {
    JFrame f1;
    JLabel headtext, Block, AdharNo,image;
    JTextField TfAdharNo;
    Choice Block_Combo;
    JButton search;
    JTable tabledata;
    Font ft1, ft2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Student_Report() {
        f1 = new JFrame("Student Report");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        f1.setSize(930, 600);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.pink);
        tabledata = new JTable();
        headtext = new JLabel("Student Report");
        headtext.setFont(new Font("", Font.BOLD, 30));
        headtext.setBounds(300, 10, 500, 50);
        ft1 = new Font("Monospaced", Font.BOLD, 20);
        ft2 = new Font("Monospaced", Font.BOLD, 17);
        Block = new JLabel("Block");
        Block.setFont(ft1);
        Block.setBounds(50, 80, 200, 30);
        Block_Combo = new Choice();
        Block_Combo.add("<None>");
        Block_Combo.add("A");
        Block_Combo.add("B");
        Block_Combo.setFont(ft2);
        Block_Combo.setBounds(300, 80, 200, 30);
        AdharNo = new JLabel("Aadhar Number");
        AdharNo.setFont(ft1);
        AdharNo.setBounds(50, 120, 250, 30);
        TfAdharNo = new JTextField("");
        TfAdharNo.setFont(ft2);
        TfAdharNo.setBounds(302, 120, 200, 30);
        TfAdharNo.addKeyListener(this);
        search = new JButton("Search");
        search.setFont(ft1);
        search.addActionListener(this);
        search.setBounds(620, 100, 200, 30);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/10.jpg"));
        Image i2=i1.getImage().getScaledInstance(930,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,930,600);
        f1.add(image);
        TfAdharNo.setOpaque(false);
        TfAdharNo.setBorder(border);
        image.add(headtext);
        image.add(Block);
        image.add(Block_Combo);
        image.add(AdharNo);
        image.add(TfAdharNo);
        image.add(search);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String bl = Block_Combo.getSelectedItem();
            String aadhar = TfAdharNo.getText();
            if (aadhar.isEmpty() && bl=="<None>")
            {
                JOptionPane.showMessageDialog(null,"Please select a Method for Search");
            }
            else if (aadhar.isEmpty() && bl!="<None>") {
                try {
                    con = DBConnection.createDBConnection();
                    ps = con.prepareStatement("select * from student_rent where Block=?");
                    ps.setString(1, bl);
                    rs = ps.executeQuery();
                    tabledata.setModel(DbUtils.resultSetToTableModel(rs));
                    JScrollPane scroolpane1 = new JScrollPane(tabledata);
                    scroolpane1.setBounds(0,450,927,122);
                    scroolpane1.setVisible(true);
                    scroolpane1.setEnabled(false);
                    scroolpane1.setOpaque(true);
                    scroolpane1.setBackground(Color.WHITE);
                    f1.add(scroolpane1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (!aadhar.isEmpty() && bl=="<None>") {
                try {

                    con = DBConnection.createDBConnection();
                    ps = con.prepareStatement("select * from student_rent where Aadharnumber=?");
                    ps.setString(1, aadhar);
                    rs = ps.executeQuery();
                    tabledata.setModel(DbUtils.resultSetToTableModel(rs));
                    JScrollPane scroolpane1 = new JScrollPane(tabledata);
                    scroolpane1.setBounds(0,450,927,122);
                    scroolpane1.setVisible(true);
                    scroolpane1.setEnabled(false);
                    scroolpane1.setOpaque(true);
                    scroolpane1.setBackground(Color.WHITE);
                    f1.add(scroolpane1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    con = DBConnection.createDBConnection();
                    ps = con.prepareStatement("select * from student_rent where Aadharnumber=? and Block=?");
                    ps.setString(1, aadhar);
                    ps.setString(2, bl);
                    rs = ps.executeQuery();
                    tabledata.setModel(DbUtils.resultSetToTableModel(rs));
                    JScrollPane scroolpane1 = new JScrollPane(tabledata);
                    scroolpane1.setBounds(0,450,927,122);
                    scroolpane1.setVisible(true);
                    scroolpane1.setEnabled(false);
                    scroolpane1.setOpaque(true);
                    scroolpane1.setBackground(Color.WHITE);
                    f1.add(scroolpane1);
                } catch (Exception e) {
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
        if(ke.getSource()==TfAdharNo)
        {
            int l=(TfAdharNo.getText().length());
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
