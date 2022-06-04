#!/bin/sh

mkdir ~/.ssh
echo "$SSH_KEY" > ~/.ssh/id_ed25519
chmod 0600 /root/.ssh/id_ed25519
eval "$(ssh-agent -s)" && ssh-add ~/.ssh/id_ed25519

cd ansible

ansible-playbook -i hosts.ini deploy.yml
