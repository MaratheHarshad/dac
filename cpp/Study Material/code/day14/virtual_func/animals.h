class Animals { // Abstract class due to pure virtual function
    int i;
public:
    virtual const char* getName() const  = 0; // Pure virtual    
};

class Lion : public Animals {
    int j;
public:
    const char* getName() const;    
};

class Rat : public Animals {
    int j;
public:
    const char* getName() const;    
};