/*
Language: C\C++
Category: Database\Files
Description: Hotel Reservation
*/
#include<iostream.h>
#include<graphics.h>
#include <conio.h>
#include <stdlib.h>
#include <dos.h>
#include<iomanip.h>
#define size 51

void mainm(void);
void entry(void);
void modify(void);
void delet(void);
void view(void);

// Structure

struct hoteldata
{
char name[size][30], nic[size][20],rdate[size][12],cdate[size][12];
};

struct hoteldata guest;

struct hoteldata1
{
char name[size][30], nic[size][20],rdate[size][12],cdate[size][12];
};

struct hoteldata1 guest1;



// Initializations

int li,lp,sr[size];int dr[size];int rno;int i;int e;
char rc,ch,choice,echoice,rchoice,temp[80],vchoice,mf,ar;


// Main Fuction
void main(void)
{
int i;
clrscr();
int x=50, y=10, b=600, c=340;
int gdriver = EGA, gmode = EGAHI;
initgraph(&gdriver, &gmode, "c:\\tc\\bgi");
int dly=110,dly1=40;//110 40
for ( i = 0; i < 200; i+=2 )
{ // graphics output
setcolor(i);
circle(300,i,200-i);
delay(dly1);
}
for ( i = 0; i < 220; i+=2 )
{
setcolor(i);
circle(300,i+200,i);
delay(dly1);
}
clrscr();

for ( i=1;i<=10;i++)
{if(i==7)
continue;
else
{
setcolor(i);
settextstyle( DEFAULT_FONT, HORIZ_DIR, i);
moveto(40,120);
outtext("PROJECT"); //blink
delay(dly);
clrscr();
}
}
for ( i=1;i<7;i++)
{
setcolor(i);
settextstyle( DEFAULT_FONT, HORIZ_DIR, i);
moveto(160,150);
outtext("OF C++");
delay(dly);
clrscr();
}
for ( i=3;i<=9;i++)
{if(i==7)
continue;
else
{
setcolor(i);
settextstyle( TRIPLEX_FONT, HORIZ_DIR, i);
moveto(40,120);
outtext("SUBMITTED");
delay(dly);
clrscr();
}
}
for ( i=1;i<=10;i++)
{if(i==7)
continue;
else
{
setcolor(i);
settextstyle( DEFAULT_FONT, HORIZ_DIR, i);
moveto(230,160);
outtext("BY");
delay(dly);
clrscr();
}
}

for ( i=1;i<=5;i++)
{
setcolor(i+7);
settextstyle( DEFAULT_FONT, HORIZ_DIR, i);
moveto(10,120);
outtext("Inderbir Singh");
delay(i*dly);
clrscr();
}

for ( i=1;i<=4;i++)
{
setcolor(i);
settextstyle( DEFAULT_FONT, HORIZ_DIR, i);
moveto(50,120);
outtext("Amritpal Singh");
delay(i*dly);
clrscr();
}
for ( i=1;i<=5;i++)
{
setcolor(i);
settextstyle( DEFAULT_FONT, HORIZ_DIR, i);
moveto(40,120);
outtext("Ricky Chadda");
delay(i*dly);
clrscr();
}

for ( i=1;i<=6;i++)
{
setcolor(i);
settextstyle( DEFAULT_FONT, HORIZ_DIR, i);
moveto(30,120);
outtext("Rohit Kumar");
delay(i*dly);
clrscr();
}
for(i=1;i<=10;i++)
{
setcolor(5);
rectangle(x, y+3, b, c);
clrscr();
setcolor(5);
rectangle(x, y+3, b, c);
if(i!=5)
{
setcolor(i);
settextstyle( GOTHIC_FONT, HORIZ_DIR, 6);
moveto(180,100);
outtext("SOFTWARE");
}
if(i!=5)
{
setcolor(1+i);
settextstyle( GOTHIC_FONT, HORIZ_DIR, 3);
moveto(280,150);
outtext("OF");
}
if(i!=5)
{
setcolor(i+2);
settextstyle( DEFAULT_FONT, HORIZ_DIR, 3);
moveto(100, 200);
outtext("HOTEL RESERVATION");
delay(dly);
}
}
closegraph();
mainm();
}// Main Fuction End

//Main Menu Function
void mainm(void)
	{
	clrscr();
	for(li=30;li<=50;li++)
	{
		gotoxy(li,14);
		delay(30);
		cout<<"*";
	}
	for(li=50;li>=30;li--)
	{
		gotoxy(li,30);
		delay(30);
		cout<<"*";
	}
	for(lp=15;lp<30;lp++)
	{
		gotoxy(30,lp);
		delay(100);
		cout<<"|";
	}
	for(lp=29;lp>=15;lp--)
	{
		gotoxy(50,lp);
		delay(100);
		cout<<"|";
	}
	gotoxy(15,10);
	textcolor(LIGHTGRAY);
	cprintf("Press the corresponding Keys for the desired action");
	gotoxy(33,16);
	textcolor(BROWN);
	cprintf("R: Reservation");
	gotoxy(33,19);
	textcolor(LIGHTMAGENTA);
	cprintf("V: Room Status");
	gotoxy(33,22);
	textcolor(LIGHTBLUE);
	cprintf("M: Modification");
	gotoxy(33,25);
	textcolor(LIGHTRED);
	cprintf("D: Deletion");
	gotoxy(33,28);
	textcolor(GREEN);
	cprintf("Q: Quit");
	textcolor(WHITE);
	choice=getch();
	switch(choice)
	{// Choice Switch Begin
		case 'R':
		entry();
		case 'V':
		view();
		case 'M':
		modify();
		case 'D':
		delet();
		case 'Q':
		exit(0);
	default:
		{//Choice Default
		gotoxy(33,40);
		cout<<"\n\nIllegal Choice or make sure CAPS Lock is on";
		getch();
		mainm();
		}//Choice Default End
	} //Choice Switch End
	} //Main Menu Function End



// Data Entry Function
void entry(void)
{//Data Entry Function Begin
clrscr();
cout<<"Do You Want To reserve A Room? (Y/N)\n";
echoice=getch();
switch(echoice) // Echoice Switch Begin
{
case 'Y':
{ // E-Choice Case Y Begin
cout<<"\n\nEnter S for Single Room or D for Double Room\n\n";
rchoice=getch();
switch(rchoice) // Rchoice Switch Begin
{
case 'S': // Rchoice
{// R-Choice Case S Begin
for(i=1;i<size;i++)
if(sr[i]==0)
{// Single Room IF begin
clrscr();
sr[i]=1;
cout<<"\n\nRoom No :"<<i<<"Is available For Reservation";
cout<<"\n\nEnter Occupant's Name\n";
cin>>guest.name[i];
cout<<"\n\nEnter Occupant's NIC Number\n";
cin>>guest.nic[i];
cout<<"\n\nEnter Check In Date\n";
cin>>guest.rdate[i];
cout<<"\n\nEnter Check Out Date\n";
cin>>guest.cdate[i];
cout<<"\n\n\n\nDo You Want To Reserve Another Room? Y/N";
ar=getch();
switch (ar)
{// AR Switch Begin
case 'Y':
entry();
case 'N':
mainm();
default:
{//AR Default Begin
cout<<"\n\nIllegal Choice or make sure CAPS Lock is on";
getch();
mainm();
}//AR Default End

}// AR Switch End
}// Single Room IF End
}// Rchoice Case S End

case 'D':
{ //Rchoice Case D Begin
for(i=1;i<size;i++)
if(dr[i]==0)
{// Double Room IF begin
clrscr();
dr[i]=1;
cout<<"\n\nRoom No :"<<i<<"Is available For Reservation";
cout<<"\n\nEnter Occupant's Name\n";
cin>>guest1.name[i];
cout<<"\n\nEnter Occupant's NIC Number\n";
cin>>guest1.nic[i];
cout<<"\n\nEnter Check In Date\n";
cin>>guest1.rdate[i];
cout<<"\n\nEnter Check Out Date\n";
cin>>guest1.cdate[i];
cout<<"\n\n\n\nDo You Want To Reserve Another Room? Y/N";
ar=getch();
switch (ar)
{// AR Switch Begin
case 'Y':
entry();
case 'N':
mainm();
default:
{//AR Default Begin
cout<<"\n\nIllegal Choice or make sure CAPS Lock is on";
getch();
mainm();
}//AR Default End
}// AR Switch End
}// Double Room IF End
}// Rchoice Case D End
default: // Rchoice Default
{//Rchoice Default Begin
cout<<"\n\nIllegal Choice or make sure CAPS Lock is on";
getch();
mainm();
}//Rchoice default end
}//Rchoice End
}//Echoice Case Y End
case 'N':
{// Echoice Case N Begin
mainm();
}//Echoice Case N End
default: //Echoice Default
cout<<"\n\nIllegal Choice or make sure CAPS Lock is on";
getch();
mainm();
} // Echoice Default End
} //Data Entry Function End


// Data View Fucntion
void view(void)
{// Data View Function Begin
clrscr();
cout<<"Press S for Sequential Display of the room status"<<endl;
cout<<"Press R for Manual Check Of Room Status"<<endl;
vchoice=getch();
switch(vchoice)
{//Vchoice Switch Begin
case 'S':
{//Vchoice Case S Begin
clrscr();
cout<<"R.No.\tName\t\tNIC Number\tCheck In\tCheck Out\n";
for(i=1;i<size;i++)
{//i Loop Begin
if(sr[i]==1)
{//SR[i]==1 Conditional Printing Begin
cout<<setw(3)<<i<<setw(12)<<guest.name[i]
<<setw(12)<<guest.nic[i]<<setw(9)<<guest.rdate[i]
<<setw(9)<<guest.cdate[i];

}//SR[i]==1 Conditional Printing End
}//i Loop End
cout<<"\n\n\nPress Any Key For Double Room Status\n\n";
getch();
clrscr();
cout<<"R.No.\tName\t\tNIC Number\tCheck In\tCheck Out\n";
for(i=1;i<size;i++)
{//i Loop Begin
if(dr[i]==1)
{//dr[i]==1 Conditional Printing Begin
cout<<setw(3)<<i<<setw(12)<<guest1.name[i]
<<setw(12)<<guest1.nic[i]<<setw(9)<<guest1.rdate[i]
<<setw(9)<<guest1.cdate[i];

}//dr[i]==1 Conditional Printing End
}//i Loop End
cout<<"\n\n\nPress Any Key To Return To The Main Menu\n\n";
getch();
mainm();
}//Vchoice Case S End
case 'R':
{// Vchoice case R Start
clrscr();
cout<<"Enter The Room Number That Needs To Be Checked For Occupancy\n\n";
cin>>temp;
rno=atoi(temp);
// Room Number Limit Check
if(rno<1 || rno >51)
{//IF Condition Begin
cout<<"\n\nIllegal Room Number";
getch();
mainm();
} //IF Condition End
else
{ // Limit Else Falsified Begin
if(sr[rno]==1)
{//sr==1 if Begin
cout<<"\n\nSingle Room No"<<rno<<"Is Reserved";
cout<<"\n\nOccupant's Name :"<< guest.name[rno]
<<"\n\nOccupant's NIC Number :"<<guest.nic[rno]
<<"\n\nCheck In Date :"<<guest.rdate[rno]
<<"\n\nCheck Out Date :"<<guest.cdate[rno];
}//sr==1 if End
else
{// sr else begin
cout<<"\n\nSingle Room No"<<rno<<"is Vacant";
getch();
}//sr else end
if(dr[rno]==1)
{//dr==1 if Begin
cout<<"\n\nDouble Room No"<<rno<<"Is Reserved";
cout<<"\n\nOccupant's Name :"<< guest1.name[rno]
<<"\n\nOccupant's NIC Number :"<<guest1.nic[rno]
<<"\n\nCheck In Date :"<<guest1.rdate[rno]
<<"\n\nCheck Out Date :"<<guest1.cdate[rno];

cout<<"\n\nPress Any Key To Return To The Main Menu";
getch();
mainm();
}//dr==1 if End
else
{// dr else begin
cout<<"\n\nDouble Room No "<<rno<<"is Vacant";
getch();
mainm();
}//dr else end
}//Vchoice Case R End
}// Falsified Limit End
default:
{
//Vchoice Default Begin
cout<<"\n\nIllegal Choice or make sure CAPS Lock is on";
getch();
mainm();
} // Vchoice Default End
} // Vchoice Switch End
} // Data View Function End



//Modify Function
void modify(void)
{// Modify Function Begin
clrscr();
cout<<"\t\t\t\tData Modification\n\n\n\n\n\n";
cout<<"Enter The Room Number To Be Modified\n";
cin>>temp;
rno=atoi(temp);
// Room Number Limit Check
if(rno<1 || rno >51)
{//IF Condition Begin
cout<<"\n\nIllegal Room Number";
getch();
mainm();
} //IF Condition End
else
{ // Limit Else Falsified Begin
cout<<"Enter S For Single Room / D For Double Room\n";
rc=getch();
switch(rc)
{//rc Switch Begin
case 'S':
{//rc Case S Begin
if(sr[rno]==1)
{//sr==1 if Begin
clrscr();
cout<<"\n\nSingle Room No"<<rno<<"Is Reserved";
cout<<"\n\nOccupant's Name :"<< guest.name[rno]
<<"\n\nOccupant's NIC Number :"<<guest.nic[rno]
<<"\n\nCheck In Date :"<<guest.rdate[rno]
<<"\n\nCheck Out Date :"<<guest.cdate[rno];
cout<<"\n\nPress N : Change Of Name\nI : Change In NIC\nR : \
Check In Date\nO : Check Out Date\n\n";
mf=getch();
switch(mf)
{//mf switch Begin
case 'N':
{//mf Case N Begin
cout<<"\n\nEnter New Name\n";
cin>>guest.name[rno];
getch();
mainm();
}//mf Case N End
case 'I':
{//mf Case I Begin
cout<<"\n\nEnter New NIC Number\n";
cin>>guest.nic[rno];
getch();
mainm();
}//mf Case I End
case 'R':
{//mf Case R Begin
cout<<"\n\nEnter New Check In Date\n";
cin>>guest.rdate[rno];
getch();
mainm();
}//mf Case R End
case 'O':
{//mf Case O Begin
cout<<"\n\nEnter New Check Out Date\n";
cin>>guest.cdate[rno];
getch();
mainm();
}//mf Case O End
default:
{//mf Default Begin
cout<<"\n\nInvalid Entry";
getch();
mainm();
}//mf Default End
}//sr==1 if End
} //rc Case S End
else
{// sr else begin
cout<<"\n\nSingle Room No"<<rno<<"is Vacant";
getch();
mainm();
}//sr else end
}//rc Case S End
case 'D':
{// rc Case D Begin
if(dr[rno]==1)
{//dr==1 if Begin
clrscr();
cout<<"\n\nDouble Room No"<<rno<<"Is Reserved";
cout<<"\n\nOccupant's Name :"<< guest1.name[rno]
<<"\n\nOccupant's NIC Number :"<<guest1.nic[rno]
<<"\n\nCheck In Date :"<<guest1.rdate[rno]
<<"\n\nCheck Out Date :"<<guest1.cdate[rno];

cout<<"\n\nPress N : Change Of Name\nI : Change \
In NIC\nR : Check In Date\nO : Check Out Date\n\n";
mf=getch();
switch(mf)
{//mf switch Begin
case 'N':
{//mf Case N Begin
cout<<"\n\nEnter New Name\n";
cin>>guest1.name[rno];
getch();
mainm();
}//mf Case N End
case 'I':
{//mf Case I Begin
cout<<"\n\nEnter New NIC Number\n";
cin>>guest1.nic[rno];
getch();
mainm();
}//mf Case I End
case 'R':
{//mf Case R Begin
cout<<"\n\nEnter New Check In Date\n";
cin>>guest1.rdate[rno];
getch();
mainm();
}//mf Case R End
case 'O':
{//mf Case O Begin
cout<<"\n\nEnter New Check Out Date\n";
cin>>guest1.cdate[rno];
getch();
mainm();
}//mf Case O End
default:
{//mf Default Begin
cout<<"\n\nIllegal Choice or make sure CAPS Lock is on";
getch();
mainm();
}//mf Default End
}//dr==1 if End
}//rc Case D End
else
{// dr else begin
cout<<"\n\nSingle Room No"<<rno<<"is Vacant";
getch();
mainm();
}//dr else end
} // Case D End
default:
{// rc Default Begin
cout<<"\n\n\nIllegal Entry Or Make Sure CAPS Lock is On";
getch();
mainm();
} // rc Default End
} //Switch rc End
} // Limit Else Falsified End
} //Modify Function End


//Delete Function
void delet(void)
{//Delete Function
clrscr();
cout<<"Enter The Room Number To Vacate\n";
cin>>temp;
rno=atoi(temp);

// Room Number Limit Check
if(rno<1 || rno >51)
{//IF Condition Begin
cout<<"\n\nIllegal Room Number";
getch();
mainm();
} //IF Condition End
else
{// Room Number Limit Falsified Else
cout<<"\n\nSingle Or Double Room? (S/D)";
rc=getch();
switch(rc)
{//rc Switch Begin
case 'S':
{//rc Case S Begin
sr[rno]=0;
cout<<"\n\nRoom Vacated";
cout<<"\n\nPress Any Key To Exit To The Main Menu";
getch();
mainm();
}// rc Case S End
case 'D':
{//rc Case D Begin
dr[rno]=0;
cout<<"\n\nRoom Vacated";
cout<<"\n\nPress Any Key To Exit To The Main Menu";
getch();
mainm();
}//rc Case D End
default:
{//rc Default Begin
cout<<"\n\nIllegal Choice Or Make Sure CAPS Lock is ON";
getch();
mainm();
}// rc Default End
}// rc Switch End
}// Room Number Falsified Else End
}// Delete Function End

// END OF PROGRAM