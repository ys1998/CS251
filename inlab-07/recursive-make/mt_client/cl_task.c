#include "cl_task.h"

void do_task(int cfd){
  char buffer[] = "maximum effort!";
  printf("%ld\n", strlen(buffer));
  int n = write(cfd, buffer, strlen(buffer));
  if (n < 0)
    error("write failed");
}
