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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author PAYUSH
 */
public class ATM_System extends JFrame{
    JButton b1;
    JLabel l1,l2;

    /**
     * @param args the command line arguments
     */
    public ATM_System(){
          setVisible(true);
        setSize(900, 700);
        setTitle("AUTOMATED TELLER MACHINE");
        setLocationRelativeTo(null);
        setLayout(null);
        
        ImageIcon img=new ImageIcon(new ImageIcon("D:\\programs\\New folder\\ad.jpg").getImage().getScaledInstance(900, 700,Image.SCALE_DEFAULT));
        JLabel bk=new JLabel(img);
        bk.setBounds(0,0,900,700);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        l1=new JLabel("ATM SIMULATOR SYSTEM");
        l1.setFont(l1.getFont().deriveFont(0, 40.0f));
        l1.setBounds(200,30,600,50);
        l1.setForeground(Color.gray);
        
        l2=new JLabel("PROJECT BY : PAYUSH BATHLA AND PUNIT KUMAR");
        l2.setBounds(40,500 ,300 ,300);
        l2.setForeground(Color.BLUE);
        
        b1=new JButton("Please Press Button To Start >>>");
        b1.setBounds(450,550,300 ,80 );
        b1.setForeground(Color.red);
        add(b1);
        add(l1);
        add(l2);
        b1.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
             new Login();
                  setVisible(false);
              }
          });
        b1.setBackground(Color.LIGHT_GRAY);
        add(bk);
    }
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATM_System();
            }
        });
    }
        
    }
    

