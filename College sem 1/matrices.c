#include<stdio.h>
int main ()
{
    int i,j,r,c,n,m1[10][10],m2[10][10], sum[10][10],mul[10][10],k;
    printf("enter the no of rows");
    scanf("%d",&r);
    printf("enter the no of column");
    scanf("%d",&c);

    printf ("\n\nMAtRICES 1\n\n");
    for ( i=0;i<r;i++)
    {
        for (j=0;j<c;j++)
        {
            printf("enter no [%d][%d] = ", i,j);
            scanf("%d",&n);
            m1[i][j]= n   ;
        }
    }
    for ( i=0;i<r;i++)
    {
        for (j=0;j<c;j++)
        {
            printf("%d\t",m1[i][j]);
   
        }
        printf("\n");
    }
    printf ("\n\nMAtRICES 2\n\n");
   
   
    for ( i=0;i<r;i++)
    {
        for (j=0;j<c;j++)
        {
            printf("enter no [%d][%d] = ", i,j);
            scanf("%d",&n);
            m2[i][j]= n   ;
        }
    }
    for ( i=0;i<r;i++)
    {
        for (j=0;j<c;j++)
        {
            printf("%d\t",m2[i][j]);
   
        }
        printf("\n");
    }


// summ


    printf("\n\n Sum of Matrices\n\n" );


        for ( i=0;i<r;i++)
    {
        for (j=0;j<c;j++)
        {
           sum[i][j] = m1[i][j] + m2[i][j];
        }
    }
    for ( i=0;i<r;i++)
    {
        for (j=0;j<c;j++)
        {
            printf("%d\t",sum[i][j]);
   
        }
        printf("\n");
    }
                   

// multipication

      printf("\n\n Multiplication of Matrices\n\n" );

        for (i = 0; i < r; i++)
        {
        for (j = 0; j < c; j++)
        {
       
            mul[i][j] = 0;
            for (k = 0; k < c; k++)
            {
                mul[i][j] += m1[i][k] * m2[k][j];
            }
        }
        }

        printf("The product of the two matrices is: \n");
        for (i = 0; i < r; i++)
     {
        for (j = 0; j < c; j++)
        {
            printf("%d\t", mul[i][j]);
        }
        printf("\n");
     }

       return 0;
}

