Simple application who takes data from data base and return in web browser.
Data taking msql format. Db config (there is also mysql file witch one you can make table in db):
url=jdbc:mysql://localhost:3306/db
username=root
password=admin
Application return JSon format data.
Covered by JUnit.
End points:
/api/tasks (GET) - returns all records from DB
/api/task/{taskID} (GET) - returns one record by taskId(int) from DB
/api/task (PUT) - edit existing record by id and return edited record
/api/task/{taskId} (DELETE) - delete record by takId(int)
/api/task (POST) - save record in DB and return record whit Id(auto generated)

Launch application locally:
Create data base whit name "da" username"root" and password"admin"
launch "table.sql" in this data base (its creat a table for entity)
launch "craftsoft-0.0.1-SNAPSHOT.jar" to run application

For future:
need to make login for application
need to catch exception


