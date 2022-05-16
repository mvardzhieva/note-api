# Note Application

### The application supports the following features:
- create a note
- retrieve all notes
- filter notes by keyword
- delete note by id

### The application is written in Java 15. It is used MySQL database so to run the *noteapi.sql* script you should install MySQL Server. The application expect that there is a running MySQL server on port *3306* with username *root* and password *root*. You should change the *application.properties* file in case there is any differece with your credentials.

### The following endpoints should be executed:
* /notes - **POST** method to create a note
* /notes - **GET** method to retrieve all notes
* /notes/{keyword} - **GET** method to retrieve all notes filtered by keyword
* /notes/{id} - **DELETE** method to remove note by id
