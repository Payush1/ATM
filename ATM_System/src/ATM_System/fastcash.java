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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class fastcash extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JLabel l;
    JTextField t;
    long cardno=Login.g1;
       String email="";
    public fastcash(){
           setVisible(true);
        setTitle("FAST CASH");
        setSize(900,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
         ImageIcon img=new ImageIcon(new ImageIcon("D:\\programs\\New folder\\24.jpg").getImage().getScaledInstance(900, 700,Image.SCALE_DEFAULT));
        
        JLabel bk=new JLabel(img);
        bk.setBounds(0,0,900,700);
        
        l=new JLabel("SELECT WITHDRAWAL AMOUNT");
               
        l.setBounds(180,70,500,30);
         l.setFont(l.getFont().deriveFont(1,30.0f));
         b1=new JButton("100");        
        b2=new JButton("200");
        b3=new JButton("500");
        b7=new JButton("EXIT");
        b5=new JButton("2000");
        b6=new JButton("5000");
        b4=new JButton("1000");
        b8=new JButton("BACK");
        
        b1.setBounds(100,150 ,300,50);
        b2.setBounds(500,150,300,50);
        b3.setBounds(100,250,300,50);
        b4.setBounds(500,250,300,50);
        b5.setBounds(100,350,300,50);
        b6.setBounds(500,350,300,50);
        b7.setBounds(550,520,200,50);
        b8.setBounds(150,520 ,200,50);
       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
       b4.addActionListener(this);
       b5.addActionListener(this);
       b6.addActionListener(this);
       
       b1.setBackground(Color.orange);
        b2.setBackground(Color.orange);
         b3.setBackground(Color.orange);
          b4.setBackground(Color.orange);
           b5.setBackground(Color.orange);
          b6.setBackground(Color.orange);
         b7.setBackground(Color.orange);
          b8.setBackground(Color.orange);
       t=new JTextField();
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new mainwindow();
                setVisible(false);
            }
        });
        add(l);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(bk);
    }
     public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
             new fastcash();
            }
        });
}

    @Override
    public void actionPerformed(ActionEvent e) {
    int balance=0,g4=0,g2=0;
    Date d=new Date();
        SimpleDateFormat sd=new SimpleDateFormat("YYYY-MM-dd HH-mm-ss");
        String g3=sd.format(d);
          
        try{
              
              
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
                    
                        ResultSet rs1=stat.executeQuery("select * from balance where card_no="+cardno);              
                while(rs1.next()){
                   balance=rs1.getInt("balance");
                  
                    System.out.println(balance);
                } 
           
        }
          
              catch(ClassNotFoundException exc){
            System.out.println(""+exc);
            
        }
        catch(SQLException se){
            System.out.println(""+se);
        }
     try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
                 
              ResultSet rs2=stat.executeQuery("select * from person_info where card_no="+cardno);              
                while(rs2.next()){
                   email=rs2.getString("email");
                   t.setText(email);  
                }
               System.out.println(email);
           
        }
          
              catch(ClassNotFoundException exc){
            System.out.println(""+exc);
            
        }
        catch(SQLException se){
            System.out.println(""+se);
        }
   
 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
            
            
            if(e.getSource()==b1){
                g2=100;
            }
            else if(e.getSource()==b2){
                g2=200;
            }else if(e.getSource()==b3){
                g2=500;
            }else if(e.getSource()==b4){
                g2=1000;
            }else if(e.getSource()==b5){
                g2=2000;
            }else if(e.getSource()==b6){
                g2=5000;
            }
   
                  
                if(g2<=10000){
                if(g2<=balance){
            
            String sq1 ="insert into acc_info(card_no,trans_type,date_time,amount)values("+cardno+",'withdraw','"+g3+"',"+g2+")";
                g4=balance-g2;        
                        stat.executeUpdate(sq1);
                        
                        String sq2="update balance "
                    + " set balance="+g4+""
                    + " where card_no="+cardno+"";
                        
                        stat.executeUpdate(sq2);
                        
                        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("atmsimulatorsystem@gmail.com","atm12345");
				}
			});

		try {
                        email=t.getText();
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("atmsimulatorsystem@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("withdraw");
			message.setText("Rs."+g2+" withdrawn from"
                                        + "ATM your balance left"
                                + "in Account is Rs."+g4);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException c) {
			throw new RuntimeException(c);
		}
                }
                else{
                    System.out.println(" low balance");
                    JOptionPane.showMessageDialog(rootPane,"Low balance");
                }
                }
                else{
                    System.out.println("exceeds daily amont");
                    JOptionPane.showMessageDialog(rootPane,"exceeds daily amount");
                }
            System.out.println(g4);
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
    }

