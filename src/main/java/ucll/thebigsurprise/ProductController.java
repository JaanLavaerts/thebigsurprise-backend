package ucll.thebigsurprise;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.oauth2.jwt.Jwt;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin( origins = "http://localhost:8080", allowCredentials = "true")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/check")
    public boolean greeting(@RequestParam(value = "name", defaultValue = "World") String name,
                            @AuthenticationPrincipal Jwt accessToken) {
        System.out.println("In GET Request");
        String scope = accessToken.getClaims().get("scope").toString();
        Boolean partnerRole = scope.contains("partner");
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
        if (partnerRole) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public String addProduct(@RequestBody Product product, @AuthenticationPrincipal Jwt accessToken) {
        System.out.println("In POST Request");
        String scope = accessToken.getClaims().get("scope").toString();
        Boolean partnerRole = scope.contains("partner");

        if (partnerRole) {
            System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
            System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
            repository.save(product);
            return "Product added";
        } else {
            return "Not Authorized to add product";
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public String deleteProduct(@PathVariable("id") long id, @AuthenticationPrincipal Jwt accessToken){
        String scope = accessToken.getClaims().get("scope").toString();
        boolean partnerRole = scope.contains("partner");

        if(partnerRole){
            repository.deleteById(id);
        }
        return "product deleted";
    }
}