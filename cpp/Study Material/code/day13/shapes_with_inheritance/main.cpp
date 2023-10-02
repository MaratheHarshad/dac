#include <iostream>

#include "shapes_with_inheritance.h"

int main() {
    Object* pObjects[20];
    int objectCount = 0;

    // Create some lines and rectangles in some order
    std::cout << "\nCreating Line\n";
    pObjects[objectCount++] = new Line(0, 0, 1, 1);
    std::cout << "\nCreating Rect\n";
    pObjects[objectCount++] = new Rect(1, 1, 2, 2);
    std::cout << "\nCreating Rect\n";
    pObjects[objectCount++] = new Rect(10, 10, 20, 20);
    std::cout << "\nCreating Line\n";
    pObjects[objectCount++] = new Line(5, 5, 10, 10);

    std::cout << "\nMove first line\n";
    // Move first line
    pObjects[0]->Move(10, 10);

    std::cout << "\nDraw all\n";
    // Draw all objects in the order of creation.
    for (int i = 0; i < objectCount; ++i) {
        // pObjects[i++]->Draw(); // mistake by Navendu Singh sir
        pObjects[i]->Draw();
    }

    std::cout << "\nDelete all\n";
    // Delete the memory for objects created.
    for (int i = 0; i < objectCount; ++i) {
        delete pObjects[i];
    }

    return 0;
}

