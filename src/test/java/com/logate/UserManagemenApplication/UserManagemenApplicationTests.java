package com.logate.UserManagemenApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class UserManagemenApplicationTests {

	@Test
	void contextLoads() {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		String email="asd@SADas.com";
		Matcher matcher = pattern.matcher(email);
		System.out.println(matcher.matches());
		String email2 = "as#d@SAD#as.com";
		Matcher matcher2 = pattern.matcher(email2);
		System.out.println(matcher2.matches());
	}
}
