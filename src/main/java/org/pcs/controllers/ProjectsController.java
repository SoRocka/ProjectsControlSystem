package org.pcs.controllers;

import org.pcs.dao.ProjectDAO;
import org.pcs.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/projects")
public class ProjectsController {

    private ProjectDAO projectDAO;

    @Autowired
    public ProjectsController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("project", projectDAO.index());
        return "projects/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("project", projectDAO.show(id));
        return "projects/show";
    }

    @GetMapping("/new")
    public String newProject(@ModelAttribute("project") Project project) {
        return "project/new";
    }

    @PostMapping
    public String create(@ModelAttribute("project") @Valid Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "projects/new";
        projectDAO.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("project", projectDAO.show(id));
        return "projects/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("project") @Valid Project project, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return  "projects/edit";

        projectDAO.update(id, project);
        return "redirect:/projects";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        projectDAO.delete(id);
        return "redirect:/projects";

    }
}
