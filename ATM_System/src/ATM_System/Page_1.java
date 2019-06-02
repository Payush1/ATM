/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM_System;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Page_1 extends JFrame implements ActionListener{
    static String g1;
    static String g2;
    static String g3;
    static String g4;
    static String g5;
    static String g6;
    static String g7;
    static String g8;
    static String g9;
    static String g10;
    static String g11;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
    JRadioButton jrb1,jrb2,jrb3,jrb4,jrb5;
    JComboBox jcb,jc1,jc2,jc3;
    ButtonGroup bg1,bg2;
    JButton jb1,jb2;
   
//    JCalendar cal;
    
    public Page_1() {
        
        setVisible(true);
        setSize(650, 700);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img=new ImageIcon(new ImageIcon("D:\\programs\\New folder\\k.jpg").getImage().getScaledInstance(650, 700,Image.SCALE_DEFAULT));
        JLabel bk=new JLabel(img);
        
        jl1=new JLabel("APPLICATION FORM");
        jl1.setFont(jl1.getFont().deriveFont(1, 35.0f));
        jl1.setBounds(150, 10, 500, 40);
        jl2=new JLabel("Page 1: Personal Deatils");
        jl2.setFont(jl2.getFont().deriveFont(0, 20.0f));
        jl2.setBounds(200, 50, 300, 30);
        jl3=new JLabel("Name :");
        jl3.setBounds(80, 100, 50, 20);
        jl4=new JLabel("Father's Name :");
        jl4.setBounds(80, 150, 150, 20);
        jl5=new JLabel("Date of Birth :");
        jl5.setBounds(80, 200, 150, 20);
        jl6=new JLabel("Gender :");
        jl6.setBounds(80, 250, 50, 20);
        jl7=new JLabel("Email Address :");
        jl7.setBounds(80, 300, 150, 20);
        jl8=new JLabel("Marital Status :");
        jl8.setBounds(80, 350, 150, 20);
        jl9=new JLabel("Address :");
        jl9.setBounds(80, 400, 80, 20);
        jl10=new JLabel("City :");
        jl10.setBounds(80, 450, 50, 20);
        jl11=new JLabel("Pin Code :");
        jl11.setBounds(80, 500, 100, 20);
        jl12=new JLabel("State :");
        jl12.setBounds(80, 550, 50, 20);
        add(jl1);
        add(jl2);
        add(jl3);
        add(jl4);
        add(jl5);
        add(jl6);
        add(jl7);
        add(jl8);
        add(jl9);
        add(jl10);
        add(jl11);
        add(jl12);
        
        
       // cal = new JCalendar();
        //add(cal);
        //cal.setBounds(280,200, 50,50);
        
        jtf1=new JTextField(80);
        jtf1.setBounds(250, 100, 300, 20);
        jtf2=new JTextField(80);
        jtf2.setBounds(250, 150, 300, 20);
        jtf3=new JTextField(80);
        jtf3.setBounds(250, 300, 300, 20);
        jtf4=new JTextField(80);
        jtf4.setBounds(250, 400, 300, 20);
        jtf5=new JTextField(80);
        jtf5.setBounds(250, 500, 300, 20);
        jtf6=new JTextField(80);
        jtf6.setBounds(250, 450, 300, 20);
        add(jtf1);
        add(jtf2);
        add(jtf3);
        add(jtf4);
        add(jtf5);
        add(jtf6);
        
        jcb=new JComboBox();
        jcb.setBounds(250, 550, 300, 20);
        jcb.addItem("<Select State>");
        jcb.addItem("Andra Pradesh");
        jcb.addItem("Arunachal Pradesh");
        jcb.addItem("Assam");
        jcb.addItem("Bihar");
        jcb.addItem("Chhattisgarh");
        jcb.addItem("Goa");
        jcb.addItem("Gujrat");
        jcb.addItem("Haryana");
        jcb.addItem("Himachal Pradesh");
        jcb.addItem("Jammu and Kashmir");
        jcb.addItem("Jharkhand");
        jcb.addItem("Karnataka");
        jcb.addItem("Kerala");
        jcb.addItem("Madhya Pradesh");
        jcb.addItem("Maharashtra");
        jcb.addItem("Manipur");
        jcb.addItem("Meghalaya");
        jcb.addItem("Mizoram");
        jcb.addItem("Nagaland");
        jcb.addItem("Odisha");
        jcb.addItem("Punjab");
        jcb.addItem("Rajasthan");
        jcb.addItem("Sikkim");
        jcb.addItem("Tamil Nadu");
        jcb.addItem("Telangana");
        jcb.addItem("Tripura");
        jcb.addItem("Uttar Pradesh");
        jcb.addItem("Uttarakhand");
        jcb.addItem("West Bengal");
                    jc1=new JComboBox();
            jc2=new JComboBox();
            jc3=new JComboBox();
            
            
            jc1.addItem("<Day>");
            for(int i=1;i<32;i++)
            {
              jc1.addItem(i);
            }
            jc2.addItem("<Month>");
            jc2.addItem("January");
            jc2.addItem("February");
            jc2.addItem("March");
            jc2.addItem("April");
            jc2.addItem("May");
            jc2.addItem("June");
            jc2.addItem("July");
            jc2.addItem("August");
            jc2.addItem("September");
            jc2.addItem("October");
            jc2.addItem("November");
            jc2.addItem("December");
            
            jc3.addItem("<Year>");
            for(int k=1950; k<=2017; k++)
            {
              jc3.addItem(k);
            }
             jc1.setBounds(280, 200, 60, 20);
            jc2.setBounds(350, 200, 80, 20);
            jc3.setBounds(440, 200, 80, 20);

     
      add(jcb);
        add(jc1);
        add(jc2);
        add(jc3);
        jrb1=new JRadioButton("Male");
        jrb1.setBounds(250,250,60,20);
        jrb2=new JRadioButton("Female");
        jrb2.setBounds(350,250,80,20);
        jrb3=new JRadioButton("Married");
        jrb3.setBounds(250,350,70,20);
        jrb4=new JRadioButton("Unmarried");
        jrb4.setBounds(350,350,90,20);
        jrb5=new JRadioButton("Others");
        jrb5.setBounds(450,350,80,20);
        bg1=new ButtonGroup();
        bg1.add(jrb1);
        bg1.add(jrb2);
        bg2=new ButtonGroup();
        bg2.add(jrb3);
        bg2.add(jrb4);
        bg2.add(jrb5);
        add(jrb1);
        add(jrb2);
        add(jrb3);
        add(jrb4);
        add(jrb5);
        
        jb1=new JButton("Next");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
               
             g1=jtf1.getText();
             g2=jtf2.getText();
            String a1=jc1.getSelectedItem().toString();
            String a2=jc2.getSelectedItem().toString();
            String a3=jc3.getSelectedItem().toString();
             g3=a3+"-"+a2+"-"+a1;
             g4="";
            if(jrb1.isSelected()){
                g4="Male";
            }
            else if(jrb2.isSelected()){
            g4="Female";}
            
             g5=jtf3.getText();
             g6="";
            if(jrb3.isSelected()){
                 g6=jrb3.getText();
            }else if(jrb4.isSelected()){
                 g6=jrb4.getText();
            }
            else if(jrb5.isSelected())
            { g6=jrb5.getText();
            }
            
             g7=jtf4.getText();
             g8=jtf6.getText();
             g9=jtf5.getText();
             g10=jcb.getSelectedItem().toString();
            
                   
              
       
                new Page_2();
                setVisible(false);
            }
        });
        jb1.setBounds(200, 600, 80, 30);
        jb2=new JButton("Clear");
        jb2.addActionListener(this);
        jb2.setBounds(350, 600, 80, 30);
        add(jb1);
        add(jb2);
        add(bk);
    }
    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Page_1();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Page_1 p1=new Page_1(); 
        setVisible(false);
    }
    
}
