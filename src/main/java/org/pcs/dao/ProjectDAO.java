package org.pcs.dao;

import org.pcs.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectDAO {
    private static int PEOPLE_COUNT;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Project> index() {
        return jdbcTemplate.query("SELECT * FROM project", new BeanPropertyRowMapper<>(Project.class));
    }

    public Project show(int id) {
        return jdbcTemplate.query("SELECT * FROM project WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Project.class))
                .stream().findAny().orElse(null);
    }

    public void save(Project project) {
        jdbcTemplate.update("INSERT INTO project (name, start_date, end_date, status_id, currensy_id, business_entity_id, project_manager_id) VALUES (?, ?, ?, ?, ?, ?, ?)", project.getId(),
                project.getName(), project.getStart_date(), project.getEnd_date(), project.getProgram_manager_id(),
                project.getBusiness_entity_id(), project.getCurrency_id(), project.getStatus_id());
    }

    public void update(int id, Project updatedProject) {
        jdbcTemplate.update("UPDATE project SET id =?, name=?, start_date=?, end_date=?, status_id=?, currensy_id=?, business_entity_id=?, project_manager_id=? WHERE id=?", updatedProject.getName(),
                updatedProject.getId(), updatedProject.getName(), updatedProject.getStart_date(), updatedProject.getEnd_date(),
                updatedProject.getProgram_manager_id(), updatedProject.getBusiness_entity_id(), updatedProject.getCurrency_id(), updatedProject.getStatus_id());
        }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM project WHERE id=?", id);
    }
}
