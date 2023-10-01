#include <iostream>

#include "shapes.h"

Line::Line(int x1, int y1, int x2, int y2) {
    std::cout << "Line::Line()\n";
}
Line::~Line() {
    std::cout << "Line::~Line()\n";
}
void Line::Move(int cx, int cy) {
    std::cout << "Line::Move()\n";
}
void Line::Draw() {
    std::cout << "Line::Draw()\n";
}

Rect::Rect(int x1, int y1, int x2, int y2) {
    std::cout << "Rect::Rect()\n";
}
Rect::~Rect() {
    std::cout << "Rect::~Rect()\n";
}
void Rect::Move(int cx, int cy) {
    std::cout << "Rect::Move()\n";
}
void Rect::Draw() {
    std::cout << "Rect::Draw()\n";
}

