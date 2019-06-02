/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM_System;


import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class cash_withdrawal extends JFrame{
    JLabel l1,l2,l3;
    JTextField t,t1;
    JButton b1,b2,b3;
    long cardno=Login.g1;
     int g5=0,balance=0;
   String email="";  
    public cash_withdrawal(){
        setVisible(true);
        setTitle("CASH_WITHDRAWAL");
        setSize(900,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        ImageIcon img=new ImageIcon(new ImageIcon("D:\\programs\\New folder\\28.jpg").getImage().getScaledInstance(900, 700,Image.SCALE_DEFAULT));
        
        JLabel bk=new JLabel(img);
        bk.setBounds(0,0,900,700);

        l1=new JLabel("MAXIMUM DAILY WITHDRAWAL");
        l2=new JLabel("IS RS.10,000");
        l3=new JLabel("PLEASE ENTER YOUR AMOUNT");
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        
        l1.setBounds(180,100,500,30);
        l2.setBounds(280,150,500,30);
        l3.setBounds(180,250,500,30);
        l1.setFont(l1.getFont().deriveFont(1,30.0f));
        l2.setFont(l2.getFont().deriveFont(1,30.0f));
        l3.setFont(l3.getFont().deriveFont(1,30.0f));
        
        t=new JTextField();
        t.setBounds(260,300,300,30);
          
        
       
        t1=new JTextField();
        
        Date d=new Date();
        SimpleDateFormat sd=new SimpleDateFormat("YYYY-MM-dd HH-mm-ss");
        String g3=sd.format(d);
        
        b1=new JButton("WITHDRAWAL");
        b2=new JButton("BACK");
        b3=new JButton("EXIT");
        b1.setBounds(260,400,150,30);
        b2.setBounds(420,400,150,30);
        b3.setBounds(360,570,100,30);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
           
               
        
                    try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
            
            int g4=Integer.parseInt(t.getText());
            ResultSet rs1=stat.executeQuery("select * from balance where card_no="+cardno);              
                while(rs1.next()){
                   balance=rs1.getInt("balance");
                    System.out.println(balance);
                }  
              
              ResultSet rs2=stat.executeQuery("select * from person_info where card_no="+cardno);              
                while(rs2.next()){
                   email=rs2.getString("email");
                    System.out.println(email);
                    t1.setText(email);
                }  
                
                if(g4<=10000){
                if(g4<=balance){
            
            String sq1 ="insert into acc_info(card_no,trans_type,date_time,amount)values("+cardno+",'withdraw','"+g3+"',"+g4+")";
                g5=balance-g4;        
                        stat.executeUpdate(sq1);
                             String sq2="update balance "
                    + " set balance="+g5+""
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
			message.setSubject("withdraw");
			message.setText("Rs."+g4+" withdrawn from"
                                        + "\nATM your balance left"
                                + "\nin Account is Rs."+g5);

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
            System.out.println(balance);
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
        
        b1.setBackground(Color.WHITE);
       b2.setBackground(Color.WHITE);
         b3.setBackground(Color.WHITE);
        add(l1);
        add(l2);
        add(l3);
         add(t);
        add(b1);
        add(b2);
        add(b3);
        add(bk);
    }
          public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
             new cash_withdrawal();
            }
        });
                
    }
}
