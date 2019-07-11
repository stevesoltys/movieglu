plugins {
    java
}

group = "com.stevesoltys"
version = "0.1.0"

repositories {
    mavenCentral()
}

val retrofitVersion = "2.4.0"
val lombokVersion = "1.16.16"
val junitVersion = "5.5.0"

dependencies {
    implementation("com.squareup.retrofit2", "retrofit", retrofitVersion)
    implementation("com.squareup.retrofit2", "converter-jackson", retrofitVersion)

    testImplementation("org.junit.jupiter", "junit-jupiter", junitVersion)

    compileOnly("org.projectlombok", "lombok", lombokVersion)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<Test> {
    useJUnitPlatform()
}