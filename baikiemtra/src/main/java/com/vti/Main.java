package com.vti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo dữ liệu cho Employee và Manager
        List<User> users = new ArrayList<>();

        // Tạo các Manager
        Manager manager1 = new Manager(1, "Nguyen Van A", "nguyenvana@vti.com.vn", "password123", 5, 101);
        Manager manager2 = new Manager(2, "Tran Thi B", "tranthib@vti.com.vn", "password456", 3, 102);

        // Tạo các Employee
        Employee employee1 = new Employee(3, "Le Van C", "levanc@vti.com.vn", "password789", 101, "Java");
        Employee employee2 = new Employee(4, "Pham Thi D", "phamthid@vti.com.vn", "password012", 102, "SQL");
        Employee employee3 = new Employee(5, "Hoang Van E", "hoangvane@vti.com.vn", "password345", 101, "Testing");

        // Thêm các User vào danh sách
        users.add(manager1);
        users.add(manager2);
        users.add(employee1);
        users.add(employee2);
        users.add(employee3);

        // Tạo đối tượng UserDao để quản lý danh sách User
        UserDao userDao = new UserDao(users);

        Scanner scanner = new Scanner(System.in);

        // Chức năng tìm kiếm Employee theo Project ID
        System.out.print("Nhap ID du an de tim kiem cac Employee: ");
        int projectId = scanner.nextInt();
        userDao.printEmployeesByProjectId(projectId);

        // Chức năng lấy danh sách các Manager
        System.out.println("\nDanh sach cac Manager:");
        userDao.printManagers();

        // Chức năng đăng nhập
        System.out.print("\nNhap Email de dang nhap: ");
        scanner.nextLine(); // Clear the newline
        String email = scanner.nextLine();
        System.out.print("Nhap Password: ");
        String password = scanner.nextLine();

        boolean isLoggedIn = userDao.login(email, password);
        if (isLoggedIn) {
            System.out.println("Dang nhap thanh cong!");
        } else {
            System.out.println("Dang nhap that bai! Email hoac Password khong dung.");
        }

        scanner.close();
    }
}
