package com.commerce.Store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.commerce.Store.entity.OrderDetails;
import com.commerce.Store.entity.Product;
import com.commerce.Store.entity.ShoppingCartImpl;
import com.commerce.Store.entity.User;
import com.commerce.Store.service.OrderService;
import com.commerce.Store.service.ProductService;
import com.commerce.Store.service.UserService;

@Controller
@Scope("request")
@RequestMapping("/")
public class StoreController {
	
	@Autowired
	private ShoppingCartImpl cart;
	
	@Autowired
	private ProductService theProductService;
	
	@Autowired
	private OrderService theOrderService;
	
	@Autowired
	private UserService theUserService;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private String currentPrincipalName;
	
	//--------------------------------------------------
	
	@GetMapping("/list")
	public String getProducts(Model theModel) {
		
		List<Product> products = theProductService.findAll();
		setPrincipalName();
		theModel.addAttribute("products", products);
		theModel.addAttribute("username", currentPrincipalName);
		
		return "list-products";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		
		theProductService.save(theProduct);
		
		return "redirect:/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {

		Product theProduct = theProductService.findById(theId);

		theModel.addAttribute("product", theProduct);

		return "product-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		theProductService.deleteById(theId);
		
		return "redirect:/list";
	}
	
	//-----------------------------------
	//			REGISTRATION FUNCTIONS
	//-----------------------------------
	
	@GetMapping("/showFormForRegistration")
	public String showFormForRegistration(Model theModel) {
		theModel.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User theUser) {

		String uncodedPassword = theUser.getPassword();
		theUser.setPassword(passwordEncoder.encode(uncodedPassword));
		theUserService.save(theUser);
		
		return "redirect:/list";
	}
	
	//-----------------------------------
	//			CART FUNCTIONS
	//-----------------------------------	
	
	@GetMapping("/listCart")
	public String getCart(Model theModel) {
		setPrincipalName();
		theModel.addAttribute("cart", cart.getCart());
		theModel.addAttribute("cartTotal", cart.getTotal());
		theModel.addAttribute("username", currentPrincipalName);
		
		return "list-cart";
	}
	
	@GetMapping("/showCartForm")
	public String showCartForm(@RequestParam("productId") int theId, Model theModel) {

		Product theProduct = theProductService.findById(theId);

		theModel.addAttribute("maxQuantity", theProduct.getQuantity());
		theProduct.setQuantity(1);
		theModel.addAttribute("product", theProduct);
		

		return "cartAdd-form";
	}
	
	@PostMapping("/addToCart")
	public String addToCart(@ModelAttribute("product") Product theProduct) {
		
		cart.addToCart(theProduct);
		
		return "redirect:/list";
	}
	
	@GetMapping("/deleteFromCart")
	public String deleteFromCart(@RequestParam("productId") int theId) {
		
		cart.removeFromCart(theId);
		
		return "redirect:/list";
	}
	
	@GetMapping("/purchaseCart")
	public String purchaseCart(Model theModel) {
		
		setPrincipalName();
		
		List<Product> products = theProductService.findAll();
		List<Integer> productIds = cart.getProductIds();
		List<Product> badPurchase = new ArrayList();
		boolean state = false;
		
		//check to see if any bad products
		for (Product product : products) {
			if(cart.compareQuantity(product) && productIds.contains(product.getId())) {
				badPurchase.add(product);
				state = true;
			}
		}
		
		if(state) {
			theModel.addAttribute("products", badPurchase);
			return "out-of-stock";
		}
		
		if(currentPrincipalName == null) {
			theOrderService.createOrderHistoryForCart(cart.getCart(), -1, "Guest User");
		} else {
			theOrderService.createOrderHistoryForCart(cart.getCart(), theUserService.findByUsername(currentPrincipalName).getUser_id(), currentPrincipalName);
		}

		theProductService.purchaseCart(cart.getCart());
		
		return "redirect:/list";
	}
	
	
	public void setPrincipalName() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		if(name != "anonymousUser") {
			currentPrincipalName = name;
		} else {
			currentPrincipalName = null;
		}
	}
	
	//-----------------------------------
	//			ORDER HISTORY FUNCTIONS
	//-----------------------------------
	
	@GetMapping("/orderHistory")
	public String getOrderHistory(Model theModel) {
		
		setPrincipalName();
		List<OrderDetails> orderHistory = new ArrayList();
		if(currentPrincipalName != null) {
			orderHistory = theOrderService.findByAccountId(theUserService.findByUsername(currentPrincipalName).getUser_id());
		}
		
		theModel.addAttribute("orderHistory", orderHistory);
		theModel.addAttribute("username", currentPrincipalName);
		
		return "list-orders";
	}
}

