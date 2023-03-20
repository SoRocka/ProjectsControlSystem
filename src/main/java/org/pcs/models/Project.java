package org.pcs.models;


import javax.validation.constraints.Size;
import java.util.Date;

public class Project {
    private int id;
    @Size(min=2, max = 42, message = "Name should be between 2 or 30 characters.")
    private String name;
    private Date start_date;
    private Date end_date;
    private int program_manager_id;
    private int currency_id;
    private int business_entity_id;
    private int status_id;
    public Project() {
    }

    public Project(int id, String name, Date start_date, Date end_date, int program_manager_id, int currency_id, int business_entity_id, int status_id) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.program_manager_id = program_manager_id;
        this.currency_id = currency_id;
        this.business_entity_id = business_entity_id;
        this.status_id = status_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getProgram_manager_id() {
        return program_manager_id;
    }

    public void setProgram_manager_id(int program_manager_id) {
        this.program_manager_id = program_manager_id;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public int getBusiness_entity_id() {
        return business_entity_id;
    }

    public void setBusiness_entity_id(int business_entity_id) {
        this.business_entity_id = business_entity_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}

