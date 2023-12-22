package br.com.renato.quantovale;

import br.com.renato.quantovale.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuantovaleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(QuantovaleApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
