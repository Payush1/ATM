/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM_System;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.layout.Border;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
    static long g1;
    
    JLabel jl1,jl2,jl3;
    JTextField jtf1,t2,t3;
    JPasswordField jtf2;
    JButton jb1,jb2,jb3;
    
    
    public Login() {
        
        setVisible(true);
        setSize(650, 600);
        setTitle("LOG IN");
        setLocationRelativeTo(null);
        setLayout(null);
        
        ImageIcon img=new ImageIcon(new ImageIcon("D:\\programs\\New folder\\cx.jpg").getImage().getScaledInstance(650, 600,Image.SCALE_DEFAULT));
        JLabel bk=new JLabel(img);
        bk.setBounds(0,0,650,600);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        jl1=new JLabel("WELCOME TO ATM");
        jl1.setFont(jl1.getFont().deriveFont(3, 40.0f));
        jl1.setBounds(150, 70, 400, 40);
        jl2=new JLabel("Card No.  :");
        jl2.setFont(jl2.getFont().deriveFont(1, 20.0f));
        jl2.setBounds(100, 190 , 110, 20);
        jl3=new JLabel("PIN  :");
        jl3.setFont(jl3.getFont().deriveFont(1, 20.0f));
        jl3.setBounds(100, 270, 70, 20);
        jl1.setForeground(Color.WHITE);
        jl2.setForeground(Color.WHITE);
        jl3.setForeground(Color.white);
        add(jl1);
        add(jl2);
        add(jl3);
        
        jtf1=new JTextField(80);
        jtf1.setBounds(280, 190, 270, 20);
        jtf2=new JPasswordField(80);
        jtf2.setBounds(280, 270, 270, 20);
        
        t2=new JTextField();
        t3=new JTextField();
        
          
        add(jtf1);
        add(jtf2);
        jb1=new JButton("SIGN IN");
        jb1.setBounds(200, 350, 100, 40);
        jb1.setBackground(Color.white);
        
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           int id=0,id1=0;    
                      try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
            
            g1=Long.parseLong(jtf1.getText());
                          System.out.println(g1);
                
                     ResultSet rs =stat.executeQuery("select * from person_info where card_no="+g1); 
                while(rs.next()){
                  id=rs.getInt("id");
                    System.out.println(id);   
                  
                }   
                      
                 if(id==0){
                    id-=2;
                    
                }
          System.out.println(id);
                
           
        }
          
              catch(ClassNotFoundException exc){
            System.out.println(""+exc);
            
        }
        catch(SQLException se){
            System.out.println(""+se);
        }
    
            
        
       
          
 try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System","root","root");
            Statement stat=conn.createStatement();
            
           
        
                int g2=Integer.parseInt(jtf2.getText());
          ResultSet rs1=stat.executeQuery("select * from person_info where password="+g2);              
                while(rs1.next()){
                   id1=rs1.getInt("id");
                     System.out.println(id1);
                    }       
           
        }
          
              catch(ClassNotFoundException exc){
            System.out.println(""+exc);
            
        }
        catch(SQLException se){
            System.out.println(""+se);
        }
 
        if(id==id1){              
                new mainwindow();
                setVisible(false);
                }else {
            JOptionPane.showMessageDialog(rootPane,"Login Failed you have entered wrong Login or pin");
            System.out.println("Login failed");
            jtf1.setText("");
            jtf2.setText("");
            }
            }
        });
        
        
        jb2=new JButton("CLEAR");
        jb2.addActionListener(this);
        jb2.setBounds(350, 350, 100, 40);
        jb3=new JButton("SIGN UP");
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Page_1 p1=new Page_1();  
              setVisible(false);
            }
        });
        jb3.setBounds(200, 425, 250, 40);
        jb2.setBackground(Color.white);
        jb3.setBackground(Color.white);
        add(jb1);
        add(jb2);
        add(jb3);
     add(bk);
    }

   
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Login l=new Login();
        setVisible(false);
    }
    
}
