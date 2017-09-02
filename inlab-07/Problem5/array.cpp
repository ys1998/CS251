/** @file

  * Manipulating Arrays
  */

#include <iostream>
#include <stdlib.h>

using namespace std;

/** \param myArr 7 x 7 matrix
  * \return myArr
  * \brief Populates a 7 x 7 matrix with random numbers
  
  * Fills the 7 x 7 matrix with random numbers in the range [20, 319]
  */
int fillArray(int myArr[7][7])                 
{
	for(int i=0;i<7;i++)
	{
		for(int j=0;j<7;j++)                    
		{
			myArr[i][j]=20+rand()%400;              
		}
	}
	return 0;
}

/** \param myArr 7 x 7 matrix
  * \brief Print a 7 x 7 matrix spiralling inwards
  */
void printSpiral(int myArr[7][7])
{
	cout << "Array Spiral Function." << endl;
	for(int j=0;j<1;j++)                           
    {                                              
        for(int i=0;i<7;i++)
        {
            cout<< myArr[i][j]<< "  ";
        }

    }
    cout << endl;

    for(int i=6;i<7;i++)                          
    {                                            
        for(int j=1;j<7;j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for(int j=6;j<7;j++)                          
    {                                             
        for(int i=5;i>=0;i--)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=0;i<1;i++)                          
    {                                              
        for (int j=5;j>=1;j--)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int j=1; j<2;j++)
    {                                             
        for (int i=1; i<6;i++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=5; i<6;i++)                        
    {
        for (int j=2; j<6; j++)
        {
            cout << myArr[i][j] << "  ";
	}
    }
    cout << endl;

    for (int j=5; j<6; j++)                        
    {
        for (int i=4; i>0; i--)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=1; i<2; i++)                        
    {
       for (int j=4; j>1; j--)
       {
           cout << myArr[i][j] << "  ";
       }
    }
    cout << endl;

    for (int j=2; j<3; j++)                        
    {
        for (int i=2; i<5; i++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=4; i<5; i++)                        
    {
        for (int j=3; j<5; j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int j=4; j<5; j++)                        
    {
        for (int i=3; i>1; i--)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=2; i<3; i++)                        
    {
        for (int j=3; j<4; j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
    cout << endl;

    for (int i=3; i<4; i++)                         
    {
        for (int j=3; j<4; j++)
        {
            cout << myArr[i][j] << "  ";
        }
    }
  cout << endl << endl;
}

/** \param s starting column index
  * \param e end column index
  * \param myArr 7 x 7 matrix
  * \brief Print the requested columns
  
  * If the passed indices of columns are X and Y, print col X, then col (X+1) and so on till col (Y-1)
  */
void printCol(int myArr[7][7], int s, int e)                     
{  
	cout << "Column Output" << endl;                
	for (int j=s-1; j<e-1; j++)
	{                                               
		for (int i=0; i<7; i++)
		{
			cout << myArr[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl << endl;
}

/** \param myArr 7 x 7 matrix
  * \return minimum
  * \brief Find the minimum of all the elements in a 7 x 7 matrix
  
  */
int findMin (int myArr[7][7])
{
	int i,j;
	int min = myArr[0][0];

	for (i=0; i<7; i++)                             
	{
		for (j=0; j<7; j++)
		{
			if(myArr[i][j] < min)                   
			{                                       
				min = myArr[i][j];
			}                                       
		}                                           

	}
    return min;
}

/** \param myArr 7 x 7 matrix
  * \return average
  * \brief Find the average of all the elements in a 7 x 7 matrx
  
  * Returns the floor function of the average of all the elements in the 7 x 7 square matrix
  */
int findAverage (int myArr[7][7])                  
{                                                   
	int i,j;
	int sum = 0;

	for (i=0; i<7; i++)                             
	{
	    for (j=0; j<7; j++)
	    {
	        sum = sum + myArr[i][j];
	    }

	}
    return sum/49;       
}

/** \param myArr 7 x 7 matrix
  * \brief Prints the 7 x 7 matrix
  
  * Prints the elements of 7 x 7 matrx in the following manner:
  *   1st Row
  *   2nd Row
  *   7th Row
  */
void printArray (int myArr[7][7])                     
{
    cout << "Normal Array Output" << endl;

    for (int i =0; i<7; i++)
    {
        for (int j=0; j<7; j++)
        {
            cout << myArr[i][j] << "  ";
        }
        cout << endl;
    }
    cout << endl;                                   
    cout << endl;
}

#ifndef NOT_REQ
int main(){
	
	int myArr [7][7];
	fillArray(myArr);                               
	printArray(myArr);
	printSpiral(myArr);
	printCol(myArr, 2, 5);
	cout<<"Min:"<<findMin(myArr);
	cout<<" Average:"<<findAverage(myArr);
    cout<<endl;

	return 0;
}
#endif
