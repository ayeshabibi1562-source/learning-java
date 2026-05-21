
package gui.panels;

import filehandler.DataManager;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
import models.people.Student;
import repository.CampusRepository;

public class StudentPanel extends JFrame implements ActionListener, Serializable
{



    JTextField idField;
    JTextField nameField;
    JTextField emailField;
    JTextField semesterField;
    JTextField gpaField;
    JTextField departmentField;

    JPasswordField passwordField;

    JButton addBtn;
    JButton deleteBtn;
    JButton saveBtn;
    JButton loadBtn;
    JButton searchBtn;
    JButton totalSBtn;

    JTextArea displayArea;

    CampusRepository<Student> repo =new CampusRepository<>();



    public StudentPanel()
    {

        setTitle("Student Management");

        setSize(550, 650);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLayout(new BorderLayout());

        loadData();

        JPanel formPanel =
                new JPanel(
                        new GridLayout(
                                7,
                                2,
                                5,
                                5
                        )
                );

        formPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Student Details"
                )
        );



        
        formPanel.add(
                new JLabel("Student ID:")
        );

        idField = new JTextField();

        formPanel.add(idField);


        formPanel.add(
                new JLabel("Name:")
        );

        nameField = new JTextField();

        formPanel.add(nameField);




        formPanel.add(
                new JLabel("Email:")
        );

        emailField = new JTextField();

        formPanel.add(emailField);


        formPanel.add(
                new JLabel("Password:")
        );

        passwordField =
                new JPasswordField();

        formPanel.add(passwordField);


        formPanel.add(
                new JLabel("Semester:")
        );

        semesterField =
                new JTextField();

        formPanel.add(semesterField);


        formPanel.add(
                new JLabel("GPA:")
        );

        gpaField =
                new JTextField();

        formPanel.add(gpaField);


        formPanel.add(
                new JLabel("Department:")
        );

        departmentField =
                new JTextField();

        formPanel.add(departmentField);



        add(formPanel, BorderLayout.NORTH);


        displayArea =
                new JTextArea();

        displayArea.setEditable(false);

        JScrollPane scroll =
                new JScrollPane(displayArea);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Students List"
                )
        );

        add(scroll, BorderLayout.CENTER);


        JPanel btnPanel =
                new JPanel(
                        new FlowLayout()
                );

        addBtn =
                new JButton("Add");

        deleteBtn =
                new JButton("Delete");

        saveBtn =
                new JButton("Save");

        loadBtn =
                new JButton("Load");

        searchBtn =
                new JButton("Search");

        totalSBtn =
                new JButton("Total Students");



        addBtn.addActionListener(this);

        deleteBtn.addActionListener(this);

        saveBtn.addActionListener(this);

        loadBtn.addActionListener(this);

        searchBtn.addActionListener(this);

        totalSBtn.addActionListener(this);


        btnPanel.add(addBtn);

        btnPanel.add(deleteBtn);

        btnPanel.add(saveBtn);

        btnPanel.add(loadBtn);

        btnPanel.add(searchBtn);

        btnPanel.add(totalSBtn);

        add(btnPanel, BorderLayout.SOUTH);


        refreshDisplay();

        setVisible(true);
    }


    private void addStudent()
    {

        if(idField.getText().isEmpty()
                ||
           nameField.getText().isEmpty()
                ||
           passwordField.getPassword().length == 0)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "ID, Name and Password are required!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        try
        {

            String id =
                    idField.getText().trim();

            String name =
                    nameField.getText().trim();

            String email =
                    emailField.getText().trim();

            String password =
                    new String(
                            passwordField.getPassword()
                    );

            String semester =
                    semesterField.getText().trim();

            double gpa =
                    Double.parseDouble(
                            gpaField.getText().trim()
                    );

            String department =
                    departmentField.getText().trim();

            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getPersonID()
                        .equalsIgnoreCase(id))
                {

                    JOptionPane.showMessageDialog(
                            this,
                            "Student ID already exists!",
                            "Duplicate Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }
            }

            Student student =
                    new Student(
                            id,
                            name,
                            email,
                            password,
                            "0000",
                            semester,
                            gpa,
                            department
                    );



            repo.add(student);

            saveData();


            refreshDisplay();

            clearFields();



            JOptionPane.showMessageDialog( this, "Student Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        }

        catch(NumberFormatException e)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "GPA must be numeric!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }



  

    private void deleteStudent()
    {

        if(repo.getSize() == 0)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "No students available!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }



        String id =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Student ID to delete:"
                );



        if(id != null)
        {

            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getPersonID()
                        .equalsIgnoreCase(id))
                {

                    repo.remove(repo.get(i));

                    saveData();

                    refreshDisplay();



                    JOptionPane.showMessageDialog(
                            this,
                            "Student Deleted Successfully!"
                    );

                    return;
                }
            }



            JOptionPane.showMessageDialog(
                    this,
                    "Student ID not found!"
            );
        }
    }



    private void searchData()
    {

        if(repo.getSize() == 0)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "No students available!"
            );

            return;
        }



        String id =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Student ID:"
                );



        if(id != null)
        {

            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getPersonID()
                        .equalsIgnoreCase(id))
                {

                    JOptionPane.showMessageDialog(
                            this,
                            repo.get(i).toString(),
                            "Student Found",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    return;
                }
            }



            JOptionPane.showMessageDialog(
                    this,
                    "Student not found!"
            );
        }
    }


    private void totalStudent()
    {

        JOptionPane.showMessageDialog(
                this,
                "Total Students: "
                        + repo.getSize()
        );
    }



    private void refreshDisplay()
    {

        displayArea.setText("");



        if(repo.getSize() == 0)
        {

            displayArea.setText(
                    "No Students Available!"
            );

            return;
        }



        for(int i = 0; i < repo.getSize(); i++)
        {

            displayArea.append(
                    repo.get(i).toString()
                            + "\n\n"
            );
        }
    }


    private void saveData()
    {

        DataManager.saveData(
                "students.dat",
                repo
        );
    }



    @SuppressWarnings("unchecked")

    private void loadData()
    {

        Object obj =
                DataManager.loadData(
                        "students.dat"
                );



        if(obj != null)
        {

            repo =
                    (CampusRepository<Student>)
                            obj;
        }

        else
        {

            repo =
                    new CampusRepository<>();
        }
    }


    private void clearFields()
    {

        idField.setText("");

        nameField.setText("");

        emailField.setText("");

        passwordField.setText("");

        semesterField.setText("");

        gpaField.setText("");

        departmentField.setText("");
    }



    @Override

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == addBtn)
        {

            addStudent();
        }

        else if(e.getSource() == deleteBtn)
        {

            deleteStudent();
        }

        else if(e.getSource() == saveBtn)
        {

            saveData();

            JOptionPane.showMessageDialog(
                    this,
                    "Data Saved Successfully!"
            );
        }

        else if(e.getSource() == loadBtn)
        {

            loadData();

            refreshDisplay();

            JOptionPane.showMessageDialog(
                    this,
                    "Data Loaded Successfully!"
            );
        }

        else if(e.getSource() == searchBtn)
        {

            searchData();
        }

        else if(e.getSource() == totalSBtn)
        {

            totalStudent();
        }
    }
}

