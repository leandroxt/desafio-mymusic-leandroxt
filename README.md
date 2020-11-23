# About the backend

The project is divided in 3 parts. The playlist and music services and the gateway.
Each service run in a different port and the gateway is responsible to intermediate all connections.

#### Running the services

If you are going to run the project inside an IDE, like intellij, there is nothing to change, if you 
will run from command line using `./mvnw spring-boot:run` command, inside the services you will need
to make a small change in the `application.properties` of each service;
The project use SQLite as a database, so the DB itself is a simple .db file and to the project run 
properly change this line in the file:
`spring.datasource.url = jdbc:sqlite:MyMusic.db` to `spring.datasource.url = jdbc:sqlite:../MyMusic.db`

To solve the cors problem using a better solution, use nginx is a good approach:

```
client ->   |                       |                                   
            | Nginx proxy_pass->    |   -> frontend localhost:300       
            |                       |                                   
            |                       |   -> gateway localhost:8080 ->   |  -> plalist localhost:8081
            |                       |                                  |  -> musics localhost:8081
```

#### runing the frontend

You need to install node and npm or yarn

In the folder `mu-music-ui` run

```
$> npm i
$> npm start
```