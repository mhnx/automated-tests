package dev.maia;

import dev.maia.models.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {

    Person person;

    static IPersonService service;

    @BeforeAll
    static void setup() {
        service = new PersonService();
    }

    @BeforeEach
    void instantiateAPersonObject() {
        person = new Person("Keith", "Moon", "kmoon@mail.com", "Sheffield, EN", "M");
    }

    @DisplayName("When Create a Person With Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "createPerson() should not have returned null");
    }

    @DisplayName("When Create a Person With Success Should Contains firstName In Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual.getFirstName(), () -> "createPerson() should not have returned null");
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The first name is different!");
    }

    @Test
    @DisplayName("When Create a Person With Success Should Contains lastName In Returned Person Object")
    void shouldVerifyAPersonContainsLastNameField() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(person.getLastName(), actual.getLastName());
    }

    @Test
    @DisplayName("When Create a Person With Success Should Contains email In Returned Person Object")
    void shouldVerifyAPersonContainsEmailField() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(person.getEmail(), actual.getEmail());
    }

    @Test
    @DisplayName("When Create a Person With Success Should Contains city In Returned Person Object")
    void shouldVerifyAPersonContainsCityField() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(person.getCity(), actual.getCity());
    }

    @Test
    @DisplayName("When Create a Person With Success Should Contains gender In Returned Person Object")
    void shouldVerifyAPersonContainsGenderField() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(person.getGender(), actual.getGender());
    }

    @Test
    @DisplayName("When Create a Person With Success Should Contains id In Returned Person Object")
    void shouldVerifyAPersonContainsIdField() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual.getId(), () -> "Person ID is missing!");
    }

    @Test
    @DisplayName("Should Throw IllegalArgumentException When Email Is Missing")
    void shouldThrowIllegalArgumentExceptionWhenEmailIsMissing() {

        person.setEmail(null);

        var exceptionMessage = assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person));

        assertEquals("Email is null or empty!", exceptionMessage.getMessage());
    }
}
