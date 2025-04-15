/**
 Lab 5 Starter program
 The CreateAccount class build the Create Account  GUI
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateAccount extends JFrame {
    JLabel labelBanner, labelStatus,labelUser, labelPassword;
    JButton createButton, exitButton;
    JTextField usrTextField, pwTextField;
    JPanel newPanel;

    CreateAccount(){
        setTitle("Create Account");
        setLayout(new BorderLayout());
        labelBanner = new JLabel("Create Account");
        labelBanner.setFont(new Font("Serif", Font.BOLD, 40));
        labelBanner.setForeground(Color.BLUE);


        labelStatus = new JLabel("Status: In Progress...");
        createButton = new JButton("Create");
        exitButton = new JButton("Exit");
        labelUser = new JLabel("User Name");
        labelPassword =  new JLabel("Password");
        usrTextField = new JTextField(15);
        pwTextField = new JTextField(15);
        newPanel = new JPanel();
        newPanel.setLayout(new GridLayout(3,2));
        newPanel.add(labelUser);
        newPanel.add(usrTextField);
        newPanel.add(labelPassword);
        newPanel.add(pwTextField);
        newPanel.add(createButton);
        newPanel.add(exitButton);
        add(labelBanner,BorderLayout.NORTH);
        add(newPanel,BorderLayout.CENTER);
        add(labelStatus,BorderLayout.SOUTH);


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fileWriter = new FileWriter("users.txt", true);
                    // Open the file.
                    PrintWriter outputFile = new PrintWriter(fileWriter);
                    outputFile.print(usrTextField.getText());
                    outputFile.print(" ");
                    outputFile.println(pwTextField.getText());
                    outputFile.close();
                    System.out.println("Data written to the file.");
                    labelStatus.setText("Status: Success");

                }
                catch (IOException io){System.out.println("Error: " + io.getMessage());}
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
class CreateAccountFormDemo
{
    //main() method start
    public static void main(String arg[])
    {
        //create instance of the CreateLoginForm
        CreateAccount form = new CreateAccount();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setSize(300,220);  //set size of the frame
        form.setVisible(true);  //make form visible to the user

    }
}