#include <iostream>

#include "shapes_with_inheritance.h"

Object::Object(int x1, int y1, int x2, int y2) {
    std::cout << "Object::Object()\n";
}
Object::~Object() {
    std::cout << "Object::~Object()\n";
}
void Object::Move(int cx, int cy) {
    std::cout << "Object::Move()\n";
}
void Object::Draw() {
    std::cout << "Object::Draw()\n";
}

Line::Line(int x1, int y1, int x2, int y2) : Object(x1, y1, x2, y2) {
    std::cout << "Line::Line()\n";
}
Line::~Line() {
    std::cout << "Line::~Line()\n";
}
void Line::Draw() {
    std::cout << "Line::Draw()\n";
}

Rect::Rect(int x1, int y1, int x2, int y2) : Object(x1, y1, x2, y2) {
    std::cout << "Rect::Rect()\n";
}
Rect::~Rect() {
    std::cout << "Rect::~Rect()\n";
}
void Rect::Draw() {
    std::cout << "Rect::Draw()\n";
}
