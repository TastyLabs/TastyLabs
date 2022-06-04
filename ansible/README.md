# Initial Server configuration
1. Generate a SSH key: `ssh-keygen -t ed25519 -C "info@tastylabs.de"`
2. Add the public SSH key to the `authorized_keys` file: `cat ~/.ssh/id_ed25519.pub > ~/.ssh/authorized_keys`
3. Copy the private SSH key and add it as a GitHub secret: `cat ~/.ssh/id_ed25519`
