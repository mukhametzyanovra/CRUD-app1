package ru.mukhametzyanov.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.mukhametzyanov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;

    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ruslan"));
        people.add(new Person(++PEOPLE_COUNT, "Dzhamil"));
        people.add(new Person(++PEOPLE_COUNT, "Iskander"));
        people.add(new Person(++PEOPLE_COUNT, "Iskander2"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
