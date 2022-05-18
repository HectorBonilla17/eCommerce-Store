<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html xmlns:th="http://www.thymeleaf.org">

<head>
	<title>Product Directory</title>
	
	
	
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
</head>

<body>

<div class="container">
	<br>
	<h3>Product Directory</h3>
	
	<hr>
	
	<a th:href="@{/showFormForAdd}" 
		class="btn btn-primary btn-sm mb-3">
		Add Product
	</a> 
	
	<table class="table table-bordered table-striped">

		<thead class="thead-dark">
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Action</th>
			</tr>
		</thead>


		<tbody>
			<tr th:each="tempProduct : ${products}">
				<td th:text="${tempProduct.name}" />
				<td th:text="${tempProduct.price}" />
				<td th:text="${tempProduct.quantity}" />		
				
				<td>
					<!-- Add Add-To-Cart button/link -->
					<a th:href="@{/showFormForUpdate(productId=${tempProduct.id})}"
						class="btn btn-info btn-sm">
						Add To Cart
					</a>
					
					<security:authorize access="hasRole('MANAGER')">
					<!-- Add update button/link -->
					<a th:href="@{/showFormForUpdate(productId=${tempProduct.id})}"
						class="btn btn-info btn-sm">
						Update
					</a>
					
					<!-- Add delete button/link -->
					<a th:href="@{/delete(productId=${tempProduct.id})}"
						class="btn btn-sm btn-danger"
						onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">
						Delete
					</a>
					</security:authorize>
					
				</td>
					
			</tr>
		</tbody>
	
	</table>
</div>
	
</body>

</html>