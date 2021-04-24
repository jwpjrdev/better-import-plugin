package com.github.jwpjrdev.betterimportplugin.services

import com.github.jwpjrdev.betterimportplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
