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
import javax.swing.JTextField;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PAYUSH
 */
public class deposit extends JFrame{
    JLabel jl1,jl2;
    JTextField t,t1;
    JButton b1,b2,b3;
    long cardno=Login.g1;
 
    String email="";
     int g5=0,balance=0;
    public deposit(){
        setVisible(true);
        setTitle("DEPOSIT");
        setSize(900,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
         ImageIcon img=new ImageIcon(new ImageIcon("D:\\programs\\New folder\\z.jpg").getImage().getScaledInstance(900, 700,Image.SCALE_DEFAULT));
        
        JLabel bk=new JLabel(img);
        bk.setBounds(0,0,900,700);
         
        t1=new JTextField();
        
        jl1=new JLabel("ENTER AMOUNT YOU WANT ");
        jl1.setBounds(200,160,500,100);
        jl1.setFont(jl1.getFont().deriveFont(1,30.0f));
        jl2=new JLabel("TO DEPOSIT");
        jl2.setBounds(310,200,500,100);
        jl2.setFont(jl1.getFont().deriveFont(1,30.0f));
        
        jl1.setForeground(Color.red);
        jl2.setForeground(Color.red);
        t=new JTextField();
        t.setBounds(260,300,300,30);
        
        b1=new JButton("DEPOSIT");
        b2=new JButton("BACK");
        b3=new JButton("EXIT");
        b1.setBounds(280,400,100,30);
        b2.setBounds(400,400,100,30);
        b3.setBounds(340,470,100,30);
        Date d=new Date();
        SimpleDateFormat sd=new SimpleDateFormat("YYYY-MM-dd HH-mm-ss");
        String g3=sd.format(d);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
            String g2="deposit";
            int g4=Integer.parseInt(t.getText());
           
            ResultSet rs1=stat.executeQuery("select * from balance where card_no="+cardno);              
                while(rs1.next()){
                  balance=rs1.getInt("balance");
                    System.out.println(balance);
                }
                
                                ResultSet rs2=stat.executeQuery("select * from person_info where card_no="+cardno);              
                while(rs2.next()){
                   email=rs2.getString("email");
                   t1.setText(email);
                   System.out.println(email);
                }  
            
            String sq1 ="insert into acc_info(card_no,trans_type,date_time,amount)values("+cardno+",'"+g2+"','"+g3+"',"+g4+")";
                g5=g4+balance;        
                        stat.executeUpdate(sq1);
              
                        String sq2="update balance "
                    + "set balance="+g5+""
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
                   email=t1.getText();

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("atmsimulatorsystem@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("deposit");
			message.setText("RS."+g5+"deposited from"
                                        + "ATM your balance left"
                                + "in Account is"+g5);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException c) {
			throw new RuntimeException(c);
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
        
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mainwindow();
                setVisible(false);
            }
        });
        
        add(jl1);
        add(jl2);
        add(t);
        add(b1);
        add(b2);
        add(b3);
        add(bk);
    b1.setBackground(Color.lightGray);
        b1.setForeground(Color.red);
        b2.setBackground(Color.lightGray);
    b3.setBackground(Color.lightGray);
        b2.setForeground(Color.red);
        b3.setForeground(Color.red);
        t.setBackground(Color.LIGHT_GRAY);

    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
             new deposit();
            }
        });
                
    }
    
}
