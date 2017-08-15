********************HONOR CODE********************
 I pledge on my honour that I have not given or received any unauthorized assistance on this assignment or any previous task.


********************CONTRIBUTION******************
160050056, Kumar Saunack - Latex, Git 1 & 3
160050057, Kumar Saurav - Latex, Git 2 & 3
160050002, Yash Shah - Latex, Git 2


*******************COMMENTS**********************
1. The normal commit message states something like n files changed, n insertion(+), n deletion(-). But this line is removed after resolving merge conflict because now the conflicted file matches the latest file on the server so there is no need to remove or add anything. However, when there is no conflict, the file must change and a new file is inserted alongwith the commits and at the same time the old file is deleted.

	Two commits are listed when a commit is staged after resolving a conflict, while only one commit is listed in normal cases.

2. Command to print graph on terminal -
   git log --graph --branches
   
   Yes, we observed a merge conflict regarding 'demo.txt'. This was due to different versions of the same file in the two branches during pulling.
   No, we did not observe any merge commit since we were working on two different branches and hence no merge had taken place. 

   The command to skip rebase conflicts was : git rebase --skip
   
   NOTE : Since it was not possible to push a rebased 'feature1' branch back onto the same branch, we first merged feature1 with master and then pushed the merged branch onto master.
   
3.
a) git commit -amend
b) ' git rebase -i origin/master ' followed by replacing 'pick' with 'squash' in whichever commit(s) we want to squash

   COMMAND FOR SQUASHING 'n' COMMITS : 
   git reset --soft HEAD~n && git commit -m "new message"
   
c) i) git format-patch origin/feature --stdout > patches.patch
      git apply patches.patch

*******************CITATIONS*********************
LATEX: 
inserting pictures side-by-side with captions -
 https://tex.stackexchange.com/questions/119984/subfigures-side-by-side-with-captions
 MAKING FLOWCHARTS USING TIKZ -
 https://www.sharelatex.com/blog/2013/08/29/tikz-series-pt3.html
 https://en.wikibooks.org/wiki/LaTeX/Tables

GIT
1. editing diffs using vimdiff https://www.youtube.com/watch?v=kFVjoIish0E
2. https://stackoverflow.com/questions/2529971/what-is-the-head-in-git

