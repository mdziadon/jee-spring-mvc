package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ProductDao;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;

import java.util.List;
import java.util.Random;

@Controller
public class CartController {

    private Cart cart;
    private ProductDao productDao;

    @Autowired
    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

    @RequestMapping("/addtocart/{id}/{quantity}")
    @ResponseBody
    public String addtocart(@PathVariable Long id, @PathVariable Integer quantity) {

        Product product = productDao.getProduct(id);
        if (product == null) {
            return "Brak takiego produktu";
        }

        CartItem cartItem  = cart.getCartItem(product);
        if (cartItem == null) {
            cart.addToCart(new CartItem(quantity, product));
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }

        return "addtocart";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        List<CartItem> cartItems = cart.getCartItems();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("size", cartItems.size());
        model.addAttribute("summary", cart.getSum());
        return "cartItems";
    }
}
