package dev.dhanush.EcomProductService.Controller;

import dev.dhanush.EcomProductService.Client.FakeStoreClient;
import dev.dhanush.EcomProductService.DTO.fakeStoreDTOs.FakeStoreCartResponseDTO;
import dev.dhanush.EcomProductService.Exception.CartNotFoundException;
import dev.dhanush.EcomProductService.Exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  Cart controller was only created to showcase the use of controller advice, in this code we are not doing
 *  anything related to cart.
 */

@RestController
public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDTO> cartResponse = fakeStoreClient.getCartByUserId(userId);
        if(cartResponse == null){
            throw new CartNotFoundException("Cart not found for userID " + userId);
        }
        return ResponseEntity.ok(cartResponse);
    }

    @GetMapping("/cartexception")
    public ResponseEntity getCartException(){
        throw new RandomException("Exception from cart");
    }
}