package dev.maia.business;

import dev.main.business.CourseBusiness;
import dev.main.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CourseBusinessMockTest {

    CourseService serviceMock;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setup() {
        serviceMock = mock(CourseService.class);
        business = new CourseBusiness(serviceMock);
        courses = List.of(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void shouldRetrieveCoursesRelatedToSpringUsingAStub() {

        // When / Act
        when(serviceMock.retrieveCourses("Marco"))
                .thenReturn(courses);

        var filteredCourses = business.retrieveCoursesRelatedToSpring("Marco");

        // Then / Assert
        assertEquals(4, filteredCourses.size());
    }

    @Test
    @DisplayName("Should delete courses not related to Spring")
    void shouldDeleteCoursesNotRelatedToSpring() {

        given(serviceMock.retrieveCourses("Marco")).willReturn(courses);

        business.deleteCoursesNotRelatedToSpring("Marco");

        verify(serviceMock).deleteCourse("Spotify Engineering Culture Desmistificado");
        verify(serviceMock, never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
        verify(serviceMock, times(1)).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
        verify(serviceMock, atLeast(1)).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
        verify(serviceMock, atLeastOnce()).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
    }
}
