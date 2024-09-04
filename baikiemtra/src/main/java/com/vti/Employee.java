package com.vti;

public class Employee extends User {
    private int projectId;
    private String proSkill;

    public Employee(int id, String fullName, String email, String password, int projectId, String proSkill) {
        super(id, fullName, email, password);
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProSkill() {
        return proSkill;
    }
}
