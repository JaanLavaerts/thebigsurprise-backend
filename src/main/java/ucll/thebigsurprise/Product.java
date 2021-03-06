package ucll.thebigsurprise;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank(message = "title.missing")
    private String title;

    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String thumbnail_url;

    @Min(value = 0, message = "quantity.cannot.be.lower.than.0")
    @NotNull(message = "quantity.missing")
    private int quantity;

    @DecimalMin(value = "0.00", message = "price.cannot.be.lower.than.0")
    @Digits(integer = 4, fraction = 2)
    @NotNull(message = "price.missing")
    private float price;

    public Product() {

    }

    public Product(long id, String title, String description, String thumbnail_url, int quantity, float price) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnail_url = thumbnail_url;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}