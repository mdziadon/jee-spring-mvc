package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;

import java.util.List;
import java.util.Random;

@Controller
public class CartController {

    private Cart cart;

    @Autowired
    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        List<CartItem> cartItems = cart.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cartItems";
    }
}
