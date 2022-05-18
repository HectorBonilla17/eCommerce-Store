# eCommerce-Store
A Spring Boot Web Application that manages a database of products (name, price, & quantity) with the ability to add products to the database and to add products to a cart for purchase. The application uses Spring Security to manage the ability to create & update products within the database. The general user role doesn't need to be logged into in order to add products to a cart & purchase, while not having access to the admin-like abilities. While the users with the “ADMIN” role have access to the ability to create new products & update or delete existing products. In addition, the database keeps track of the product history such name, price, quantity, and time of purchase for each order.

1. The website allows all users to view all the current products in the database. In addition, an "ADMIN" user has to ability to update the selected product or delete them.

![list](https://user-images.githubusercontent.com/31080342/168953155-1a7c1a43-73f4-4061-b948-44ab85c1ac9f.png)

2. An "ADMIN" user can create a new product using the "Add Product" button, which will redirect them to a different html form where they can provide the necessary data for the product. 
 
![createProduct](https://user-images.githubusercontent.com/31080342/168953267-9ac2c912-c255-472e-9f73-25f36ae0e759.png)

3. 
