# Student Information Database

This simple Java project incorporates the use of JDBC (Java Database Connectivity) to enter student information into an MySQL database in terms of a student's ID, name, and major. This information is provided in a text file which is then parsed to extract a student's information. The information is inserted from the file into a table called "student" in the connected MySQL database. The program handles potential errors that may occur during the database connection process, file reading, or database operations, such as invalid student records or database connectivity issues. After all information has been successfully inserted, it closes the connection to the MySQL database after all student records have been processed and inserted.

![Database containing student information](https://github.com/anish-siv/Student-Information-Database/assets/73561392/f60d5925-b04c-414c-99af-49e28a2a9d63)

## Notes
* On line 10, replace `<USERNAME>` and `<PASSWORD>` with your MySQL credentials.
* On line 14, replace `<TEXT FILE PATH>` with the file path of the .txt file containing the student information on your computer.
