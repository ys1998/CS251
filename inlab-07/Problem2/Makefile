default: hello
factorial.o: factorial.cpp functions.h
	g++ -c factorial.cpp
hello.o: hello.cpp functions.h
	g++ -c hello.cpp
main.o: main.cpp functions.h
	g++ -c main.cpp
hello: main.o hello.o factorial.o
	g++ main.o hello.o factorial.o -o hello
all: hello
