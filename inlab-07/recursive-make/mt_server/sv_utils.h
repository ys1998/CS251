#ifndef TT_SERVER_UTILS_H
#define TT_SERVER_UTILS_H

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
#include <signal.h>

struct sv_thread_data{
  struct sockaddr_in *c_addr;
  int cfd;
  void (*task)(int);
};

void error(char *msg);
void handle_client(struct sv_thread_data *args);
#endif
