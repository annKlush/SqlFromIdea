# SqlFromIdea
Task 1 - Create a utility class for database operations
Create a singleton class called Database, which encapsulates the logic for interacting with the database. 
Upon instantiation of this class, establish a connection to the H2 database and store the Connection instance. 
Provide a method getConnection() that returns the Connection object. 

Task 2 - Create a class to initialize the database structure
Create a class named DatabaseInitService. This class should have a public static void main(String[] args) method that reads the file sql/init_db.sql and 
executes the queries from this file against the database.
Utilize the Database class you previously created to work with the database.

The result of running this class is an initialized database with properly created tables and relationships.

Task 3 - Create a class to populate the database tables
Create a class named DatabasePopulateService. This class should have a public static void main(String[] args) method that reads 
the file sql/populate_db.sql and executes the queries from this file against the database.
Utilize the Database class previously created to work with the database.

The result of running this class should be populated tables in the database.

Task 4 - Create a class for querying data from the database
Create a class named DatabaseQueryService. This class should have methods corresponding to each SELECT statement from the previous task. Each method should:
Read the corresponding .sql file.
Return the desired result.
Each method named according to the Java Code Conventions.

Utilize the Database class you previously created to work with the database.
