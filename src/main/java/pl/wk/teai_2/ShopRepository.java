package pl.wk.teai_2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import pl.wk.teai_2.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopRepository {

    private List<Product> products;

    @EventListener( ApplicationReadyEvent.class)
    public void init5Products() {
        products = new ArrayList<>();
        addProduct("product 1", randomPrice());
        addProduct("product 2", randomPrice());
        addProduct("product 3", randomPrice());
        addProduct("product 4", randomPrice());
        addProduct("product 5", randomPrice());
    }

    public List<Product> addProduct(String name, BigDecimal price) {
        System.out.println( String.format("adding " + name + " " + price.toPlainString()));
        products.add( new Product( name, price));
        return products;
    }

    public static BigDecimal randomPrice(double min, double max) {
        double range = max - min;
        double price = min + (Math.random() * range);
        return BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);      // // zaokrąglenie ceny do *.??
    }

    public static BigDecimal randomPrice() {
        return randomPrice(50.0, 300.0);
    }

    public List<Product> getProducts() {
        return products;
    }
}
