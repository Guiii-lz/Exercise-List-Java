package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("How many employees will be registered?");
		int n = sc.nextInt();
		List<Employee> list = new ArrayList<>(); //inicializa a list referente a classe employee

		for(int i=0;i<n;i++) {
			System.out.println("Emplyoee #"+i+":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) { //verifica se o ID já existe
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary)); //Salva o ID, NOME e SALÁRIO no set da classe
		
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); //filtra o ID para verificar se existe
		if (emp == null) {//verifica se o retorno é nulo, se for não existe
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);//faz a conta da incrementação do salário
		}
		System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : list) {//LISTA todos os employess
			System.out.println(obj);
		}
				
		
		sc.close();







	}

		public static boolean hasId(List<Employee> list, int id) {
			Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); //lista o ID para verificar se possui 
		return emp != null;
		}
}
