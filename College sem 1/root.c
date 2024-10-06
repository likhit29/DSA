#include<stdio.h>
int main()
{
    float i,n;
    printf("enter the number");
    scanf("%f",&n);
    for(i=0.01; i*i<n ; i=i+0.01);

    printf("%.2f",i);




    return 0;
}