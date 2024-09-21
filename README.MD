# Web App API using Java Spring Boot Framework

## This is a project for testing my react and react-native apps with axios

### Anyone can use this without a problem

**Tech Stack**
- Java Spring Boot
- PostgreSQL
- Docker and Docker Compose

**System has three main users (roles)**
- Admin
- Moderator
- Viewer

## ✅Features (Implemented for now)
- Login for only viewer
- Add posts for only viewer
- Approve posts by moderator
- View all approved posts of the logged in viewer

## Todo
- Login for other users
- Logout
- Password reset
- Edit, delete and view all posts by the user created
- Reject, delete and view posts by moderator
- Add moderators to the system and do all the tasks of moderator by admin
- Email sending with 2FA for Viewers
- Password reset for Moderators after Admin adding them to system
- Email Notifications
- Error Handling

## Currently Implemented Endpoints
- /api/v1/auth/login
    - Can be used to login for every roles.
- /api/v1/posts/add
    - To add posts as the viewer
- api/v1/posts/approve/{postid}
    - To Approve posts as moderator
- /api/v1/viewer/getpostsapproved
    - To get Approved posts of the currently logged in viewer

## How to run

### Prerequisites
- [git](https://git-scm.com/downloads)
- [Java 21](https://www.oracle.com/java/technologies/downloads/#java21) and [add it to path](https://www.java.com/en/download/help/path.html).
- [Docker](https://www.docker.com/)
    - We are using docker to host our postgreSQL Database

**Steps**

1. Clone this repo
```
git clone https://github.com/pachax001/JavaSpring-WebApp.git
```
2. Go in to `src/main/resources` and create a file named `env.properties`. This where we put our secrets like Database username, password etc.
    - Here are the required fields
    ```
    DB_USERNAME=
    DB_PASSWORD=
    DB_URL=jdbc:postgresql://localhost:5433/webapp-db
    CORS_ALLOWED_ORIGINS=http://localhost:5173
    JWT_PUBLIC_KEY=
    JWT_PRIVATE_KEY=
    ```
    - `DB_USERNAME` - username of the database
    - `DB_PASSWORD` - password of the database
    - `DB_URL` - database URL. Do not change this.
    - `CORS_ALLOWED_ORIGINS` - Allowed Cors to communicate with my react front end without being blocked by CORS policy restrictions.
    - `JWT_PUBLIC_KEY` - Keys used to generate jwt token encryption.
    - `JWT_PUBLIC_KEY` - Keys used to generate jwt token encryption.
        - For Both public and private key generation please use `PKCS8` format or else the code will throw an error.
            - A PKSC8 Private key begins with the following text in PEM format:
            ```
            -----BEGIN PRIVATE KEY-----
            (Base64 encoded data)
            -----END PRIVATE KEY-----
            ```
        - A PKSC8 Public key begins with the following text in PEM format:
        ```
        -----BEGIN PUBLIC KEY-----
        (Base64 encoded data)
        -----END PUBLIC KEY-----

        ```
        - Can use [`openssl`](https://openssl-library.org/source/) to generate both private and public keys. Asks Chat-GPT how to do it😁.
3. Now create a file named `config.env` in the cloned folder or main folder (If you created the `env.properties` now you are in `resources directory`. So go to `main directory`.) and copy paste following.
```
POSTGRES_DB= 
POSTGRES_USER=
POSTGRES_PASSWORD=
```
- `POSTGRES_DB`- Database Name
- `POSTGRES_USER` Database username. Same as one put in `properties.env`
- POSTGRES_PASSWORD=Database password. Same as one put in `properties.env`



4. Now open terminal/cmd/powershell (Whatever you call) in the cloned folder or the main folder and type this.(Need to have a good internet connection because this is gonna pull the official `postgres Image` from the `Docker-Hub`(This not the **hub** you know)).

5. If all are good it is time to run the project. Assuming you are using [Intellij](https://www.jetbrains.com/idea/). If you are using [VsCode](https://code.visualstudio.com/) use `Spring Boot Extension Pack` to run the project.

### If all is good the app will start





