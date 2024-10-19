package oop.family_tree;

import java.util.List;

import oop.family_tree.family_tree.FamilyTree;
import oop.family_tree.human.Gender;
import oop.family_tree.human.Human;

public class Main {

    public static void main(String[] args) {

        //Создаем людей
        FamilyTree familyTree = new FamilyTree();
        Human human = new Human("Сын", Gender.Male, 1990);
        Human human1 = new Human("Мама", Gender.Female, 1969);
        Human human2 = new Human("Папа", Gender.Male, 1964);
        Human human3 = new Human("Дочь", Gender.Male, 2002);
        Human human4 = Human.addHuman();


        // Добавляем родственные связи
        human.setMather(human1);
        human1.addChild(human);
        human.setFather(human2);
        human2.addChild(human);

        human3.setMather(human1);
        human1.addChild(human3);
        human3.setFather(human2);
        human2.addChild(human3);

        human2.setMather(human4);
        human4.addChild(human2);

        //// Вывод информации о людях
        // System.out.println("================================ ");
        // human.getFullInfo();
        // System.out.println("================================ ");
        // human1.getFullInfo();
        // System.out.println("================================ ");
        // human2.getFullInfo();
        // System.out.println("================================ ");
        // human3.getFullInfo();

        // Добавляем людей в древо
        familyTree.addPerson(human);
        familyTree.addPerson(human1);
        familyTree.addPerson(human2);
        familyTree.addPerson(human3);
        familyTree.addPerson(human4);

        //Поиск человека по имени
        familyTree.getChildren(human1);
        Human person = familyTree.findPersonByName("baba");
        if (person != null) {
            person.getFullInfo();
        }
           
        

        // Получаем список детей
        List<Human> johnsChildren = familyTree.getChildren(human4);
        System.out.println("Дети " + human4.getName() + " :");
        for (Human child : johnsChildren) {
            System.out.printf(child.getName() + " ");
        }

    }
}
