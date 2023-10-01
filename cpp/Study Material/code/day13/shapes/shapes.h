struct Point {
    int x;
    int y;
};

class Line {
    Point pts[2];
public:
    Line(int x1, int y1, int x2, int y2);
    ~Line();
    void Move(int cx, int cy);
    void Draw();
};

class Rect {
    Point pts[2];
public:
    Rect(int x1, int y1, int x2, int y2);
    ~Rect();
    void Move(int cx, int cy);
    void Draw();
};
