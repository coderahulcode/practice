#include<stdio.h>
#include<conio.h>
void main()
{
int n;
printf("Enter a no=");
scanf("%d",&n);
if(n%2==0)
{
printf("%d is Even number",n);
}
else
{
printf("%d is ODD number",n);
}
getch();
}