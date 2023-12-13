package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.printf("Inserted. New ID: %d\n", newDepartment.getId());
		
		System.out.println("\n=== TEST 4: department update ===");
		department = departmentDao.findById(4);
		department.setName("Movies");
		departmentDao.update(newDepartment);
		System.out.println("Update completed.");
		
		System.out.println("\n=== TEST 5: department deleteById ===");
		System.out.print("Enter ID for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed.");
		
		sc.close();
	}
}
