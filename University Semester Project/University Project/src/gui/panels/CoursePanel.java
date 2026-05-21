
package gui.panels;

import filehandler.DataManager;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
import models.academic.Course;
import repository.CampusRepository;

public class CoursePanel extends JFrame implements ActionListener, Serializable
{

    JTextField codeField;
    JTextField nameField;
    JTextField teacherField;
    JTextField creditField;
    JTextField scheduleField;
    JTextField studentsField;

    JButton addBtn;
    JButton deleteBtn;
    JButton saveBtn;
    JButton loadBtn;
    JButton searchBtn;
    JButton totalBtn;

    JTextArea displayArea;

    CampusRepository<Course> repo = new CampusRepository<>();



    public CoursePanel()
    {

        setTitle("Course Management");

        setSize(650, 650);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());


        loadData();


        JPanel formPanel =new JPanel( new GridLayout(6, 2, 5, 5));

        formPanel.setBorder( BorderFactory.createTitledBorder("Course Details") );


        formPanel.add( new JLabel("Course Code:")
        );

        codeField = new JTextField();

        formPanel.add(codeField);



        formPanel.add(
                new JLabel("Course Name:")
        );

        nameField = new JTextField();

        formPanel.add(nameField);


        formPanel.add(
                new JLabel("Teacher Name:")
        );

        teacherField = new JTextField();

        formPanel.add(teacherField);


        formPanel.add(
                new JLabel("Credit Hours:")
        );

        creditField = new JTextField();

        formPanel.add(creditField);


        formPanel.add(
                new JLabel("Schedule:")
        );

        scheduleField = new JTextField();

        formPanel.add(scheduleField);


        formPanel.add(
                new JLabel("Enrolled Students:")
        );

        studentsField = new JTextField();

        formPanel.add(studentsField);


        add(formPanel, BorderLayout.NORTH);



        displayArea = new JTextArea();

        displayArea.setEditable(false);

        displayArea.setFont(
                new Font("Monospaced", Font.PLAIN, 13)
        );

        JScrollPane scroll =
                new JScrollPane(displayArea);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Courses List"
                )
        );

        add(scroll, BorderLayout.CENTER);


        JPanel btnPanel =
                new JPanel(
                        new FlowLayout()
                );

        addBtn = new JButton("Add");

        deleteBtn = new JButton("Delete");

        saveBtn = new JButton("Save");

        loadBtn = new JButton("Load");

        searchBtn = new JButton("Search");

        totalBtn = new JButton("Total Courses");


        addBtn.addActionListener(this);

        deleteBtn.addActionListener(this);

        saveBtn.addActionListener(this);

        loadBtn.addActionListener(this);

        searchBtn.addActionListener(this);

        totalBtn.addActionListener(this);


        btnPanel.add(addBtn);

        btnPanel.add(deleteBtn);

        btnPanel.add(saveBtn);

        btnPanel.add(loadBtn);

        btnPanel.add(searchBtn);

        btnPanel.add(totalBtn);


        add(btnPanel, BorderLayout.SOUTH);


        refreshDisplay();

        setVisible(true);
    }


    private void addCourse()
    {

        if(codeField.getText().isEmpty()
                ||
           nameField.getText().isEmpty())
        {

            JOptionPane.showMessageDialog(
                    this,
                    "Course Code and Name are required!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        try
        {

            String code =
                    codeField.getText().trim();

            String name =
                    nameField.getText().trim();

            String teacher =
                    teacherField.getText().trim();

            int credits =
                    Integer.parseInt(
                            creditField.getText().trim()
                    );

            String schedule =
                    scheduleField.getText().trim();

            int students =
                    Integer.parseInt(
                            studentsField.getText().trim()
                    );



            // DUPLICATE COURSE CHECK
            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getCourseCode()
                        .equalsIgnoreCase(code))
                {

                    JOptionPane.showMessageDialog(
                            this,
                            "Course Code already exists!",
                            "Duplicate Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }
            }



            Course course =
                    new Course(
                            code,
                            name,
                            teacher,
                            credits,
                            schedule,
                            students
                    );


            repo.add(course);


            saveData();


            refreshDisplay();

            clearFields();


            JOptionPane.showMessageDialog(
                    this,
                    "Course Added Successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }

        catch(NumberFormatException e)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "Credit Hours and Students must be numbers!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }



  
    private void deleteCourse()
    {

        if(repo.getSize() == 0)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "No courses available!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        String code =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Course Code to delete:"
                );


        if(code != null)
        {

            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getCourseCode()
                        .equalsIgnoreCase(code))
                {

                    repo.remove(repo.get(i));


                    saveData();

                    refreshDisplay();


                    JOptionPane.showMessageDialog(
                            this,
                            "Course Deleted Successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    return;
                }
            }


            JOptionPane.showMessageDialog(
                    this,
                    "Course not found!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    private void searchCourse()
    {

        if(repo.getSize() == 0)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "No courses available!"
            );

            return;
        }


        String code =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Course Code:"
                );


        if(code != null)
        {

            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getCourseCode()
                        .equalsIgnoreCase(code))
                {

                    JOptionPane.showMessageDialog(
                            this,
                            repo.get(i).toString()
                    );

                    return;
                }
            }


            JOptionPane.showMessageDialog(
                    this,
                    "Course not found!"
            );
        }
    }


    private void totalCourses()
    {

        JOptionPane.showMessageDialog(
                this,
                "Total Courses: " + repo.getSize()
        );
    }


    private void refreshDisplay()
    {

        displayArea.setText("");


        if(repo.getSize() == 0)
        {

            displayArea.setText(
                    "No Courses Available!"
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
                "courses.dat",
                repo
        );
    }


    @SuppressWarnings("unchecked")

    private void loadData()
    {

        Object obj =
                DataManager.loadData(
                        "courses.dat"
                );


        if(obj != null)
        {

            repo =
                    (CampusRepository<Course>) obj;
        }

        else
        {

            repo =
                    new CampusRepository<>();
        }
    }



    private void clearFields()
    {

        codeField.setText("");

        nameField.setText("");

        teacherField.setText("");

        creditField.setText("");

        scheduleField.setText("");

        studentsField.setText("");
    }


    @Override

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == addBtn)
        {

            addCourse();
        }

        else if(e.getSource() == deleteBtn)
        {

            deleteCourse();
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

            searchCourse();
        }

        else if(e.getSource() == totalBtn)
        {

            totalCourses();
        }
    }
}

