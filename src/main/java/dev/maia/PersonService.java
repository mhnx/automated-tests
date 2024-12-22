package dev.maia;

import dev.maia.models.Person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {

    @Override
    public Person createPerson(Person person) {

        person.setId(new AtomicLong().incrementAndGet());

        if (person.getEmail() == null || person.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is null or empty!");
        }

        return person;
    }
}
