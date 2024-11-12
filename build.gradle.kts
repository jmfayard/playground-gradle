plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "dev.jmfayard"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("com.squareup.okhttp3:okhttp:4.11.0")

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("io.github.wimdeblauwe:htmx-spring-boot:3.5.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


tasks.withType<Test> {
	useJUnitPlatform()
}


tasks.register<Exec>("loc") {
	commandLine("/opt/homebrew/bin/loc")
}
tasks.named("check").configure {
	dependsOn("loc")
}
tasks.register<DefaultTask>("doctor") {
	doLast {
		val requiredEnvironmentVariables =  listOf("GITHUB_TOKEN")
		// listOf("GITHUB_TOKEN_XXX", "DATABASE_URL", "JAVASCRIPT_IS_GREAT")
		val requiredTools = mapOf(
			"loc" to "Install with $ brew install loc",
			// "brainfuck" to "See https://fr.wikipedia.org/wiki/Brainfuck",
		)

		gradleDoctorTask(requiredEnvironmentVariables, requiredTools)
	}
}








fun gradleDoctorTask(requiredEnvironmentVariables: List<String>, requiredTools: Map<String, String>) {
	println("Checking that the required environment variables are set")
	val values = requiredEnvironmentVariables.associateWith {
		System.getenv(it)
	}
	val missing = values.filter { it.value == null }.keys.toList()
	println(values.entries.joinToString("\n"))
	if (missing.isNotEmpty()) throw GradleException("Missing environment variables $missing")

	println("Checking that the required tools are installed")
	val paths = System.getenv("PATH").split(":").filterNotNull()
	val map = requiredTools.keys.filter { cmd ->
		val found = paths.firstOrNull { path ->
			File(path, cmd).canExecute()
		}
		found == null
	}
	val missingTools = map.joinToString(separator = "\n") { tool ->
		"MISSING TOOL $tool - ${requiredTools[tool]}"
	}
	if (map.isNotEmpty()) throw GradleException(missingTools)
}