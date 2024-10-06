#include<iostream>
using namespace std;
class Student{
	public :
	int Roll_No;
	float CGPA;
	string Name;

	void get_data(){

		cout<<"Enter Roll number :";
		cin>>Roll_No;
		cout<<"Enter Name of Student :";
		cin>>Name;
		cout<<"Enter CGPA of student :";
		cin>>CGPA;
	}
	void display_data(){
		cout<<Roll_No<<" -> ";
		cout<<Name<<" -> ";
		cout<<CGPA<<endl;
	}

	friend void mergeSort(Student S[], int si, int ei);
	friend void merge(Student S[],int si,int mid,int ei);
};
void mergeSort(Student S[],int si,int ei){
	if (si >= ei){
	   return;
	}
int mid = si+(ei-si)/2;

mergeSort(S, si, mid);
mergeSort(S, mid+1, ei);
merge(S,si,mid,ei);

}

void merge(Student S[],int si,int mid,int ei){
	Student temp[ei-si+1];
	int i=si;
	int j=mid+1;
	int k=0;
	int n = sizeof(temp) / sizeof(temp[0]);

	while (i <= mid && j <= ei){
		if (S[i].Name<S[j].Name){
		   temp[k] = S[i];
	    	   i++;
		   k++;
		}
		else{
		      temp[k]=S[j];
		      j++;
		      k++;
		}
	}

	while(i<=mid) temp[k++] = S[i++];

	while(j<=ei) temp[k++] = S[j++];


	for (k=0,i=si; k<n; k++, i++){
	   S[i] = temp[k];

	}
}

int main(){
	int n;
	cout<<"Enter number of student you want to enter data:";
	cin>>n;
	Student S[n];
	for (int i=0; i<n; i++){
	    cout<<"Enter details of Student " << i+1 <<endl;
	    S[i].get_data();
	}
	mergeSort(S , 0, n-1);
	cout << endl << "Sorted student data with Name:" << endl;
	for (int i=0; i<n; i++){
	    S[i].display_data();
	}
return 0;
}
