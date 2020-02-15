package pl.wk.teai_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.wk.teai_2.model.Product;
import pl.wk.teai_2.ShopRepository;

import java.math.BigDecimal;

public abstract class Response {

	private ShopRepository repository;

	@Autowired
	public Response( ShopRepository repository ) {
		this.repository = repository;
	}

	public BigDecimal sumOfPrice() {
		BigDecimal sum = BigDecimal.ZERO;
		for( Product product : repository.getProducts()) {
			sum = sum.add( product.getPrice() );     // sum += product.price
		}
		return sum;
	}

	public void printLine( StringBuilder stringBuilder, String title, BigDecimal amount ) {
		System.out.println( String.format("%-20s%12s", title, amount.toPlainString()));
		stringBuilder.append("<tr><td>" + title + "</td><td style='padding:0 0 0 5;text-align:right;'>" + amount.toPlainString() + "</td></tr>\n");
	}

	public void printProducts( StringBuilder stringBuilder ) {
		for( Product p : repository.getProducts() ) {
			printLine( stringBuilder, p.getName(), p.getPrice());
		}
		System.out.println();
		stringBuilder.append("<tr><td><hr></td><td><hr></td></tr>\n");
	}

	public abstract BigDecimal printSum( StringBuilder stringBuilder );

	public String getResponseHTML( StringBuilder stringBuilder )  {
		stringBuilder.setLength(0);
		stringBuilder.append("<table>");
		printProducts( stringBuilder );
		printSum( stringBuilder );
		stringBuilder.append("</table>\n");
		return stringBuilder.toString();
	}
}
