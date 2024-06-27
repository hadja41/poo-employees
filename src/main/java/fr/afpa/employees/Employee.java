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
	// les attributs comme présenté dans le PDF

	private String registrationNumber;
	private String lastName;
	private String firstName;
	private double salary;
	private final int socialRate = 30;
	private LocalDate birthDate;

	// compléter le constructeur de la classe
	public Employee(String registrationNumber, String lastName, String firstName, double salary, String birthDate) {
		checkRegistrationNumber(registrationNumber);
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.birthDate = LocalDate.parse(birthDate);
	}

	// implémenter les setters et getters de la classe (permet d'accéder aux
	// attributs privés)

	// ajouter les getters et les setters

	// Récuperation des attributs
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
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

	// Modification des attribut
	public void setRegistrationNumber(String registrationNumber) throws Exception {
		boolean isRegistrationNumber = checkRegistrationNumber(registrationNumber);
		if (isRegistrationNumber) {
			this.registrationNumber = registrationNumber;

		} else {
			throw new Exception(
					"Le matricule doit avoir le format suivant: nnXXXnn où n est un chiffre et X un caractère alphabétique (par exemple:11ABC22)");
		}

	}

	public void setLastName(String lastName) throws Exception {
		boolean isName = checkName(lastName);
		if (isName) {
			this.lastName = lastName;

		} else {
			throw new Exception("Le nom ne doit pas contenir des chiffres et des caractères spéciaux.");
		}

	}

	public void setFirstName(String firstName) throws Exception {
		boolean isName = checkName(firstName);
		if (isName) {
			this.firstName = firstName;
		} else {
			throw new Exception("Le prenom ne doit pas contenir des chiffres et des caractères spéciaux.");
		}

	}

	public void setSalary(double salary) {
		this.salary = salary;

	}

	public void setBirthDate(String birthDate) throws Exception {
		boolean isBirthdate = checkBirthdate(birthDate);

		if (isBirthdate) {
			this.birthDate = LocalDate.parse(birthDate);

		} else {

			throw new Exception("La date doit avoir le format: YYYY-MM-DD");
		}
	}

	// implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	// qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" ->
	// https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring

	// Fonction pour obtenir le nom complet
	public String toString() {
		return "\nEmployee {"
				+ "\n Matricule:" + getRegistrationNumber()
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

		// Pour obtenir la date actuelle
		LocalDate currentDate = LocalDate.now();

		// Pour obtenir la date d'anniversaire de l'année en cours
		LocalDate nextBirthDate = birthDate.withYear(currentDate.getYear());

		// Boucle si la date de l'anniversaire est dejà passé, prendre celle de l'année
		// prochaine
		if (nextBirthDate.isBefore(currentDate) || nextBirthDate.isEqual(currentDate)) {
			nextBirthDate = nextBirthDate.plusYears(1);
		}
		return ChronoUnit.DAYS.between(currentDate, nextBirthDate);

	}

	// Fonction pour verifier si le matricule est correct ou incorrect
	private boolean checkRegistrationNumber(String stringToCheck) {
		if (stringToCheck.length() != 7) {
			return false;
		}
		boolean isRegistrationNumber = false;

		// Vérifier que les deux premiers et les deux derniers caractères sont des
		// chiffres
		for (int i = 0; i < stringToCheck.length(); i++) {
			char ch = stringToCheck.charAt(i);
			if (i == 0 || i == 1 || i == 5 || i == 6) {
				if (Character.isDigit(ch)) {
					isRegistrationNumber = true;
				} else {
					return false;
				}

			} else {
				if (Character.isLetter(ch)) {
					isRegistrationNumber = true;

				} else {
					return false;
				}
			}
		}
		return isRegistrationNumber;
	}

	// Vérification du format du nom etdu prenom
	private boolean checkName(String inputToCheck) {
		boolean isName = false;
		for (int i = 0; i < inputToCheck.length(); i++) {
			char ch = inputToCheck.charAt(i);
			if (Character.isLetter(ch) || ch == '-') {
				isName = true;
			}
		}
		return isName;
	}

	// Vérification du format du birthdate
	private boolean checkBirthdate(String inputToCheck) {
		if (inputToCheck.length() != 10) {
			return false;
		}
		boolean isBirthdate = false;

		for (int i = 0; i < inputToCheck.length(); i++) {
			char ch = inputToCheck.charAt(i);
			if (i == 0 || i == 1 || i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 9){
				if (Character.isDigit(ch)){
					isBirthdate = true;

				} else {
					return false;
				}
			
			} else {
		    	if((i == 4 || i == 7) && ch == '-') {
			 		isBirthdate = true;

				} else {
					return false;
				}
			}

		}
		return isBirthdate;
	}

	
}

