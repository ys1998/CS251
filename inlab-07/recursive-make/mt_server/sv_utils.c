#include "sv_utils.h"

void error(char *msg){
  perror(msg);
  exit(1);
}

void handle_client(struct sv_thread_data *args){
  args->task(args->cfd);
  free(args->c_addr);
  if (close(args->cfd) < 0)
    error("on close?");
  free(args);
}
