package br.com.entra21.casca.casca;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.entra21.model.Pessoa;

@SpringBootApplication
public class CascaApplication implements CommandLineRunner{
	public static ArrayList<Pessoa> pessoas=new ArrayList();
	
	public static void main(String[] args) {
		SpringApplication.run(CascaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		pessoas.add(new Pessoa("Pessoa1",33));
		pessoas.add(new Pessoa("Pessoa2",33));
		pessoas.add(new Pessoa("Pessoa3",33));
		pessoas.add(new Pessoa("Pessoa4",33));
		pessoas.add(new Pessoa("Pessoa5",33));
		
	}
	
	

}
