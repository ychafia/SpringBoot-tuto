package fr.youness.MSAProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.ArrayList;

@SpringBootApplication
//@EnableConfigurationProperties
//@EnableAutoConfiguration
//@EnableDiscoveryClient
public class MsaProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MsaProjectApplication.class, args);
	}
}