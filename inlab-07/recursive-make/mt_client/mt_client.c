#include <pthread.h>
#include "cl_utils.h"
#include "cl_task.h"

#define NUM_THREADS_DEFAULT 300

int main(int argc, char *argv[]){
  int NUM_THREADS;
  
  if (argc < 3){
    fprintf(stderr, "Server name and/or port missing.");
    exit(1);
  }
  else if (argc == 3)
    NUM_THREADS = NUM_THREADS_DEFAULT;
  else
    NUM_THREADS = atoi(argv[3]);

  int port = atoi(argv[2]);
  struct sockaddr_in s_addr;
  find_server(&s_addr, argv[1], port);

  struct cl_thread_data args = {&s_addr, do_task};
  
  pthread_attr_t attr;
  pthread_attr_init(&attr);
  pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);

  pthread_t threads[NUM_THREADS];
  for (int i=0; i<NUM_THREADS; i++){
    if(pthread_create(threads+i, &attr, (void *)hit_the_server, &args) != 0)
      error("pthread_create");
  }
  pthread_attr_destroy(&attr);

  for (int i=0; i<NUM_THREADS; i++){
    pthread_join(threads[i], NULL);
    printf("Client #%02d dies.\n", i);
  }
  return 0;
}

