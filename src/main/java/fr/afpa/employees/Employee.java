package fr.afpa.employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
Objectif :
L’objectif de ce TP est de concevoir un programme en console basé sur une approche objet et
permettant de gérer (vraiment très basiquement) des salariés d’une entreprise.

Vous allez écrire une classe représentant les salariés d'une entreprise.
Vous pourrez vous aider du PDF disponible sur pour obtenir des informations sur la façon de faire.
*/

class Employee {
	// TODO compléter les attributs comme présenté dans le PDF
	/**
	 * Matricule de l'employé
	 */
	private String registrationNumber;
	private String lastName;
	private String firstName;
	private double salary;
	private final int socialRate = 30;
	private LocalDate birthDate;

	// TODO compléter le constructeur de la classe
	public Employee(String registrationNumber, String lastName, String firstName, double salary, String birthDate) {
		checkRegistrationNumber(registrationNumber);
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.birthDate = LocalDate.parse(birthDate);
	}

	// TODO implémenter les setters et getters de la classe (permet d'accéder aux
	// attributs privés)

	// Récuperation des attributs
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public double getSalary() {
		return salary;
	}

	public int getSocialRate() {
		return socialRate;
	}

	public LocalDate getbirthDate() {
		return birthDate;
	}

	// Modification des attributs
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSalary(double salary) {
		this.salary = salary;

	}

	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate);
	}
	// TODO ajouter les getters et les setters

	// TODO implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	// qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" ->
	// https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring

	// Fonction pour obtenir le nom complet
	public String toString() {
		return "Employee {"
				+ "\nNom: " + getFirstName()
				+ "\nPrenom: " + getLastName()
				+ "\nSalaire: " + getSalary()
				+ "\nDate de naissance: " + getbirthDate()
				+ "\nSalaire net: " + netSalary()
				+ "}";
	}

	// Fonction pour calculer le salaire net
	public double netSalary() {
		return this.salary - (this.salary * this.socialRate) / 100.0;

	}

	// Fonction pour calculer le nombre de jours restant avant la date
	// d'anniversaire
	public Long daysBeforeBirthDate() {

		//Pour obtenir la date actuelle
		LocalDate currentDate = LocalDate.now();

		//Pour obtenir la date d'anniversaire de l'année en cours
		LocalDate nextBirthDate = birthDate.withYear(currentDate.getYear());

		//Boucle si la date de l'anniversaire est dejà passé, prendre celle de l'année prochaine
		if (nextBirthDate.isBefore(currentDate) || nextBirthDate.isEqual(currentDate)){
		 	nextBirthDate = nextBirthDate.plusYears(1);
		}
	
		return ChronoUnit.DAYS.between(currentDate, nextBirthDate);

	}

	//Fonction pour verifier si le matricule est correct ou incorrect
	private boolean checkRegistrationNumber(String stringToCheck){
		if (stringToCheck == null || stringToCheck.length() !=7){
			return false;
		}

		//Vérifier que les deux premiers et les deux derniers caractères sont des chiffres
		for (int i = 0; i < stringToCheck.length(); i++){
			if (i == 0 || i == 1 || i == 5 || i == 6){
				if (!Character.isDigit(stringToCheck.charAt(i))){
					return false;
				}
			}
		}

		//Vérifier que les caractères sont des lettres 
		for (int i = 2; i <= 4; i++){
			if (!Character.isLetter(stringToCheck.charAt(i))){
				return false;
			}

		}
		return true;

	}

		

}


