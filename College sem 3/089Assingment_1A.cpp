#include<iostream>
using namespace std;
class Student{
	int Roll_No;
	float CGPA;
	string Name;

	public:
		void get_data(){
		cout<<"Enter Roll number :";
		cin>>Roll_No;
		cout<<"Enter Name of Student :";
		cin>>Name;
		cout<<"Enter CGPA of student :";
		cin>>CGPA;
	}
	void display_data(){
		cout<<"Roll No. "<<Roll_No<<" "<<"-> ";
		cout<<"Name "<<Name<<" "<<"-> ";
		cout<<"CGPA "<<CGPA<<endl;
	}

	friend void insertionSort(Student S[], int n);
};
	void insertionSort(Student S[] , int n){
		for(int i=0;i<n;i++){
		Student curr = S[i];
		int j = i-1;
			while(j >= 0 && S[j].Roll_No > curr.Roll_No ){
			S[j+1] = S[j];
			j--;

			}
			S[j+1] = curr;
		}	

}
int main(){
	int n;
	cout<<"Enter number of student data you want to enter:";
	cin>>n;
	Student S[n];

	for(int i=0;i<n;i++){
	cout<<"Enter data of student "<<i+1<<endl;
	S[i].get_data();
	}
	insertionSort(S , n);
	for(int i=0;i<n;i++){
	S[i].display_data();
	}
return 0;
}
