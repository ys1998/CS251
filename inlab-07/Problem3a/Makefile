# MACROS and variables
CC=g++
hello_dependencies=main.o hello.o factorial.o

default: hello
factorial.o: factorial.cpp functions.h
	${CC} -c factorial.cpp
hello.o: hello.cpp functions.h
	${CC} -c hello.cpp
main.o: main.cpp functions.h
	${CC} -c main.cpp
hello: ${hello_dependencies}
	${CC} main.o hello.o factorial.o -o $@
all: hello
