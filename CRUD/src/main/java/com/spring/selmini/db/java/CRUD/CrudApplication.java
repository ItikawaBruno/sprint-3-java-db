package com.spring.selmini.db.java.CRUD;

import com.spring.selmini.db.java.CRUD.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	private final Menu menu;

	@Autowired
	public CrudApplication(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		menu.menu();
	}
}
