package oop.family_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Human {
    private String name;
    private Gender gender;
    private int birthDate;
    private int deathDate;
    private Human mather;
    private Human father;
    private Human spouse;
    private List<Human> children;

    public Human(String name, Gender gender, int birthDate,
            int deathDate, Human mather, Human father, Human spouse) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mather = mather;
        this.father = father;
        this.spouse = spouse;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, int birthDate) {
        this(name, gender, birthDate, 0, null, null, null);
    }
    public Human(String name, Gender gender, int birthDate, int deathDate) {
        this(name, gender, birthDate, deathDate, null, null, null);
    }

    public static Human addHuman() {
        Gender gender = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя человека: ");
        String name = scanner.nextLine();
        System.out.println("Выберите пол:");
        System.out.println("1. Мужской");
        System.out.println("2. Женский");
        String genderString = scanner.nextLine();
        if (Objects.equals("1", genderString)) {
            gender = Gender.Male;
        } else if (Objects.equals("2", genderString)) {
            gender = Gender.Female;
        } else {
            System.out.println("Некорректный ввод! Пол по умолчанию 'Мужской'");
            gender = Gender.Male;
        }

        System.out.print("Год рождения: ");
        int bd = scanner.nextInt();
        System.out.print("Год смерти (укажите 0, если человек жив): ");
        int dy = scanner.nextInt();
        Human human = new Human(name, gender, bd, dy);
        return human;
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
        if (mather != null) {
            System.out.print("Родители: " + mather.getName());
        }
        if (father != null) {
            System.out.println(" " + father.getName());
        }
        if (spouse != null) {
            System.out.println("Супруг: " + spouse.getName());
        }
        if (children != null) {
            System.out.printf("Дети: ");
            for (Human child : children) {
                System.out.printf(child.getName() + " ");
            }
            System.out.println();
        }

        // return "Имя: " + name + "\n" +
        // "Пол: " + gender + "\n" +
        // "Возраст: " + getAge(birthDate, deathDate) + "\n" +
        // "Родители: " + mather.getName() + " " + father.getName() + "\n" +
        // "Супруг: " + spouse.getName() + "\n" +
        // "Дети: " + ((Human) children).getName();

    }

    public int getAge(int birthDate, int deathDate) {
        if (deathDate == 0) {
            LocalDate currentDate = LocalDate.now();
            return currentDate.getYear() - birthDate;
        } else {
            return deathDate - birthDate;
        }
    }

}
