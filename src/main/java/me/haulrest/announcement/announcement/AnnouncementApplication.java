package me.haulrest.announcement.announcement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = @Server(url = "/"))
@SpringBootApplication
public class AnnouncementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnouncementApplication.class, args);
	}
}
