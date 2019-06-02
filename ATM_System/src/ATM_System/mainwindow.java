/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM_System;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author PAYUSH
 */
public class mainwindow extends JFrame{
    JLabel jl1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JDialog d;
            
    public mainwindow(){
        setVisible(true);
        setTitle("main window");
        setSize(900,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        ImageIcon img=new ImageIcon(new ImageIcon("D:\\programs\\New folder\\j.jpg").getImage().getScaledInstance(900, 700,Image.SCALE_DEFAULT));
        
        JLabel bk=new JLabel(img);
        bk.setBounds(00,0,900 ,700);
        jl1=new JLabel("Please Select Your Transaction");
        jl1.setBounds(200, 30,500 ,100);
        jl1.setFont(jl1.getFont().deriveFont(1,30.0f));
        jl1.setForeground(Color.ORANGE);
        
        b1=new JButton("DEPOSIT");        
        b2=new JButton("CASH WITHDRAWAL");
        b3=new JButton("FAST CASH");
        b4=new JButton("MINI STATEMENT");
        b5=new JButton("PIN CHANGE");
        b6=new JButton("BALANCE INQURY");
        b7=new JButton("EXIT");
        
        b1.setBounds(100,150 ,300,50);
        b2.setBounds(500,150,300,50);
        b3.setBounds(100,250,300,50);
        b4.setBounds(500,250,300,50);
        b5.setBounds(100,350,300,50);
        b6.setBounds(500,350,300,50);
        b7.setBounds(350,470,200,50);
       
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new deposit();
                setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new cash_withdrawal();
            setVisible(false);
            }
        });
        
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new fastcash();
              setVisible(false);
            }
        });
       
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              new mini_statement();
              setVisible(false);
            }
        });
        
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new pin_change();
              setVisible(false);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
                
                long g1=Login.g1;
                     ResultSet rs =stat.executeQuery("select * from balance where card_no="+g1); 
                while(rs.next()){
                   int balance=rs.getInt("balance");
                   
                    System.out.println(balance);
                     JOptionPane.showMessageDialog(rootPane,"your balance is Rs."+balance);
                }                              
        }
          
              catch(ClassNotFoundException exc){
            System.out.println(""+exc);
            
        }
        catch(SQLException se){
            System.out.println(""+se);
        }
    
       
            }
        });
        
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(jl1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(bk);
        
        b1.setForeground(Color.orange);
        b2.setForeground(Color.orange);
        b3.setForeground(Color.orange);
        b4.setForeground(Color.orange);
        b5.setForeground(Color.orange);
        b6.setForeground(Color.orange);
        b7.setForeground(Color.orange);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
          new mainwindow();               }
        });
        
       
    }
    
}

