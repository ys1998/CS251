
# _______________________________________________________________________________________________________
# Note: Everything must be accomplished by this Makefile. You are not allowed to use recursive Makefiles.
# _______________________________________________________________________________________________________


## PHASE 1 [CANCELLED]
#
# 1. [CANCELLED]
# 2. [CANCELLED]

## PHASE 2
#
# Add rules to:
# 1. to compile all source files in "./ganit_src/", into separate object files
# 2. to archive all object files from "./ganit_src/" into a static library called "libganit.a"

## PHASE 3
#
# 1. Uncomment the relevant declarations from ganit.h
# 2. Uncomment the relevant lines from the definition of `struct init_funcs arith_fncts[]` in calc_utils.c
# 3. At this point if you run "make calc" it should complain that it can't find any definition of whatever (functions) you uncommented.
# 4. Change the rule for "calc" so that it links against libganit.a also (which has references to the functions needed in arith_fncts).

CFLAGS := -g -Wall
LDFLAGS := -lm
SBPATH := ganit_src
SOURCES=$(wildcard $(SBPATH)/*.c)
OBJECTS=$(patsubst %.c, %.o, $(SOURCES))

all: calc

calc: calc.tab.o lexer.o libganit.a
	$(CC) $(CFLAGS) -L. -o $@ $^ $(LDFLAGS) -lganit

calc.tab.o: calc.tab.c calc.tab.h calc_utils.h
	$(CC) -c $(CFLAGS) $< -o $@

calc.tab.c calc.tab.h: calc.y
	bison -d $<

lexer.o: lexer.c calc.tab.h
	$(CC) -c $(CFLAGS) $< -o $@

libganit.a: $(OBJECTS)
	ar rc $@ $^

libs: libganit.a

$(OBJECTS): $(SBPATH)/%.o : $(SBPATH)/%.c ganit.h
	$(CC) -c $(CFLAGS) $< -o $@ 

clean:
	@rm -f *.o
	@rm -f *.tab.*
	@rm -f $(SBPATH)/*.o

