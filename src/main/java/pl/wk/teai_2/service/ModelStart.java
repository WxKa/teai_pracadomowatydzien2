package pl.wk.teai_2.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.wk.teai_2.ShopRepository;
import pl.wk.teai_2.controller.Response;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Service
@Profile("start")
public class ModelStart extends Response {

    public ModelStart( ShopRepository repository ) {
        super(repository);
    }

    @PostConstruct
    public void start( ) {
        System.out.println("Profile start");
    }

    @Override
    public BigDecimal printSum( StringBuilder stringBuilder ) {
        BigDecimal sum = sumOfPrice();
        printLine( stringBuilder, "Razem:", sum );
        return sum;
    }

}


