package oop.family_tree.family_tree.servise;

import java.io.IOException;

import oop.family_tree.family_tree.FamilyTree;

interface FileOperationsInterface {
    void saveToFile(FamilyTree familyTree, String fileName) throws IOException;

    FamilyTree loadFromFile(String fileName) throws IOException,
            ClassNotFoundException;
}
