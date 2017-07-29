# CS251 
## Software Systems Lab : Assignments' collection
### Setup
Delete any existing previous local repositories having the name **CS251**, and execute :
```
git clone https://github.com/ys1998/CS251.git
cd CS251/
```
### Using your branch
Each time before you make any changes to your local repository, you **must** execute this command :
```
cd CS251/
git pull
```
This is done to sync your local repo with the online repo so as to prevent merge conflicts in the future.
After syncing the repository to your machine :
```
git checkout <your-branch-name>
```
Here the branch name is either `saurav` or `saunack` or `yash`.

Create a directory named `outlab-XX` in the local repo and write your code in it preserving the directory structure provided to us by the TA's, and work on your local repo.

To push your code from your local repository to the remote (online) repo, execute these commands :
```
git add .
git commit -m "some-commit-message-like-Solved-question-XX"
git push origin <branch-name>
```
Here the branch-names are, once again, `saurav`, `saunack` and `yash`.

After all have submitted their part, the branches will be merged with the `master` branch. Submission will follow.

