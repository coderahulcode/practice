/*read write integer */
#include<stdio.h>
#include<conio.h>
void main()
{
FILE *f1,*f2,*f3;
int n,i,a,m;
clrscr();
printf("Enter no of value=");
scanf("%d",&n);
printf("Enter the values\n");
f1=fopen("main.txt","w");
for(i=1;i<=n;i++)
{
scanf("%d",&m);
putw(m,f1);
}
fclose(f1);

f1=fopen("main.txt","r");
f2=fopen("odd.txt","w");
f3=fopen("even.txt","w");
a=getw(f1);
while(a!=EOF)
{
if(a%2==0)
putw(a,f3);
else
putw(a,f2);
a=getw(f1);
}
fclose(f1);
fclose(f2);
fclose(f3);
f2=fopen("odd.txt","r");
f3=fopen("even.txt","r");
printf("ODD VALUES\n");
while((a=getw(f2))!=EOF)
printf("%d\t",a);
printf("\nEVEN VALUES\n");
while((a=getw(f3))!=EOF)
printf("%d\t",a);
fclose(f2);
fclose(f3);
getch();
}