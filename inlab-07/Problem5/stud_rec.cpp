/*! @file
  * \brief Student records

  */

/**
This Code is taken from http://www.worldbestlearningcenter.com for learning/teaching purpose
**/

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <string.h>
using namespace std;


/*! \struct student
  \brief A structure for storing detailed information for students

  * Details of student stored :
  * - Name
  * - Number
  * - Gender
  * - Marks in Quiz 1 & 2, Assignment, Midterm, Final
  * - Total Marks
  * The member numberOfitem does not store any information
  */
struct student
{
	string stnumber;  /**< Unique number/ID of student */
	string stname;	  /**< Name of student */
	char sex;	  /**< Gender of student */
	float quizz1;	  /**< Marks obtained in quiz 1 by student*/
	float quizz2;	  /**< Marks obtained in quiz 2 by student*/
	float assigment;  /**< Marks obtained in assignment by student*/
	float midterm;	  /**< Marks obtained in midterm by student*/
	float final;	  /**< Marks obtained in final term by student*/
	float total;	  /**< Total marks obtained by student*/
	int numberOfitem; /**< No useful information*/ 
};

int search(struct student st[],string id, int itemcount);
void clean(struct student st[],int deleteitem);

/*! Displays menu
  */
void displaymenu(){
	cout<<"=========================================="<<"\n";
	cout<<" MENU "<<"\n";
	cout<<"=========================================="<<"\n";
	cout<<" 1.Add student records"<<"\n";
	cout<<" 2.Delete student records"<<"\n";
	cout<<" 3.Update student records"<<"\n";
	cout<<" 4.View all student records"<<"\n";
	cout<<" 5.Calculate average score of a student"<<"\n";
	cout<<" 6.Show student who gets the max total score"<<"\n";
	cout<<" 7.Show student who gets the max total score"<<"\n"; 
	cout<<" 8.Find a student by ID"<<"\n"; 
	cout<<" 9.Sort records by TOTAL"<<"\n"; 
}

/** \param st - current records
  * \param itemcount - number of records
  * \brief Add a new record

  * If the entered ID of the new student is unique, the record is added after taking all inputs from the user, the total marks calculated and updated and the total number of records incremented. Otherwise, the user is requested to enter a valid ID.
  */
void add_rec(struct student st[],int& itemcount){
	again:
	cout<<"\nEnter student's ID:";
	cin>>st[itemcount].stnumber;
	if(search(st,st[itemcount].stnumber,itemcount)!=-1){
		cout<<"This ID already exists\n";goto again;
	}
	cout<<"Enter student's Name:"; 
	cin>>st[itemcount].stname;
	cout<<"Enter student's Sex(F or M):";cin>>st[itemcount].sex;
	cout<<"Enter student's quizz1 score:";cin>>st[itemcount].quizz1;
	cout<<"Enter student's quizz2 score:";cin>>st[itemcount].quizz2;
	cout<<"Enter student's assigment score:";cin>>st[itemcount].assigment;
	cout<<"Enter student's mid term score:";cin>>st[itemcount].midterm;
	cout<<"Enter student's final score:";cin>>st[itemcount].final;
	st[itemcount].total=st[itemcount].quizz1+st[itemcount].quizz2+st[itemcount].assigment+st[itemcount].midterm+st[itemcount].final;

	++itemcount;
}

/** \param st - current records
  * \param itemcount - number of records
  * \param id - ID to search against 
  * \return index of matched record
  * \brief Search for the student against the id

  */
int search(struct student st[], string id,int itemcount){
	int found =-1;
	for (int i = 0; i < itemcount && found==-1; i++)
	{
		if (st[i].stnumber == id) found=i;
		else found=-1 ;
	}

	return found;
}

/** \param st - current records
  * \param itemcount - number of records
  * \brief Print all records

  * Prints all records in a tabulated form
  */
void viewall(struct student st[], int itemcount){
	int i=0;
	cout<<left<<setw(5)<<"ID"<<setw(20)<<"NAME"<<setw(5)<<"SEX"

	<<setw(5)<<"Q1"
	<<setw(5)<<"Q2"<<setw(5)<<"As"<<setw(5)<<"Mi"<<setw(5)<<"Fi"
	<<setw(5)<<"TOTAL"<<"\n";
	cout<<"==============================================\n";
	while(i<=itemcount){
		if(st[i].stnumber!=""){
			cout<<left<<setw(5)<<st[i].stnumber<<setw(20)<<st[i].stname<<setw(5)

			<<st[i].sex;
			cout<<setw(5)<<st[i].quizz1<<setw(5)<<st[i].quizz2<<setw(5)<<st[i].assigment
			<<setw(5)<<st[i].midterm<<setw(5)<<st[i]. final<<setw(5)
			<<st[i].total;

			cout<<"\n";
		}
		i=i+1;
	}
}

/** \param st - current records
  * \param itemcount - number of records 
  * \brief Delete a student record

  * Requests the user for the ID of the student whose record is to be deleted. If the ID doesn't exist, the function returns without doing anything
  */
void delete_rec(struct student st[], int& itemcount){
	string id;
	int index;
	if (itemcount > 0)
	{
		cout<<"Enter student's ID:";
		cin>>id;
		index = search(st, id,itemcount); 

		if ((index!=-1) && (itemcount != 0)){
			if (index == (itemcount-1)){ 

				clean(st, index);
				--itemcount;

				cout<<"The record was deleted.\n";
			}
			else{ 
				for (int i = index; i < itemcount-1; i++){
					st[i] = st[i + 1];
					clean(st, itemcount);
					--itemcount ;
				}
			}
		}
		else cout<<"The record doesn't exist.Check the ID and try again.\n";
	}
	else cout<<"No record to delete\n";
}

/** \param st - current records
  * \param index - number of records 
  * \brief Sets up an empty record
  
  */
void clean(struct student st[],int index){
	st[index].stnumber = "";
	st[index].stname = "";
	st[index].sex = 'X';
	st[index].quizz1 = 0;
	st[index].quizz2 = 0;
	st[index].assigment = 0;
	st[index].midterm = 0;
	st[index].final = 0;
	st[index].total = 0;
}

/** \param st - current records
  * \param itemcount - number of records 
  * \brief Update an existing record

  * Takes a ID from the user. If the ID doesn't exist, the function prints an error message and returns. Otherwise, the program updates the records according to the user's inputs.
  */
void update_rec(struct student st[],int itemcount){
	string id;
	int column_index;
	cout<<"Enter student's ID:";
	cin>>id;
	cout<<"Which field you want to update(1-7)?:";
	cin>>column_index;

	int index = search(st, id,itemcount);

	if (index != -1)
	{
		if (column_index == 1){
			cout<<"Enter student's Name:";
			cin>>st[index].stname;
		}

		else if (column_index == 2){
			cout<<"Enter student's Sex(F or M):";
			cin>>st[index].sex;
		}
		else if (column_index == 3){
			cout<<"Enter student's quizz1 score:";
			cin>>st[index].quizz1;
		}
		else if (column_index == 4){
			cout<<"Enter student's quizz2 score:";
			cin>>st[index].quizz2;
		}
		else if (column_index == 5){
			cout<<"Enter student's assigment score:";
			cin>>st[index].assigment;
		}
		else if (column_index == 6){
			cout<<"Enter student's mid term score:";
			cin>>st[index].midterm;
		}
		else if (column_index == 7)	{
			cout<<"Enter student's final score:";
			cin>>st[index].final;
		}
		else cout<<"Invalid column index";

		st[index].total = st[index].quizz1 + st[index].quizz2 + st[index].assigment

		+ st[index].midterm + st[index].final;
	}
	else cout<<"The record deosn't exits.Check the ID and try again.";
}

/** \param st - current records
  * \param itemcount - number of records 
  * \brief Prints the id and total score of the student with total maximum score

  */
void showmax(struct student st[], int itemcount){
	float max = st[0].total;
	int index=0;

	if (itemcount >= 2){
		for (int j = 0; j < itemcount-1; ++j)
			if (max < st[j+1].total) {
				max = st[j+1].total;
				index = j+1;
			}
	}
	else if (itemcount == 1){
		index = 0;
		max = st[0].total;
	}
	else 
		cout<<"Not record found!\n";

	if (index != -1) 
		cout<<"The student with ID "<<st[index].stnumber<<" gets the highest score "<<max<<endl;
}

/** \param st - current records
  * \param itemcount - number of records 
  * \brief Prints the id and total score of the student with total maximum score

  */
void showmin(struct student st[], int itemcount){

	float min = st[0].total;
	int index = 0;

	if (itemcount >= 2){
		for (int j = 0; j < itemcount-1; ++j)
			if (min > st[j+1].total){
				min = st[j+1].total;
				index = j+1;
			}
	}
	else if (itemcount == 1){
		index = 0;
		min = st[0].total;
	}
	else 
		cout<<"No record found!\n";

	if (index != -1) cout<<"The student with ID "<<st[index].stnumber<<" gets the highest score "<<min<<endl;

}

/** \param st - current records
  * \param itemcount - number of records 
  * \brief Search for a record against an ID

  * Requests the user for an ID. If the ID is valid, i.e., it matches against a record, it prints the corresponding record. Otherwise, the program prints an error message and returns.
  */
void find(struct student st[], int itemcount){
	string id;
	cout<<"Enter student's ID:";
	cin>>id;

	int index=search(st,id,itemcount);
	if (index != -1) { 								
		cout<<left<<setw(5)<<st[index].stnumber<<setw(20)<<st[index].stname<<setw(5)<<st[index].sex;
		cout<<setw(5)<<st[index].quizz1<<setw(5)<<st[index].quizz2<<setw(5)

		<<st[index].assigment
		<<setw(5)<<st[index].midterm<<setw(5)<<st[index].final<<setw(5)
		<<st[index].total;
		cout<<"\n"; 

	}
	else cout<<"The record doesn't exits.";

}

/** \param dataset - current records
  * \param n - number of records 
  * \brief Sorting routine

  * Sorts the records in an ascending order according to their total marks
  */
void bubblesort(struct student dataset[], int n){
	int i, j;
	for (i = 0; i < n; i++)
		for (j = n - 1; j > i; j--)
			if (dataset[j].total < dataset[j - 1].total ){
				student temp = dataset[j];
				dataset[j] = dataset[j - 1];
				dataset[j - 1] = temp;
			}

}

/** \param st - current records
  * \param itemcount - number of records 
  * \brief Prints the average score

  * Requests for an ID input. Prints the average of quizzes, assignment, midterm and final marks if the ID is valid, otherwise 0.
  */
void average(struct student st[], int itemcount){
	string id;
	float avg=0;
	cout<<"Enter students'ID:";
	cin>>id;
	int index = search(st, id,itemcount);
	if (index != -1 && itemcount>0)
	{
		st[index].total = st[index].quizz1 + st[index].quizz2 + st[index].assigment
			+ st[index].midterm + st[index].final;
		
		avg = st[index].total /5;
	}

	cout<<"The average score is "<<avg;
}

#ifndef NOT_REQ
int main(int argc, char *argv[]){

	student st[80];
	int itemcount=0;

	int yourchoice;
	char confirm;
	do{
	
		displaymenu();
		cout<<"Enter your choice(1-9):";
		cin>>yourchoice;

		switch(yourchoice){
			case 1:add_rec(st, itemcount);break;
			case 2:delete_rec(st, itemcount);break;
			case 3:update_rec(st, itemcount);break;
			case 4:viewall(st, itemcount);break;
			case 5:average(st, itemcount);break;
			case 6:showmax(st, itemcount);break;
			case 7:showmin(st, itemcount);break;
			case 8:find(st, itemcount);break;

			case 9:bubblesort(st,itemcount);break;
			default:cout<<"invalid";
		}

		cout<<"Press y or Y to continue:";
		cin>>confirm;
	}while(confirm=='y'||confirm=='Y');

	system("PAUSE");
	
	return EXIT_SUCCESS;
}
#endif
