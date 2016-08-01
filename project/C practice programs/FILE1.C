/*red write single character*/
#include<stdio.h>
#include<conio.h>
void main()
{
FILE *fin,*fout;
char st[]="My Name is Rahul Mahajan";
char ch;
int i=0;
clrscr();
fout=fopen("f1.txt","w");
while(st[i])
{
fputc(st[i],fout);
i++;
}
fclose(fout);
fin=fopen("f1.txt","r");
while((ch=fgetc(fin))!=EOF)
{
putch(ch);
}
fclose(fin);
getch();
}