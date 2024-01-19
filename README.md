# api

## Local testing

Modification of [**application.properties**](src/main/resources/application.properties) file.

```cmd
ssh etudiant@intensif03.ecole.ensicaen.fr -L5306:localhost:5432
```

## User profile test :

JWT Token delivery under **'Token'** key in header's response.

```json
{
  "username": "TAN",
  "password": "intensive-project-03-tan"
}
```

```json
{
  "username": "VAL",
  "password": "intensive-project-03-val"
}
```

```json
{
  "username": "ANGELINA",
  "password": "intensive-project-03-angelina"
}
```

```json
{
  "username": "CHRISTELLE",
  "password": "intensive-project-03-christelle"
}
```

```json
{
  "username": "RANDOM",
  "password": "intensive-project-03-random"
}
```