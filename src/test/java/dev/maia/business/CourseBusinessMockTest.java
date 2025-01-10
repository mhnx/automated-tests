package dev.maia.business;

import dev.maia.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
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

        // usando then, should e never ao invés do verify
        // porque? eu não sei ainda! kkkkk
        then(serviceMock)
                .should()
                    .deleteCourse("Spotify Engineering Culture Desmistificado");

        then(serviceMock)
                .should(never())
                    .deleteCourse("Microsserviços do 0 com Spring Cloud, Kotlin e Docker");

        then(serviceMock)
                .should(times(1))
                    .deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
    }

    @Test
    @DisplayName("Should test using ArgumentCaptor")
    void testDeleteCoursesWithArgumentCaptor() {
        courses = List.of(
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
        );

        var agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        given(serviceMock.retrieveCourses("Marco")).willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        business.deleteCoursesNotRelatedToSpring("Marco");

        then(serviceMock).should().deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is(agileCourse));
    }

    @Test
    @DisplayName("Should test size using ArgumentCaptor")
    void testDeleteCoursesWithArgumentCaptorAndAssertSize() {

        given(serviceMock.retrieveCourses("Marco")).willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        business.deleteCoursesNotRelatedToSpring("Marco");

        then(serviceMock).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}
