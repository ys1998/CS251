from itertools import starmap, groupby

def nextNumberGenerator():
   seq="1"
   yield 1
   while True:
      seq = "".join( \
              list( starmap( \
              lambda x,y: str(len(list(y))) + x, groupby(seq))))
      yield int(seq)

