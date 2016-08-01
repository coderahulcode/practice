#include<stdio.h>
#include<conio.h>
void main()
{
int a[20],i,n;
printf("Enter no of values=");
scanf("%d",&n);
printf("Enter the values\n");
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}
printf("The values you can entered are\n");
for(i=0;i<n;i++)
{
printf("a[%d] element entered are=%d",i,a[i]);
}
getch();
}