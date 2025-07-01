package com.foodorderbe.foodorderbe_artifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
public class FoodorderbeArtifactApplication {

	@Bean
	// com.cloudinary.utils.ObjectUtils;
	public Cloudinary cloudinary() {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dzq2us5zi",
				"api_key", "486442285494884",
				"api_secret", "Beyh7TAogM7IDGum5gmXM7f1ZKQ",
				"secure", true));
		return cloudinary;
	}

	public static void main(String[] args) {
		SpringApplication.run(FoodorderbeArtifactApplication.class, args);
	}

}
