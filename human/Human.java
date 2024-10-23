package oop.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mather;
    private Human father;
    private Human spouse;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate,
            LocalDate deathDate, Human mather, Human father, Human spouse) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mather = mather;
        this.father = father;
        this.spouse = spouse;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name, gender, birthDate, deathDate, null, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getMather() {
        return mather;
    }

    public void setMather(Human mather) {
        this.mather = mather;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public void getFullInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Пол: " + gender);
        System.out.println("Возраст: " + getAge(birthDate, deathDate));

        if (mather != null || father != null) {
            System.out.print("Родители: ");
            if (mather != null) {
                System.out.printf(mather.getName() + " ");
            }
            if (father != null) {
                System.out.println(father.getName());
            }
        }
        if (spouse != null) {
            System.out.println("Супруг: " + spouse.getName());
        }
        if (children.size() > 0) {
            System.out.printf("Дети: ");
            for (Human child : children) {
                System.out.printf(child.getName() + " ");
            }
            System.out.println();
        }
        System.out.println("================================ ");

        // return "Имя: " + name + "\n" +
        // "Пол: " + gender + "\n" +
        // "Возраст: " + getAge(birthDate, deathDate) + "\n" +
        // "Родители: " + mather.getName() + " " + father.getName() + "\n" +
        // "Супруг: " + spouse.getName() + "\n" +
        // "Дети: " + ((Human) children).getName();

    }

    public int getAge(LocalDate birthDate, LocalDate deathDate) {
        if (deathDate == null) {
            LocalDate currentDate = LocalDate.now();
            return currentDate.getYear() - birthDate.getYear();
        } else {
            return deathDate.getYear() - birthDate.getYear();
        }
    }

}
