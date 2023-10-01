#include <iostream>

#include "shapes.h"

int main() {
    Line* pLines[10];
    int lineCount = 0;

    Rect* pRects[10];
    int rectCount = 0;

    std::cout << "\nCreating objects\n";
    // Create some objects.
    pLines[lineCount] = new Line(0, 0, 1, 1);
    ++lineCount;
    pLines[lineCount] = new Line(2, 2, 3, 3);
    ++lineCount;

    pRects[rectCount] = new Rect(10, 10, 20, 20);
    ++rectCount;

    std::cout << "\nDrawing objects\n";
    // Draw first line and rect
    pLines[0]->Draw();
    pRects[0]->Draw();

    std::cout << "\nDeleting objects\n";
    // Delete the memory for objects created.
    for (int i = 0; i < lineCount; ++i)
        delete pLines[i];
    for (int i = 0; i < rectCount; ++i)
        delete pRects[i];

    return 0;
}

