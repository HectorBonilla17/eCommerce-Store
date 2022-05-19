# eCommerce-Store
A Spring Boot Web Application that manages a database of products (name, price, & quantity) with the ability to add products to the database and to add products to a cart for purchase. The application uses Spring Security to manage the ability to create & update products within the database. The general user role doesn't need to be logged into in order to add products to a cart & purchase, while not having access to the admin-like abilities. While the users with the “ADMIN” role have access to the ability to create new products & update or delete existing products. In addition, the database keeps track of the product history such name, price, quantity, and time of purchase for each order.

1. The website allows all users to view all the current products in the database. In addition, an "ADMIN" user has to ability to update the selected product or delete them.

![list](https://user-images.githubusercontent.com/31080342/169421403-36837f44-3f45-4c92-b588-d2021036b50c.png)

![delete](https://user-images.githubusercontent.com/31080342/169421411-126a96ed-9bee-4410-bfc3-a61b169f6beb.PNG)

2. A user can sign into their account on either the "Product List", "Cart", or "Order History" page with the "Login" button, which when click will redirect them to the login page.

![signin](https://user-images.githubusercontent.com/31080342/168954175-98f3c884-a853-4dad-8a07-84e3f2f410e3.PNG)

3. Anyone can register for a "USER" account on  on either the "Product List", "Cart", or "Order History" page with the "Register New Account" button, which when click will redirect them to the registration page.

![register](https://user-images.githubusercontent.com/31080342/169421658-bac8d814-ff06-41b9-bba4-03eed2a4a752.png)

4. An "ADMIN" user can create a new product using the "Add Product" button, which will redirect them to a different html form where they can provide the necessary data for the product. In addition, they can also update a product using the same form via clicking the "Update" button on the respective product.
 
![createProduct](https://user-images.githubusercontent.com/31080342/168953267-9ac2c912-c255-472e-9f73-25f36ae0e759.png)

5. All users can use the "Add To Cart" button, which will redirect them to a different html form where they can provide the quantity for the product and add that product to their cart.

![addToCart](https://user-images.githubusercontent.com/31080342/168953624-a1441a1c-446b-453b-8c28-a7c9769596f5.png)

6. All users to view their current cart by selecting the "Cart" tab at the top of the website, which will display the products they have added (with their name, price, & quantity) and the total cost of all the products. 

![listCart](https://user-images.githubusercontent.com/31080342/169421436-b67908b6-5dcf-4fc1-a21e-eb2738dd429d.png)

7. If a user tries to by a product in their cart which has a greater quantity than the one in the database, they will redirected to an error page which tells them which of the products in their cart are either out of stock or there is not enough stock of them based on their cart. 

![badPurchase](https://user-images.githubusercontent.com/31080342/169421810-cd95f86d-85ec-4369-a451-38b11bf51e1d.png)

8. Anyone with either a "USER" or "ADMIN" account has the ability to track their previous cart purchases and can use the "Order History" tab/page in order to get a table that display their previous purchases, with information such as Product Name, Price, Quantity, & Date of Order.

![orderHistory](https://user-images.githubusercontent.com/31080342/169421935-81608686-c9b5-4d35-abb2-ff809e23b43d.png)

