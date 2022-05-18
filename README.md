# eCommerce-Store
A Spring Boot Web Application that manages a database of products (name, price, & quantity) with the ability to add products to the database and to add products to a cart for purchase. The application uses Spring Security to manage the ability to create & update products within the database. The general user role doesn't need to be logged into in order to add products to a cart & purchase, while not having access to the admin-like abilities. While the users with the “ADMIN” role have access to the ability to create new products & update or delete existing products. In addition, the database keeps track of the product history such name, price, quantity, and time of purchase for each order.

1. The website allows all users to view all the current products in the database. In addition, an "ADMIN" user has to ability to update the selected product or delete them.

![list](https://user-images.githubusercontent.com/31080342/168953155-1a7c1a43-73f4-4061-b948-44ab85c1ac9f.png)

![delete](https://user-images.githubusercontent.com/31080342/168953841-031772ec-3e91-4d76-a064-744049116769.PNG)

2. An "ADMIN" user can create a new product using the "Add Product" button, which will redirect them to a different html form where they can provide the necessary data for the product. In addition, they can also update a product using the same form via clicking the "Update" button on the respective product.
 
![createProduct](https://user-images.githubusercontent.com/31080342/168953267-9ac2c912-c255-472e-9f73-25f36ae0e759.png)

3. All users can use the "Add To Cart" button, which will redirect them to a different html form where they can provide the quantity for the product and add that product to their cart.

![addToCart](https://user-images.githubusercontent.com/31080342/168953624-a1441a1c-446b-453b-8c28-a7c9769596f5.png)

4. All users to view their current cart by selecting the "Cart" tab at the top of the website, which will display the products they have added (with their name, price, & quantity) and the total cost of all the products. 

![listCart](https://user-images.githubusercontent.com/31080342/168954027-2f7f8dfc-1090-4a84-9d12-c04ec2d2945c.png)

5. An "ADMIN" user can sign into their account on either the "Product List" or "Cart" with the "Admin Login" button, which when click will redirect them to the login page.

![signin](https://user-images.githubusercontent.com/31080342/168954175-98f3c884-a853-4dad-8a07-84e3f2f410e3.PNG)
