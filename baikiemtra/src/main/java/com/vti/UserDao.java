package com.vti;

import java.util.List;

public class UserDao {
    private List<User> users;

    public UserDao(List<User> users) {
        this.users = users;
    }

    public void printUserDetails() {
        for (User user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Full Name: " + user.getFullName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password: " + user.getPassword());
            
            if (user instanceof Manager) {
                Manager manager = (Manager) user;
                System.out.println("Experience in Year: " + manager.getExpInYear());
                System.out.println("Project ID: " + manager.getProjectId());
            } else if (user instanceof Employee) {
                Employee employee = (Employee) user;
                System.out.println("Project ID: " + employee.getProjectId());
                System.out.println("Professional Skill: " + employee.getProSkill());
            }
        }
    }

    public void printEmployeesByProjectId(int projectId) {
        System.out.println("Employees in Project ID: " + projectId);
        for (User user : users) {
            if (user instanceof Employee) {
                Employee employee = (Employee) user;
                if (employee.getProjectId() == projectId) {
                    System.out.println("ID: " + employee.getId());
                    System.out.println("Full Name: " + employee.getFullName());
                    System.out.println("Email: " + employee.getEmail());
                    System.out.println("Pro Skill: " + employee.getProSkill());
                }
            }
        }
    }

    public void printManagers() {
        for (User user : users) {
            if (user instanceof Manager) {
                Manager manager = (Manager) user;
                System.out.println("ID: " + manager.getId());
                System.out.println("Full Name: " + manager.getFullName());
                System.out.println("Email: " + manager.getEmail());
                System.out.println("Experience in Year: " + manager.getExpInYear());
                System.out.println("Project ID: " + manager.getProjectId());
            }
        }
    }

    public boolean login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
