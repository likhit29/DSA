#include<stdio.h>
int main()
{
    int a,b;
    printf("Enter two number");
    scanf("%d%d",&a,&b);
    printf("\na=%d , b=%d",a,b);
    a=a+b;
    b=a-b;
    a=a-b;
   printf("\na=%d , b=%d",a,b);
    return 0;

}