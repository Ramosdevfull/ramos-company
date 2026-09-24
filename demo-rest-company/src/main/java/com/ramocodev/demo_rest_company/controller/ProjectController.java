package com.ramocodev.demo_rest_company.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramocodev.demo_rest_company.model.Project;

/**
 * ProjectController
 */
@RestController
public class ProjectController {

    private static final String templateName = "Project name: %s";
    private static final String templateDescription = "Project descrition: %s";
    private static final String templateOwner = "Project owner: %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/project")
    public Project project(@RequestParam(value = "nameProj", defaultValue = "Nome do Projeto") String nameProj, @RequestParam(value = "descProj", defaultValue = "Descricao do Projeto") String descProj, @RequestParam(value = "ownerProj", defaultValue = "Responsavel pelo Projeto") String ownerProj) {

        return new Project(counter.incrementAndGet(), String.format(templateName, nameProj), String.format(templateDescription, descProj), String.format(templateOwner, ownerProj));

    }

    
}