package utils;

import models.people.Student;
import models.people.Teacher;
import models.people.Admin;
import models.academic.Course;
import models.academic.Department;
import models.facility.Library;
import models.facility.Book;
import repository.CampusRepository;
import filehandler.DataManager;
import java.io.File;

public class DataInitializer
{
    public static void initializeData()
    {
        if(!new File("students.dat").exists())
        {
            CampusRepository<Student> studentRepo = new CampusRepository<>();

            studentRepo.add(new Student("S001", "Ali Hassan", "ali@campus.edu", "pass123", "0301-1234567", "3rd", 3.75, "Computer Science"));

            studentRepo.add(new Student("S002", "Sara Ahmed", "sara@campus.edu", "pass123", "0302-2345678", "2nd", 3.50, "Software Engineering"));

            studentRepo.add(new Student("S003", "Usman Khan", "usman@campus.edu", "pass123", "0303-3456789", "4th", 3.90, "Computer Science"));

            studentRepo.add(new Student("S004", "Fatima Malik", "fatima@campus.edu", "pass123", "0304-4567890", "1st", 3.20, "Mathematics"));

            studentRepo.add(new Student("S005", "Ahmed Raza", "ahmed@campus.edu", "pass123", "0305-5678901", "3rd", 3.60, "Physics"));

            DataManager.saveData("students.dat", studentRepo);
            System.out.println("Students initialized!");
        }


        if(!new File("courses.dat").exists())
        {
            CampusRepository<Course> courseRepo =
                    new CampusRepository<>();

            courseRepo.add(new Course("CS101", "Object Oriented Programming", "Dr. Ahmed Khan", 3, "Mon/Wed 9:00-10:30", 45));

            courseRepo.add(new Course("CS102", "Data Structures", "Dr. Sara Ali", 3, "Tue/Thu 11:00-12:30", 38));

            courseRepo.add(new Course("CS103", "Database Systems", "Dr. Usman Malik", 3, "Mon/Wed 2:00-3:30", 42));

            courseRepo.add(new Course("CS104", "Software Engineering", "Dr. Fatima Khan", 3, "Tue/Thu 9:00-10:30", 35));

            courseRepo.add(new Course("CS105", "Computer Networks", "Dr. Ali Hassan", 3, "Mon/Wed 11:00-12:30", 40));

            DataManager.saveData("courses.dat", courseRepo);
            System.out.println("Courses initialized!");
        }


        if(!new File("facilities.dat").exists())
        {
            CampusRepository<Library> facilityRepo =
                    new CampusRepository<>();

            Library lib1 = new Library("L001", "Main Library", "Block A", 5000.0, 150, 5000, 800);

            lib1.addBook(new Book("B001", "Java Programming", "James Gosling"));
            lib1.addBook(new Book("B002", "OOP Concepts", "Grady Booch"));

            Library lib2 = new Library("L002", "Science Library", "Block B", 3000.0, 100, 3000, 400);

            lib2.addBook(new Book("B003", "Data Structures", "Robert Lafore"));

            Library lib3 = new Library("L003", "Engineering Library", "Block C", 4000.0, 120, 4000, 600);

            Library lib4 = new Library("L004", "Digital Library", "Block D", 6000.0, 200, 8000, 1000);

            Library lib5 = new Library("L005", "Research Library", "Block E", 7000.0, 180, 10000, 1200);

            facilityRepo.add(lib1);
            facilityRepo.add(lib2);
            facilityRepo.add(lib3);
            facilityRepo.add(lib4);
            facilityRepo.add(lib5);

            DataManager.saveData("facilities.dat", facilityRepo);
            System.out.println("Facilities initialized!");
        }
    }
}
