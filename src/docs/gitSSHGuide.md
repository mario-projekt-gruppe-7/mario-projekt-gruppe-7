## Git SSH key Guide

SSH key (Secure Shell Protocol) is a smooth way to connect your Github account to your Computer, so you don't have to type your gitHub password every time you push and pull. 
Read the official guide [here](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)


- First you need to generate a SSH Key. You need to replace the email with your own and run this in your terminal from any location.
```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

- You will get "Enter a file in which to save the key". Just press `Enter` for default. 

You will be asked for a passphrase when using an SSH key. Some people skip setting a passphrase (just press Enter) to avoid typing it, but this is not very secure: a virus or anyone who gains access to your computer could use your private key to push to your repositories.
On the other hand, you don’t want to type the passphrase every time you push or pull. The solution is to use an **SSH agent**, which keeps the decrypted key in memory, so you only type the passphrase once per session (once every time you start your computer).

- Folow the official guide [here](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent). 




- You now need to find your public key. It should contain -pub. Find it this way:
```bash
cat ~/.ssh/id_ed25519.pub
```
- It should now return your public key (containing -pub). Copy this key
- Now you need to login to your GitHub account. 
- Click on your profile (top right corner)
- Click on `Settings`
- Click on 'SSH and GPG keys' (bottom left)
- Click 'New SSH key'
- Paste your key and add it

- Back in your terminal, run:  
```bash
ssh -T git@github.com
```
It should now print 
`Hi username! You've successfully authenticated, but GitHub does not provide shell access.`

Congratulations! You have now connected GitHub to your computer with the SSH.
