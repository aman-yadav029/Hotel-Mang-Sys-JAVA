package Hostel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Add_Room implements ActionListener,KeyListener {
    JFrame f1;
    JLabel head,Block,Room_No,Price,Total_Beds;
    JTextField Tfroom ,TfPrice,NoB;
    Font ft1,ft2;
    JComboBox Block_Combo;
    JButton btn1,btn2;
    Connection con;
    PreparedStatement ps;
    public Add_Room()
    {
        f1=new JFrame("Add Room");
        Border border = new MatteBorder(new Insets(0,0,1,0),Color.BLACK);
        f1.setSize(550, 550);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);
        f1.setResizable(false);
        ft1 = new Font("Monospaced", Font.BOLD, 20);
        ft2 = new Font("Monospaced", Font.BOLD, 18);
        head=new JLabel("Add Rooms");
        head.setBounds(175,20,370,50);
        head.setFont(new Font("Monospaced", Font.BOLD, 30));
        Block=new JLabel("Block");
        Block.setFont(ft1);
        String Block_Values[]={"A","B"};
        Block_Combo=new JComboBox(Block_Values);
        Block_Combo.setBackground(Color.WHITE);
        Block_Combo.setToolTipText("A for Boys B for Girls");
        Block.setBounds(50,95,200, 30);
        Block_Combo.setBounds(270,95,200,30);
        Block_Combo.setFont(ft2);
        Room_No=new JLabel("Room Number");
        Room_No.setFont(ft1);
        Tfroom=new JTextField();
        Tfroom.setFont(ft2);
        Tfroom.addKeyListener(this);
        String Avialable_Values[]={"Avialable","Occupied"};
        String cleaning_Values[]={"Cleaned","Dirty"};
        Price=new JLabel("Price/Head");
        Price.setFont(ft1);
        TfPrice=new JTextField();
        TfPrice.setFont(ft2);
        TfPrice.setBorder(border);
        TfPrice.addKeyListener(this);
        Total_Beds=new JLabel("Number of Beds");
        Total_Beds.setFont(ft1);
        String Bed_Numbers[]={"1","2","3","4"};
        NoB=new JTextField();
        NoB.setFont(ft2);
        NoB.setOpaque(false);
        NoB.setBorder(border);
        NoB.addKeyListener(this);
        btn1=new JButton("Add");
        btn1.setFont(ft1);
        btn1.addActionListener((this));
        btn2=new JButton("Back");
        btn2.setFont(ft1);
        btn2.addActionListener((this));
        Room_No.setBounds(50,160,200,30);
        Tfroom.setBounds(275,160,200,30);
        Price.setBounds(50,235,200,30);
        TfPrice.setBounds(275,235,200,30);
        Total_Beds.setBounds(50,305,200,30);
        NoB.setBounds(275,305,200,30);
        btn1.setBounds(50,375,200,30);
        btn2.setBounds(270,375,200,30);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/6.jpg"));
        Image i2=i1.getImage().getScaledInstance(550,550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,550,550);
        f1.add(image);
        TfPrice.setOpaque(false);
        Tfroom.setOpaque(false);
        Tfroom.setBorder(border);
        TfPrice.setBorder(border);
        image.add(NoB);
        image.add(Block);
        image.add(Block_Combo);
        image.add(head);
        image.add(Room_No);
        image.add(Tfroom);
        image.add(Price);
        image.add(TfPrice);
        image.add(Total_Beds);
        image.add(btn1);
        image.add(btn2);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn1) {
            if (Tfroom.getText().isEmpty()||TfPrice.getText().isEmpty()||NoB.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "All the Textfields are Mandatory");
            }else {
            int room_no = Integer.parseInt(Tfroom.getText());
            String avail = "Available";
            String Cleaning = "Cleaned";
            int price = Integer.parseInt(TfPrice.getText());
            int totalBeds = Integer.parseInt(NoB.getText());
            String block = Block_Combo.getSelectedItem().toString();
            if (room_no==0|| price==0 || totalBeds==0) {
                JOptionPane.showMessageDialog(null, "Values cannot be zero");
            } else {
                try {
                        con = DBConnection.createDBConnection();
                        ps =con.prepareStatement("select * from room where room_no=? and Block=?");
                        ps.setString(1,Tfroom.getText());
                        ps.setString(2,block);
                        ResultSet rs = ps.executeQuery();
                        if(!rs.next())
                            {
                                ps = con.prepareStatement("insert into Room(Room_No,Availability,Cleaning_Status,price,TotalBeds,Block) values (?,?,?,?,?,?)");
                                ps.setString(1, Tfroom.getText());
                                ps.setString(2, avail);
                                ps.setString(3, Cleaning);
                                ps.setString(4, TfPrice.getText());
                                ps.setString(5, NoB.getText());
                                ps.setString(6, block);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, " New Room Added Successfully");
                                Add_Room room=new Add_Room();
                                f1.dispose();
                            }
                        else {
                            JOptionPane.showMessageDialog(null,"Room no. Already Exists...");
                        }}
                 catch(Exception e){
                        e.printStackTrace();
                    }} }}
        else if(ae.getSource()==btn2)
        {
            f1.dispose();
        }}

    public void keyPressed(KeyEvent ke)
    {
    }//key pressed
    public void keyReleased(KeyEvent ke)
    {
    }//key released
    public void keyTyped(KeyEvent ke)
    {
        if(ke.getSource()==Tfroom || ke.getSource()==TfPrice||ke.getSource()==NoB)
        {
            char c=ke.getKeyChar();
            if(c>='0'&&c<='9'){}
                else
                {
                    ke.consume();
                }//else

        }//if
    }//key typed

}


