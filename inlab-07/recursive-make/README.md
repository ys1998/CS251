# Working with recursive `make`

__DO NOT FORK THIS REPO. YOU WILL BE AWARDED ZERO MARKS IF YOU DO SO.__

Large projects make heavy use of recursive `make` calls. Project modules are arranged and built separately in sub-directories and a top-level Makefile orchestrates the whole build.
In this repository you will find a trivial implementation of a multi-threaded server and client written in C. They have not been written in a true [DRY](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself) fashion, but let's ignore that. Essentially, this project has 2 modules which have little overlap and can be built separately.

Complete the tasks mentioned in the checklist as well as you can.

## Learning Goals

Keep these in mind as you attempt this problem.

1. Use `gcc`'s `-c` flag to make object files.
2. Be able to keep all object files neatly in a build directory.
3. Link object files together to make an executable.
4. Get comfortable with `make`'s automatic variables, filename and text manipulation functions and recursive makefiles.

# What to submit

Submit 3 Makefiles. While you work name them all `Makefile`.
**Use the following naming convention _only_ when you submit:**

| Folder | Name |
| ------ | ---- |
| Top-level | `Makefile` |
| server | `Makefile.s` |
| client | `Makefile.c` |

We will rename the files to remove the extensions, and place them in the correct directories before grading your submission.

# General information

1. Compiling `mt_server` and `mt_client`
   - You must pass the `-pthread` (or `-lpthread`) at the linking phase.
2. The client application spawns multiple threads that bombard the server with requests.
2. Any top level Makefile can export variables to sub-makes.
3. You might have to make a few targets `.PHONY`.
4. Running the server:
   ```
   <server_executable> <port>
   ```
   Needless to say, use a port no. that is free.
5. Running the client:
    ```
    <client_executable> localhost <port> [<num_clients> = NUM_DEFAULT_THREADS]
    ```
6. You might find this [page](https://www.gnu.org/software/make/manual/html_node/File-Name-Functions.html#File-Name-Functions) to be very useful.
7. Assignments (to variables) in Makefiles can be done in various ways, ie `=` is not the only assignment operator. Do read up on this.

# Checklist

0. **Before beginning, PLEASE read all closed issues (if there are any)**, so that you don't miss any clarifications.
1. Write a Makefile for `mt_server` and `mt_client` each.
   1. Use variables like `CC`, `CFLAGS`, etc as much as possible.
   2. Any hardcoded information on file paths must be kept in variables. So we should not see rules like:
      `$(CC) $(CFLAGS) ./mt_server/$<`.
      The string `./mt_server` should have been kept in a variable and that should be used instead (DRY again).
   3. Your top-level makefile must export some variables to the sub-`make`s.
   4. Include atleast these targets:
      + `all`, `clean`, `run`
   5. **IMPORTANT** Your object files must be put in a sub-folder called `build`
      + Eg: `mt_server`, all `.o` files generated in the build-process for server executable must be put in `mt_server/build`. Similarily for `mt_client`.
      + Your Makefile _must_ create the `build` folder if it does not exist. Naturally, this step must run _before_ compilation starts.
   5. Each source file (ie `*.c`) must be compiled to its object code (ie `*.o`) without linking and saved in the corresponding `build` folder. The object files thus created must then be merged (ie linked) together to make the executable. _Hint: Use the `-c` flag of `gcc`._
   6. **IMPORTANT** The client and server executables must be kept in the top-level directory.
   7. The command make uses for `clean` should not be echoed to the terminal.
   8. Make sure you build the client with `-Wall` flag. The server must be built with `-Wextra`
2. Write a top-level Makefile with (atleast) the following targets:
   + `all`, `clean`, {Optional} `run`
3. Make sure that the executable and object files have debugging information (using `gcc`'s `-g` flag).

# Requests for clarifications

~~Please open an issue on this repository. Clarification/help requests for this problem will not be entertained on moodle.~~
~~Before opening an issue PLEASE read all closed issues (if there are any).~~

# Contributing

_This is not required for the lab/course and shall not be graded._

Pull requests that improve the README, modularize the code (lot of scope for that) are welcome. If in doubt, file an issue and we shall discuss there.

A feature wishlist:

+ Improve logging
+ Randomise strings sent by client threads.
+ Catch the `SIGINT` signal in server and do a graceful shutdown.
  - the `pthread_attr_t attr` is never `free`-ed, for example.
+ Submit a server that uses multi-processing (via fork) to handle requests.
