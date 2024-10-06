 #include <iostream>
#include <string>
using namespace std;

class Student {

public:
    int Roll_No;
    float CGPA;
    string Name;

    void get_data() {
        cout << "Enter Roll number: ";
        cin >> Roll_No;
        cout << "Enter Name of Student: ";
        cin>>Name;
        cout << "Enter CGPA of student: ";
        cin >> CGPA;
     
    }

    void display_data()  {
        cout << Roll_No << " -> ";
        cout << Name << " -> ";
        cout << CGPA << endl;
    }

    friend void shellSort(Student S[], int n);
};

void shellSort(Student S[], int n) {
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            Student temp = S[i];
            int j;
            for (j = i; j >= gap && S[j - gap].Name  >  temp.Name; j -= gap) {
                S[j] = S[j - gap];
            }
            S[j] = temp;
        }
    }
}

int main() {
    int n;
    cout << "Enter number of students you want to enter data: ";
    cin >> n;
    Student S[n];
    for (int i = 0; i < n; i++) {
        cout << "Enter details of Student " << i + 1 << endl;
        S[i].get_data();
    }

    shellSort(S, n);

    cout << endl << "Sorted student data:" << endl;
    for (int i = 0; i < n; i++) {
        S[i].display_data();
    }

    return 0;
}

