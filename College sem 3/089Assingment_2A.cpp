#include<iostream>
using namespace std;
class Employee {

	int EmpID;
	string Name;
	int Salary;
	
	public:
	
	void getdata() {
	  cout<<"Enter the id of employee :";
	  cin>>EmpID;
	  cout<<"Enter the name of employee :";
	  cin>>Name;
	  cout<<"Enter the salary of employee :";
	  cin>>Salary;
	}

	void display() {
	  cout<<"The id of employee : "<<EmpID<<endl;
	  cout<<"The name of employee : "<<Name<<endl;
	  cout<<"The salary of employee : "<<Salary<<endl;
	}
		
	friend void quicksort(Employee E[],int n);
	friend int partition(Employee E[],int low, int high);
};
int partition(Employee E[],int low ,int high) {

	int pivot=E[low].EmpID;
	int i=low+1;
	int j=high;
	Employee temp;
	do{
	    while(pivot >= E[i].EmpID) {
		  i++;
	    }
	    while(pivot < E[j].EmpID) {
		 j--;
	    }
	    if(i<j) {
	      temp=E[i];
	      E[i]=E[j];
              E[j]=temp;
	   }
	}
	while(i<j);
	temp=E[low];
	E[low]=E[j];
	E[j]=temp;
return j;
}
void quicksort(Employee E[],int low ,int high) {

	int partindex;
	if (low<high) {
	  partindex=partition(E,low,high);
	  quicksort(E,low,partindex-1);
	  quicksort(E,partindex+1,high);
	}
}

int main(){
	int n;
	cout<<"Enter the number of employee : ";
	cin>>n;
	Employee  E[n];

	for (int i=0; i<n; i++) {
	    cout<<"Enter detail of "<<i+1<<endl;
	    E[i].getdata();
	    cout<<endl;
	}
	
	cout<<"Sorting using EMPID"<<endl;
	cout<<endl<<"The Employee Detail :\n"<<endl;
	quicksort(E,0,n-1);
	
	for (int i=0; i<n; i++) {
	    E[i].display();
	    cout<<endl;
	}
return 0;
}
