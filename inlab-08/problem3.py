from itertools import *

def genPrime(N):
  return \
  sorted(\
  list(\
  set(range(2,N+1)) - set(list( \
  chain.from_iterable \
  (list \
  (map \
  (lambda x: list(range(2*x,N+1,x)),range(2,N+1))\
  ))))))