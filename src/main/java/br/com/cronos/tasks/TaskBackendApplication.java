package br.com.cronos.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TaskBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TaskBackendApplication.class, args);
		System.out.println("Tasks in running");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TaskBackendApplication.class);
	}
}
