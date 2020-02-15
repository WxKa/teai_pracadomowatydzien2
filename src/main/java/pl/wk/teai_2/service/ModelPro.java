package pl.wk.teai_2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.wk.teai_2.ShopRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Profile("pro")
public class ModelPro extends ModelPlus {

    @Value("${price.discount}")
    private double discount;

    public ModelPro( ShopRepository repository ) {
        super(repository);
    }

    @PostConstruct
    public void pro() {
        System.out.println(String.format("Profile pro( rabat=%2.2f%% )", discount));
    }

    @Override
    public BigDecimal printSum( StringBuilder stringBuilder ) {
        BigDecimal total = super.printSum( stringBuilder );
        total = total.multiply( BigDecimal.valueOf(1 - discount/100 ));
        total = total.setScale(2, RoundingMode.HALF_UP);
        printLine( stringBuilder, "Razem po rabacie:", total);
        return total;
    }
}
