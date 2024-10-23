package oop.family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import oop.family_tree.human.Human;

public class FamilyTree implements Serializable, Iterable<Human> {

    private static final long serialVersionUID = 1L;

    private List<Human> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Human human) {
        this.people.add(human);
    }

    public List<Human> getChildren(Human parent) {
        return parent.getChildren();
    }

    public List<Human> getPeople() {
        return people;
    }

    public Human findPersonByName(String name) {
        for (Human person : people) {
            if (person.getName().equals(name)) {
                System.out.println("Человек найден");
                return person;
            }
        }
        System.out.println("Нет совпадений");
        return null;
    }

    @Override
    public Iterator<Human> iterator() {
        return people.iterator();
    }

    public void sortByName() {
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void sortByBirthYear() {
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.getBirthDate().getYear(), p2.getBirthDate().getYear()));
    }
}
