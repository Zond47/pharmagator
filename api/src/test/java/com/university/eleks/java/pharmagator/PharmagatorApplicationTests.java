package com.university.eleks.java.pharmagator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Qualifier("pharmagatorApplicationTests")
class PharmagatorApplicationTests {

	@Test
	void contextLoads() {
	}

}
