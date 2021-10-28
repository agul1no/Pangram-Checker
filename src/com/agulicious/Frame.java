package com.agulicious;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener {

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton button = new JButton();
    JLabel label = new JLabel();
    Border border = BorderFactory.createLineBorder(Color.BLACK,5);
    public static String text;
    boolean pangram = true;
    boolean[] mark = new boolean[26];
    int index = 0;


    Frame(){

        textField.setBounds(50,100,700,50);
        textField.setEditable(false);
        textField.setText("This is a pangram checker. Please enter a text in this field:");
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("time new roman", Font.PLAIN,25));
        textField.setBackground(new Color(50,50,50));
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createBevelBorder(2));

        textArea.setBounds(100,200,600,112);
        textArea.setLineWrap(true);
        textArea.setFont(new Font("time new roman", Font.PLAIN,20));
        textArea.setBorder(border);

        button.setBounds(200,350,400,50);
        button.setFont(new Font("time new roman", Font.PLAIN,15));
        button.setText("Press here to check");
        button.addActionListener(this);
        button.setEnabled(true);
        button.setFocusable(false);


        label.setBounds(200,400,500,100);
        label.setBackground(new Color(50,50,50));
        label.setFont(new Font("time new roman", Font.PLAIN,30));

        frame.add(button);
        frame.add(label);
        frame.add(textArea);
        frame.add(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pangram Checker");
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null); //setting the object by hand

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            pangram = true;
            for(int i = 0; i<mark.length;i++)
                mark[i]=false;
            text = textArea.getText();
            text = text.replace(" ", "").toLowerCase().replace(".","");
            checkPangram();
            if (pangram){
                label.setText("Congratulation! it's a Pangram :)");
                label.setForeground(new Color(50,200,0, 150));
            } else {
                label.setText("Sorry: Not a Pangram :/");
                label.setForeground(new Color(200,50,50, 190));
            }
        }

    }

    public boolean checkPangram(){

        for(int i=0; i<Frame.text.length();i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                index = text.charAt(i) - 'a';
            }
            mark[index] = true;
        }
        for(int i = 0; i<mark.length;i++){
            System.out.println(mark[i] + " array mark position "+ i);
            if(!mark[i]){
                pangram = false;
            }
        }
        if(pangram){
            System.out.println("Congratulation: it's a Pangram! :)");
        }else {
            System.out.println("Sorry: Not a Pangram :/");
        }

        return pangram;
    }
}
