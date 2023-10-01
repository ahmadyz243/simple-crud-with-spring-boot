package com.yazdi.practicetwo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticeTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeTwoApplication.class, args);
	}

}
