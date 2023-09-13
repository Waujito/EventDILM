plugins {
    id("io.github.waujito.eventdilm.java-application-conventions")
}

dependencies {
    implementation(project(":core"))
}

application {
    // Define the main class for the application.
    mainClass.set("io.github.waujito.eventdilm.app.App")
}