
<!-- slide bg="#fff" -->
## Gradle pour les utilisateurs de Maven

---
<!-- slide bg="#fff" -->
## Who uses Gradle ?


note: Best and worst thing about Gradle ?

---
<!-- slide bg="#fff" -->
## Why Gradle?

---

## Why a build system ?

---

## Make everything


---
## Make it 1 step

![](https://i.imgur.com/F7wAvuU.png)


---
## Make it fast

---

## Make it open source
https://github.com/jmfayard/playground-gradle


---

## Make it interactive


---
<!-- slide bg="#fff" -->
## How to get started  ?
#livecoding

- Migrate Maven project
- Tip: Execute Gradle goal
- New project from IntelliJ
- New projet from start.spring.io
- Structure of a Gradle build

---

## 💣 Don't use Groovy

![](https://i.imgur.com/c88hFxi.png)

note:
application {  
mainClass.set("dev.jmfayard.Main")  
}

---
<!-- slide bg="#fff" -->
## Make it fast

---
## The costs of waiting

## https://gradle.com/roi-calculator/

---
## Make it faster then Maven

## https://gradle.org/gradle-vs-maven-performance/

---
## Make it faster then Maven
- Gradle daemon
- Classpath optimization
- Just say NO to `mvn clean`
- Incremental compilation
- Compilation avoidance
- Build cache
- Network cache

---

## 💣 Configuration Phase vs Execution Phase

![](https://i.imgur.com/Crpzxx9.png)

note:
```
tasks.create("someTask") {  
    Thread.sleep(5000)  
  
    doLast {  
       Thread.sleep(5000)  
    }  
}
```

---
<!-- slide bg="#fff" -->
## Live Demo

- Use the buildScan
- Incremental compilation
- Build cache
- Configuration cache

note:
initial
- gradle clean assemble --refresh-dependencies

configuration phase
- add `someTask` in `build.gradle`
- buildScan > Performance

build cache
- `gradle compileJava --build-cache`
- GradlePlaygroundApplication : add method
- compile
- remove method
- `gradle compileJava --build-cache`

configuration cache
- gradle assemble --configuration-cache-problems fail
- gradle assemble --configuration-cache
- `org.gradle.configuration-cache=true`



---

<!-- slide bg="#fff" -->
## Make everything

---

## [README-oriented programming](https://github.com/jmfayard/tb/tree/main)

| Gradle task              | What it does                                                 |
| ------------------ | --------------------------------------------- |
| `./gradlew doctor`       | makes a diagnostic of your setup                             |
| `./gradlew runUnitTests` | run the unit tests                                           |
| `./gradlew check`        | run all the tests and verification. Also count lines of code |
| `./gradlew bootRun`      | launch the server at http://localhost:8080                   |
| `./gradlew ciPulRequest` | run by GitHub Actions on a PR                                |
| `./gradlew ciMainBranch` | run by GitHub Actions on a main branch                       |
| `./gradlew ciRelease`    | run by GitHub Actions when a release is published            |
|                          |                                                              |


---

## Make custom tasks
#livecoding
- Define task `ciPullRequest`
- Define task dependency
- The test fail on the CI!

----
## Advanced tasks
- Define task `loc`
- Define tasks `doctor`
- Check environment variable `DATABASE_URL`
- Create task dependencies
- [[202411110934#Create custom task]]

---

## 💣 Configuration Phase vs Execution Phase
#livecoding
- use the Gradle build scan
- understand the issue
- fix the issue

---

## Make it clear why it fails

- failing test on the CI
- gradle buildScan to the rescue





