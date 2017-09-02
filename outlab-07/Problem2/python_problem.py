## @package python_problem This package was provided to us as a part of 7th outlab assignment.
#
# It consists of a single Python file and a data file (consisting of integers on each line) which were provided to us for the Doxygen section of the 7th outlab assignment

## @file python_problem.py
#
# This Python file consists of several functions, their invokations and variables which we had to properly document as a part of our 7th outlab assignment

from sys import argv
from copy import deepcopy

## Function to obtain integers from a data file
#
#  This function reads integers from the specified file and stores them in a list in the order that they occur in the file. Only one number must be present in each line. The list of integers is then returned.
#
# @param filename complete path of the input data file as string
# @returns a list of integers extracted from the specified file
def make(filename):
	file = open (filename)
	l=[]
	for line in file:
		a=int(line)
		l.append(a)
	return l

## Function to sort a list of integers into ascending order
#
#  This function implements bubble sort algorithm (in reverse order) to sort the given list of integers. Each element is compared with the element to its right, and if the former is larger, these two elements are swapped. This is repeated till the largest element of the examined part of the list reaches the end. The length of the list to be examined is decremented by one, and the same process is iterated until the length of the list to be examined becomes zero. The final list has all elements in ascending order.
#
# @param l a list of integers
# @returns the list given as input, modified such that elements are in ascending order 
def fun1(l):	
	size=len(l)
	for i in range(0,size-1):
		for j in range(0,size-i-1):
			if l[j] > l[j+1]:
				temp=l[j]
				l[j]=l[j+1]
				l[j+1]=temp
			
	return l

## Function to search for an element in a list, and display the intermediate steps
#
#  This function uses binary search to search for the given element in the given list. During each step, the step-number and the element of list under examination is printed on the screen. If the element is found, the process ends and the current step-number is returned. Otherwise, the process continues with updated values of s, e and m - which are the indices of the starting, ending and middle of the section of \a l under examination. If s becomes equal to e, the process ends and the function returns -1 indicating that \a x was not found.
#
# @param l a list of numbers
# @param x the number to be searched for in the list \a l
# @returns -1 if \a x is not found in \a l and number of steps required to find \a x in \a l, otherwise
def fun2(l,x):
	n=int(x)
	probes=0
	s=0
	e=len(l)-1
	flag=0
	while(s<=e):
		probes=probes+1
		m=(s+e)//2
		print ("Probe "+str(probes)+":",m,l[m])
		if(l[m]==n):
			flag=1
			break
		elif(l[m]>n):
			e=m-1
		elif(l[m]<n):
			s=m+1
	if(flag==1):
		return probes
	else:	
		return -1

## Function to find the determinant of the given square matrix
#
#  This function finds the determinant of the given list of lists of real numbers recursively. It iterates over the first row of the input matrix, creating a submatrix for each element of this row (the submatrix has that row and the entire column containing that element removed), followed by a recursive call with this submatrix as input parameter. The return value of recursion is used to compute the determinant of the input matrix.
#
# @param L a list of rows of a square matrix (consisting of real numbers) in the same order as they appear in the matrix
# @returns the only element of the matrix if its size is 1, and the determinant of the matrix otherwise
def fun3(L):
	d=0
	n=len(L)
	if(n==1):
		return L[0][0]
	for i in range(0,n):
		A=deepcopy(L)
		for j in range(0,len(A)):
			A[j].pop(i)
		A.pop(0)
		d=d+L[0][i]*((-1)**i)*fun3(A)
	return d

## List or list of lists of numbers
#
# All the lists or list of lists in this program are referred to by \a L
L = make("data")
print (L)
L = fun1(L)
print ("\nAfter Fun1:")
print (L)
print ("\nFun2 Starts:")
## Temporarily stores results of all function calls
#
# This variable is used to store the result of all function calls made in this program. It thus refers to an integer or a list depending upon the function whose return value it stores
ans = fun2(L, 48)
print ("Result of Fun2:", ans)

print ("\n")
# Change the elements and observe the result  
L = [[1, 2, 3], [100, 54, 23], [9, 27, 11]]
print(L)
ans = fun3(L)
print ("Result of Fun3:", ans)
