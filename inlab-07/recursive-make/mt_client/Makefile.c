# Makefile for CLIENT

# MACROS
CC=gcc
CFLAGS=-g -c
# EXTFLAGS will be passed from top makefile -g -Wall
target=./build/
exec_target=../
libs=-pthread
.PHONY: clean all

default: exec_client
all: exec_client
clean:
	@rm -rf ${target}
exec_client: mt_client.o cl_task.o cl_utils.o
	${CC} ${EXTFLAGS} ${target}mt_client.o ${target}cl_task.o ${target}cl_utils.o -o ${exec_target}$@ ${libs}
mt_client.o: mt_client.c cl_utils.h cl_task.h
	@mkdir -p build
	${CC} ${CFLAGS} $< -o ${target}$@ 
cl_task.o: cl_task.c cl_task.h
	@mkdir -p build
	${CC} ${CFLAGS} $< -o ${target}$@ 
cl_utils.o: cl_utils.c cl_utils.h
	@mkdir -p build
	${CC} ${CFLAGS} $< -o ${target}$@ 

 
