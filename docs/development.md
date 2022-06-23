# Development

We recommend IntelliJ IDEA for development and local testing.

## IntelliJ
In IntelliJ, you can get the project from a version control system.
Use this option to import the repository in your IDE.

For starting the application, use the predefined run configuration on the top right of your toolbar.
After compilation and startup the server should be available on [http://localhost:8080](http://localhost:8080).

The recipes are stored in an H2 Database, creating some files for persistent data storage.
If you want to reset the database, delete all `database.*.db` files.

## Docker and Command line
For setup with Docker or the command line, please refer to the [installation documentation](/installation).
