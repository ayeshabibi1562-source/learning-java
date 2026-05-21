
package gui.dashboard;

import filehandler.DataManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.academic.Course;
import models.facility.Library;
import models.people.Student;
import repository.CampusRepository;

public class DashboardFrame extends JFrame
        implements ActionListener
{

    String role;

    Student loggedInStudent;

    JButton studentBtn;
    JButton courseBtn;
    JButton facilityBtn;
    JButton mapBtn;
    JButton logoutBtn;

    Timer autoSave;


    private int totalStudents = 0;

    private int totalCourses = 0;

    private int totalFacilities = 0;


    public DashboardFrame(String role)
    {

        this(role, null);
    }



    public DashboardFrame(String role,Student student)
    {

        this.role = role;

        this.loggedInStudent = student;

        loadStatistics();


        setTitle("Smart Campus Management System");

        setSize(500, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 1, 10, 10)
        );


    String welcomeText ="Welcome " + role + "!";

        if(loggedInStudent != null)
        {

            welcomeText ="Welcome "+ loggedInStudent.getName()+ "!";
        }

        JLabel welcomeLabel =new JLabel(welcomeText,JLabel.CENTER);

        welcomeLabel.setFont(new Font( "Arial", Font.BOLD, 20));

        welcomeLabel.setOpaque(true);

        welcomeLabel.setBackground(new Color(44, 62, 80));

        welcomeLabel.setForeground(Color.WHITE);

        add(welcomeLabel);


      JLabel statsLabel =new JLabel("Students: " + totalStudents+ " | Courses: "+ totalCourses+ " | Facilities: "+ totalFacilities,JLabel.CENTER);

        statsLabel.setFont(new Font("Arial",Font.PLAIN,13));

        statsLabel.setOpaque(true);

        statsLabel.setBackground(new Color(52, 73, 94));

        statsLabel.setForeground(Color.WHITE);

        add(statsLabel);


        studentBtn =createButton("Manage Students",new Color(39, 174, 96));

        courseBtn =createButton("Manage Courses",new Color(41, 128, 185));

        facilityBtn =createButton("Manage Facilities",new Color(142, 68, 173));

        mapBtn =createButton("Campus Map",new Color(243, 156, 18));

        logoutBtn =createButton("Logout",new Color(192, 57, 43));



        studentBtn.addActionListener(this);

        courseBtn.addActionListener(this);

        facilityBtn.addActionListener(this);

        mapBtn.addActionListener(this);

        logoutBtn.addActionListener(this);


        add(studentBtn);

        add(courseBtn);

        add(facilityBtn);

        add(mapBtn);

        add(logoutBtn);



        if(role.equalsIgnoreCase("Student"))
        {

            studentBtn.setText("My Profile");

            courseBtn.setEnabled(false);

            facilityBtn.setEnabled(false);

            mapBtn.setEnabled(true);
        }

        else if(role.equalsIgnoreCase("Teacher"))
        {

            studentBtn.setEnabled(true);

            courseBtn.setEnabled(true);

           facilityBtn.setEnabled(false);

           mapBtn.setEnabled(true);
        }


        autoSave =
                new Timer(60000,new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {

                                System.out.println("Auto saving data...");
                            }
                        }
                );

        autoSave.start();



        addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent e)
                    {

                        autoSave.stop();

                        System.out.println("Saving before close...");
                    }
                }
        );



        setVisible(true);
    }


    @SuppressWarnings("unchecked")

    private void loadStatistics()
    {


        Object studentObj =
                DataManager.loadData("students.dat");

        if(studentObj != null)
        {

            CampusRepository<Student> studentRepo =(CampusRepository<Student>)studentObj;

            totalStudents =studentRepo.getSize();
        }


        Object courseObj =
                DataManager.loadData("courses.dat");

        if(courseObj != null)
        {

            CampusRepository<Course> courseRepo =(CampusRepository<Course>)
                            courseObj;

            totalCourses =courseRepo.getSize();
        }


        Object facilityObj = DataManager.loadData("facilities.dat");

        if(facilityObj != null)
        {

            CampusRepository<Library> facilityRepo =(CampusRepository<Library>)facilityObj;

            totalFacilities =facilityRepo.getSize();
        }
    }



    // ================= BUTTON METHOD =================
    private JButton createButton(String text,Color color)
    {

        JButton btn = new JButton(text);

        btn.setBackground(color);

        btn.setForeground(Color.WHITE);

        btn.setFont(
                new Font( "Arial", Font.BOLD, 14)
        );

        btn.setFocusPainted(false);

        btn.setOpaque(true);

        return btn;
    }


    @Override

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == studentBtn)
{
    if(role.equalsIgnoreCase("Student"))
    {
     
        JOptionPane.showMessageDialog(this,loggedInStudent.toString(),"My Profile",JOptionPane.INFORMATION_MESSAGE);
    }
    else if(role.equalsIgnoreCase("Admin"))
    {
       
        new gui.panels.StudentPanel();
    }
    else if(role.equalsIgnoreCase("Teacher"))
    {
     
        new gui.panels.StudentPanel();
    }
}



      

        else if(e.getSource() == courseBtn)
        {

            new gui.panels.CoursePanel();
        }



        else if(e.getSource() == facilityBtn)
        {

            new gui.panels.FacilityPanel();
        }



        else if(e.getSource() == mapBtn)
        {

            new gui.panels.CampusMapPanel();
        }



        else if(e.getSource() == logoutBtn)
        {

            autoSave.stop();

            dispose();

            new gui.login.LoginFrame();
        }
    }
}
