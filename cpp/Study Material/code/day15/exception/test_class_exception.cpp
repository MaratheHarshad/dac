#include <iostream>

#include "function.h"

InvalidCharException::InvalidCharException(const char *m) : msg(m) {
}
const char* InvalidCharException::getMessage() const {
    return msg;
}

void onlyLowerCase(char ch) throw(InvalidCharException) {
    if ((ch < 'a') || (ch > 'z')) {
        throw InvalidCharException("Got wrong char");
    }
    std::cout << "Got lowercase - " << ch << "\n";
}

void testF4() {
    try {
        onlyLowerCase('a');
        onlyLowerCase('0');
        std::cout << "Done\n";
    } catch (int e) {
        std::cout << "\nCaught exception - " << e << "\n";
    }
    std::cout << "Function done\n";
}
