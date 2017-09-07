#ifndef MULTI_FUNC_CALC_H
#define MULTI_FUNC_CALC_H

#include <stdlib.h> /* malloc. */
#include <string.h> /* strlen. */

/* Function type.  */
typedef double (*func_t) (double);

/* Data type for links in the chain of symbols.  */
struct symrec
{
  char *name;  /* name of symbol */
  int type;    /* type of symbol: either VAR or FNCT */
  union
  {
    double var;      /* value of a VAR */
    func_t fnctptr;  /* value of a FNCT */
  } value;
  struct symrec *next;  /* link field */
};

typedef struct symrec symrec;

/* The symbol table: a chain of 'struct symrec'.  */
extern symrec *sym_table;

symrec *putsym (char const *, int);
symrec *getsym (char const *);

struct init_funcs {
  char const *fname;
  double (*fnct) (double);
};

struct init_vars {
  char const *varname;
  double value;
};

/* The symbol table: a chain of 'struct symrec'.  */
symrec *sym_table;

#endif /* !MULTI_FUNC_CALC_H */
