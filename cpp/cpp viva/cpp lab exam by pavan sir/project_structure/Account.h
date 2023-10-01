
class Account {

    int accNumber;
    char accType [10];
    double accBalance;
    char accName [20];

    static int count;


    public:

        Account();
        Account(char *accType, char *accName);

        void deposite(int amount);
        void withdraw(int amount);
        void display();
        int getAccountNumber();

};

