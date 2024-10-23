package oop.family_tree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import oop.family_tree.family_tree.FamilyTree;
import oop.family_tree.family_tree.servise.FileOperations;
import oop.family_tree.human.Gender;
import oop.family_tree.human.Human;

public class Main {

    public static void main(String[] args) {

        // Создаем людей
        FamilyTree familyTree = new FamilyTree();

        Human human = new Human("Сын", Gender.Male, LocalDate.of(1990, 05, 06));
        Human human1 = new Human("Мама", Gender.Female, LocalDate.of(1969, 03, 06));
        Human human2 = new Human("Папа", Gender.Male, LocalDate.of(1964, 01, 28));
        Human human3 = new Human("Дочь", Gender.Male, LocalDate.of(2002, 8, 23));
        Human human4 = new Human("Бабушка", Gender.Female, LocalDate.of(1941, 10, 10));

        // Добавляем родственные связи
        human.setMather(human1);
        human1.addChild(human);
        human.setFather(human2);
        human2.addChild(human);

        human3.setMather(human1);
        human1.addChild(human3);
        human3.setFather(human2);
        human2.addChild(human3);

        human2.setFather(human4);
        human4.addChild(human2);

        // Добавляем людей в древо
        familyTree.addPerson(human);
        familyTree.addPerson(human1);
        familyTree.addPerson(human2);
        familyTree.addPerson(human3);
        familyTree.addPerson(human4);

        // Поиск человека по имени
        familyTree.getChildren(human1);
        Human person = familyTree.findPersonByName("Бабушка");
        if (person != null) {
            person.getFullInfo();
        }

        // Получаем список детей
        List<Human> childrens = familyTree.getChildren(human4);
        System.out.println("Дети " + human4.getName() + " :");
        for (Human child : childrens) {
            System.out.printf(child.getName() + " ");
        }
        System.out.println();
        System.out.println("================================ ");

        // Вывод списка людей в древе
        List<Human> peoples = familyTree.getPeople();
        for (Human people : peoples) {
            System.out.println(people.getName() + " родился(ась) в " + people.getBirthDate().getYear() + " году");
        }
        System.out.println("================================ ");

        // Сортируем по имени
        System.out.println("Сортировка по имени:");
        familyTree.sortByName();
        for (Human people : familyTree) {
            System.out.println(people.getName() + " родился(ась) в " + people.getBirthDate().getYear() + " году");
        }
        System.out.println("================================ ");

        // Сортируем по дате рождения
        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthYear();
        for (Human people : familyTree) {
            System.out.println(people.getName() + " родился(ась) в " + people.getBirthDate().getYear() + " году");
        }
        System.out.println("================================ ");

        // сохраняем семейное древо в файл
        FileOperations fileOperations = new FileOperations();
        try {
            fileOperations.saveToFile(familyTree, "familyTree.dat");
            System.out.println("Семейное древо сохранено в файл 'familyTree.dat'.");
            System.out.println("================================ ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Загружаем семейное древо из файла
        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree = fileOperations.loadFromFile("familyTree.dat");
            System.out.println("Семейное дерево загружено из файла.");
            System.out.println("================================ ");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            List<Human> loadedPeople = loadedFamilyTree.getPeople();

            System.out.println("Список загруженных людей: ");
            for (Human people : loadedPeople) {
                System.out.println(people.getName() + " родился(ась) в " + people.getBirthDate().getYear() + " году");
            }
            System.out.println("================================ ");
        }

    }
}
