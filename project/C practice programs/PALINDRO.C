#include<stdio.h>
#include<conio.h>
#include<string.h>
void main()
{
char a[100];
int n,i,j,flag=0;
clrscr();
printf("Enter a string=");
gets(a);
n=strlen(a);
for(i=0,j=n-1;i<n/2;i++,j--)
{
if(a[i]==a[j])
continue;
else
{
printf("String is not palindrom\n");
flag=1;
break;
}}
if(flag==0)
printf("String is palindrom");
getch();
}