#include<iostream>
using namespace std;

class Coordinates {
 public:
 int X, Y; //The fields of the class
 Coordinates(int x, int y){    // Constructor to initialize the X and Y
 X= x;
 Y = y;  }
 // Overloading(-) operator for decrementing X and Y Coordinates
 void operator-(){
 X--;
 Y--;
 cout << "\nDecremented X & Y are " <<
 X << " and " << Y<<endl;  }
 };
 int main()
 {
 Coordinates C(11,13);
 -C;
 return 0;
 }