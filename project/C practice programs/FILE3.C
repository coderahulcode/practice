/*read write block   */
#include<stdio.h>
#include<conio.h>
struct student
{
int rollno;
char name[20];
int marks;
};
void main()
{
FILE *f1;
int i,n,r,a;
struct student s,k,p;
f1=fopen("f3.txt","w");
clrscr();
printf("Enter no of students=");
scanf("%d",&n);
printf("\nEnter the records\n");
for(i=0;i<n;i++)
{
printf("Enter Roll no of %d student=",i+1);
scanf("%d",&s.rollno);
printf("Enter name of student=");
scanf("%s",s.name);
printf("Enter marks of student=");
scanf("%d",&s.marks);
printf("\n\n\n");
fwrite(&s,sizeof(s),1,f1);
}
fclose(f1);
f1=fopen("f3.txt","r");
printf("Roll_no\tName\tmarks");
a=fread(&k,sizeof(k),1,f1);
do
{
printf("\n%d\t%s\t%d",k.rollno,k.name,k.marks);
a=fread(&k,sizeof(k),1,f1);
}while(a>0);
fclose(f1);
getch();
}