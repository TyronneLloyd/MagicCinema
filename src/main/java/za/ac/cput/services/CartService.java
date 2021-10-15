package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.rentalcart.Cart;
import za.ac.cput.repository.cart.CartRepository;
import za.ac.cput.services.cart.ICartService;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService {
    private CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }
    @Override
    public Cart create(Cart cart) {
        return this.repository.save(cart);
    }

    @Override
    public Cart read(Integer cardId) {
        return this.repository.findById(cardId).orElseThrow(() -> new EntityNotFoundException("Cart with id " + cardId + " was not found" ));
    }

    @Override
    public Cart update(Cart cart) {
        if(this.repository.existsById(cart.getId()))
            return this.repository.save(cart);
        return null;
    }

    @Override
    public boolean delete(Integer cartId) {
        this.repository.deleteById(cartId);
        if(this.repository.existsById(cartId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Cart> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Cart> getCartFromCustomerId(String customerId) {
        Set<Cart> allCartItems = getAll();
        Set<Cart> output = new HashSet<>();

        for(Cart cart: allCartItems) {
            if(cart.getCustomerId().equals(customerId)) {
                output.add(cart);
            }
        }

        return output;
    }
}
