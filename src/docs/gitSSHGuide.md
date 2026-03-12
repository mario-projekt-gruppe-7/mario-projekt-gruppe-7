## Git SSH key Guide

SSH key (Secure Shell Protocol) is a smooth way to connect your Github account to your Computer, so you don't have to type your gitHub password every time you push and pull. 
Read the official guide [here](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)


- First you need to generate a SSH Key, replace the email with your own
```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

- You will get "Enter a file in which to save the key". Just press `Enter` for default.

- You will be asked for a password. It is convenient to just skip this with `Enter`, but the ideal thing would be to use an SSH agent so you don't have to type it every time. See the official guide at the top. 
- 