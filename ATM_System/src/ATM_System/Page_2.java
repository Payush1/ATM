/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM_System;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Page_2 extends JFrame implements ActionListener{
    static String g12;
    static String g13;
    static String g14;
    static String g15;
    static String g16;
    static String g17;
    static String g18;
    static String g19;
    static String g20;
    
    
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
    JTextField jtf1,jtf2;
    JComboBox jcb1,jcb2,jcb3,jcb4,jcb5;
    JRadioButton jrb1,jrb2,jrb3,jrb4;
    ButtonGroup bg1,bg2;
    JButton jb1,jb2;
    
    public Page_2() {
        
        setVisible(true);
        setSize(650, 700);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jl1=new JLabel("Page 2: Additional Details");
        jl1.setFont(jl1.getFont().deriveFont(0, 20.0f));
        jl1.setBounds(200, 40, 500, 40);
        jl2=new JLabel("Religion :");
        jl2.setBounds(80, 100, 100, 20);
        jl3=new JLabel("Category :");
        jl3.setBounds(80, 150, 150, 20);
        jl4=new JLabel("Income :");
        jl4.setBounds(80, 200, 100, 20);
        jl5=new JLabel("Educational");
        jl5.setBounds(80, 250, 100, 20);
        jl6=new JLabel("Qualification :");
        jl6.setBounds(80, 270, 150, 20);
        jl7=new JLabel("Occupation :");
        jl7.setBounds(80, 320, 150, 20);
        jl8=new JLabel("PAN Number :");
        jl8.setBounds(80, 370, 80, 20);
        jl9=new JLabel("Aadhar Number :");
        jl9.setBounds(80, 420, 100, 20);
        jl10=new JLabel("Senior Citizen :");
        jl10.setBounds(80, 470, 100, 20);
        jl11=new JLabel("Existing Account :");
        jl11.setBounds(80, 520, 150, 20);
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
        
        jtf1=new JTextField(80);
        jtf1.setBounds(250, 370, 300, 20);
        jtf2=new JTextField(80);
        jtf2.setBounds(250, 420, 300, 20);
        add(jtf1);
        add(jtf2);
        
        jcb1=new JComboBox();
        jcb1.setBounds(250, 100, 300, 20);
        jcb1.addItem("<Select Religion>");
        jcb1.addItem("Hindu");
        jcb1.addItem("Muslim");
        jcb1.addItem("Sikh");
        jcb1.addItem("Christian");
        jcb1.addItem("Others");
        jcb2=new JComboBox();
        jcb2.setBounds(250, 150, 300, 20);
        jcb2.addItem("<Select Category>");
        jcb2.addItem("General");
        jcb2.addItem("OBC");
        jcb2.addItem("SC");
        jcb2.addItem("ST");
        jcb2.addItem("Others");
        jcb3=new JComboBox();
        jcb3.setBounds(250, 200, 300, 20);
        jcb3.addItem("<Select Income>");
        jcb3.addItem("Null");
        jcb3.addItem("<1,50,000");
        jcb3.addItem("<2,50,000");
        jcb3.addItem("<5,00,000");
        jcb3.addItem("Upto 10,00,000");
        jcb3.addItem("Above 10,00,000");
        jcb4=new JComboBox();
        jcb4.setBounds(250, 260, 300, 20);
        jcb4.addItem("<Select Qualification>");
        jcb4.addItem("Non-Graduate");
        jcb4.addItem("Graduate");
        jcb4.addItem("Post-Graduate");
        jcb4.addItem("Doctrate");
        jcb4.addItem("Others");
        jcb5=new JComboBox();
        jcb5.setBounds(250, 320, 300, 20);
        jcb5.addItem("<Select Occupation>");
        jcb5.addItem("Salaried");
        jcb5.addItem("Self-Employed");
        jcb5.addItem("Business");
        jcb5.addItem("Student");
        jcb5.addItem("Retired");
        jcb5.addItem("Others");
        add(jcb1);
        add(jcb2);
        add(jcb3);
        add(jcb4);
        add(jcb5);
        
        jrb1=new JRadioButton("Yes");
        jrb1.setBounds(250,470,50,20);
        jrb2=new JRadioButton("No");
        jrb2.setBounds(350,470,80,20);
        jrb3=new JRadioButton("Yes");
        jrb3.setBounds(250,520,70,20);
        jrb4=new JRadioButton("No");
        jrb4.setBounds(350,520,90,20);
        bg1=new ButtonGroup();
        bg1.add(jrb1);
        bg1.add(jrb2);
        bg2=new ButtonGroup();
        bg2.add(jrb3);
        bg2.add(jrb4);
        add(jrb1);
        add(jrb2);
        add(jrb3);
        add(jrb4);
        
        jb1=new JButton("Next");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
             g12=jcb1.getSelectedItem().toString();
             g13=jcb2.getSelectedItem().toString();
             g14=jcb3.getSelectedItem().toString();
             g15=jcb4.getSelectedItem().toString();
             g16=jcb5.getSelectedItem().toString();
             g17=jtf1.getText();
             g18=jtf2.getText();
             g19="";
            if(jrb1.isSelected()){
                g19="yes";
            }else if(jrb2.isSelected()){
                g19="no";
            }
             g20="";
            if(jrb3.isSelected()){
                g20="yes";
            }else if(jrb2.isSelected()){
                g20="no";
            }

            
            
               
                Page_3 p3=new Page_3();
                setVisible(false);
            }
        });
        jb1.setBounds(200, 600, 80, 30);
        jb2=new JButton("Clear");
        jb2.addActionListener(this);
        jb2.setBounds(350, 600, 80, 30);
        add(jb1);
        add(jb2);
    }

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Page_2();
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Page_2 p2=new Page_2();
        setVisible(false);
    }
}

