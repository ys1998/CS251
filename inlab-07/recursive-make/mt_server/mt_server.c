#include <pthread.h>
#include "sv_utils.h"
#include "sv_task.h"

#define NUM_THREADS 30

int main(int argc, char *argv[]){
  if (argc < 2){
    fprintf(stderr, "Port missing.");
    exit(1);
  }
  
  struct sockaddr_in s_addr;
  int port = atoi(argv[1]);
  bzero(&s_addr, sizeof(s_addr));
  s_addr.sin_addr.s_addr = INADDR_ANY;
  s_addr.sin_family = AF_INET;
  s_addr.sin_port = htons(port);
  
  int sfd, cfd;
  sfd = socket(AF_INET, SOCK_STREAM | SOCK_CLOEXEC, 0);
  if (sfd == -1)
    error("FD failed.");

  if (bind(sfd, (struct sockaddr*) &s_addr, sizeof(struct sockaddr_in)) == -1)
    error("Couldn't bind.");
  
  if (listen(sfd, 5) == -1)
    error("Can't listen.");
  printf("Listening on %s...\n", argv[1]);
  char host[NI_MAXHOST], service[NI_MAXSERV];
  socklen_t c_addr_length = sizeof(struct sockaddr_in);

  pthread_attr_t attr;
  pthread_attr_init(&attr);
  pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_DETACHED);
  
  while(1){
    struct sockaddr_in *c_addr = malloc(sizeof (struct sockaddr_in));
    bzero(c_addr, sizeof(struct sockaddr_in));
    cfd = accept(sfd, (struct sockaddr*) c_addr, &c_addr_length);
    if (cfd == -1)
      error("Couldn't accept connection.");

    pthread_t tid;
    // Fixing the following line
    // struct sv_thread_data args = {&c_addr, cfd, do_task};
    struct sv_thread_data *args = malloc(sizeof (struct sv_thread_data));
    args->c_addr = c_addr;
    args->cfd = cfd;
    args->task = do_task;
    // handle_client must free args.c_addr and args
    
    int rc = pthread_create(&tid, &attr, (void *)handle_client, args);
    if (rc == 0){
      getnameinfo((const struct sockaddr*) c_addr, sizeof(struct sockaddr_in),
                  host, NI_MAXHOST, service, NI_MAXSERV, 0);
      printf("TID %5x handling (%s:%s) on FD %02d.\n", (int)tid, host, service, cfd);
    }
    else 
      error("pthread_create");
  }
}
