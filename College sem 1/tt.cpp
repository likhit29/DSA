#include<iostream>
using namespace std;

class A{
 private:
 int a;
 public:
 void set_a();
 void get_a();
 friend A operator -(A);
 };
 void A :: set_a(){
 a = 10;
 }
 void A :: get_a(){
 cout<< a <<"\n";
 }
 A operator -(A ob){
 ob.a = -(ob.a);
 return ob;
 }
  int main()
 {
 A ob;
 ob.set_a();
 cout<<"The value of a is : ";
 ob.get_a();
 //Calling operator overloaded function - to negate the value
 ob = -ob; //ob object is passed as an argument to the friend function and its negative version is returned.
 cout<<"The value of a after calling operator overloading friend function - is : ";
 ob.get_a();
 }