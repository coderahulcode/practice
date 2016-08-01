#include<stdio.h>
#include<conio.h>
void main()
{
int i=1,n;
float fact=1;
printf("Enter no to which factorial is found=");
scanf("%d",&n);
do
{
fact=fact*i;
i++;
}while(i<=n);
printf("Factorial of %d=%f",n,fact);
getch();
}