# Git Workflow Guide


## Setup

When working with github, it is a good idea to connect your github account, see our [SSH Key Guide](gitSSHGuide.md)


## How to get the most recent changes
Save a "draft" of your recent work, and remove it from your view so you see the last commit instead. 
```bash
git stash
```
Fetch the most recently pushed commit.
```bash
git pull
```

## How to upload your changes
First make sure your code runs without errors. 

Save a "draft" of your recent work, and remove it from your view so you see the last commit instead.
```bash
git stash
```
Fetch the most recently pushed commit.
```bash
git pull
```

If there is nothing in the cloud to pull, just run step (A) else move to step (B). In either case continue step (C)

(A) get your most recent "draft" back from the top of the stack
```bash
git stash apply
```

(B) else from IntelliJ navigate to...

-> Commit (in left panel)

-> Stash (up left corner)

-> select the top stash, the first in the list

-> Click apply (there should now be a notification in the left bottom corner)
    (and if there is a merge conflict, you have to navigate through that as well)

(C)
Make sure you are in the root directory.
Stage all changes to be included in the commit.
```bash
$git add .
```
Then you initiate a new commit
```bash
$git commit -m "Describe your changes"
```
Upload the commit to the shared Github Repository
```bash
$git push
```

## Also useful

``` bash
git status 
```

### Conventions we follow...

- We push every time we implement something new (often).
- We don't push until the program runs without errors. 
- Commi messages are descriptive, in english and imperative (bydeform). For example "Add Pizza class", "Update Toppingn to take multiple toppings" etc.

### Workflows we don't use yet but we might use in the future

- Making a feature branch for every task to be implemented:
```bash
git checkout -b feature/player-movement
git add .
git commit -m "Task to be implemented"
git push -u origin feature/player-movement
```
...and make a pull request for that branch. Then someone else can implement it

## Other resources

- [The official guide and documentation](https://git-scm.com/learn)
- [Github guides to git](https://github.com/git-guides)