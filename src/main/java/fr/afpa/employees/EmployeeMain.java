package fr.afpa.employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain {
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

		// TODO instanciez 4 objets de la classe "Employee" (une fois celle-ci
		// implémentée)
		Employee employee1 = new Employee("11ABC22", "Paul", "Thomas", 1400.0, "1999-09-17");
		Employee employee2 = new Employee("11ABC23", "Toto", "Thomas", 1900.0, "2002-01-23");
		Employee employee3 = new Employee("11ABC24", "Tata", "Thomas", 2100.0, "2002-06-23");
		Employee employee4 = new Employee("11ABC25", "Ben", "Thomas", 1700.0, "2005-01-23");

		// Appel de la fonction à partir de l'objet employee1
		
		System.out.println("\n------Employe1------");
		System.out.println(employee1);
		System.out.println(employee1.toString());
		System.out.println(employee1.netSalary());
		System.out.println("Nombre de jours restant avant la date d'anniversaire: " + employee1.daysBeforeBirthDate());
		
		System.out.println("\n------Employe2------");
		System.out.println(employee2);
		System.out.println(employee2.toString());
		System.out.println(employee2.netSalary());
		System.out.println("Nombre de jours restant avant la date d'anniversaire: " + employee2.daysBeforeBirthDate());
		
		System.out.println("\n------Employe3------");
		System.out.println(employee3);
		System.out.println(employee3.toString());
		System.out.println(employee3.netSalary());
		System.out.println("Nombre de jours restant avant la date d'anniversaire: " + employee3.daysBeforeBirthDate());
		
		System.out.println("\n------Employe4------");
		System.out.println(employee4);
		System.out.println(employee4.toString());
		System.out.println(employee4.netSalary());
		System.out.println("Nombre de jours restant avant la date d'anniversaire: " + employee4.daysBeforeBirthDate());
		// TODO afficher les informations des employés avec System.out.println
	}
}
