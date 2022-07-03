# Installation

## Quick start

We provide a `docker-compose.yml` file for quick and easy setup.

```shell
docker-compose up -d --build --remove-orphans
```

The service should be available at [https://localhost]().

## Deployment with Docker
1. Before deploying to a remote server, please adapt the `docker-compose.yml`, `Caddyfile` (URL of the server for the HTTPS certificate) as well as the `src/main/resources/application.yml` files for your needs.
2. If you use the Ansible playbook provided in the `ansible` directory to deploy the Docker stack to your server, please also adapt the `ansible/hosts.ini` (IP of the server) and `ansible/deploy.yml` (Since you have made some changes, it is not possible to clone the repository. Therefore, please transfer your code to the server in another way.).

## Deployment without Docker

### Requirements
- Linux server
- Java 11
- Maven

### TastyLabs
1. Create the folder for the application: `mkdir /opt/tastylabs && cd /opt/tastylabs`
2. Clone the source code: `git clone https://github.com/TastyLabs/TastyLabs.git /opt/tastylabs`
3. Adapt the `src/main/resources/application.yml` file for your needs.
4. Build the Spring Boot application: `mvn package`
5. Copy the `.jar` file to the current directory: `cp ./target/*.jar ./app.jar`
6. Start the application with `java -jar app.jar`

_Note: You may want to start the `.jar` file as a service._

### Caddy Reverse Proxy
1. Adapt the `Caddyfile` file for your needs.
2. Install Caddy according to their [docs](https://caddyserver.com/docs/install).
3. Copy the `Caddyfile` to the right location: `cp Caddyfile /etc/caddy/Caddyfile`
4. Restart Caddy.

## Deletion of the database
If you want to delete **all** stored recipes, delete the `data/database.*.db` files.
