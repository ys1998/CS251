#include "cl_utils.h"

void error(char *msg){
  perror(msg);
  exit(1);
}

void find_server(struct sockaddr_in *s_addr, char *hostname, int port){
  bzero(s_addr, sizeof(struct sockaddr_in));
  s_addr->sin_family = AF_INET;
  s_addr->sin_port = htons(port);
  struct hostent *server;
  server = gethostbyname(hostname);
  if (server == NULL)
    error("No host");
  bcopy(server->h_addr, &(s_addr->sin_addr.s_addr), server->h_length);
}

void hit_the_server(struct cl_thread_data *args){
  int cfd = socket(AF_INET, SOCK_STREAM, 0);
  if (cfd < 0)
    error("Bad FD");

  if (connect(cfd, (struct sockaddr*) args->s_addr, sizeof(struct sockaddr_in)) < 0)
    error("Connection failed");
  args->task(cfd);
  close(cfd);
}
