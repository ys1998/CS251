#ifndef TT_CLIENT_UTILS_H
#define TT_CLIENT_UTILS_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <netinet/in.h>

struct cl_thread_data{
  struct sockaddr_in *s_addr;
  void (*task)(int);
};

void error(char *msg);
void find_server(struct sockaddr_in *s_addr, char *hostname, int port);
void hit_the_server(struct cl_thread_data *args);
#endif
