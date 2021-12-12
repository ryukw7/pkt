import org.gradle.api.artifacts.dsl.DependencyHandler

object deps {

    val classpaths = listOf(
        "com.android.tools.build:gradle:${ver.android_tools_build_gradle}",
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${ver.kotlin}"
    )

    // std lib
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${ver.kotlin}"

    // test
    private const val junit = "junit:junit:${ver.junit}"
    private const val kotlintest = "io.kotlintest:kotlintest-assertions:${ver.kotlintest}"

    object pkt : DepsInterface {
        override val impls = listOf(
            kotlinStdLib,
        )

        override val kapts = emptyList<String>()

        override val testImpls = listOf(
            junit,
            kotlintest
        )
    }

    interface DepsInterface {
        val impls: List<Any>
        val kapts: List<Any>
        val testImpls: List<Any>
    }
}

fun DependencyHandler.set(dep: deps.DepsInterface) {
    implementations(dep.impls)
    kapts(dep.kapts)
    testImplementations(dep.testImpls)
}

fun DependencyHandler.kapts(list: List<Any>) = dep("kapt", list)
fun DependencyHandler.implementations(list: List<Any>) = dep("implementation", list)
fun DependencyHandler.testImplementations(list: List<Any>) = dep("testImplementation", list)
fun DependencyHandler.androidTestImplementations(list: List<Any>) = dep("androidTestImplementation", list)
fun DependencyHandler.dep(type: String, list: List<Any>) {
    list.forEach {
        if (it is List<*>) {
            dep(type, it as List<Any>)
        } else {
            add(type, it)
        }
    }
}
