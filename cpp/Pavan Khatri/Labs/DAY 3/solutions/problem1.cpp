#include <iostream>
#include <string>

using namespace std;

int main() {
    // Declare variables
    int numStudents;
    
    // Input: Ask the user for the number of students
    cout << "Enter the number of students: ";
    cin >> numStudents;
    
    // Validate the number of students
    if (numStudents <= 0) {
        cout << "Invalid number of students. Please enter a positive integer." << endl;
        return 1;  // Exit the program with an error code
    }
    
    // Process each student
    for (int i = 1; i <= numStudents; i++) {
        string studentName;
        int assignmentScores[3];
        double averageScore;
        char letterGrade;
        
        // Input: Ask for student's name
        cout << "Enter the name of student " << i << ": ";
        cin >> studentName;
        
        // Input: Loop to get assignment scores
        for (int j = 0; j < 3; j++) {
            cout << "Enter score for assignment " << (j + 1) << ": ";
            cin >> assignmentScores[j];
            
            // Validate scores
            if (assignmentScores[j] < 0 || assignmentScores[j] > 100) {
                cout << "Invalid score. Scores must be between 0 and 100." << endl;
                return 1;  // Exit the program with an error code
            }
        }
        
        // Calculate average score
        averageScore = (assignmentScores[0] + assignmentScores[1] + assignmentScores[2]) / 3.0;
        
        // Determine letter grade based on average score
        if (averageScore >= 90) {
            letterGrade = 'A';
        } else if (averageScore >= 80) {
            letterGrade = 'B';
        } else if (averageScore >= 70) {
            letterGrade = 'C';
        } else if (averageScore >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        
        // Output: Display student information and grade
        cout << "Student Name: " << studentName << endl;
        cout << "Assignment Scores: " << assignmentScores[0] << ", " << assignmentScores[1] << ", " << assignmentScores[2] << endl;
        cout << "Average Score: " << averageScore << endl;
        cout << "Letter Grade: " << letterGrade << endl;
        
        // Prompt the user if they want to continue grading more students
        char choice;
        cout << "Do you want to continue grading more students? (y/n): ";
        cin >> choice;
        
        if (choice == 'n' || choice == 'N') {
            break;  // Exit the loop if the user chooses not to continue
        }
    }
    
    return 0;  // Exit the program with success
}
