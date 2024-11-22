package Hostel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    public class HomePage implements ActionListener {
        JFrame f1;
        JPanel room,student,employee,report,userp;
        JButton Man_Room,Upt_Room,New_Stu,Upt_Stu,Stu_Liv,Leaved_Stu,Stu_Fees,New_Emp,Upt_Emp,Emp_Pay,Working_Emp,Leaved_Emp,Rep,Logout,user,RepE,Del;
        public HomePage() {
//            -----------------------------------------update student rent-------------------------------------------------------
            f1 = new JFrame("Home_Page");
            f1.setSize(1200, 720);
            f1.setResizable(false);
            f1.setLocationRelativeTo(null);
            f1.setLayout(null);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Font ft1 = new Font("Monospaced", Font.BOLD, 18);
            Man_Room=new JButton("Add Room");
            Man_Room.setFont(ft1);
            Man_Room.addActionListener(this);
            Upt_Room=new JButton("Update Room");
            Upt_Room.setFont(ft1);
            Upt_Room.addActionListener(this);
            New_Stu=new JButton("Add New Student");
            New_Stu.setFont(ft1);
            New_Stu.addActionListener(this);
            Upt_Stu=new JButton("Update Student");
            Upt_Stu.setFont(ft1);
            Upt_Stu.addActionListener(this);
            Stu_Liv=new JButton("Student");
            Stu_Liv.setFont(ft1);
            Stu_Liv.addActionListener(this);
            Leaved_Stu=new JButton("Ex-Students");
            Leaved_Stu.setFont(ft1);
            Leaved_Stu.addActionListener(this);
            Stu_Fees=new JButton("Student Fees");
            Stu_Fees.setFont(ft1);
            Stu_Fees.addActionListener(this);
            New_Emp=new JButton("Add New Employee");
            New_Emp.setFont(ft1);
            New_Emp.addActionListener(this);
            Upt_Emp=new JButton("Update Employee");
            Upt_Emp.setFont(ft1);
            Upt_Emp.addActionListener(this);
            Emp_Pay=new JButton("Employee Payment");
            Emp_Pay.setFont(ft1);
            Emp_Pay.addActionListener(this);
            Working_Emp=new JButton("Employees");
            Working_Emp.setFont(ft1);
            Working_Emp.addActionListener(this);
            Leaved_Emp=new JButton("Ex-Employees");
            Leaved_Emp.setFont(ft1);
            Leaved_Emp.addActionListener(this);
            Rep=new JButton("Students Report");
            Rep.setFont(ft1);
            Rep.addActionListener(this);
            RepE=new JButton("Employees Report");
            RepE.setFont(ft1);
            RepE.addActionListener(this);
            Logout=new JButton(new ImageIcon(ClassLoader.getSystemResource("Hostel/19.png")));
            Logout.setFont(new Font("courier",1,20));
            Logout.setForeground(Color.RED);
            Logout.addActionListener(this);
            user =new JButton("Add User");
            user.setFont(ft1);
            user.addActionListener(this);
            Del =new JButton("Delete User");
            Del.setFont(ft1);
            Del.addActionListener(this);
            Man_Room.setBounds(40, 80, 270, 30);
            Upt_Room.setBounds(40, 130, 270, 30);
            New_Stu.setBounds(40, 80, 270, 30);
            Upt_Stu.setBounds(40, 130, 270, 30);
            Stu_Liv.setBounds(40, 230, 270, 30);
            Leaved_Stu.setBounds(40, 280, 270, 30);
            Stu_Fees.setBounds(40, 180, 270, 30);
            New_Emp.setBounds(40, 80, 270, 30);
            Upt_Emp.setBounds(40, 130, 270, 30);
            Emp_Pay.setBounds(40, 180, 270, 30);
            Working_Emp.setBounds(40, 230, 270, 30);
            Leaved_Emp.setBounds(40, 280, 270, 30);
            Rep.setBounds(40, 80, 270, 30);
            RepE.setBounds(40, 130, 270, 30);
            user.setBounds(40, 80, 270, 30);
            Del.setBounds(40, 130, 270, 30);
            Logout.setBounds(1000, 50, 150, 50);
            Logout.setOpaque(true);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hostel/4.jpeg"));
            Image i2=i1.getImage().getScaledInstance(1200,720,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(0,0,1200,720);
            f1.add(image);
            room=new JPanel();
            JLabel l1,l2,l3,l4,l5;
            Font ft3 = new Font("Cambria",1,30);
            l1=new JLabel("Rooms");
            l2=new JLabel("Employees");
            l3=new JLabel("Students");
            l4=new JLabel("Reports");
            l5=new JLabel("Users");
            l5.setFont(ft3);
            l4.setFont(ft3);
            l3.setFont(ft3);
            l2.setFont(ft3);
            l1.setFont(ft3);
            room =new JPanel();
            student=new JPanel();
            employee=new JPanel();
            report=new JPanel();
            userp=new JPanel();
            room.setLayout(null);employee.setLayout(null);student.setLayout(null);report.setLayout(null);userp.setLayout(null);
            room.setBounds(20,20,350,180);
            l1.setBounds(125,15,100,40);
            employee.setBounds(20,250,350,350);
            l2.setBounds(110,15,150,40);
            student.setBounds(390,250,350,350);
            l3.setBounds(110,15,150,40);
            report.setBounds(755,235,350,180);
            l4.setBounds(120,15,150,40);
            userp.setBounds(770,420,350,180);
            l5.setBounds(125,15,100,40);
            room.add(l1);
            userp.setVisible(true);
            employee.add(l2);
            student.add(l3);
            report.add(l4);
            userp.add(l5);
            employee.add(New_Emp);
            room.add(Man_Room);
            room.add(Upt_Room);
            student.setOpaque(false);
            room.setOpaque(false);
            employee.setOpaque(false);
            report.setOpaque(false);
            userp.setOpaque(false);
            //student.setVisible(false);report.setVisible(false);employee.setVisible(false);room.setVisible(false);
            image.add(userp);
            image.add(report);
            image.add(student);
            image.add(employee);
            image.add(room);
            userp.add(Del);
            userp.add(user);
//            image.add(Man_Room);
//            image.add(Upt_Room);
            student.add(New_Stu);
            student.add(Upt_Stu);
            student.add(Stu_Liv);
            student.add(Leaved_Stu);
            student.add(Stu_Fees);
            employee.add(Upt_Emp);
            employee.add(Emp_Pay);
            employee.add(Working_Emp);
            employee.add(Leaved_Emp);
            report.add(Rep);
            image.add(Logout);
            report.add(RepE);
            f1.setVisible(true);
        }
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == Man_Room) {

                Add_Room mr = new Add_Room();
            }
            else if (ae.getSource() == Upt_Room) {
                Update_Room ur=new Update_Room();
            }
            else if (ae.getSource() == New_Stu) {
                AddStudent as=new AddStudent();
            }
            else if (ae.getSource() ==Upt_Stu) {
                Update_Student as=new Update_Student();
            }
            else if (ae.getSource()==Stu_Fees) {
                Student_Rent sr=new Student_Rent();
            }
            else if (ae.getSource()==Stu_Liv)
            {
                Student_Living sl=new Student_Living();
            }
            else if (ae.getSource()==New_Emp) {
                AddEmployee aem=new AddEmployee();
            }
            else if (ae.getSource()==Upt_Emp) {
                Update_Employee ue=new Update_Employee();
            }
            else if (ae.getSource()==Stu_Liv) {
                Student_Living sl=new Student_Living();
            }
            else if (ae.getSource()==Leaved_Stu) {
                Student_Leaved sl=new Student_Leaved();
            }
            else if (ae.getSource()==Emp_Pay) {
                            Employee_Payment ue=new Employee_Payment();
            }
            else if (ae.getSource()==Working_Emp) {
               Employees we=new Employees();
            }
            else if (ae.getSource()==Leaved_Emp) {
                Employee_Leaved ue=new Employee_Leaved();
            }
            else if (ae.getSource()==Rep) {
                Student_Report ue=new Student_Report();
            }
            else if (ae.getSource()==Logout) {

                Login login =new Login();
                f1.dispose();
            } else if (ae.getSource()==user) {

                AddUser register =new AddUser();
            }
            else if (ae.getSource()==RepE) {

                Employee_Report register =new Employee_Report();
            }else if (ae.getSource()==Del) {

                Delete_User register =new Delete_User();
            }
        }
    }


