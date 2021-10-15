package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.catalog.Equipment;
import za.ac.cput.entity.rentalcart.Cart;
import za.ac.cput.services.CartService;

import java.util.Set;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping(value = "/create")
    public Cart create(@RequestBody Cart cart) {
        return  cartService.create(cart);
    }
    @GetMapping("/read")
    public Cart read (@RequestBody Cart cart)
    {
        return cartService.read(cart.getId());
    }
    @PostMapping("/update")
    public Cart update (@RequestBody Cart cart)
    {
        return cartService.update(cart);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id)
    {
        return cartService.delete(id);
    }
    @GetMapping("/getCartFromCustomerId/{customerId}")
    public Set<Cart> getCartFromCustomerId(@PathVariable String customerId)
    {
        return cartService.getCartFromCustomerId(customerId);
    }
    @DeleteMapping("/clearcart/{customerId}")
    public boolean delete(@PathVariable String customerId) {
        Set<Cart> cartInfo = getCartFromCustomerId(customerId);
        if(cartInfo.size() > 0) {
            for(Cart cart : cartInfo) {
                cartService.delete(cart.getId());
            }
            return true;
        }
        return false;
    }

}
