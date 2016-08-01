#include<fstream.h>
//for file handling
#include<stdio.h>
//for gets,getchar,remove,rename function
#include<process.h>
//for exit function
#include<conio.h>
//for clrscr,textbackground,textcolor,gotoxy,
//clreol,getch
#include<dos.h>
//for delay function
#include<string.h>
//for strlen function
#include<ctype.h>
//for toupper function

int a1,a2,a3,a4;
//GLOBAL VARIABLE
class menu
//DECLARATION OF CLASS MENU
{
public:
//MEMBER FUNCTIONS  DECLARED IN PUBLIC MODE
void main_menu(void);
void edit_menu(void);
void edit_cass(void);
void edit_member(void);
void screen(void);
};
menu u;
// U IS THE OBJECT OF CLASS MENU
class cass
//DECLERATION OF CLASS CASS
{
  //DATA MEMBER OF CLASS
char name[50];
int price;
int casscode;
int copies;
public:
//MEMBER FUNCTION OF CLASS DECLARED
//IN PUBLIC MODE
void cdis(void);
void add_new_cass();
void issuecass(void);
void returncass(void);
void cadelete(void);
void camodify(void);
};
cass b;
//OBJECT OF CLASS  CASS
class member
//DECLARATION OF CLASS MEMBER
{
public:
//DATA MEMBERS OF CLASS
int membercode;
char name[50];
char phone[8];
char add1[50];
public:
//MEMBER FUNCTIONS OF CLASS
//DECLARED IN PUBLIC MODE
void mdisplay(void);

void add_member(void);
void mmodify(void);
void mdelet(void);
};
// O IS THE OBJECT OF CLASS MEMBER

member m;
//DEFINING MEMBER FUNCTION
//MAIN_MENU OF CLASS MENU
void menu::main_menu(void)
{
clrscr();
int ch=0;
while (ch!=8)
{
ch=0;
cout<<"\n";
textbackground(BLACK);
//SELECTS BACK GROUND COLOUR(BLACK)
textcolor(CYAN);
//SELECTS  TEXT COLOUR (CYAN)
clrscr();
gotoxy(2,2);
//PLACES THE CURSOR AT GIVEN POSITION

cout<<"******************************************************************************";
gotoxy(24,6);
cout<<"V I D E O  L I B R A R Y   S Y S T E M";
gotoxy(24,9);
cout<<"1.	     INTRODUCTION	";
gotoxy(24,10);
cout<<"2.	 TO ADD CASSETTES";
gotoxy(24,11);
cout<<"3.       TO ADD A NEW MEMBER";
gotoxy(24,12);
cout<<"4.       TO ISSUE A CASSETTE";
gotoxy(24,13);
cout<<"5.	  TO RETURN A CASSETTE";
gotoxy(24,14);
cout<<"6.       TO DISPLAY LIST OF CASSETTES ";
gotoxy(24,15);
cout<<"7.       TO DISPLAY LIST OF MEMBERS"  ;
gotoxy(24,16);
cout<<"8.	EDIT  MENU";
gotoxy(24,17);
cout<<"0.	   EXIT";
gotoxy(2,20);
cout<<"*****************************************************************************";
gotoxy(24,18);
cout<<"Enter Your Choice : ";
cin>>ch;

switch(ch)
{
case 1:u.screen();
//CALLING SCREEN FUNCTION OF CLASS MENU
break;
case 2:b.add_new_cass();
//CALLING ADD_NEW_CASSSETTE OF CLASS CASS
break;
case 3:m.add_member();
//CALLING ADD_MEMBER FUNCTION OF CLASS MEMBER
break;
case 4:b.issuecass();
//CALLING ISSUE_FUNCTION OF CLASS CASS
break;
case 5:b.returncass();
//CALLING RETURNCASS FUNCTION OF CLASS CASS
break;
case 6: b.cdis();
//CALLING CDIS FUNCTION OF CLASS CASS
break;
case 7: m.mdisplay();
//CALLING MEMBER FUNCTION OF CLASS MEMBER
break;
case 8:u.edit_menu();
//CALLING EDIT_MENU FUNCTION OF CLASS MENU
break;
case 0:
// WHEN CHOICE '0'ENTERED PROGRAM GETS TEMINATED

clrscr();
gotoxy(29,6);
cout<<"PROJECT TERMIANTED";
gotoxy(29,7);
cout<<"~~~~~~~~~~~~~~~~~~";
delay(1000);
//PROGRAM GETS SUSPENDED FROM
//EXECUTION BY 1000 MILLISECONDS
exit(0);
//TERMINATES THE PROGRAM
}
//END OF SWITCH
}
//END OF WHILE LOOP
u.main_menu();
//CALLING MAIN_MENU FUNCTION OF CLASS MENU
}
//END OF MAIN_MENU FUNCTION OF CLASS MENU



void menu::edit_menu(void)
//DEFINING EDIT MENU_FUNCTION OF CLASS MENU
{
clrscr();
char ch=0;
while(ch!=2)
{
clrscr();
gotoxy(32,9);
//TO LOCATE THE CURSOR IN THE GIVEN POSITION
cout<<"E D I T  M E N U";
gotoxy(32,10);
cout<<"~~~~~~~~~~~~~~~~";
gotoxy(34,13);
cout<<"1.	CASSETTES";
gotoxy(34,14);
cout<<"2.	MEMBERS";
gotoxy(34,15);
cout<<"0.	EXIT";
gotoxy(34,17);
cout<<"ENTER YOUR CHOICE :";
cin>>a2;
switch(a2)
{
case 1:u.edit_cass();
//CALLS EDIT_CASS FUNCTION OF CLASS MENU
break;
case 2:u.edit_member();
//CALLS EDIT_MEMBER FUNCTION OF CLASS MENU
break;
case 0:u.main_menu();
//CALLS MAIN_MENU FUNCTION OF CLASS MENU
break;
}
//END OF SWITCH STATEMENT
}
//END OF WHILE LOOP
}
//END OF  EDIT_MENU FUNCTION OF CLASS MENU

void menu::edit_cass(void)
//DEFINING EDIT_CASS FUNCTION OF CLASS MENU
{
clrscr();
char ch=0;
while(ch!=2)
{
clrscr();
gotoxy(29,9);
cout<<"E D I T C A S S E T T E";
gotoxy(29,10);
cout<<"~~~~~~~~~~~~~~~~~~~~~~~~";
clreol();
// CLEARS ALL CHARACTERS FROM
//THE CURSOR POSITION TO END OF THE LINE
gotoxy(34,13);
//LOCATES THE CURSOR IN THE GIVEN POSITION
clreol();
cout<<"1.	MODIFY";
clreol();
gotoxy(34,14);
cout<<"2.	DELETE";
clreol();
gotoxy(34,15);
clreol();
cout<<"0.	EXIT";
clreol();
gotoxy(34,17);
cout<<"Enter your choice :";
cin>>a3;
switch(a3)
{
case 1:b.camodify();
//CALLS  CAMODIFY FUNCTION OF CLASS CASS
break;
case 2:b.cadelete();
//CALLS CADELETE FUNCTION OF CLASS CASS
break;
case 0:u.edit_menu();
//CALLS EDIT_MENU FUNCTION OF CLASS MENU
break;
}
//END OF SWITCH STATEMENT
}
// END OF WHILE LOOP
}
//END OF EDIT_CASS FUNCTION OF CLASS MENU

void menu::edit_member(void)
//DEFINING EDIT_MEMBER FUNCTION OF CLASS MENU
{
clrscr();
char ch=0;
while(ch!=2)
{
clrscr();
//CLEARS THE SCREEN
gotoxy(29,9);
cout<<"E D I T M E M B E R S";
gotoxy(29,10);
cout<<"~~~~~~~~~~~~~~~~~~~~~~";
clreol();
gotoxy(34,13);
cout<<"1.      MODIFY";
clreol();
gotoxy(34,14);
cout<<"2.      DELETE";
clreol();
gotoxy(34,15);
cout<<"0.	 EXIT";
clreol();
gotoxy(34,17);
cout<<"Enter your choice";
cin>>a4;

switch(a4)
{
case 1:m.mmodify();
//CALLING MMODIFY FUNCTION OF CLASS MEMBER
break;
case 2:m.mdelet();
//CALLING  MDELET FUNCTION OF CLASS MEMBER
break;
case 0:u.edit_menu();
//CALLING EDIT MENU FUNCTION OF CLASS MENU
break;
}
//END OF THE SWITCH STATEMENT
}
//END OF THE WHILE LOOP
}
//END OF EDIT MEMBER FUNCTION OF CLASS MENU


void menu::screen(void)
//DEFINING SCREEN FUNCTION OF CLASS MENU
{
clrscr();
gotoxy(25,10);
cout<<"VIDEO LIBRARY MANAGEMENT SYSTEM ";
gotoxy(34,13);
cout<<"BY: GEC";
gotoxy(49,22);

cout<<"Press any key to continue...";
getch();
clrscr();
gotoxy(3,8);
cout <<" \t	THIS PROJECT COMPUTERISES A VIDEO LIBRARY."
<<"\n\n\n \t\tThis program deals in:"
<<"\n\t\t1. Addition of cassettes and members."
<<"\n\t\t2. Display of cassettes and members."
<<"\n\t\t3. Modifications fo cassettes and members."
<<"\n\t\t4. Deletion of cassettes and members."
<<"\n\t\t5. Issue and return of cassettes.";
gotoxy(49,22);
cout<<"Press any key to continue...";
getch();
//READS A SINGLE CHARACTER FROM THE KEYBOARD
u.main_menu();
//CALLING MAIN_MENU FUNCTION OF CLASS MENU
}
//END OF SCREEN FUNCTION OF CLASS MENU

//FUNCTION TO ADD NEW CASSETTE
 void cass::add_new_cass()
//DEFINING ADD_NEW_CASSETTE FUNCTION OF CLASS CASS
 {
clrscr();
fstream fil;
//CREATE INPUT - OUTPUT STREAM
int code;
char choice='y';
while(choice=='y')
{
fil.open("cas3.dat",ios::in|ios::binary);
//OPENS DATA FILE CAS3 IN INPUT AND BINARY MODE
if(fil==0)
{
code=0;
}
else
{
while(!fil.eof())
//CHECKS WHETHER THE FILE IS END
{
fil.read((char *)&b,sizeof(cass));
//READS THE CONTENTS OF FILE
if(fil.eof())
code= b.casscode;
} //END OF WHILE LOOP
}//END OF ELSE
fil.close();
//CLOSES THE FILE
fil.open("cas3.dat",ios::out|ios::app|ios::binary);
//OPENS DATAFILE CAS
//IN OUTPUT,APPEND,BINARY,MODE
clrscr();
b.casscode=code+1;
gotoxy(20,2);
cout<<"Add Video Details";
gotoxy(20,3);
cout<<"~~~~~~~~~~~~~~~~~~";
gotoxy(20,6);
cout<<"Code Number : ";
cout<<b.casscode;
int l=0;
while(l==0)
{
gotoxy(20,8);
cout<<"Name of cassette : ";
gets(b.name);
l=strlen(b.name);
if (l==0)
cout << "Cannot be blank. Enter again";
}
//END OF WHILE LOOP WHEN NAME IS BLANK
clreol();
gotoxy(20,10);
cout<<"Number of copies : ";
cin>>b.copies;
if(b.copies < 0 )
{
cout<<"Copies cannot be less than 0.Enter again ";
gotoxy(20,10);
clreol();
cout<<"Number of copies : ";
cin>>b.copies;
}// END OF IF WHEN NUMBER OF COPIES ARE 0
clreol();
gotoxy(20,12);
cout<<"Price : ";
cin>>b.price;
if(b.price <= 0 )
{
cout<<"Price cannot be less or equal to 0";
cout<<"Enter again ";
gotoxy(20,12);
clreol();
cout<<"Price : ";
cin>>b.price;
}
//END OF IF STATEMENT WHEN PRICE IS 0
clreol();
gotoxy(20,20);
fil.write((char *)&b,sizeof(cass));
//WRITE THE CONTENTS OF FILE IN DATAFILE CAS3
fil.flush();
//FLUSHES THE STREAM
cout<<"Any more records to be added (y/n)----------- ";
cin>>choice;
fil.close();
//CLOSES THE FILE
 }
//END OF FIRST WHILE LOOP WHEN CHOICE IS 'Y'
 }
//END OF ADD_NEW_CASS FUNCTIONOF CLASS CASS

//FUNCTION TO DISPLAY
void cass::cdis()
//DEFINING CDIS FUNCTION OF CLASS CASS
{
fstream file1;
file1.open("cas3.dat",ios::in|ios::out|ios::out|ios::binary);
//OPENS THE FILE IN INPUT,OUTPUT,BINARY MODE
file1.seekg(0,ios::beg);
//BRINGS THE CURSOR IN BEGINNING
while(!file1.eof())
//CHECKS WHETHER THE FILE IS END OR NOT
{
file1.read((char *)&b,sizeof(cass));
//READS THE CONTENTS OF THE FILE
clrscr();
gotoxy(36,2);
cout<<"Display Video Details";
gotoxy(36,3);
cout<<"~~~~~~~~~~~~~~~~~~~~~";
gotoxy(15,6);
cout<<"Code Number : ";
cout<<b.casscode;
gotoxy(15,8);
cout<<"Name of cassette : ";
cout<<b.name;
gotoxy(15,10);
cout<<"Number of copies : ";
cout<<b.copies;
gotoxy(15,12);
cout<<"Price : Rs. ";
cout<<b.price;
gotoxy(15,14);
getch();
}
//END OF WHILE LOOP
file1.close();
}//END OF CDIS FUNCTION OF CLASS CASS

//FUNCTION TO ADD NEW MEMBER

void member::add_member()
//DEFINING ADD_MEMBER OF CLASS MEMBER
{
int code;
char choice='y';
while(choice=='y')
{
clrscr();
fstream file2;
file2.open("mem1.dat",ios::in|ios::binary);
//OPENS THE DATA FILE MEM1 IN INPUT AND BINARY MODE
if(file2==0)
{
code=0;
}
else
{
while(!file2.eof())
{
file2.read((char *)&m,sizeof(member));
if(file2.eof())
code= m.membercode;
}
//END OF WHILE LOOP
}
//END OF ELSE
file2.close();
//CLOSES DATA FILE  MEM1
file2.open("mem1.dat",ios::app|ios::binary);
//OPENS THE DATA FILE MEM1 IN APPEND AND BINARY MODE
m.membercode=code+1;
gotoxy(25,2);
cout<<"Add Member Details";
gotoxy(25,3);
cout<<"~~~~~~~~~~~~~~~~~~";
gotoxy(20,6);
cout<<"Code Number : ";
cout<<m.membercode;
int l=0;
while(l==0)
{
gotoxy(20,8);
cout<<"Name of member : ";
gets(m.name);
l=strlen(m.name);
if (l==0)
cout << "Cannot be blank. Enter again";
}//END OF WHILE LOOP WHEN THE NAME OF
//THE MEMBER ENTERED IS BLANK
clreol();
int a=0;
while(a==0)
{
gotoxy(20,10);
cout<<"Address : ";
gets(m.add1);
a=strlen(m.add1);
if(a==0)
cout<<"Cannot be blank.Enter again ";
}
//END OF WHILE LOOP WHEN ADDRESS ENTERED IS BLANK
clreol();
int b=0;
while(b!=7)
{
gotoxy(20,12);
cout<<"Phone : ";
gets(m.phone);
b=strlen(m.phone);
if (b!=7)
cout <<"Cannot be less than 7 digits";
}
//END OF WHILE LOOP WHEN NUMBER OF DIGITS
//PHONE ARE LESS THEN '7'
clreol();
gotoxy(20,20);
file2.write((char *)&m,sizeof(member));
file2.flush();
// FLUSHES THE STREAM
cout<<"Any more records to be added (y/n)--------";
cin>>choice;
file2.close();
//CLOSES THE FILE
}
//END OF WHILE LOOP WHEN CHOICE IS 'Y'
}
//END OF ADD_MEMBER FUNCTION OF CLASS MEMBER

//FUNCTION TO DISPLAY MEMBER
void member::mdisplay()
{
fstream file2;
file2.open("mem1.dat",ios::in|ios::out);
//OPENS DATA FILE MEM1 IN INPUT AND OUTPUT MODE
file2.seekg(0,ios::beg);
//BRINGS THE CURSOR POSITION IN BEGINING
file2.read((char *)&m,sizeof(member));
//READS THE CONTENS OF FILE
while(!file2.eof())
//CHECKS WHEYTHER THE FILE IS END
{
clrscr();
gotoxy(36,2);
cout<<"Display Member Details";
gotoxy(36,3);
cout<<"~~~~~~~~~~~~~~~~~~~~~~~";
gotoxy(15,6);
cout<<"Code Numbner : ";
cout<<m.membercode;
gotoxy(15,8);
cout<<"Name : ";
cout<<m.name;
gotoxy(15,10);
cout<<"Address : ";
cout<<m.add1;
gotoxy(15,12);
cout<<"Phone : ";
cout<<m.phone;
file2.read((char *)&m,sizeof(member));
//READS THE CONTENTS OF THE FILE
getch();
}
//END OFWHILE LOOP
file2.close();
}
//END OF MDISPLAY FUNCTION OF CLASS MEMBER

//FUNCTION TO MODIFY MEMBER
void member::mmodify()
//DEFINING MMODIFY FUNCTION OF CLASS MEMBER
{
clrscr();
char chw='y';
int c,x;
while(toupper(chw)=='y')
//TOUPPER ACCEPTS UPPERCASE 'Y'
{
clrscr();
fstream file2;
clrscr();
gotoxy(29,2);
cout<<"Member Modifications";
gotoxy(29,3);
cout<<"~~~~~~~~~~~~~~~~~~~~";
gotoxy(15,7);
cout<<"Enter the code number ";
cin>>c;
file2.open("mem1.dat",ios::out|ios::in|ios::binary);
//OPENS DATA FILE MEM1 IN INPUT,OUTPUT AND BINARY MODE
while(!file2.eof())
//CHECKS WHETHER FILE IS END
{
file2.read((char *)&m,sizeof(member));
if(file2.eof())

break;
else
{
if(c == m.membercode)
{
cout<<"\n\t\tName : "<<m.name;
cout<<"\n\n\t\t Address : "<<m.add1;
cout<<"\n\n\t\t Phone : "<<m.phone;
gotoxy(3,16);
cout<<"Are you sure want to modify : (Y/N) ";
chw = getch();
if(chw=='y'|| chw=='Y')
{
clrscr();
gotoxy(26,4);
cout<<"Enter Modified Details ";
gotoxy(3,9);
int l=0;
while(l==0)
{
gotoxy(3,9);
cout<<"Name : ";
gets(m.name);
l = strlen(m.name);
if (l==0)
cout << "Cannot be blank. Enter again";
}//END OF WHILE LOOP WHEN NAME IS BLANK
clreol();
//CLEARS ALL THE CHARACTER FROM THE
//CURSOR POSOITION TO END OF THE LINE
gotoxy(3,11);
int a=0;
while(a == 0)
{
gotoxy(3,11);
cout<<"Address : ";
gets(m.add1);
a=strlen(m.add1);
if(a==0)
cout<<"Cannot be blank.Enter again ";
}
//END OF WHILE LOOP WHEN ADDRESS IS BLANK
clreol();
int b=0;
while(b!=7)
{
gotoxy(3,13);
cout<<"Phone : ";
cin>>m.phone;
b=strlen(m.phone);
if(b!=7)
cout<<"Cannot be less than 7 digits.Enter again";
}
//END OF WHILE LOOP WHEN NUMBER OF  PHONE DIGIT
//IS LESS THEN '7'
clreol();
x=sizeof(member);
file2.seekg(-x ,ios::cur);
file2.write((char *)&m,sizeof(member));
file2.close();
clrscr();
}//ask
}
}
}
cout << "n\n\t\tDo you want to continue....(y/n) ";
chw=getche();//
}
} //END OF  WHILE LOOP WHEN CHOICE IS Y
//FUNCTION TO MODIFY CASSETTES

void cass::camodify()
//DEFING CAMODIFY FUNCTION OF CLASS CASS
{
clrscr();
char chw='y';
int c,x;
clrscr();
fstream file1;
clrscr();
gotoxy(29,2);
cout<<"Cassette Modifications";
gotoxy(29,3);
cout<<"~~~~~~~~~~~~~~~~~~~~~~~";
gotoxy(15,6);
cout<<"Enter the code number ";
cin>>c;
file1.open("cas3.dat",ios::out|ios::in|ios::binary);
while(!file1.eof())
{
file1.read((char *)&b,sizeof(cass)) ;
if(file1.eof())
break;
else
{
if(c==b.casscode)
{
cout<<"\n\n\t Name : "<<b.name;
cout<<"\n\n\t\t Number of copies : "<<b.copies;
cout<<"\n\n\t\tPrice : "<<b.price;
gotoxy(6,19);
cout<<"Are you sure you want to modify : (Y/N) ";
chw=getch();
if(chw=='y'||chw=='Y')
{
clrscr();
gotoxy(26,4);
cout<<" Enter Modified Details ";
gotoxy(3,9);
int l=0;
while(l==0)
{
gotoxy(3,9);
cout<<"Name of cassette	: ";
gets(b.name);
l=strlen(b.name);
if (l==0)
cout << "Cannot be blank. Enter again";
}
//END OF THE WHILE LOOP WHEN THE NAME
//OF CASSETTE IS BLANK
clreol();
gotoxy(3,11);
cout<<"Number of copies 	: ";
cin>>b.copies;
gotoxy(3,13);
cout<<"Price		: ";
cin>>b.price;
gotoxy(3,15);
x=sizeof(cass);
file1.seekg(-x ,ios::cur);
file1.write((char *)&b,sizeof(cass));
file1.close();
clrscr();
}//END OF IF WHEN CHW IS 'Y'
}//END OF IF WHEN C IS B.CASSCODE
}//END OF ELSE STATEMENT
} //END OF WHILE LOOP WHEN CHOICE IS Y
cout << "\n\n\t\tDo you want to continue....(y/n) ";

chw=getch();
} //END OF MENU SCREEN FUNCTION
//DELETE FUNCTION  FOR MEMBER

void member::mdelet()
//DEFINING MDELET FUNCTION OF CLASS MEMBER
{
int e,x;
char chw='Y';
char ch=' ';
while(chw=='y' || chw=='Y')
{
clrscr();
gotoxy(30,4);
cout<<"DELETION OF MEMBER";
gotoxy(30,5);
cout<<"~~~~~~~~~~~~~~~~~~~";
cout<<"\n\n Enter the member code you want to delete ";
cin>>e;
fstream outfile;
fstream file2;
outfile.open("ne.dat",ios::in|ios::out|ios::app|ios::binary);
//OPENS DATAFILE NE IN INPUT,
//OUTPUT ,APPENDAND BINARY MODE
file2.open("mem1.dat",ios::in|ios::out|ios::binary);
//OPENS DATAFILE MEM1 IN INPUT,OUTPUT AND BINARY MODE
while(!file2.eof())
{
file2.read((char *)&m,sizeof(member));
if(file2.eof())
break;
else
{
if(e==m.membercode)
{
cout<<"\n\n Name : "<<m.name;
cout<<"\n\n Address : "<<m.add1;
cout<<"\n\n Phone : "<<m.phone;
gotoxy(3,15);
cout<<"Are you sure you want to delete? (y/n)";
cin>>ch;
while(ch=='n'|| ch=='N')
{
outfile.write((char *)&m,sizeof(member));
}//END OF WHILE LOOP
}//END OF IF WHEN E  = M.MEMBERCODE
else
{
outfile.write((char *)&m,sizeof(member));
}//END OFELSE
}
}
file2.close();
outfile.close();
remove("mem1.dat");
rename("ne.dat","mem1.dat");
gotoxy(20,20);
cout<<"Do you wish to continue (y/n)";
cin>>chw;
}
}//END OF MDELET FUNCTION OF CLASS MEMBER
//----
//FUNCTION TO DELETE CASSETTE

void cass::cadelete()
//DEFINING CADELETE FUNCTION OF CLASS CASS
{
int e,x;
char chw='y';
char ch=' ';
while(chw=='y'|| chw=='Y')
{
clrscr();
gotoxy(30,4);
cout<<"DELETION OF CASSETTE";
gotoxy(30,5);
cout<<"~~~~~~~~~~~~~~~~~~~~~~~";
gotoxy(25,8);
cout<<"Enter the cassette code you want to delete :";
cin>>e;
fstream outfile;
fstream file1;
outfile.open("new1.dat",ios::in|ios::out|ios::app|ios::binary);
file1.open("cas3.dat",ios::in|ios::out|ios::binary);
while(!file1.eof())
{
file1.read((char *)&b,sizeof(cass));
if(file1.eof())
break;
else
{
if(e==b.casscode)
{
cout<<"\n Name : "<<b.name;
cout<<"\n Number of copies : "<<b.copies;
cout<<"\n Price : "<<b.price;
gotoxy(3,15);
cout<<"Are you sure you want to delete ?(y/n)";
cin>>ch;
while(ch=='n' || ch=='N')
{
outfile.write((char *)&b,sizeof(cass));
}
}
else
{
outfile.write((char *)&b,sizeof(cass));
}
}
}
file1.close();
outfile.close();
remove("cas3.dat");
rename("new1.dat","cas3.dat");
gotoxy(25,20);
cout<<"Do you wish to continue (y/n)";
cin>>chw;
}
}
//-------
//FUNCTION TO ISSUE CASSETTE

void cass :: issuecass()
//DEFINING ISSUECASS FUNCTION OF CLASS CASS
{
int e,x,y,s;
clrscr();
gotoxy(30,5);
cout<<"ISSUE OF CASSETTES ";
gotoxy(30,6);
cout<<"~~~~~~~~~~~~~~~~~~~~~";
fstream file1,file2;
char f='n';
while (f=='n')
{
file2.open("mem1.dat",ios::in|ios::out|ios::binary);
//OPENS DATA FILE  MEM1 IN INPUT,OUTPUT AND BINARY MODE
gotoxy(25,8);
cout<<"Enter your membercode ...";
cin>>e;
file2.seekg(0,ios::beg);
//BRINGS CURSOR TO BEGINNING
file2.read((char *)&m,sizeof(member));
//READS CONTENTS OF FILE
while(!file2.eof())
{
//CHECKS WHETHER FILE IS END
if (e==m.membercode)
{
f='y';
break;
}
file2.read((char *)&m,sizeof(member));
//READS CONTENT OF FILE
}
if(f=='n')
{
gotoxy(25,9);
cout << "Invalid member code";
getchar();
gotoxy(25,9);
cout<< "		";
}
file2.close();
}
f='n';
while (f=='n')
{
file1.close();
file1.open("cas3.dat", ios::in|ios::out);
gotoxy(25,10);
cout<<"\n Enter the cassette code...";
cin >> x;
file1.seekg(0,ios::beg);
file1.read((char *)&b,sizeof(cass));
while(!file1.eof())
{
if(x==b.casscode)
{
f='y';
break;
}
file1.read((char *)&b,sizeof(cass));
}
if(f=='n')
{
gotoxy(25,11);
cout << "\n Invalid code";
getchar();
gotoxy(25,11);
cout<< "		";
}
}
if(f=='y' && b.copies > 0)
{
cout<<"\n The Cassette is issued to you";
getchar();
y=sizeof(cass);
file1.seekg(-y,ios::cur);
b.copies--;
file1.write((char *)&b,sizeof(cass));
file1.flush();
}
else
{
cout<<"\n Copies not available";
getchar();
}
u.main_menu();
}
//----
//FUNCTION TO RETURN CASSETTE

void cass :: returncass()
//DEFINING RETURNCASS FUNCTION OF CLASS CASS
{
int e,x,y,s;
clrscr();
gotoxy(30,5);
cout<<" RETURN OF CASSETTES ";
gotoxy(30,6);
cout<<"~~~~~~~~~~~~~~~~~~~~~";
fstream file1,file2;
char f='n';
while (f=='n')
{
file2.open("mem1.dat",ios::in|ios::out|ios::binary);
gotoxy(25,8);
cout<<"Enter your membercode ...";
cin>>e;
file2.seekg(0,ios::beg);
file2.read((char*)&m,sizeof(member));
while(!file2.eof())
{
if (e==m.membercode)
{
f='y';
break;
}
file2.read((char *)&m,sizeof(member));
}
if(f=='n')
{
gotoxy(25,9);
cout << "Invalid member";
getchar();
gotoxy(25,9);
cout<< "		";
}
file2.close();
}
f='n';
while (f=='n')
{
file1.close();
file1.open("cas3.dat", ios::in|ios::out);
gotoxy(25,10);
cout<<"\n Enter the cassette code...";
cin >> x;
file1.seekg(0,ios::beg);
file1.read((char *)&b,sizeof(cass));
while(!file1.eof())
{
if(x==b.casscode)
{
f='y';
break;
}
file1.read((char *)&b,sizeof(cass));
}
if(f=='n')
{
gotoxy(25,11);
cout<<"Invalid code";
getchar();
gotoxy(25,11);
cout<< "	";
}
}
if(f=='y')
{
cout<<"\n The Cassette is returned ";
getchar();
y=sizeof(cass);
file1.seekg(-y,ios::cur);
b.copies++;
file1.write((char *)&b,sizeof(cass));
file1.flush();
}
else
{
cout<<"\n Copies not available";

getch();
}
u.main_menu();
//CALLLING MAIN_MENU FUNCTION OF CLASS MENU
}
//THE MAIN FUNCTION BEGINS

	void main()
	{
	clrscr();
	u.main_menu();
	u.edit_menu();
	getch();
	}
//END OF THE PROGRAM





































