all: peer server
CC=g++

peer: peer.cpp
	$(CC) -o peer peer.cpp

server: server.cpp peerinfo.hpp
	$(CC) -o server server.cpp
	
