# Spring Boot Device Seller

## Endpoints

### Sign-Up

````
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 73

{
    "name": "admin",
    "username": "admin",
    "password": "admin"
}
````


### Sign-In

````
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "username": "admin",
    "password": "admin"
}
````


