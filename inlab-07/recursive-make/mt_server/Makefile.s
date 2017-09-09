# Makefile for SERVER

# MACROS
CC=gcc
CFLAGS=-g -c
# EXTFLAGS will be passed from top makefile -g -Wextra
target=./build/
exec_target=../
libs=-pthread
.PHONY: clean all

default: exec_server
all: exec_server
clean:
	@rm -rf ${target}
exec_server: mt_server.o sv_task.o sv_utils.o
	${CC} ${EXTFLAGS} ${target}mt_server.o ${target}sv_task.o ${target}sv_utils.o -o ${exec_target}$@ ${libs}
mt_server.o: mt_server.c sv_utils.h sv_task.h
	@mkdir -p build
	${CC} ${CFLAGS} $< -o ${target}$@ 
sv_task.o: sv_task.c sv_task.h sv_utils.h
	@mkdir -p build
	${CC} ${CFLAGS} $< -o ${target}$@ 
sv_utils.o: sv_utils.c sv_utils.h
	@mkdir -p build
	${CC} ${CFLAGS} $< -o ${target}$@ 

 
