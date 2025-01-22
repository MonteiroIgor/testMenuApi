package com.igor.testMenuApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {
		"com.igor.testMenuApi.TestMenuApiApplication.*",
		"com.igor.testMenuApi.TestMenuApiApplicationTests.*"})
public class TestMenuApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
