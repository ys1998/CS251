# Top level Makefile

server_path=./mt_server/
client_path=./mt_client/

default: all

all: 
	@cd ${client_path} && $(MAKE) EXTFLAGS="-g -Wall"
	@cd ${server_path} && $(MAKE) EXTFLAGS="-g -Wextra"
	

clean:
	@cd ${client_path} && $(MAKE) clean
	@cd ${server_path} && $(MAKE) clean
	@rm -f exec_client
	@rm -f exec_server
run:
	


