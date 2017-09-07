# `ganit`, an arithmetic system.

__DO NOT FORK THIS REPO. YOU WILL BE GIVEN ZERO MARKS IF YOU FORK IT.__

# PROBLEM STATEMENT UPDATED!

__IT HAS BEEN SIMPLIFIED! I APOLOGIZE FOR THE BIG BLUNDER.__

`ganit` is composed of two components, a parser and lexical analyser duo and the actual implementation of arithmetic functions.
We have provided you with a parser and all you have to worry about are the implementations of arithmetic functions.

Well, that's not entirely true, we've given you a parser specification _(not a parser)_: `calc.y`. A tool called `bison` generates the parser using this specification. This might sound complicated, but remember that you don't have to do anything with the specification or `bison` or parsers.

The aim of this problem is to teach you how a [static library](http://www.adp-gmbh.ch/cpp/gcc/create_lib.html) is built and how to compile a project against a custom library. This static library is going to have implementations of simple arithmetic functions. Please read up on the compilation process and GNU linker basics before you proceed.

Also make sure your machine has `bison` installed. Their must be a package for your OS. To check if you have it or not see output of `which bison`.

# What to submit

Even if you don't complete all tasks, make sure the build succeeds. Almost correct/complete, yet broken solutions will be brutally awarded a zero.

We expect the following inside a folder named `ganit`:

1. Makefile
2. ganit.h
3. ganit_src/*.c

# What we've given you

A working project is what we've given you, with a Makefile.
If you run `make`, you will get an executable called `calc`.

`calc` can parse infix mathematical expressions on the command line and compute their value. Additionally, it can also,

* assign values to variables: `ans_to_universe = 42`, subsequent use of `ans_to_universe` evaulates to `42.0`.
* Few functions are supported `{sin, cos, atan, sqrt, exp, ln}`: `sqrt(4)` evaluates to `2.0`.

`lexer.c` is the lexical analyser that needs no changes, so don't worry about it.

### What `bison` does

`bison` produces 2 files from `calc.y`: `calc.tab.h` and `calc.tab.c`. 

### Where is the `main()` function?

Good question, it's in `calc.y`, so it eventually finds its way into `calc.tab.c`. There are also many other functions in `calc.y`.

### So what does the Makefile do?

1. Generates output of `bison`
2. Compiles `lexer.c` -> `lexer.o`
3. Compiles `calc.tab.*` and `calc_utils.h` -> `calc.tab.o`
4. Links `lexer.o` and `calc.tab.o` -> `calc`

# What do I have to do, everything seems to be done...

Far from it... :D <br>
Follow these steps. The tasks for this problem are embedded in the steps.

> **Please see the discussion on [Issue #2](#2), Step 1 is no longer part of the problem statement.**

>> 1. ~~Notice that things _declared_ in `calc_utils.h` are _defined_ in `calc.y` (which becomes the same as `calc.tab.c`). Because we are such purists, we wish to move those _definitions_ from `calc.y` into a new file `calc_utils.c`.~~
>>  - ~~For your convenience the section of code to be moved has been marked, all you have to do is move it :)~~
>>  - ~~Of course, `calc_utils.c` must include `calc_utils.h`.~~
>>  - ~~Now that you've moved stuff, you need to add a new rule in the makefile that compiles `calc_utils.o`.~~
>>  - ~~And, you need to change the rule for `calc` so that `gcc` also links `calc.tab.c` against `calc_utils.o` (the existing rule already links it with `lexer.o`).~~

1. [CANCELLED]
2. Add more functionality to `ganit`. Notice the definition of `struct init_funcs arith_fncts[]` in `calc_utils.c`. A very intuitive mapping from name_of_function -> actuall_c_function.
It has a few more entries that are commented and you should now implement them. Template files are provided in `./ganit_src/`, fill them and then uncomment their declarations in `./ganit.h` <br>
**We recommend you do this 1 function at a time, simplest function first. Only the first time will be the hardest.**
  - Provide the definition in the relevant file.
  - Add a rule that compiles it/them into a/an object file(s). Keep the object file(s) in `./ganit_src`.
  - Add a rule that archives all the object files in `.ganit_src/` into a static library called `libganit.a`. Use GNU `ar` not `libtool` (`libtool` is way overkill).
3. Now that we have `libganit.a`, we can uncomment entries in the _definition_ of `struct init_funcs arith_fncts[]`.
4. Run `make`, it should fail saying that there are "undefined references to the functions you just uncommented".
5. Just change the rule for `calc` so that it links against `libgnint.a` also.
  - If you are not careful, you might make the (rookie) mistake of providing arguments to `gcc` in the wrong order (while linking). Read [this](https://gcc.gnu.org/onlinedocs/gcc/Link-Options.html) and [this](http://tldp.org/HOWTO/Program-Library-HOWTO/static-libraries.html) carefully and remember it all your life.

# For those who liked this/want some more. 

After you've done everything,

1. make a (trivial) change to one of the functions in `./ganit_src`. How many things should be re-built? How many does your Makefile re-build?
2. How many rebuilds if you make a change in `ganit.h`?
3. How many rebuilds if you comment out a few entries in `struct init_funcs arith_fncts[]`?
4. How many rebuilds if you do (3) then (1) and then run `make`?
5. Find out how to list the contents of the archive.
6. Since `libganit.a` is an archive after-all, can it be decompressed into constituent object files?

# Clarification requests

Are welcome as issues on this repo. Do not post questions on moodle.

# Contributing

Are also welcome, send a PR or open an issue.

# Attribution

The `lexer.c` and `bison` parser spec. come from the official `bison` manual's [examples](https://www.gnu.org/software/bison/manual/html_node/Examples.html#Examples).
