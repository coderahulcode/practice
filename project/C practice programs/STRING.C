#include<stdio.h>
#include<conio.h>
#include<string.h>
void main()
{
char a[100],b[100],c[100];
int n;
clrscr();
printf("Enter string=");
gets(a);
printf("Enter string=");
scanf("%s",b);
puts(b);
printf("SECond string=%s",a);
////string length of a
n=strlen(a);
printf("length of %s string=%d\n",a,n);
////string copy b to a (a is overide)
strcpy(a,b);
printf("String after coping=%s\n",a);
////////reverse of b string to a
printf("String after reverse=%s\n",strrev(a));
///////////////string compare
n=strcmp(a,b);
printf("Comparing of %s and %s string=%d\n",a,b,n);
////////string concatenate
strcat(a,b);
printf("A string=%s\n",a);
printf("B string=%s",b);
getch();
}