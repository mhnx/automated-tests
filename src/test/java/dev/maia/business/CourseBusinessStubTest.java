package dev.maia.business;

import dev.maia.service.stubs.CourseServiceStub;
import dev.main.business.CourseBusiness;
import dev.main.service.CourseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseBusinessStubTest {

    @Test
    void shouldRetrieveCoursesRelatedToSpringUsingAStub() {
        // Given / Arrange
        CourseService serviceStub = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(serviceStub);

        // When / Act
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Marco");

        // Then / Assert
        assertEquals(4, filteredCourses.size());
    }
}
