#
# ~/.bashrc
#

# If not running interactively, don't do anything
[[ $- != *i* ]] && return

alias ls='ls --color=auto'
alias size='du -s -h -c *[!.]* ./*'
PS1='[\u@\h \W]\$ '
