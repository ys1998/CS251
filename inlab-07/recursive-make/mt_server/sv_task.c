#include "sv_task.h"
#include "sv_utils.h"

void do_task(int cfd){
  char buffer[256] = {0};
  int n = read(cfd, buffer, 255);
  if (n < 0)
    error("read failed.");
  printf("'%s'\n", buffer);

  n = write(cfd, "DONE", 4);
  if (n < 0)
    error("write failed.");
}
