import org.gradle.api.artifacts.dsl.DependencyHandler

object LibDependencies {

    val classpaths = listOf(
        "com.android.tools.build:gradle:${ver.android_tools_build_gradle}",
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${ver.kotlin}"
    )

    // @formatter:off ------------------------------------------------------------------------- //
    // std lib
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${ver.kotlin}"

    // test
    private const val junit        = "junit:junit:${ver.junit}"
    private const val kotlintest   = "io.kotlintest:kotlintest-assertions:${ver.kotlintest}"
    // @formatter:on    ----------------------------------------------------------------------- //

    val mainDeps = listOf(
        kotlinStdLib,
    )

    val testDeps = listOf(
        junit,
        kotlintest
    )
}

// util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach {
        add("kapt", it)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach {
        add("androidTestImplementation", it)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach {
        add("testImplementation", it)
    }
}
