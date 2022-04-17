package com.revature.Track2gether;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.revature.Track2gether.utility.DataPopulateUtility;



@SpringBootApplication
@EnableTransactionManagement
public class Track2getherApplication {
	@Autowired
	private DataPopulateUtility util;
	private static  final Logger logger= LoggerFactory.getLogger(Track2getherApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Track2getherApplication.class, args);
	}
	@Bean
	@Profile("prod")
	public CommandLineRunner test() {
		return s -> {
			util.populateIntialData();
		};
	}
}