#
# ~/.bashrc
#

# If not running interactively, don't do anything
[[ $- != *i* ]] && return

alias ls='ls --color=auto'
alias SIZE='du -sh .'
echo $(find -maxdepth 1 | cut -d '/' -f 2)
echo $(SIZE)
PS1='[\u@\h \W]\$ '
