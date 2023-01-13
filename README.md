# FinalProject-TrainerApp
![My_personal_trainer_app_logp](./assets/logo.png)

> Hi 👋 ! I`m Martu!</br>
> My final project is a training application, in this file you will find the corresponding information to be able to use it *So... here we go!*

# DIAGRAMS
[Here](./assets/Diagrama%20de%20clases.png) you have a link with the **use  diagram**, and
[here](./assets/My%20Personal%20Trainer%20App-%20Use%20Case%20Diagram.png)
  with the **class diagram**.

## How the application works

1. We have two databases, one for users, and another for training.</br>
2. The administrator user can access the user list, check their progress and edit their list of routines.</br>
3. Client users have access to all routines and can filter them by goal, save them to their preferences and track their progress.</br>
4. Like Backlog, users will be able to rank up to premium, and will have the ability to chat with their coach and get personalized routines..</br>
5. The routines are editable by the administrator, as well as each of the components.</br>


##THE API [Repository](https://github.com/MartuDorado/Final-project-EY/tree/master/Api)<br>
##THE CLIENT [Repository](https://github.com/MartuDorado/Final-project-EY/tree/master/Client/Vue-project)


## API `endpoints`

| Method  | URL                                                               | Description                                                          |
|---------|-------------------------------------------------------------------|----------------------------------------------------------------------|
| `GET`   | `/catalog/{userName}`                                             | Retrieve User.                                                       |
| `POST`  | `/catalog`                                                        | Create a new User.                                                   |
| `GET`   | `/catalog/routines`                                               | Retrieve all routines.                                               |
| `POST`  | `/catalog/routines`                                               | Create a new routine.                                                |
| `GET`   | `/api/routines/{routineId}`                                       | Retrieve routine.                                                    |
| `PATCH` | `/catalog/user-routines/userName/routineId`             | Add a routine to followup´s user .                                   |


**Response**
`/catalog/{userName}`
```
// GET ENDPOINT =
{
    "user": {
        "userName": "USER@gmail.com",
        "password": "$2a$10$4azmrFuIzB160VUUTBvyV.y8J0HNOc5VuI0b0AGD37NCqJsKko.yG",
        "name": "User",
        "dateOfBirth": "22/11/0000",
        "age": --
    },
    "followUp": {
        "userName": "USER@gmail.com",
        "routines": [
            {
                "id": 3,
                "title": "Rutina de prueba",
                "blocks": [
                    {
                        "id": 3,
                        "title": "Bloque de prueba",
                        "laps": 4,
                        "exercises": [
                            {
                                "id": 5,
                                "name": "Sentadilla",
                                "reps": 10,
                                "description": "",
                                "video": "https://www.youtube.com/watch?v=BjixzWEw4EY&ab_channel=FisioOnline"
                            },
                            {
                                "id": 6,
                                "name": "Push Up",
                                "reps": 10,
                                "description": "",
                                "video": "https://www.youtube.com/watch?v=Yd79XBIdDnI&ab_channel=PRO-BARRAS"
                            }
                        ]
                    }
                ],
                "creation_DATE": "2023-01-12"
            }
        ],
        "routinesDones": [],
        "annotations": []
    }
}
}


## Setup

- Fork this repo
- Clone this repo

```shell
$ git clone <NameOfRepository>
$ cd MyPersonalTrainerApp
```

- Open folder in IntelliJ IDEA
- Run program

## VIEWS
[HomePage](../assets/screen1.png)<br>
[LoginPage](../assets/screen2.png)
