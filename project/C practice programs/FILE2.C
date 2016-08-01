/*read write string */
#include<stdio.h>
#include<conio.h>
#include<string.h>
void main()
{
FILE *fout,*fin;
char st[]="My name is rahul mahajan";
char msg[20];
clrscr();
fout=fopen("f2.txt","w");
fputs(st,fout);
fclose(fout);
fin=fopen("f2.txt","r");
fgets(msg,strlen(st)+1,fin);
printf("%s",msg);
fclose(fin);
getch();
}