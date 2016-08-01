////      <<********EMPLOYEE DATA BASE MANAGEMENT SYSTEM********>>

  #include<fstream.h>
  #include<conio.h>
  #include<stdio.h>
  #include<iomanip.h>
  #include<graphics.h>
  #include<dos.h>
  #include<string.h>
  #include<stdlib.h>
  #include<process.h>

//// <<********Global Functions********>>

  void display();
  void menu();
  void exit();
  void search_des();
  void search_dep();
  void old_rec();
  void readfile();
  void deleter();
  void names();
  void screen1();
  void date();
  void password();

//// <<********Start Of Personal Class********>>

  class personal
    {
       protected:
       float age,ht,wt,n,chld;
       long int id;
       char  fnme[20],mnme[20],lnme[20],ftnme[40],
	     hnme[40],ms,bg[10],sex,add[60],cty[20],state[20],
	     cnt[20],dte[20],lndno[30],mbno[20];
       public:
       void getdata(long int);
       void showdata();
    };
//// <<********End Of The Personal Class********>>



//// <<********Professional Class Derived From Personal Class********>>

  class professional:public personal
    {
       protected:
       float bp,al,net;
       char  pe[60],doj[40],mtrc[30],itm[30],bd[30],md[30],noc[40],
	     dep[30],des[30];
       public:
       void indata();
       void outdata();
       void completedata();
       void update();
       void writefile();
       void search_id();
       void dfile();

       int check1(char *q)
       {
	  if(strcmp(q,des)==0)
	  {
	     return 1;
	  }
	  else
	  {
	     return 0;
	  }
       }

       int check2(char *r)
       {
	  if(strcmp(r,dep)==0)
	  {
	     return 1;
	  }
	  else
	  {
	  return 0;
	  }
      }
    }s;

//// <<********End Of Professional Class********>>


//// <<********Getdata Of Personal Information********>>

  void personal::getdata(long int idno)
    {
       clrscr();
       id=idno;
       cout<<endl;
       cout<<"\t\t                 Personal Details "<<endl;
       cout<<"\t  Enter the Record for Employee ID No. : ";
       cin>>id;
       cout<<endl<<"\t  Enter the Employee's First Name : ";
       gets(fnme);
       cout<<endl<<"\t  Enter the Employee's Middle Name : ";
       gets(mnme);
       cout<<endl<<"\t  Enter the Employee's last Name  : ";
       gets(lnme);
       cout<<endl<<"\t  Enter the Father's Name  : ";
       gets(ftnme);
       cout<<endl<<"\t  Enter the Date of Birth : ";
       gets(dte);
       cout<<endl<<"\t  Enter the Age of the Employee  : ";
       cin>>age;
       cout<<endl<<"\t  Enter the Sex of the Employee(F/M)  : ";
       cin>>sex;
       cout<<endl<<"\t  Enter the Marital Status of the Employee(Y/N)  : ";
       cin>>ms;

       if(sex=='F' && ms=='Y')
       {
	  cout<<endl<<"\t  Enter the Name of the Husband  : ";
	  gets(hnme);
       }

       if(ms
	 =='Y')
       {
	  cout<<endl<<"\t  Enter the Number of Children(if any)  : ";
	  cin>>chld;
       }
       cout<<endl<<"\t  Enter the Address of the Employee  : ";
       gets(add);
       cout<<endl<<"\t  Enter the City  : ";
       gets(cty);
       cout<<endl<<"\t  Enter the State  : ";
       gets(state);
       cout<<endl<<"\t  Enter the Country  : ";
       gets(cnt);
       cout<<endl<<"\t  Enter the Contact No.    ";
       cout<<endl<<"\t  Landline No. with STD Code  :  ";
       gets(lndno);
       cout<<endl<<"\t  Mobile No. with Country Code : ";
       gets(mbno);
       cout<<endl<<"\t  Enter the Height of Employee(in cms)  : ";
       cin>>ht;
       cout<<endl<<"\t  Enter the Weight of Employee(in kg)  : ";
       cin>>wt;
       cout<<endl<<"\t  Enter the Blood Group of Employee  : ";
       gets(bg);
    }

//// <<********End Of Getdata********>>


//// <<********Showdata Of Personal Information********>>

  void personal::showdata()
    {
       cout<<"\t\t             Personal Record"<<endl;
       cout<<"\tEmployee's ID    : " <<id<<endl;
       cout<<"\tEmployee's Name  : " <<fnme<<setw(5)<<mnme<<setw(5)<<lnme<<endl;
       cout<<"\tFather's Name    : " <<ftnme<<endl;
       cout<<"\tDate Of Birth    : " <<dte<<"\tAge              : " <<age<<endl;
       cout<<"\tSex              : " <<sex<<"\t  Marital Status : " <<ms<<endl;

       if(sex=='F' && ms=='Y')
       {
	  cout<<"\tHusband's Name   : " <<hnme<<endl;
       }

       if(ms=='Y')
       {
	  cout<<"\tNo. Of Children  : " <<chld<<endl;
       }

       cout<<"\tAddress          : " <<add<<","<<cty<<","<<","<<state<<","<<cnt<<endl;
       cout<<"\tContact No.:-"<<" Landline No.:"<<lndno<<"\tMobile No.:" <<mbno<<endl;
       cout<<"\tHeight(in cms)   : " <<ht<<"\t  Weight(in kg)    : " <<wt<<endl;
       cout<<"\tBlood Group      : " <<bg<<endl;
    }

//// <<********End Of Showdata********>>



//// <<********Indata Of Professional Information********>>

  void professional::indata()
    {
       clrscr();
       cout<<endl;
       cout<<"\t\t             Professional Details     "<<endl;
       cout<<endl<<"\t  Enter the Percentage gained in High School  : ";
       gets(mtrc);
       cout<<endl<<"\t  Enter the Percentage gained in Intermediate  : ";
       gets(itm);
       cout<<endl<<"\t  Mention the Bachelor's Degree  : ";
       gets(bd);
       cout<<endl<<"\t  Mention the Master's Degree(if any)  : ";
       gets(md);
       cout<<endl<<"\t  Any Other Course  : " ;
       gets(noc);
       cout<<endl<<"\t  Enter the Previous Experience(if any)  : " ;
       gets(pe);
       cout<<endl<<"\t  Enter the Date Of Joining  : " ;
       gets(doj);
       cout<<endl<<"\t  Designation  : ";
       gets(des);
       cout<<endl<<"\t  Department   : ";
       gets(dep);
       cout<<endl<<"\t  Enter the Basic Pay(in Rs.)  : " ;
       cin>>bp;
       cout<<endl<<"\t  Enter the Allowances(in Rs.)  : " ;
       cin>>al;
    }

//// <<********End Of Indata********>>



//// <<********Outdata Of Professional Information********>>

  void professional::outdata()
    {
       cout<<endl;
       cout<<"\t\t             Professional Record " <<endl;
       cout<<"\tPercentage gained in High School   : "<<mtrc<<endl;
       cout<<"\tPercentage gained in Intermediate  : "<<itm<<endl;
       cout<<"\tBachelor's Degree                  : "<<bd<<endl;
       cout<<"\tMaster's Degree                    : "<<md<<endl;
       cout<<"\tAny Other Course                   : "<<noc<<endl;
       cout<<"\tPrevious Experience                : "<<pe<<endl;
       cout<<"\tDate Of Joining                    : "<<doj<<endl;
       cout<<"\tDesignation      : " <<des<<"\tDepartment : "<<dep<<endl;
       cout<<"\tBasic Pay(in Rs.)                  : "<<bp<<endl;
       cout<<"\tAllowances(in Rs.)                 : "<<al<<endl;
       net=bp+al;
       cout<<"\tNet Salary                         : "<<net<<endl;
    }

//// <<********End Of Outdata********>>



//// <<********Completedata********>>

  void professional::completedata()
    {
       personal::showdata();
       professional::outdata();
       getch();
    }


//// <<********Writing Data From The File xyz.txt********>>

  void professional::writefile()
    {
       fstream f1;
       professional s;
       long int id_num;
       int flag=0;
       f1.open("ss.dat",ios::in | ios::out | ios::ate | ios::binary);
       f1.seekg(0);
       s.getdata(id_num);
       s.indata();
       f1.write((char *) &s,sizeof(s));
       f1.close();
       sleep(1);
    }

//// <<********End Of Writedata********>>




//// <<********Reading data From The File xyz.txt********>>


  void readfile()
    {
       ifstream f;
       professional s;
       f.open("ss.dat",ios::in | ios::binary);
       f.seekg(0);
       while(f.read((char *) &s,sizeof(s)))
       {
	  clrscr();
	  s.completedata();
       }

       f.close();
       getch();
    }

//// <<********End Of Reading Data********>>




//// <<********Main Screen Function********>>

  void screen1()
    {
       clrscr();
       sleep(1);
       cout<<endl<<endl<<endl<<endl;

       cout<<"\t			     *  *  * "<<endl;
       delay(200);
       cout<<"\t		       *		 *  "<<endl;
       delay(200);
       cout<<"\t                   *			     * "<<endl;
       delay(200);
       cout<<"\t	       *	        	         * "<<endl;
       delay(200);
       cout<<"\t  	    *					    * "<<endl;
       delay(200);
       cout<<"\t\t  *                                           *"<<endl;
       delay(200);
       cout<<"\t\t *                                             *"<<endl;
       delay(500);
       cout<<"\t\t\t           WELCOME  TO   "<<endl<<endl<<endl;
       delay(500);
       cout<<"\t\t\t  EMPLOYEE  DATABASE  MANAGEMENT   "<<endl<<endl<<endl;
       delay(500);
       cout<<"\t\t\t             SYSTEM        ";
       sleep(2);
       clrscr();
       date();
    }

////  <<********End Of Main Screen Function********>>



////  <<********Date Function********>>


  void date()
    {
       clrscr();
       struct date t;
       struct time g;
       getdate (&t);
       gettime (&g);
       gotoxy(31,8);
       printf("\n\n\t\t\t\tDate : %d/%d/%d",t.da_day,t.da_mon,t.da_year);
       gotoxy(32,11);
       printf("\n\n\t\t\t\tTime : %d:%d",g.ti_hour,g.ti_min);
       gotoxy(20,20);
       cout<<"\n\n\t\t\t\t     You will be asked for U/N & password!";
       sleep(2);
       clrscr();
       password();
    }

////  <<********End OF Date Function********>>




////  <<********Password Function********>>

  void password()
    {
       clrscr();
       int j=0;
       int c;
       char password[25],username[25];
       char password1[25]="employee",username1[25]="employee";
       gotoxy(20,7);
       cout<<"  Enter Username :  ";
       gets(username);
       gotoxy(20,9);
       cout<<"  Enter Password :  ";
       int count =0;

       while(1)
       {
	  do
	  {
	     c=getch();

	     if(c=='\r')
	     {
		password[j]=c;
		break;
	     }

	     else
	     {
		cout<<"*";
		password[j]=c;
		j++;
	     }

	  }
	  while(c!='\r');

	  j--;
	  password[j+1]='\0';
	  count++;

	  if(strcmp(password,password1)==0 && strcmp(username,username1)==0)
	  {
	     gotoxy(55,22);
	     cout<<"Login Successful"<<endl;
	     break;

	  }

	  else
	  {
	     gotoxy(32,20);
	     cout<<"You Have Entered a Wrong Password "<<endl;
	     sleep(1);

	     if(count==3)
	     {
		gotoxy(32,23);
		cout<<"ACCESS BLOCKED";
		sleep(1);
		exit(0);
		break;
	     }

	     else
	     {
		clrscr();
		c=' ';
		j=0;
		gotoxy(20,7);
		cout<<"Enter The Username Again :  ";
		gets(username);
		gotoxy(20,9);
		cout<<"Enter The Password Again :  ";
	     }
	  }


       }
       sleep(2);
       menu();
    }

//// <<********End Of Password Function********>>



//// <<********Menu Function********>>

  void menu()
    {
       professional s;
       personal p;
       int ch;
       start:
       clrscr();
       cout<<endl<<endl;
       cout<<"   ************************************************************************* "<<endl;
       cout<<"                   EMPLOYEE DATA BASE MANAGEMENT SYSTEM"<<endl;
       cout<<"   ************************************************************************* "<<endl<<endl<<endl;

       cout<<"\t   ษอออออออออออออออออออออออออออออออออออออออออออออออออออออป"<<endl;
       cout<<"\t   บ                                                     บ"<<endl;
       cout<<"\t   บ                      Main Menu                      บ"<<endl;
       cout<<"\t   บ                ---------------------                บ"<<endl;
       cout<<"\t   บ 						         บ"<<endl;
       cout<<"\t   บอออออออออออออออออออออออออออออออออออออออออออออออออออออบ"<<endl;
       cout<<"\t   บ 1).  Add A Record                                   บ"<<endl;
       cout<<"\t   บ 2).  Search And Display Records                     บ"<<endl;
       cout<<"\t   บ 3).  Update A Record                                บ"<<endl;
       cout<<"\t   บ 4).  Delete A Record                                บ"<<endl;
       cout<<"\t   บ 5).  View The Names Of Management                   บ"<<endl;
       cout<<"\t   บ 6).  Exit                                           บ"<<endl;
       cout<<"\t   บ                                                     บ"<<endl;
       cout<<"\t   ศอออออออออออออออออออออออออออออออออออออออออออออออออออออผ"<<endl<<endl;
       cout<<"\t          Enter Your Choice  :  ";
       cin>>ch;

       switch(ch)
       {

	  case 1:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t\t     **-----------------------------**"<<endl;
	  cout<<"\t\t       You Are Ready To Add A Record  "<<endl;
	  cout<<"\t\t     **-----------------------------**"<<endl;
	  sleep(1);
	  clrscr();
	  s.writefile();
	  goto start;
	  break;

	  case 2:
	  display();
	  break;

	  case 3:
	  s.update();
	  break;

	  case 4:
	  deleter();
	  break;

	  case 5:
	  names();
	  break;

	  case 6:
	    exit();
	    break;


	  default:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t       **---------------------------------------------**"<<endl;
	  cout<<"\t         You Have Entered The Wrong Choice.Enter Again  "<<endl;
	  cout<<"\t       **---------------------------------------------**"<<endl;
	  getch();
	  clrscr();
	  menu();

       }

    }

//// <<********End Of Menu Function********>>



//// <<********Sub Function Of Menu-Display Menu Funtion********>>

  void display()
    {
       int chc;
       clrscr();
       start:
       cout<<endl<<endl;
       cout<<"\t\t                ****************** "<<endl;
       cout<<"\t\t                   DI$PLAY MENU "<<endl;
       cout<<"\t\t                ******************"<<endl<<endl<<endl;
       cout<<"\tษออออออออออออออออออออออออออออออออออออออออออออออออออออออออป"<<endl;
       cout<<"\tบ	                                          	     บ"<<endl;
       cout<<"\tบ 1).  Display All Records                               บ"<<endl;
       cout<<"\tบ 2).  Search And Display A Record By ID No.             บ"<<endl;
       cout<<"\tบ 3).  Search And Display A Record By Designation        บ"<<endl;
       cout<<"\tบ 4).  Search And Display A Record By Department         บ"<<endl;
       cout<<"\tบ 5).  Display Old Records                               บ"<<endl;
       cout<<"\tบ 6).  Go To Main Menu                                   บ"<<endl;
       cout<<"\tบ                                                        บ"<<endl;
       cout<<"\tศออออออออออออออออออออออออออออออออออออออออออออออออออออออออผ"<<endl<<endl;
       cout<<"\t     Enter your choice :  ";
       cin>>chc;

       switch(chc)
       {

	  case 1:
	  clrscr();
	  readfile();
	  clrscr();
	  goto start;
	  break;

	  case 2:
	  clrscr();
	  s.search_id();
	  getch();
	  clrscr();
	  goto start;
	  break;

	  case 3:
	  clrscr();
	  search_des();
	  getch();
	  clrscr();
	  goto start;
	  break;

	  case 4:
	  clrscr();
	  search_dep();
	  getch();
	  clrscr();
	  goto start;
	  break;

	  case 5:
	  clrscr();
	  old_rec();
	  getch();
	  clrscr();
	  goto start;
	  break;

	  case 6:
	  clrscr();
	  menu();
	  break;

	  default:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t       **---------------------------------------------**"<<endl;
	  cout<<"\t         You Have Entered The Wrong Choice.Enter Again  "<<endl;
	  cout<<"\t       **---------------------------------------------**"<<endl;
	  getch();
	  clrscr();
	  display();

       }

    }

//// <<********End Of Display Menu Funtion********>>



//// <<********Deleting Records From The File********>>

  void old_rec()
    {
       clrscr();
       fstream f;
       professional s;
       f.open("ss2.dat",ios::in | ios::binary);
       f.seekg(0);

       while(f.read((char *) &s,sizeof(s)))
       {
	  clrscr();
	  s.completedata();
       }

       f.close();
    }

//// <<********End Of Deleting Records********>>



//// <<********Sub Function Of Display Menu-Search Function********>>

//// <<******** Search By ID********>>

  void professional::search_id()
    {
       fstream f;
       professional s;
       long int n;
       float flag=0;
       clrscr();
       cout<<endl<<endl<<endl<<endl;
       cout<<"\t\t  Enter The ID No. Of The Employee : ";
       cin>>n;
       f.open("ss.dat",ios::in|ios::binary);
       f.seekg(0);

       while(f.read((char *) &s,sizeof(s)))
       {

	  if(n==s.id)
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t\t   RECORD FOUND  "<<endl;
	     cout<<"\t\t\t******************"<<endl;
	     getch();
	     clrscr();
	     flag=1;
	     s.completedata();
	     getch();
	  }

       }

       if(flag==1)
       {
	  clrscr();
	  display();
       }

       else
       {
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t\t--------------------------------------------- "<<endl;
	  cout<<"\t\t|*******************************************| "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|            <RECORD NOT FOUND>             | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|*******************************************| "<<endl;
	  cout<<"\t\t--------------------------------------------- "<<endl;
	  getch();
	  clrscr();
	  display();
       }

    }

//// <<********End Of Search By ID********>>



//// <<********Search By Designation********>>


  void search_des()
    {
       fstream f;
       professional s;
       char ds[30];
       float flag=0;
       clrscr();
       cout<<endl<<endl<<endl<<endl;
       cout<<"\t\t  Enter The Designation Of The Employee : ";
       gets(ds);
       f.open("ss.dat",ios::in|ios::binary);
       f.seekg(0);

       while(f.read((char *) &s,sizeof(s)))
       {

	  if(s.check1(ds))
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t\t   RECORD FOUND  "<<endl;
	     cout<<"\t\t\t*******************"<<endl;
	     getch();
	     clrscr();
	     flag=1;
	     s.completedata();
	     getch();
	  }

       }

       if(flag==1)
       {
	  clrscr();
	  display();
       }

       else
       {
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t\t--------------------------------------------- "<<endl;
	  cout<<"\t\t|*******************************************| "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|            <Record Not Found>             | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|*******************************************| "<<endl;
	  cout<<"\t\t--------------------------------------------- "<<endl;
	  getch();
	  clrscr();
	  display();
       }

    }

//// <<********End Of Search By Designation********>>


//// <<********Search By Department********>>

  void search_dep()
    {
       fstream f;
       professional s;
       char dp[30];
       float flag;
       clrscr();
       cout<<endl<<endl<<endl<<endl;
       cout<<"\t\t  Enter The Department Of The Employee : ";
       gets(dp);
       f.open("ss.dat",ios::in|ios::binary);
       f.seekg(0);

       while(f.read((char *) &s,sizeof(s)))
       {

	  if(s.check2(dp))
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t\t   RECORD FOUND  "<<endl;
	     cout<<"\t\t\t******************"<<endl;
	     getch();
	     clrscr();
	     flag=1;
	     s.completedata();
	     getch();
	  }
       }

       if(flag==1)
       {
	  clrscr();
	  display();
       }

       else
       {
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t\t--------------------------------------------- "<<endl;
	  cout<<"\t\t|*******************************************| "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|            <Record Not Found>             | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|*******************************************| "<<endl;
	  cout<<"\t\t--------------------------------------------- "<<endl;
	  getch();
	  clrscr();
	  display();
       }

    }

//// <<********End Of Search By Department********>>



//// <<********Sub Function Of Menu-Update Menu********>>

  void professional::update()
    {
       clrscr();
       cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
       cout<<"\t\t          **--------------------------------**"<<endl;
       cout<<"\t\t            You Are Ready To Update A Record"  <<endl;
       cout<<"\t\t          **--------------------------------**"<<endl;
       getch();
       fstream f;
       professional s;
       long int a;
       char     newadd[30],newcty[30],newstate[30],newcnt[30],newlndno[30],
		newmbno[30],newdes[20],newdep[20];
       float    flag=0,i,newbp,newal;
       int      c,h,w;

       umenu:
       clrscr();
       cout<<endl<<endl<<endl<<endl;
       cout<<"\t\t             *****************  "<<endl;
       cout<<"\t\t                ***********     "<<endl;
       cout<<"\t\t                UPDATE MENU     "<<endl;
       cout<<"\t\t                ***********     "<<endl;
       cout<<"\t\t             *****************  "<<endl<<endl<<endl;
       cout<<"\t1).  Update Personal Record " <<endl;
       cout<<"\t2).  Update Professional Record"<<endl;
       cout<<"\t3).  Go To Main Menu      "<<endl<<endl;
       cout<<"\t     Enter Your Choice :  ";
       cin>>c;

       switch(c)
       {

//// <<********Update Personal Record********>>

	  upmenu:

	  case 1:
	  clrscr();
	  cout<<endl<<endl;
	  cout<<"\t\t          Update Personal Record  "<<endl;
	  cout<<"\t\t        ************************** "<<endl;
	  cout<<"\t\t        ************************** "<<endl<<endl<<endl;
	  cout<<"\t 1).  Update Address"<<endl;
	  cout<<"\t 2).  Update City"<<endl;
	  cout<<"\t 3).  Update State"<<endl;
	  cout<<"\t 4).  Update Country"<<endl;
	  cout<<"\t 5).  Update Landline No."<<endl;
	  cout<<"\t 6).  Update Mobile No."<<endl;
	  cout<<"\t 7).  Go To Update Menu "<<endl;
	  cout<<"\t 8).  Go To Menu  "<<endl<<endl;
	  cout<<"\t      Enter Your Choice : ";
	  cin>>h;

	  switch(h)
	  {

	     case 1:
	     clrscr();
	     cout<<endl<<endl<<endl<<endl;
	     cout<<"\t\t   Enter The ID No. Of The Employee : ";
	     cin>>a;
	     f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	     f.seekg(0);

	     while(f.read((char *) &s,sizeof(s)))
	     {

		if(a==s.id)
		{
		   clrscr();
		   cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		   cout<<"\t\t\t   MATCH FOUND  "<<endl;
		   cout<<"\t\t\t******************"<<endl;
		   getch();
		   clrscr();
		   i=sizeof(s);
		   f.seekp(-i,ios::cur);
		   cout<<endl<<endl<<endl<<endl;
		   cout<<"\t*  Enter New Address  : ";
		   gets(newadd);
		   cout<<endl;
		   cout<<"\t*  Old Address is     : "<<s.add<<endl;
		   strcpy(s.add,newadd);
		   cout<<"\t*  Changed Address is : "<<s.add<<endl;
		   f.write((char *) &s,sizeof(s));
		   flag=1;
		   getch();
		   clrscr();
		   goto upmenu;

		}

	     }

	     if(flag==1)
	     {
		clrscr();
		goto upmenu;
	     }

	     else
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t--------------------------------------------- "<<endl;
		cout<<"\t\t|*******************************************| "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|            <Match Not Found>              | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|*******************************************| "<<endl;
		cout<<"\t\t--------------------------------------------- "<<endl;
		f.close();
		getch();
		clrscr();
		goto upmenu;
	     }
	     break;

	     case 2:
	     clrscr();
	     cout<<endl<<endl<<endl<<endl;
	     cout<<"\t\t  Enter The ID No. Of The Employee : ";
	     cin>>a;
	     f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	     f.seekg(0);

	     while(f.read((char *) &s,sizeof(s)))
	     {

		if(a==s.id)
		{
		   clrscr();
		   cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		   cout<<"\t\t\t   MATCH FOUND  "<<endl;
		   cout<<"\t\t\t******************"<<endl;
		   getch();
		   clrscr();
		   i=sizeof(s);
		   f.seekp(-i,ios::cur);
		   cout<<endl<<endl<<endl<<endl;
		   cout<<"\t*  Enter New City  : ";
		   gets(newcty);
		   cout<<endl;
		   cout<<"\t*  Old City is     : "<<s.cty<<endl;
		   strcpy(s.cty,newcty);
		   cout<<"\t*  Changed City is : "<<s.cty<<endl;
		   f.write((char *) &s,sizeof(s));
		   flag=1;
		   getch();
		   clrscr();
		   goto upmenu;
		}

	     }

	     if(flag==1)
	     {
		clrscr();
		goto upmenu;
	     }

	     else
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t--------------------------------------------- "<<endl;
		cout<<"\t\t|*******************************************| "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|            <Match Not Found>              | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|*******************************************| "<<endl;
		cout<<"\t\t--------------------------------------------- "<<endl;
		f.close();
		getch();
		clrscr();
		goto upmenu;
	     }
	     break;

	     case 3:
	     clrscr();
	     cout<<endl<<endl<<endl<<endl;
	     cout<<"\t\t  Enter The ID No. Of The Employee : ";
	     cin>>a;
	     f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	     f.seekg(0);

	     while(f.read((char *) &s,sizeof(s)))
	     {

		if(a==s.id)
		{
		   clrscr();
		   cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		   cout<<"\t\t\t   MATCH FOUND  "<<endl;
		   cout<<"\t\t\t******************"<<endl;
		   getch();
		   clrscr();
		   i=sizeof(s);
		   f.seekp(-i,ios::cur);
		   cout<<endl<<endl<<endl<<endl;
		   cout<<"\t*  Enter New State  : ";
		   gets(newstate);
		   cout<<endl;
		   cout<<"\t*  Old State is     : "<<s.state<<endl;
		   strcpy(s.state,newstate);
		   cout<<"\t*  Changed State is : "<<s.state<<endl;
		   f.write((char *) &s,sizeof(s));
		   flag=1;
		   getch();
		   clrscr();
		   goto upmenu;
		}

	     }

	     if(flag==1)
	     {
		clrscr();
		goto upmenu;
	     }

	     else
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t--------------------------------------------- "<<endl;
		cout<<"\t\t|*******************************************| "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|            <Match Not Found>              | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|                                           | "<<endl;
		cout<<"\t\t|*******************************************| "<<endl;
		cout<<"\t\t--------------------------------------------- "<<endl;
		f.close();
		getch();
		clrscr();
		goto upmenu;
	     }
	     break;

	     case 4:
	     clrscr();
	     cout<<endl<<endl<<endl<<endl;
	     cout<<"\t\t  Enter The ID No. Of The Employee : ";
	     cin>>a;
	     f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	     f.seekg(0);

	     while(f.read((char *) &s,sizeof(s)))
	     {

		if(a==s.id)
		{
		   clrscr();
		   cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		   cout<<"\t\t\t   MATCH FOUND  "<<endl;
		   cout<<"\t\t\t******************"<<endl;
		   getch();
		   clrscr();
		   i=sizeof(s);
		   f.seekp(-i,ios::cur);
		   cout<<endl<<endl<<endl<<endl;
		   cout<<"\t*  Enter New Country  : ";
		   gets(newcnt);
		   cout<<endl;
		   cout<<"\t*  Old Country is     : "<<s.cnt<<endl;
		   strcpy(s.cnt,newcnt);
		   cout<<"\t*  Changed Country is : "<<s.cnt<<endl;
		   f.write((char *) &s,sizeof(s));
		   flag=1;
		   getch();
		   clrscr();
		   goto upmenu;
	     }

	  }

	  if(flag==1)
	  {
	     clrscr();
	     goto upmenu;
	  }

	  else
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|            <Match Not Found>              | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     f.close();
	     getch();
	     clrscr();
	     goto upmenu;
	  }
	  break;

	  case 5:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl;
	  cout<<"\t\t  Enter The ID No. Of The Employee : ";
	  cin>>a;
	  f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	  f.seekg(0);

	  while(f.read((char *) &s,sizeof(s)))
	  {

	     if(a==s.id)
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t\t   MATCH FOUND  "<<endl;
		cout<<"\t\t\t******************"<<endl;
		getch();
		clrscr();
		i=sizeof(s);
		f.seekp(-i,ios::cur);
		cout<<endl<<endl<<endl<<endl;
		cout<<"\t*  Enter New Landline No.  : ";
		gets(newlndno);
		cout<<endl;
		cout<<"\t*  Old Landline No. is     : "<<s.lndno<<endl;
		strcpy(s.lndno,newlndno);
		cout<<"\t*  Changed Landline No. is : "<<s.lndno<<endl;
		f.write((char *) &s,sizeof(s));
		flag=1;
		getch();
		clrscr();
		goto upmenu;
	     }

	  }

	  if(flag==1)
	  {
	     clrscr();
	     goto upmenu;
	  }

	  else
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|            <Match Not Found>              | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     f.close();
	     getch();
	     clrscr();
	     goto upmenu;
	  }
	  break;

	  case 6:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl;
	  cout<<"\t\t  Enter The ID No. Of The Employee : ";
	  cin>>a;
	  f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	  f.seekg(0);

	  while(f.read((char *) &s,sizeof(s)))
	  {

	     if(a==s.id)
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t\t   MATCH FOUND  "<<endl;
		cout<<"\t\t\t******************"<<endl;
		getch();
		clrscr();
		i=sizeof(s);
		f.seekp(-i,ios::cur);
		cout<<endl<<endl<<endl<<endl;
		cout<<"\t*  Enter New Mobile No.  : ";
		gets(newmbno);
		cout<<endl;
		cout<<"\t*  Old Mobile No. is     : "<<s.mbno<<endl;
		strcpy(s.mbno,newmbno);
		cout<<"\t*  Changed Mobile No. is : "<<s.mbno<<endl;
		f.write((char *) &s,sizeof(s));
		flag=1;
		getch();
		clrscr();
		goto upmenu;
	     }

	  }

	  if(flag==1)
	  {
	     clrscr();
	     goto upmenu;
	  }

	  else
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|            <Match Not Found>              | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     f.close();
	     getch();
	     clrscr();
	     goto upmenu;
	  }
	  break;

 //// <<********End Of Update Personal Record********>>

	  case 7:
	  clrscr();
	  goto umenu;
	  break;

	  case 8:
	  clrscr();
	  menu();
	  break;

	  default:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t\t*************************************************"<<endl;
	  cout<<"\t\t  You Have Entered The Wrong Choice.Enter Again "<<endl;
	  cout<<"\t\t*************************************************"<<endl;
	  getch();
	  clrscr();
	  goto upmenu;
       }

       //// <<********Update Professional Record********>>

       usmenu:

       case 2:
       clrscr();
       cout<<endl<<endl;
       cout<<"\t\t               Update Professinal Record   "<<endl;
       cout<<"\t\t             ***************************** "<<endl;
       cout<<"\t\t             ***************************** "<<endl<<endl;
       cout<<"\t 1).  Update Designation"<<endl;
       cout<<"\t 2).  Update Department"<<endl;
       cout<<"\t 3).  Update Basic Pay"<<endl;
       cout<<"\t 4).  Update Allowances"<<endl;
       cout<<"\t 5).  Go To Update Menu"<<endl;
       cout<<"\t 6).  Go To Main Menu  "<<endl<<endl;
       cout<<"\t      Enter Your Choice : ";
       cin>>w;

       switch(w)
       {

	  case 1:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl;
	  cout<<"\t\t  Enter The ID No. Of The Employee : ";
	  cin>>a;
	  f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	  f.seekg(0);

	  while(f.read((char *) &s,sizeof(s)))
	  {

	     if(a==s.id)
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t\t   MATCH FOUND  "<<endl;
		cout<<"\t\t\t******************"<<endl;
		getch();
		clrscr();
		i=sizeof(s);
		f.seekp(-i,ios::cur);
		cout<<endl<<endl<<endl<<endl;
		cout<<"\t*  Enter New Designation   : ";
		gets(newdes);
		cout<<endl;
		cout<<"\t*  Old Designation is      : "<<s.des<<endl;
		strcpy(s.des,newdes);
		cout<<"\t*  Changed Designation is  : "<<s.des<<endl;
		f.write((char *) &s,sizeof(s));
		flag=1;
		getch();
		clrscr();
		goto usmenu;
	     }

	  }

	  if(flag==1)
	  {
	     clrscr();
	     goto usmenu;
	  }

	  else
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|            <Match Not Found>              | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     f.close();
	     getch();
	     clrscr();
	     goto usmenu;
	  }
	  break;

	  case 2:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl;
	  cout<<"\t\t  Enter The ID No. Of The Employee : ";
	  cin>>a;
	  f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	  f.seekg(0);

	  while(f.read((char *) &s,sizeof(s)))
	  {

	     if(a==s.id)
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t\t   MATCH FOUND  "<<endl;
		cout<<"\t\t\t******************"<<endl;
		getch();
		clrscr();
		i=sizeof(s);
		f.seekp(-i,ios::cur);
		cout<<endl<<endl<<endl<<endl;
		cout<<"\t*  Enter New Department  : ";
		gets(newdep);
		cout<<endl;
		cout<<"\t*  Old Department is     :  "<<s.dep<<endl;
		strcpy(s.dep,newdep);
		cout<<"\t*  Changed Department is : "<<s.dep<<endl;
		f.write((char *) &s,sizeof(s));
		flag=1;
		getch();
		clrscr();
		goto usmenu;
	     }

	  }

	  if(flag==1)
	  {
	     clrscr();
	     goto usmenu;
	  }

	  else
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|            <Match Not Found>              | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     f.close();
	     getch();
	     clrscr();
	     goto usmenu;
	  }
	  break;

	  case 3:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl;
	  cout<<"\t\t  Enter The ID No. Of The Employee : ";
	  cin>>a;
	  f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	  f.seekg(0);

	  while(f.read((char *) &s,sizeof(s)))
	  {

	     if(a==s.id)
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t\t   MATCH FOUND  "<<endl;
		cout<<"\t\t\t******************"<<endl;
		getch();
		clrscr();
		i=sizeof(s);
		f.seekp(-i,ios::cur);
		cout<<"\t*  Enter New Basic Pay  : ";
		cin>>newbp;
		cout<<endl;
		cout<<"\t*  Old Basic Pay is     : "<<s.bp<<endl;
		s.bp=newbp;
		cout<<"\t*  Changed Basic Pay is : "<<s.bp<<endl;
		f.write((char *) &s,sizeof(s));
		flag=1;
		getch();
		clrscr();
		goto usmenu;
	     }

	  }

	  if(flag==1)
	  {
	     clrscr();
	     goto usmenu;
	  }

	  else
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|            <Match Not Found>              | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     f.close();
	     getch();
	     clrscr();
	     goto usmenu;
	  }

	  case 4:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl;
	  cout<<"\t\t  Enter The ID No. Of The Employee : ";
	  cin>>a;
	  f.open("ss.dat",ios::in | ios::out | ios::binary | ios::ate);
	  f.seekg(0);

	  while(f.read((char *) &s,sizeof(s)))
	  {

	     if(a==s.id)
	     {
		clrscr();
		cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
		cout<<"\t\t\t   MATCH FOUND  "<<endl;
		cout<<"\t\t\t******************"<<endl;
		getch();
		clrscr();
		i=sizeof(s);
		f.seekp(-i,ios::cur);
		cout<<"\t*  Enter New Allowances  : ";
		cin>>newal;
		cout<<endl;
		cout<<"\t*  Old Allowances is     : "<<s.al<<endl;
		s.al=newal;
		cout<<"\t*  Changed Allowances is : "<<s.al<<endl;
		f.write((char *) &s,sizeof(s));
		flag=1;
		getch();
		clrscr();
		goto usmenu;
	     }

	  }

	  if(flag==1)
	  {
	     clrscr();
	     goto usmenu;
	  }

	  else
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|            <Match Not Found>              | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|                                           | "<<endl;
	     cout<<"\t\t|*******************************************| "<<endl;
	     cout<<"\t\t--------------------------------------------- "<<endl;
	     f.close();
	     getch();
	     clrscr();
	     goto usmenu;
	  }

//// <<********End Of Update Professional Record********>>

	  case 5:
	  clrscr();
	  goto usmenu;
	  break;

	  case 6:
	  clrscr();
	  menu();
	  break;

	  default:
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t\t*************************************************"<<endl;
	  cout<<"\t\t  You Have Entered The Wrong Choice.Enter Again "<<endl;
	  cout<<"\t\t*************************************************"<<endl;
	  getch();
	  clrscr();
	  goto usmenu;
       }

       case 3:
       clrscr();
       menu();
       break;

       default:
       clrscr();
       cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
       cout<<"\t\t*************************************************"<<endl;
       cout<<"\t\t  You Have Entered The Wrong Choice.Enter Again "<<endl;
       cout<<"\t\t*************************************************"<<endl;
       getch();
       clrscr();
       goto umenu;

    }
  }
//// <<********Sub Function Of Main Menu- Delete Record********>>


  void deleter()
    {
       clrscr();
       int a;
       cout<<endl<<endl<<endl<<endl;
       cout<<"\t               **************************************"<<endl;
       cout<<"\t                  You Are Ready To Delete A Record"<<endl;
       cout<<"\t               **************************************"<<endl<<endl<<endl;
       cout<<"\t 1). Delete  A Record By ID No."<<endl;
       cout<<"\t 2). Go To Main Menu"<<endl<<endl;
       cout<<"\t     Enter Your Choice : ";
       cin>>a;

       switch(a)
       {

	  case 1:
	  clrscr();
	  s.dfile();
	  break;

	  case 2:
	  clrscr();
	  menu();
	  break;

       }
       getch();
    }

//// <<********End Of Delete Record********>>


//// <<********Delete Record Files********>>

  void professional::dfile()
    {
       fstream f1,f2,f3;
       professional s;
       long int n;
       int flag=0;
       f1.open("ss.dat",ios::in | ios::binary);
       f2.open("ss2.dat",ios::out | ios::ate | ios::binary);
       f3.open("ss3.dat",ios::out | ios::ate | ios::binary);
       cout<<endl<<endl<<endl<<endl;
       cout<<"\t\t  Enter The ID No. Of The Employee : ";
       cin>>n;
       f1.seekg(0);

       while(f1.read((char *) &s,sizeof(s)))
       {

	  if(s.id==n)
	  {
	     clrscr();
	     cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	     cout<<"\t\t\t   MATCH FOUND  "<<endl;
	     cout<<"\t\t\t******************"<<endl;
	     getch();
	     flag=1;
	     f2.write((char *) &s,sizeof(s));
	  }

	  else
	  {
	     f3.write((char *) &s,sizeof(s));
	  }
       }
       remove("ss.dat");
       rename("ss2.dat","ss.dat");
       clrscr();
       deleter();

       if(s.id!=n)
       {
	  clrscr();
	  cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
	  cout<<"\t\t--------------------------------------------- "<<endl;
	  cout<<"\t\t|*******************************************| "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|            <Match Not Found>              | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|                                           | "<<endl;
	  cout<<"\t\t|*******************************************| "<<endl;
	  cout<<"\t\t--------------------------------------------- "<<endl;
	  getch();
	  clrscr();
	  deleter();
       }
    }


//// <<********Sub Function Of Main Menu-Names********>>


  void names()
    {
       clrscr();
       cout<<endl<<endl<<endl<<endl<<endl<<endl;
       cout<<"                  Head Of Department    :- Er. Ritu Bala"<<endl<<endl;
       cout<<"                  Under the Guidance of :- Er. Ramesh Kumar"<<endl<<endl;
       cout<<"                  Team Members          :- Vinay Sharda"<<endl<<endl;
       cout<<"                                           Ramdeep Singh"<<endl<<endl;
       getch();
       clrscr();
       menu();
    }


//// <<********Sub Function Of Main Menu-Exit********>>

  void exit()
    {
       clrscr();
       cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl;
       cout<<"\t\t    | | |                          | | |  "<<endl;
       cout<<"\t\t    ****** SIGNED OUT SUCCESSFULLY****** "<<endl;
       cout<<"\t\t   | | | |                        | | | | "<<endl;
       sleep(1);
       exit(0);
    }

//// <<********End Of Exit********>>

//// <<********End Of Sub Functions Of Main Menu********>>


//// <<********Main Function********>>

  void main()
    {
       clrscr();
       textcolor(10);
       textbackground(0);
       professional s;
       screen1();
    }

//// <<********End Of The Main Function********>>











