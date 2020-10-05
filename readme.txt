The project implements CRUD operations on a person Entity.

1- used spring initializer to generate a springboot maven project with the required dependencies including spring web, JPA, mysql
2- created a hibernate entity that maps the Person class into a database table
3- created a dao layer that can do Crud operations
4- create a service layer to abstract the dao layer and handle transactions
5- created the person end point that uses the service layer to do the required operations
7- created a frontline end point that abstract the person end point and uses it to do the operations.
8- created a simple mysql db and add person table to test the Api 
