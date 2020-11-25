## TS Assignment - SDET - May 2020
​
### Given
​
A backend service, that handles some basic authentication and user management duties. 

### Expect

1 - Please build an application that handles requests and responses as below. Using open source or open framework is welcome.

2 - Write test cases.

### Implement

##### Create User API
​
REQUEST

```bash
curl -X POST 'http://{{root}}/user/create' \
--header 'Content-Type: application/json' \
--data-raw '{
   "user_name": "my_user_name",
   "password": "my_password",
   "email": "my@email.com",
   "phone_number": "84987000000"
}'
```
​
RESPONSES

```bash
200 - OK
{
   "status": "success", 
   "message": "user is created",
   "user_id": "837a53e98d654d8c9e20ee1415b6860f",
   "time":"2020-05-08T15:46:48+07:00"
}
```

```bash
400 - Bad Request
{
   "status": "invalid",
   "message": "invalid parameter",
   "detail": {"field": "detail error"},
   "time":"2020-05-08T15:46:48+07:00"
}
```

##### Login API
​
REQUEST

```bash
curl -X POST 'http://{{root}}/user/login' \
--header 'Content-Type: application/json' \
--data-raw '{
"user_name": "my_user_name",
"password": "my_password"
}'
```
​
RESPONSES

```bash
200 - OK
{
    "status": "success",
    "message": "login success",
    "token": "KyQ3XycVZVoQBixtWdLtYjdjGEtCYknO"
}
```

```bash
401 - Unauthorized
{
   "status": "unauthorized",
   "message": "user_name or password is incorrect",
   "time":"2020-05-08T15:46:48+07:00"
}
```

```bash
429 - Rate Limit
{
   "status": "lock",
   "message": "too many requests failed, try again",
   "lock_seconds": 300,
   "time":"2020-05-08T15:46:48+07:00"
}
```

##### Update User API

```bash
curl -X POST 'http://{{root}}/user/update' \
--header 'Content-Type: application/json' \
--data-raw '{
"token": "KyQ3XycVZVoQBixtWdLtYjdjGEtCYknO",
"email": "updated@email.com",
"phone_number:" "84987000001"
}'
```

```bash
200 - OK
{
    "status": "success",
    "message": "update success",
    "time":"2020-05-08T15:46:48+07:00"
}
```

```bash
403 - Forbidden
{
   "status": "forbidden",
   "message": "invalid token",
   "time":"2020-05-08T15:46:48+07:00"
}
```

```bash
400 - Bad Request
{
   "status": "invalid",
   "message": "invalid parameter",
   "detail": {"field": "detail error"},
   "time":"2020-05-08T15:46:48+07:00"
}
```