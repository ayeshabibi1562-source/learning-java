
package models.academic;

import interfaces.Schedulable;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable, Schedulable
{

    private static final long serialVersionUID = 1L;




    private final String courseCode;

    private String courseName;

    private String teacherName;

    private final int creditHours;

    private String schedule;

    private int enrolledStudents;

    private ArrayList<Assignment> assignments =
            new ArrayList<>();




    public Course(
            String courseCode,
            String courseName,
            String teacherName,
            int creditHours,
            String schedule,
            int enrolledStudents
    )
    {

        this.courseCode = courseCode;

        this.courseName = courseName;

        this.teacherName = teacherName;

        this.creditHours = creditHours;

        this.schedule = schedule;

        this.enrolledStudents = enrolledStudents;
    }




    public String getCourseCode()
    {

        return courseCode;
    }



    public String getCourseName()
    {

        return courseName;
    }



    public String getTeacherName()
    {

        return teacherName;
    }



    public int getCreditHours()
    {

        return creditHours;
    }



    public String getSchedule()
    {

        return schedule;
    }



    public int getEnrolledStudents()
    {

        return enrolledStudents;
    }



    public ArrayList<Assignment> getAssignments()
    {

        return assignments;
    }



    public int getAssignmentCount()
    {

        return assignments.size();
    }




    public void setCourseName(String courseName)
    {

        this.courseName = courseName;
    }



    public void setTeacherName(String teacherName)
    {

        this.teacherName = teacherName;
    }



    public void setSchedule(String schedule)
    {

        this.schedule = schedule;
    }



    public void setEnrolledStudents(int enrolledStudents)
    {

        this.enrolledStudents = enrolledStudents;
    }



    

    public void enrollStudent()
    {

        enrolledStudents++;
    }



    public void dropStudent()
    {

        if(enrolledStudents > 0)
        {

            enrolledStudents--;
        }
    }




    public void addAssignment(Assignment assignment)
    {

        assignments.add(assignment);
    }



    public void removeAssignment(Assignment assignment)
    {

        assignments.remove(assignment);
    }



  
    @Override

    public String generateSchedule()
    {

        return
                "Course: " + courseName
                + " | Schedule: " + schedule
                + " | Teacher: " + teacherName;
    }




    @Override

    public String toString()
    {

        return
                "Course Code: " + courseCode
                + " | Name: " + courseName
                + " | Teacher: " + teacherName
                + " | Credits: " + creditHours
                + " | Schedule: " + schedule
                + " | Enrolled Students: " + enrolledStudents
                + " | Assignments: " + assignments.size();
    }
}
