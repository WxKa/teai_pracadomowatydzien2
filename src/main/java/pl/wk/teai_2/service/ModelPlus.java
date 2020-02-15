package pl.wk.teai_2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.wk.teai_2.ShopRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Profile("plus")
public class ModelPlus extends ModelStart {

    @Value("${price.tax}")
    private double tax;

    public ModelPlus( ShopRepository repository ) {
        super(repository);
    }

    @PostConstruct
    public void plus() {
        System.out.println(String.format("Profile plus( VAT=%2.2f%% )", tax));
    }

    @Override
    public BigDecimal printSum( StringBuilder stringBuilder ) {
        BigDecimal total = super.printSum( stringBuilder );
        total = total.multiply( BigDecimal.valueOf( 1 + tax/100 ));
        total = total.setScale(2, RoundingMode.HALF_UP);
        printLine( stringBuilder, "Razem z VAT:", total);
        return total;
    }
}
