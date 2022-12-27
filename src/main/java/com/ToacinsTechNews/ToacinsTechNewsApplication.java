package com.ToacinsTechNews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

import static com.ToacinsTechNews.Actor.helloWorld;

@SpringBootApplication
public class ToacinsTechNewsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ToacinsTechNewsApplication.class, args);

//		Actor ArianaGrande = new Actor();
//		ArianaGrande.firstName = "Ariana";
//		ArianaGrande.lastName = "Grande";
//		ArianaGrande.getName();
//		helloWorld();
		HelloWorld toacin = new HelloWorld("Toacin", 33, "Cooper");
		HelloWorld princessDiana = new HelloWorld("Toacin", 33, "Cooper");

		System.out.println(princessDiana);
		System.out.println(toacin.getName());
		System.out.println(toacin == princessDiana);
	}

}