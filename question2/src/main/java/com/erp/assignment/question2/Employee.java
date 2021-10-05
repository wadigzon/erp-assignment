package com.erp.assignment.question2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope(value = "prototype")
public class Employee {
    private boolean managerFlag;
    private String name;
    private LocalDateTime dateHired;
    private Integer id;
    private boolean partTimeFlag;

    Employee() {
    }
    Employee (Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public boolean isPartTime() {
        return partTimeFlag;
    }
    public boolean isManager() {
        return managerFlag;
    }
    public String getName() {
        return name;
    }
    public LocalDateTime getDateHired() {
        return dateHired;
    }
    public Integer getID() {
        return id;
    }
    public void setManager(boolean managerFlag) {
        this.managerFlag = managerFlag;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateHired(LocalDateTime dateHired) {
        this.dateHired = dateHired;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setPartTime(boolean partTimeFlag) {
        this.partTimeFlag = partTimeFlag;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerFlag=" + managerFlag +
                ", dateHired=" + dateHired +
                ", partTimeFlag=" + partTimeFlag +
                '}';
    }
}
