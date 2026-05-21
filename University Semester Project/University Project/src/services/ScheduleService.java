package services;

import models.academic.Course;
import repository.CampusRepository;
import java.util.ArrayList;

public class ScheduleService
{

    public static boolean hasConflict(CampusRepository<Course> repo, String newSchedule, String newTeacher)
    {

        for(int i = 0; i < repo.getSize(); i++)
        {
            Course existing = repo.get(i);

            if(existing.getSchedule().equals(newSchedule) && existing.getTeacherName().equals(newTeacher))
            {

                return true;
            }
        }
        return false;

    }

    public static String getAllSchedules(CampusRepository<Course> repo)
    {
        if(repo.getSize() == 0)
        {
            return "No courses scheduled yet!";
        }

        String result = " ALL SCHEDULES \n";
        for(int i = 0; i < repo.getSize(); i++)
        {
            result += repo.get(i).generateSchedule() + "\n";
        }
        return result;
    }
}