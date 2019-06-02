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
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class Page_3 extends JFrame implements ActionListener{
                    String g1=Page_1.g1;
                    String g2=Page_1.g2;
                    String g3=Page_1.g3;
                    String g4=Page_1.g4;
                    String g5=Page_1.g5;
                    String g6=Page_1.g6;
                    String g7=Page_1.g7;
                    String g8=Page_1.g8;
                    String g9=Page_1.g9;
                    String g10=Page_1.g10;
                    String g12=Page_2.g12;
                    String g13=Page_2.g13;
                    String g14=Page_2.g14;
                    String g15=Page_2.g15;
                    String g16=Page_2.g16;
                    String g17=Page_2.g17;
                    String g18=Page_2.g18;
                    String g19=Page_2.g19;
                    String g20=Page_2.g20;
    
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
    JButton jb1,jb2;
    JRadioButton jrb1,jrb2,jrb3,jrb4;
    JCheckBox jcb1,jcb2,jcb3,jcb4,jcb5,jcb6,jcb7;
    ButtonGroup bg;
    JTextField t;
  
   static String g21;
    long  g22;
    int g23;
   String g24;
    
    public Page_3() {
        
        setVisible(true);
        setSize(650, 700);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jl1=new JLabel("Page 3: Account Details");
        jl1.setFont(jl1.getFont().deriveFont(0, 20.0f));
        jl1.setBounds(200, 40, 500, 40);
        jl2=new JLabel("Account Type :");
        jl2.setFont(jl2.getFont().deriveFont(1, 15.0f));
        jl2.setBounds(60, 120, 150, 40);
        jl3=new JLabel("CARD NUMBER :");
        jl3.setFont(jl3.getFont().deriveFont(1, 15.0f));
        jl3.setBounds(60, 250, 170, 40);
        jl4=new JLabel("(Your 16-digit Card number)");
        jl4.setFont(jl4.getFont().deriveFont(0, 11.0f));
        jl4.setBounds(60, 270, 150, 40);
        jl5=new JLabel("PIN :");
        jl5.setFont(jl5.getFont().deriveFont(1, 15.0f));
        jl5.setBounds(60, 320, 50, 40);
        jl6=new JLabel("(4-digit PASSWORD)");
        jl6.setFont(jl6.getFont().deriveFont(0, 11.0f));
        jl6.setBounds(60, 340, 150, 40);
        jl7=new JLabel("Service Required :");
        jl7.setFont(jl7.getFont().deriveFont(1, 15.0f));
        jl7.setBounds(60, 390, 150, 40);
        jl8=new JLabel("are correct to the best of my knowledge.");
        jl8.setFont(jl8.getFont().deriveFont(0, 11.0f));
        jl8.setBounds(200, 555, 300, 20);
        add(jl1);
        add(jl2);
        add(jl3);
        add(jl4);
        add(jl5);
        add(jl6);
        add(jl7);
        add(jl8);
        
        jrb1=new JRadioButton("Savings Account");
        jrb1.setBounds(80, 170, 150, 20);
        jrb2=new JRadioButton("Fixed Deposit Account");
        jrb2.setBounds(350, 170, 200, 20);
        jrb3=new JRadioButton("Current Account");
        jrb3.setBounds(80, 200, 150, 20);
        jrb4=new JRadioButton("Recurring Deposit Account");
        jrb4.setBounds(350, 200, 200, 20);
        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);
        add(jrb1);
        add(jrb2);
        add(jrb3);
        add(jrb4);
        
        t=new JTextField();
        t.setText(g5);
        jcb1=new JCheckBox("ATM CARD");
        jcb1.setBounds(80, 440, 100, 20);
        jcb2=new JCheckBox("Internet Banking");
        jcb2.setBounds(350, 440, 150, 20);
        jcb3=new JCheckBox("Mobile Banking");
        jcb3.setBounds(80, 470, 150, 20);
        jcb4=new JCheckBox("EMAIL Alerts");
        jcb4.setBounds(350, 470, 100, 20);
        jcb5=new JCheckBox("Cheque Book");
        jcb5.setBounds(80, 500, 150, 20);
        jcb6=new JCheckBox("E-Statement");
        jcb6.setBounds(350, 500, 100, 20);
        jcb7=new JCheckBox("I hereby decide that the above entered deatils");
        jcb7.setBounds(180, 540, 400, 20);
        jcb7.setFont(jcb7.getFont().deriveFont(0, 11.0f));
        add(jcb1);
        add(jcb2);
        add(jcb3);
        add(jcb4);
        add(jcb5);
        add(jcb6);
        add(jcb7);
        add(t);
        
        jb1=new JButton("SUBMIT");
        jb1.setBounds(200, 600, 80, 30);
        jb1.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jcb7.isSelected()){
                try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3305/ATM_Simulator_System?zeroDateTimeBehavior=convertToNull","root","root");
            Statement stat=conn.createStatement();
            g21="";
            if(jrb1.isSelected()){
                g21="saving acc";
            }else if(jrb2.isSelected()){
                g21="fix depo acc";
                 }
            else if(jrb3.isSelected()){
                g21="current acc";
            }else if(jrb4.isSelected()){
                g21="reccuring deposit acc";
            
            }
                    long first14=(long)(Math.random()*10000000000000L);
                     g22=5700000000000000L+first14;
                   Random rand=new Random();
             g23=rand.nextInt(10000);
               g24="";
              
              if(jcb1.isSelected()){
                  g24=g24.concat("atm");
              }
              else if(jcb2.isSelected()){
                  g24=g24.concat(",internet bank");
              }   
              if(jcb3.isSelected()){
                  g24=g24.concat("mobile ban");
              }
                   if(jcb4.isSelected()){
                  g24=g24.concat("email alerts");
              } 
                   if(jcb5.isSelected()){
                  g24=g24.concat("check books");
              }if(jcb6.isSelected()){
                  g24=g24.concat("E-statements");
              }
               
                    
                   
              
                String sq1 ="insert into person_info(name,father,dob,gender,email,marital,address,city,pincode,state,religion,category,income,qualification,occupation,pan,adhar,sc,ea,acctype,card_no,password,sr)"
                        + "values('"+g1+"','"+g2+"','"+g3+"','"+g4+"','"+g5+"','"+g6+"','"+g7+"','"+g8+"',"+g9+",'"+g10+"','"+g12+"','"+g13+"','"+g14+"','"+g15+"','"+g16+"','"+g17+"','"+g18+"','"+g19+"','"+g20+"','"+g21+"',"+g22+","+g23+",'"+g24+"')";
                        
                        stat.executeUpdate(sq1);
                        String sq9="insert into balance(card_no)values("+g22+")";
                        stat.executeUpdate(sq9);
          
                System.out.println("insert complete");
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
               
		try{
                        String email=t.getText();
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("atmsimulatorsystem@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(g5));
			message.setSubject("your card_n0 & password");
			message.setText("your card no and password are:\n\n"+"card no ="+g22+
					"\n\npin="+g23);

			Transport.send(message);

			System.out.println("Done");
                         Login l=new Login();
                setVisible(false);


                } catch (MessagingException c) {
			 JOptionPane.showMessageDialog(rootPane,"connection error");
                }
                
                }         catch(ClassNotFoundException exc){
            System.out.println(""+exc);
            
        }
        catch(SQLException se){
            System.out.println(""+se);
        }
                
                    
                }
                
                
                           }
        });
        jb2=new JButton("CANCEL");
        jb2.setBounds(350, 600, 80, 30);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(jb1);
        add(jb2);
    }

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Page_3();
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Page_3 p3=new Page_3();
        setVisible(false);
    }
    
}
