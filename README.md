# Nimap_Test1


1. How to Run the Code
Clone the repository using the GitHub link.
Open the project in your preferred IDE (e.g., IntelliJ IDEA or Eclipse or STS).
Ensure you have Java 17 or above, Maven, and MySQL installed on your system.
Update the application.properties file with your MySQL database credentials.
Run the project using the command:
bash
Copy code
mvn spring-boot:run
The application will start on http://localhost:8080.


2. Running the Machine Test
The project includes APIs for both Category and Product CRUD operations, with a one-to-many relationship between Category and Product.
I have implemented server-side pagination for the GET requests.
The product details API response includes the respective category details.
You can test the APIs using Postman or any API client. The following endpoints are available:

Category APIs:

GET all categories: GET http://localhost:8080/api/categories?page={pageNumber}
Create a new category: POST http://localhost:8080/api/categories
Get category by ID: GET http://localhost:8080/api/categories/{id}
Update category by ID: PUT http://localhost:8080/api/categories/{id}
Delete category by ID: DELETE http://localhost:8080/api/categories/{id}
Product APIs:

GET all products: GET http://localhost:8080/api/products?page={pageNumber}
Create a new product: POST http://localhost:8080/api/products
Get product by ID: GET http://localhost:8080/api/products/{id}
Update product by ID: PUT http://localhost:8080/api/products/{id}
Delete product by ID: DELETE http://localhost:8080/api/products/{id}


3. Database Design
I used MySQL as the relational database.
There are two tables: categories and products.
The categories table has a one-to-many relationship with the products table using a foreign key (category_id).

