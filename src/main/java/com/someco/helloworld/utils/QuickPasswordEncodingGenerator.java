package com.someco.helloworld.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.someco.helloworld.model.UserProfileType;

public class QuickPasswordEncodingGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String password = "naveen";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(password));
		System.out.println(
				passwordEncoder.matches("naveen", "$2a$10$dxjcwGKrfmooakvIvT1p2e6x4vqZbP5DQJB1OX/3oZNq.ngITfFAe"));
		System.out.println(UserProfileType.ADMIN.getUserProfileType());
	}

}
