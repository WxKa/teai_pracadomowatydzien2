package pl.wk.teai_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Teai2Application {

	public static void main(String[] args) {
		SpringApplication.run(Teai2Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void start() {
		System.out.println("ApplicationReady");
	}
}
