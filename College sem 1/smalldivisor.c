#include<stdio.h>
int main()

{
int n,i;
printf("Enter n\t");
scanf("%d",&n);
 for(i=2; i<n;i++)
 {
    if (n%i==0)
    {
      break;
    }
 }
 printf("%d",i);

 return 0;

}