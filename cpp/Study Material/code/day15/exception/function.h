int sumDigits(int num);
void onlyPositiveAllowed(int num) /*noexcept*/;

class InvalidCharException {
    const char *msg;
public:
    InvalidCharException(const char *m);
    const char* getMessage() const;
};

void onlyLowerCase(char ch) throw(InvalidCharException);

void testF1();
void testF2();
void testF3();
void testF4();
