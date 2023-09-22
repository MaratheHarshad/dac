#include <iostream>
#include <iomanip>

using namespace std;

const int MAX_STUDENTS = 100;  // Maximum number of students
const int MAX_SUBJECTS = 3;    // Maximum number of subjects (e.g., Math, Science, English)

// Function to input student exam scores into a 2-D array
void inputSubjectScores(int subjectScores[][MAX_SUBJECTS], int numStudents, int numSubjects) {
    for (int i = 0; i < numStudents; i++) {
        cout << "Enter exam scores for student " << (i + 1) << ":" << endl;
        for (int j = 0; j < numSubjects; j++) {
            cout << "Enter score for subject " << (j + 1) << ": ";
            cin >> subjectScores[i][j];
            
            // Validate scores (e.g., ensure they are within a valid range)
            while (subjectScores[i][j] < 0 || subjectScores[i][j] > 100) {
                cout << "Invalid score. Scores must be between 0 and 100." << endl;
                cout << "Enter score for subject " << (j + 1) << ": ";
                cin >> subjectScores[i][j];
            }
        }
    }
}

// Function to calculate and display average score for each subject
void calculateSubjectStatistics(int subjectScores[][MAX_SUBJECTS], int numStudents, int numSubjects) {
    double subjectSum[MAX_SUBJECTS] = {0};
    int subjectMax[MAX_SUBJECTS] = {0};
    int subjectMin[MAX_SUBJECTS] = {100};
    
    for (int i = 0; i < numStudents; i++) {
        for (int j = 0; j < numSubjects; j++) {
            subjectSum[j] += subjectScores[i][j];
            if (subjectScores[i][j] > subjectMax[j]) {
                subjectMax[j] = subjectScores[i][j];
            }
            if (subjectScores[i][j] < subjectMin[j]) {
                subjectMin[j] = subjectScores[i][j];
            }
        }
    }
    
    cout << "Subject Statistics:" << endl;
    for (int j = 0; j < numSubjects; j++) {
        double averageScore = subjectSum[j] / numStudents;
        cout << "Subject " << (j + 1) << ":" << endl;
        cout << "  Average Score: " << fixed << setprecision(2) << averageScore << endl;
        cout << "  Highest Score: " << subjectMax[j] << endl;
        cout << "  Lowest Score: " << subjectMin[j] << endl;
    }
}

int main() {
    // Declare variables
    int numStudents, numSubjects;
    int subjectScores[MAX_STUDENTS][MAX_SUBJECTS];
    
    // Input: Ask the user for the number of students and subjects
    cout << "Enter the number of students: ";
    cin >> numStudents;
    
    cout << "Enter the number of subjects: ";
    cin >> numSubjects;
    
    // Validate the number of students and subjects
    if (numStudents <= 0 || numStudents > MAX_STUDENTS || numSubjects <= 0 || numSubjects > MAX_SUBJECTS) {
        cout << "Invalid number of students or subjects. Please try again." << endl;
        return 1;  // Exit the program with an error code
    }
    
    // Call functions to input and process data
    inputSubjectScores(subjectScores, numStudents, numSubjects);
    calculateSubjectStatistics(subjectScores, numStudents, numSubjects);
    
    return 0;  // Exit the program with success
}
