
package gui.login;

import filehandler.DataManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.people.Student;
import repository.CampusRepository;

public class LoginFrame extends JFrame implements ActionListener
{

    JTextField usernameField;
    JPasswordField passwordField;

    JRadioButton studentBtn, teacherBtn, adminBtn;

    ButtonGroup group;

    JButton loginButton;

    JLabel titleLabel, userLabel, passLabel, roleLabel;

    public LoginFrame()
    {

        setTitle("Smart Campus Management System");

        setSize(400, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 2, 10, 10));


        titleLabel = new JLabel(
                "Smart Campus Login",
                JLabel.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );


        userLabel = new JLabel("Username:");
        usernameField = new JTextField();


        passLabel = new JLabel("Password:");
        passwordField = new JPasswordField();


        roleLabel = new JLabel("Select Role:");


        studentBtn = new JRadioButton("Student");
        teacherBtn = new JRadioButton("Teacher");
        adminBtn   = new JRadioButton("Admin");


        group = new ButtonGroup();

        group.add(studentBtn);
        group.add(teacherBtn);
        group.add(adminBtn);


        studentBtn.setSelected(true);


        loginButton = new JButton("Login");

        loginButton.addActionListener(this);


        add(titleLabel);
        add(new JLabel());

        add(userLabel);
        add(usernameField);

        add(passLabel);
        add(passwordField);

        add(roleLabel);
        add(new JLabel());

        add(studentBtn);
        add(teacherBtn);

        add(adminBtn);
        add(new JLabel());

        add(new JLabel());
        add(loginButton);


        setVisible(true);
    }



    @Override
    @SuppressWarnings("unchecked")

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == loginButton)
        {

            String username =usernameField.getText().trim();

            String password =new String(passwordField.getPassword());


          
            if(username.isEmpty() || password.isEmpty())
            {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }
            String role = "";

            if(studentBtn.isSelected())
            {
                role = "Student";
            }

            else if(teacherBtn.isSelected())
            {
                role = "Teacher";
            }

            else if(adminBtn.isSelected())
            {
                role = "Admin";
            }


            if(role.equals("Admin") &&
                    username.equals("admin") &&
                    password.equals("1234"))
            {

                JOptionPane.showMessageDialog(
                        this,
                        "Welcome Admin!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                dispose();

        
                new gui.dashboard.DashboardFrame("Admin");
            }


            else if(role.equals("Teacher") &&
                    username.equals("teacher") &&
                    password.equals("1234"))
            {

                JOptionPane.showMessageDialog(
                        this,
                        "Welcome Teacher!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                dispose();

                new gui.dashboard.DashboardFrame("Teacher");
            }



            else if(role.equals("Student"))
            {

                Object obj = DataManager.loadData("students.dat");


                if(obj != null)
                {

                    CampusRepository<Student> repo =(CampusRepository<Student>) obj;

                    boolean found = false;


                    for(int i = 0; i < repo.getSize(); i++)
                    {

                        Student s = repo.get(i);


                        if(s.getPersonID().equalsIgnoreCase(username)&&s.getPassword().equals(password))
                        {

                            found = true;


                            JOptionPane.showMessageDialog(this,"Welcome " + s.getName() + "!","Success",JOptionPane.INFORMATION_MESSAGE);

                            dispose();


                         
                            new gui.dashboard.DashboardFrame("Student",s);

                            break;
                        }
                    }


                    if(!found)
                    {

                        JOptionPane.showMessageDialog(
                                this,
                                "Invalid Student ID or Password!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }

                }

                else
                {

                    JOptionPane.showMessageDialog(
                            this,
                            "No student data found!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            else
            {

                JOptionPane.showMessageDialog(
                        this,
                        "Wrong username or password!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }



    public static void main(String[] args)
    {

        SwingUtilities.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new LoginFrame();
                    }
                }
        );
    }
}

