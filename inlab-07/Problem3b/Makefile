#https://users.cs.duke.edu/~ola/courses/programming/Makefiles/node7.html

CC=g++
CFLAGS=-c -o
all: hellomake.o hellofunc.o hellomake

hellomake.o: hellomake.c hellomake.h
	$(CC) $(CFLAGS) $@ $<  

hellofunc.o: hellofunc.c hellomake.h
	$(CC) $(CFLAGS) $@ hellofunc.c

hellomake: hellomake.o hellofunc.o
	$(CC) -o $@ $^
