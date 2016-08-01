#include<iostream.h>
#include<fstream.h>
#include<stdio.h>
#include<dos.h>
#include<ctype.h>
#include<string.h>
#include<graphics.h>
#include<iomanip.h>
#include<conio.h>

class shop
{      private:
	     int copies,amt;
	     int no_of_books;
	     int invoice_no,size;
	     char name[30];
	     char code[10];
	     char address[50];
	     char despatch[30];
	     char payment[30];
       public:
	     void menu();
	     void basic_book();
	     void cobol1_book();
	     void cobol2_book();
	     void cobol3_book();
	     void dbase_book();
	     void foxbase_book();
	     void foxpro_book();
	     void dbase_three_book();
	     void dbase_four_book();
	     void dbase_threeplus_book();
	     void c_language_book();
	     void borland_c_book();
	     void turbo_c_book();
	     void c_plus_book();
	     void turbo_c_plus_book();
	     void borland_c_plus_book();
	     void wordstar_book();
	     void ms_office_book();
	     void tally_book();
	     void tally_four_book();
	     void internet_book();
	     void coreldrw_book();
	     void photoshop_book();
	     void corel_eight_book();
	     void oracle_book();
	     void compute_data();
	     void enter_data();
	     void display_data();
	     void customer_display_data();
	     void enter1_data();
	     void search_data();
	     void welcome_menu();
	     void main_menu();
}customer;

    void shop::welcome_menu()
    {
      int driver,mode;
      driver=DETECT;
      initgraph(&driver,&mode,"..\\bgi");
      setbkcolor(6);
      setcolor(3);
      settextstyle(5,0,8);
      outtextxy(150,25,"WELCOME");
      outtextxy(60,150,"COMPUTER");
      outtextxy(20,300,"SANDHU BOOK STALL");
      delay(5000);
      closegraph();

      initgraph(&driver,&mode,"..\\bgi");
      setbkcolor(10);
      setcolor(1);
      settextstyle(4,0,8);
      outtextxy(150,25,"MADE BY");
      outtextxy(50,150,"SIMAR");
      outtextxy(160,300,"SANDHU");
      delay(5000);
      closegraph();
   }

   void shop::main_menu()
   {
      clrscr();
      gotoxy(15,7);
      cout<<"WELCOME TO MAIN OF CREATIVE PUBLICATION"<<endl;
      gotoxy(15,8);
      cout<<"***************************************"<<endl;
      gotoxy(15,11);
      cout<<"1 PRESS 1 TO DISPLAY THE LIST OF BOOKS "<<endl;
      gotoxy(15,13);
      cout<<"2 PRESS 2 TO ENTER DATA FOR CUSTOMER,BOOKS "<<endl;
      gotoxy(18,14);
      cout<<"DISPLAY THE TOTAL ,PRINT THE DETAILS "<<endl;
      gotoxy(15,16);
      cout<<"3 PRESS 3TO SEARCH IF THE CUSTOMER EXIT IN SHOPS RECORD"<<endl;
      gotoxy (15,17);
      cout<<"4 PRESS 4 TO EXIT ";
   }


   void shop::menu()
   {
      gotoxy(38,7);
      cout<<"MENU";
      cout<<"\n"<<setw(15)<<"PRODUCT NUMBER"<<setw(30)<<"PRODUCT NAME";
      cout<<setw(20)<<"PRICE";
      cout<<"\n\n";
      cout<<"\n"<<setw(15)<<"1."<<setw(30)<<"BASIC"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(15)<<"2."<<setw(30)<<"COBOL1"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(15)<<"3."<<setw(30)<<"COBOL2"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(15)<<"4."<<setw(30)<<"COBOL3"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(15)<<"5."<<setw(30)<<"DBASE"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(15)<<"6."<<setw(30)<<"FOXBASE"<<setw(20)<<"80.00";
      cout<<"\n"<<setw(15)<<"7."<<setw(30)<<"FOXPRO"<<setw(20)<<"80.00";
      cout<<"\n"<<setw(15)<<"8."<<setw(30)<<"DBASE III"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(15)<<"9."<<setw(30)<<"DBASE IV"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(150)<<"10."<<setw(30)<<"DBASE III"<<setw(20)<<"40.00";
      cout<<"\n\n\n";
      cout<<"\n"<<"PRESS ENTER TO CONTINUE--------";
      getchar();
      clrscr();
      cout<<"\n\n\n";
      cout<<"\n"<<setw(15)<<"11."<<setw(30)<<"C LANGUAGE"<<setw(20)<<"160.00";
      cout<<"\n"<<setw(15)<<"12."<<setw(30)<<"BORLAND C"<<setw(20)<<"200.00";
      cout<<"\n"<<setw(15)<<"13."<<setw(30)<<"TUROB C"<<setw(20)<<"200.00";
      cout<<"\n"<<setw(15)<<"14."<<setw(30)<<"C++"<<setw(20)<<"150.00";
      cout<<"\n"<<setw(15)<<"15."<<setw(30)<<"TUROB C++"<<setw(20)<<"150.00";
      cout<<"\n"<<setw(15)<<"16."<<setw(30)<<"BORLAND C++"<<setw(20)<<"150.00";
      cout<<"\n"<<setw(15)<<"17."<<setw(30)<<"WORD STAR"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(15)<<"18."<<setw(30)<<"MS-OFFICE"<<setw(20)<<"80.00";
      cout<<"\n\n\n\n\n"<<"PRESS ENTER TO COUTINUE---------";
      getchar();
      clrscr();
      cout<<"\n\n\n";
      cout<<"\n"<<setw(15)<<"19."<<setw(30)<<"TALLY"<<setw(20)<<"80.00";
      cout<<"\n"<<setw(15)<<"20."<<setw(30)<<"TALLY 4.5"<<setw(20)<<"80.00";
      cout<<"\n"<<setw(15)<<"21."<<setw(30)<<"INTERNET"<<setw(20)<<"40.00";
      cout<<"\n"<<setw(15)<<"22."<<setw(30)<<"COREL DRAW"<<setw(20)<<"100.00";
      cout<<"\n"<<setw(15)<<"23."<<setw(30)<<"PHOTO SHOP"<<setw(20)<<"100.00";
      cout<<"\n"<<setw(15)<<"24."<<setw(30)<<"COREL 8.0"<<setw(20)<<"150.00";
      cout<<"\n"<<setw(15)<<"25."<<setw(30)<<"ORACLE"<<setw(20)<<"100.00";
      cout<<"\n\n\n\n\n";
      cout<<"\n"<< "PRESS ENTER TO CONTINUE -------";
   }

   void shop::basic_book()
   {
      cout<<"Enter the number of copies for BASIC Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::cobol1_book()
   {
      cout<<"Enter the number of copies for COBOL1 Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::cobol2_book()
   {
      cout<<"Enter the number of copies for COBOL2 Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::cobol3_book()
   {
      cout<<"Enter the number of copies for BASIC Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::dbase_book()
   {
      cout<<"Enter the number of copies for DBASE Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::foxbase_book()
   {
      cout<<"Enter the number of copies for FOXBASE Book";
      cin>>copies;
      amt=80*copies;
   }
   void shop::foxpro_book()
   {
      cout<<"Enter the number of copies for FOXPRO Book";
      cin>>copies;
      amt=80*copies;
   }
   void shop::dbase_three_book()
   {
      cout<<"Enter the number of copies for DBASE III Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::dbase_four_book()
   {
      cout<<"Enter the number of copies for DBASE IV Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::dbase_threeplus_book()
   {
      cout<<"Enter the number of copies for DBASE III+Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::c_language_book()
   {
      cout<<"Enter the number of copies for C LANGUAGE Book";
      cin>>copies;
      amt=160*copies;
   }
   void shop::borland_c_book()
   {
      cout<<"Enter the number of copies for BORLAND C Book";
      cin>>copies;
      amt=200*copies;
   }
   void shop::turbo_c_book()
   {
      cout<<"Enter the number of copies for TURBO C Book";
      cin>>copies;
      amt=200*copies;
   }
   void shop::c_plus_book()
   {
      cout<<"Enter the number of copies for C++ Book";
      cin>>copies;
      amt=150*copies;
   }
   void shop::turbo_c_plus_book()
   {
      cout<<"Enter the number of copies for TURBO C++ Book";
      cin>>copies;
      amt=150*copies;
   }
   void shop::borland_c_plus_book()
   {
      cout<<"Enter the number of copies for BORLAND C++ Book";
      cin>>copies;
      amt=150*copies;
   }
   void shop::wordstar_book()
   {
      cout<<"Enter the number of copies for WORD STAR Book";
      cin>>copies;
      amt=40*copies;
   }
   void shop::ms_office_book()
   {
      cout<<"Enter the number of copies for MS-OFFICE Book";
      cin>>copies;
      amt=80*copies;
   }
   void shop::tally_book()
   {
      cout<<"Enter the number of copies for TALLY Book";
      cin>>copies;
      amt=80*copies;
   }
   void shop::tally_four_book()
   {
      cout<<"Enter the number of copies for TALLY 4.5 Book";
      cin>>copies;
      amt=80*copies;

   }
   void shop::internet_book()
   {
      cout<<"Enter the number of copies for INTERNET Book ";
      cin>>copies;
      amt=40*copies;
   }
   void shop::coreldrw_book()
   {
      cout<<"Enter the number of copies for COREL DRAW Book";
      cin>>copies;
      amt=100*copies;
   }
   void shop::photoshop_book()
   {
      cout<<"Enter the number of copies for PHOTOSHOP Book";
      cin>>copies;
      amt=100*copies;
   }
   void shop::corel_eight_book()
   {
      cout<<"Enter the number of copies for COREL DRAW 8.0 Book";
      cin>>copies;
      amt=150*copies;
   }
   void shop::oracle_book()
   {
      cout<<"Enter the number of copies for ORACLE Book";
      cin>>copies;
      amt=100*copies;
   }
   void shop::compute_data()
   {
      int ch_books;
      int sum=0;
      clrscr();
      cout<<"ENTER THE NUMBER OF BOOK ORDERED";
      cin>>no_of_books;
      for(int i=1;i<=no_of_books;i++)
      {
      cout<<"\n\n enter the book number/product";
      cin>>ch_books;
      switch(ch_books)
      {
	   case 1:basic_book();
		  sum=amt+sum;
		  display_data();
		  cout<<"\n\n\n\n";
		  cout<<"AMOUNT PAID    "<<sum;
		  break;

	   case 2:cobol1_book();
		 sum=amt+sum;
		 display_data();
		 cout<<"\n\n\n\n";
		 cout<<"AMOUNT PAID     "<<sum;
		 break;

	   case 3:cobol2_book();
		 sum=amt+sum;
		 display_data();
		 cout<<"\n\n\n\n";
		 cout<<"AMOUNT PAID     "<<sum;
		 break;

	   case 4:cobol3_book();
		  sum=amt+sum;
		  display_data();
		  cout<<"\n\n\n\n";
		  cout<<"AMOUNT PAID    "<<sum;
		  break;

	   case 5:dbase_book();
		  sum=amt+sum;
		  display_data();
		  cout<<"\n\n\n\n";
		  cout<<"AMOUNT PAID    "<<sum;
		  break;

	   case 6:foxbase_book();
		  sum=amt+sum;
		  display_data();
		  cout<<"\n\n\n\n";
		  cout<<"AMOUNT PAID    "<<sum;
		  break;
	   case 7:foxpro_book();
		  sum=amt+sum;
		  display_data();
		  cout<<"\n\n\n\n";
		  cout<<"AMOUNT PAID    "<<sum;
		  break;

	   case 8:dbase_three_book();
		  sum=amt+sum;
		  display_data();
		  cout<<"\n\n\n\n";
		  cout<<"AMOUNT PAID    "<<sum;
		  break;

	   case 9:dbase_four_book();
		  sum=amt+sum;
		  display_data();
		  cout<<"\n\n\n\n";
		  cout<<"AMOUNT PAID    "<<sum;
		  break;

	   case 10:dbase_threeplus_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 11:c_language_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 12:borland_c_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 13:turbo_c_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 14:c_plus_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 15:turbo_c_plus_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;
	   case 16:borland_c_plus_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 17:wordstar_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 18:ms_office_book();
		   sum=amt+sum;
		   display_data();
		   cout <<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 19:tally_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 20:tally_four_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 21:internet_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 22:coreldrw_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 23:photoshop_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 24:corel_eight_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;

	   case 25:oracle_book();
		   sum=amt+sum;
		   display_data();
		   cout<<"\n\n\n\n";
		   cout<<"AMOUNT PAID   "<<sum;
		   break;


	   default:cout<<"NOT A PROPER CHOICE";
	   }
	   }
      }



      void shop::enter_data()
      {
	   clrscr();
	   cout<<"\n\n";
	   cout<<"\n Enter the invoice number     :";
	   cin>>invoice_no;
	   cout<<"\n Enter the customer's name    :";
	   cin>>name;
	   cout<<"\n Enter the customer's code    :";
	   cin>>code;
	   cout<<"\n Enter the customer's address :";
	   cin>>address;
	   cout<<"\n Despatch by Air/Train        :";
	   cout<<"\n Enter the mode of despatch   :";
	   cin>>despatch;
	   cout<<"\n Payment by Cash/Demand Draft/Cheque   :";
	   cout<<"\n Enter the mode of payment    :";
	   cin>>payment;
      }

      void shop::customer_display_data()
      {
	   clrscr();
	   cout<<"\n";
	   cout<<"\n\n The invoice number         :"<<invoice_no;
	   cout<<"\n\n The customer's name        :"<<name;
	   cout<<"\n\n The customer's code        :"<<code;
      }

      void shop:: display_data()
      {
	   clrscr();
	   cout<<"\n\n    CREATIVE PUBLICATION     ";
	   cout<<"\n\n    ********************     ";
	   cout<<"\n        93-CHAWRI BAZAR        ";
	   cout<<"\n        P.O.Bag No.-1082       ";
	   cout<<"\n    Phone No:3261030,3279417   ";
	   cout<<"\n   E-mail:hann@ndf.vsnl.net.in ";
	   cout<<"\n";
	   cout<<"\n\n The invoice number         :"<<invoice_no;
	   cout<<"\n The customer's name          :"<<name;
	   cout<<"\n The customer's code          :"<<code;
	   cout<<"\n The customer's address       :"<<address;
	   cout<<"\n The mode of despatch         :"<<despatch;
	   cout<<"\n The mode of payment          :"<<payment;
      }

      void shop::enter1_data()
      {
	   fstream ofile;
	   ofile.open("test.dat",ios::out|ios::binary);
	   size=sizeof(customer);
	   enter_data();
	   compute_data();
	   ofile.write((char*) & customer,size);
	   ofile.close();
      }
	   void shop::search_data()
      {
	   // To display if the customer record is existing char ch1;
	   char search_code[10];
	   char search_name[30];
	   int counter=0;
	   char ch1;
	   fstream ifile;
	   clrscr();
	   gotoxy(15,10);
	   cout<<"WEL COME TO SEARCH MENU (FIND IF CUSTOMER RECORD EXISTS)"<<endl;
	   gotoxy(15,11);
	   cout<<"********************************************************"<<endl;
	   gotoxy(15,16);
	   cout<<"1.Look by customer code"<<endl;
	   gotoxy(15,17);
	   cout<<"2.Look by customer name"<<endl;
	   gotoxy(15,20);
	   cout<<"Enter your choice";
	   cin>>ch1;
		 switch(ch1)
		 {
		    case'1':clrscr();
			     cout<<"Enter nthe customer code to be searched";
			     cin>>search_code;
			     ifile.open("tes.dat",ios::in);
			     ifile.seekg(0,ios::beg);
			     ifile.read((char*)& customer,sizeof(customer));
			     while(!ifile.eof())

		 {
		    if(strcmp(customer.code,search_code)==0)
		     {
		      counter++;
		      customer.customer_display_data();
		     }
		    ifile.read((char*)&customer,sizeof(customer));
		     }
		    ifile.close ();
		    cout<<"\n\n Record found:   "<<counter;
		    getchar();
		    break;


	   case'2':clrscr();
	   cout<<"Enter the customer name to be searched";
	   cin>>search_name;
	   ifile.open("test.dat",ios::in);
	   ifile.seekg(0,ios::beg);
	   ifile.read((char*) & customer,sizeof(customer));
	   while(!ifile.eof())
	   {
	    if(strcmp(customer.name,search_name)==0)
	     {
		counter++;
		customer.customer_display_data();
	     }
	   ifile.read((char*)&customer,sizeof(customer));
	   }
	   ifile.close();
	   cout<<"\n\n record found:   "<<counter;
	   getchar();

	   default:clrscr();
		   cout<<"Wrong choice has been entered";
	   }
      }

      void main()
      {
      clrscr();
      int main_choice;
	   customer.welcome_menu();
	   customer.main_menu();
	   while(main_choice!=4)
	   {
	    gotoxy(15,21);
	    cout<<"ENTER YOUR CHOICE FROM THE MENU GIVEN "<<endl;
	    cin>>main_choice;
	    switch(main_choice)
		  {
		   case 1:customer.menu();
			  getchar ();
			  break;

		   case 2:customer.enter1_data();
			  break;

		   case 3:customer.search_data();
			  break;

		   case 4:clrscr();
			  gotoxy(25,11);
			  cout<<"THE OPERATION IS OVER";
			  gotoxy(25,12);
			  cout<<"**********************";
			  break;
		  }
	   }
       getch();
      }







