package oop.family_tree.family_tree;

import java.io.IOException;

interface FileOperationsInterface {
    void saveToFile(FamilyTree familyTree, String fileName) throws IOException;

    FamilyTree loadFromFile(String fileName) throws IOException,
            ClassNotFoundException;
}
