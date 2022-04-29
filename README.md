# The Account Management RESTFul Api

### Project Features

* Build Api enpoints for Account management project

### Project Requirement
1. Java 8+
2. Maven 
3. Install and run PostgreSQL on your localhost for storing data
4. Instal DBeaver and restore https://community.pyramidanalytics.com/t/h7hk07w/how-to-backup-and-restore-a-postgresql-database-via-dbeaver
5. ...

### How to use from this sample project
##### Clone the repository
```
git clone https://github.com/clipdoi/demoRest.git
```
##### Run project
```
* Import project into IntelliJ IDE
* Choose DemoRestApplication.java -> Run 'DemoRestApplic....main()'
```

##### Test api with postman
```
https://www.postman.com/downloads/
```

### RestApi Enpoints

* Retrieve all accounts :  http://localhost:9596/api/accounts
````

 Success Response Example
    [
        {
            "accountId": 2,
            "username": "kienca199",
            "password": "456",
            "name": "Kiên",
            "email": "cba@gmail.com",
            "created": "2022-04-19",
            "status": true
        },
        {
            "accountId": 3,
            "username": "thongnpm",
            "password": "123",
            "name": "Thông",
            "email": "bac@gmail.com",
            "created": "2022-04-20",
            "status": true
        },
        ...
    ]
  
 ````
 -------------------------------------------------------------
* Retrieve all roles of an account(id=2) : http://localhost:9596/api/account/2/roles
 ````
  
  Success Response Example
    [
        "admin",
        "customer"
    ]
  Error Response Example
   {
    "timestamp": "2022-04-29T09:25:20.048+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Invalid request ...",
    "path": "/api/account/0/roles"
}
   ````
  -------------------------------------------------------------

* Create an account :  http://localhost:9596/api/account
 ````
  Example Request
  {
    "username": "minhtu199",
    "password": "456",
    "name": "Thông",
    "email": "cbade@gmail.com",
    "created": "2022-04-29",
    "status": true
  }
 Success Response Example
  {
    "accountId": 7,
    "username": "minhtu199",
    "password": "456",
    "name": "Thông",
    "email": "cbade@gmail.com",
    "created": "2022-04-29T00:00:00.000+00:00",
    "status": true
  }
   
 Error Response Example
   {
    "timestamp": "2022-04-29T10:09:18.327+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Invalid input email format",
    "path": "/api/account"
}
  ````
  -------------------------------------------------------------

* Update an account(id=7) : http://localhost:9596/api/account/7
 ````
  {
    "username": "minhphuongtu1999",
    "password": "456",
    "name": "Thông",
    "email": "cbade@gmail.com",
    "created": "2022-04-29T00:00:00.000+00:00",
    "status": true
  }
  ````
  -------------------------------------------------------------
  

* Delete an account(id=2)(status change true to false): http://localhost:9596/api/account/2
````

  *Success Response Example
   {
        "accountId": 2,
        "username": "kienca199",
        "password": "456",
        "name": "Kiên",
        "email": "cba@gmail.com",
        "created": "2022-04-19",
        "status": false
    }
  
   ````
  -------------------------------------------------------------




