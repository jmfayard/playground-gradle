package dev.jmfayard.gradle_playground;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GradlePlaygroundApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void iAmNotSureThisTestIsActuallyCorrect() {
		// https://scans.gradle.com/s/qcqxjg2ivo572/tests/overview
		assertThat(2 + 2).isCloseTo(5, Percentage.withPercentage(10));
	}
}
