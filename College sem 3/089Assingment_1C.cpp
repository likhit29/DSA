#include<iostream>
#include<limits.h>

using namespace std;

class Student {
	public:
		int roll_no;
		string name;
		float cgpa;
	
	void getdata(){
	     cout<<"Enter the roll number of the student:";
	     cin>>roll_no;
	     cout<<"Enter the name of the student:";
	     cin>>name;
	     cout<<"Enter the cgpa of the Student :";
	     cin>>cgpa;
	}	
	void display(){
	     cout<<"The roll number of student : ";
	     cout<<roll_no<<endl;
	     cout<<"The name of the student : ";
	     cout<<name<<endl;
	     cout<<"The cgpa of student : ";
	     cout<<cgpa<<endl;
	}

	friend void radixsort(Student S[] ,int n);
};

int maximum(Student S[],int n){

	int max=INT_MIN;
	for (int i=0; i<n; i++){
	    if(S[i].roll_no>max){
		max=S[i].roll_no;
	    }
	}
   return max;
}
void countsort(Student S[],int n,int exp){
	int i;
	int count[10]={0};
	Student b[n];
	for (int i=0; i<n; i++) {
	    count[(S[i].roll_no/exp)%10]++;
	}

	for (int i=1 ;i<10; i++) {
	    count[i]=count[i]+count[i-1];
	}

	for (int i=n-1; i>=0; i--){
	    b[count[(S[i].roll_no/exp)%10]-1]=S[i];
	    count[(S[i].roll_no/exp)%10]--;
	}

	for (int i=0; i<n; i++) {
	    S[i]=b[i];
 	}

}
void radixsort(Student S[],int n){
	int max=maximum(S,n);
	for (int exp=1; max/exp>0; exp*=10){
	    countsort(S,n,exp);
	}
}

int main(){
	int n;
	cout<<"Enter the number of students: ";
	cin>>n;
	Student S[n];

	for (int i=0; i<n; i++){
	   cout<<endl;
	   cout<<"Student "<<i+1<<endl;
	   S[i].getdata();
	}

	radixsort(S,n);
	cout<<endl;
	cout<<"After sorting with ROLL NO "<<endl;

	for (int i=0; i<n; i++){
	    cout<<endl;
	    S[i].display();
	}
return 0;
}
