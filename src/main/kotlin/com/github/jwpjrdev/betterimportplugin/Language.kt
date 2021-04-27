package com.github.jwpjrdev.betterimportplugin

import com.intellij.psi.PsiFile
import lombok.Getter

@Getter
enum class Language(vararg extensions: String) {

    // TODO: change to their respective collectors
    // Good 'ol JVM
    JAVA("java") {
        override fun getImports(file: PsiFile): List<String> {
            return listOf("")
        }
    },
    KOTLIN("kt", "gradle.kts") {
        override fun getImports(file: PsiFile): List<String> {
            return listOf("")
        }
    },
    SCALA("scala") {
        override fun getImports(file: PsiFile): List<String> {
            return listOf("")
        }
    },
    GROOVY("groovy", "gradle") {
        override fun getImports(file: PsiFile): List<String> {
            return listOf("")
        }
    },
    CLOJURE("clj") {
        override fun getImports(file: PsiFile): List<String> {
            return listOf("")
        }
    },
    // Non-JVM mess
    PHP("php") {
        override fun getImports(file: PsiFile): List<String> {
            return listOf("")
        }
    },
    JAVASCRIPT("js") {
        override fun getImports(file: PsiFile): List<String> {
            return listOf("")
        }
    },
    TYPESCRIPT("ts") {
        override fun getImports(file: PsiFile): List<String> {
            return listOf("")
        }
    };

    private val extensions: List<String> = listOf(*extensions)

    abstract fun getImports(file: PsiFile): List<String>

    companion object {
        @JvmStatic
        fun getLanguageByExtension(extension: String): Language? {
            for (language in values()) {
                if (language.extensions.contains(extension.toLowerCase())) {
                    return language
                }
            }

            return null
        }
    }
}