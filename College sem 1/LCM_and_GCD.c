#include<stdio.h>
int main()
{
int i,n1,n2,gcd,lcm;
printf("Enter the number");
scanf("%d\t%d",&n1,&n2);
for (i=1 ; i<=n1 && i<=n2;i++)
{
    if(n1%i==0 && n2%i==0)
    {
        gcd = i;
        
    }
   
    

}
 printf("\nGCD=%d",gcd);
lcm = n1*n2/gcd;
printf ("\nLCM=%d",lcm );
return 0;

}