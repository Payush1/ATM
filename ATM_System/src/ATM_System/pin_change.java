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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PAYUSH
 */
public class pin_change extends JFrame{
    JLabel l1,l2,l3,l4;
    JPasswordField p1,p2;
    JTextField t;
    JButton b1,b2;
    
    public pin_change(){
          setVisible(true);
        setTitle("PIN CHANGE");
        setSize(600,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
         ImageIcon img=new ImageIcon(new ImageIcon("D:\\programs\\New folder\\rt.jpg").getImage().getScaledInstance(600, 500,Image.SCALE_DEFAULT));
        
        JLabel bk=new JLabel(img);
        bk.setBounds(0,0,600,500);
        
        l1=new JLabel("CHANGE YOUR PIN");
        l2=new JLabel("Current Pin");
        l3=new JLabel("New Pin");
        l4=new JLabel("Confirm Pin");
        l1.setBounds(150,100,300,50);
        l1.setFont(l1.getFont().deriveFont(1,30.0f));
        l2.setBounds(120,180,100,20);
        l2.setFont(l2.getFont().deriveFont(1,15.0f));
        l3.setBounds(120,210,100,20);
        l3.setFont(l3.getFont().deriveFont(1,15.0f));
        l4.setBounds(120,240,100,20);
        l4.setFont(l4.getFont().deriveFont(1,15.0f));
        
        p1=new JPasswordField();
        p2=new JPasswordField();
        
        p1.setBounds(220 ,180,200,20);
        p2.setBounds(220 ,210,200,20);
        
        t=new JTextField();
        t.setBounds(220,240,200,20);
        
        b1=new JButton("SAVE");
        b2=new JButton("BACK");
        b1.setBackground(Color.GREEN);
        b2.setBackground(Color.GREEN);
        b1.addActionListener(new ActionListener() {
            
              @Override
              public void actionPerformed(ActionEvent e) {
                  int g1=Integer.parseInt(p1.getText());
                  int g2=Integer.parseInt(p2.getText());
                  int g3=Integer.parseInt(t.getText());
                  int g4=0,id=0,id1=0;
                  long cardno=Login.g1;
               
               
                  try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
                  ResultSet rs =stat.executeQuery("select * from person_info where card_no="+cardno); 
                while(rs.next()){
                    id=rs.getInt("id");
                    System.out.println(id);
                }
          
            ResultSet rs1=stat.executeQuery("select * from person_info where password="+g1);              
                while(rs1.next()){
                   id1=rs1.getInt("id");
                    System.out.println(id1);
                }
            if(id==id1){
            if(g2==g3){
            String sq1="update person_info "
                    + " set password="+g2+""
                    + " where id="+id+"";
                        
                        stat.executeUpdate(sq1);
                        
            }else{
                System.out.println("confirm pin not match");
                JOptionPane.showMessageDialog(rootPane,"confirm pin not match");
            }
            }else{
              JOptionPane.showMessageDialog(rootPane," you have entered wrong current pin");
                System.out.println("you have entered wrong current pin");
            }
        }
        catch(ClassNotFoundException exc){
            System.out.println(""+exc);
            
            
        }
        catch(SQLException se){
            System.out.println(""+se);
        }
                  setVisible(false);
              new mainwindow();
              }
              });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mainwindow();
                setVisible(false);
            }
        });
        
        b1.setBounds(180,280,100,30);
        b2.setBounds(320,280,100,30);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(p1);
        add(p2);
        add(t);
        add(b1);
        add(b2);
        add(bk);
    }
      public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
             new pin_change();
            }
        });
}
}
