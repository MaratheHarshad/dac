#include <iostream>

struct Point {
    int x;
    int y;
};

class Object {
protected:
    Point pts[2];
public:
    Object(int x1, int y1, int x2, int y2);
    virtual ~Object();
    void Move(int cx, int cy);
    virtual void Draw();

    // virtual keyword
    // basically a virtual keyword is used to achieve the run time polymorphism
};

class Line : public Object {
public:
    Line(int x1, int y1, int x2, int y2);
    ~Line();
    void Draw();
};

class Rect : public Object {
public:
    Rect(int x1, int y1, int x2, int y2);
    ~Rect();
    void Draw();
};
