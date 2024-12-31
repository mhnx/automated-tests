package dev.main.business;

import dev.main.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// SUT - System Under Test
public class CourseBusiness {

    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student) {

        var filteredCourses = new ArrayList<String>();
        var allCourses = service.retrieveCourses(student);

        for (String course : allCourses) {
            if (course.contains("Spring")) {
                filteredCourses.add(course);
            }
        }

        return filteredCourses;
    }
}
