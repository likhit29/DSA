#include<stdio.h>
int main()
{
    int i,base,expo,value=1;
    printf("Enter two number");
    scanf("%d%d",&base,&expo);
    printf("Base = %d\nExpo = %d",base,expo);

    for(i=0; i<expo; i++)
    {
        value = base * value;
    }
    printf("\n\nValue=%d", value);

    return 0;
}