## This is how you get the most recent changes
$git stash

$git pull


## This is how you upload your changes
$git stash

$git pull

If there is nothing in the cloud to pull,
   git stash apply
else from IntelliJ navigate to...
    -> Commit (in left panel)
    -> Stash (up left corner)
    -> select the top stash, the first in the list
    -> Click apply (there should now be a notification in the left bottom corner)
    (and if there is a merge conflict, you have to navigate through that as well)


$git add .

$git commit -m "Describe your changes"

$git push

## also useful

git status 

## setup 

When working with github, it is a good idea to connect your github account, see [here](gitSSHGuide.md)

## conventions we follow...

- We push every time we implement something new (often).
- We don't push until the program runs without errors. 
- Commi messages are descriptive, in english and imperative (bydeform). For example "Add Pizza class", "Update Toppingn to take multiple toppings" etc.

## Workflows we don't use yet but we might use in the future

- Making a feature branch for every task to be implemented:
```bash
git checkout -b feature/player-movement
git add .
git commit -m "Task to be implemented"
git push -u origin feature/player-movement
```
...and make a pull request for that branch. Then someone else can implement it
