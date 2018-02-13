package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String empCity;

	private String empEmail;

	private String empFathername;

	private String empFirstname;

	private String empHouse;

	private String empHousePart;

	private String empId;

	private String empOffice;

	private String empPhone;

	private String empPhoneAdditionalDigits;

	private String empPosition;

	private String empRegion;

	private String empStreet;

	private String empSurname;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="userID")
	private User user;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpCity() {
		return this.empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpFathername() {
		return this.empFathername;
	}

	public void setEmpFathername(String empFathername) {
		this.empFathername = empFathername;
	}

	public String getEmpFirstname() {
		return this.empFirstname;
	}

	public void setEmpFirstname(String empFirstname) {
		this.empFirstname = empFirstname;
	}

	public String getEmpHouse() {
		return this.empHouse;
	}

	public void setEmpHouse(String empHouse) {
		this.empHouse = empHouse;
	}

	public String getEmpHousePart() {
		return this.empHousePart;
	}

	public void setEmpHousePart(String empHousePart) {
		this.empHousePart = empHousePart;
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpOffice() {
		return this.empOffice;
	}

	public void setEmpOffice(String empOffice) {
		this.empOffice = empOffice;
	}

	public String getEmpPhone() {
		return this.empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpPhoneAdditionalDigits() {
		return this.empPhoneAdditionalDigits;
	}

	public void setEmpPhoneAdditionalDigits(String empPhoneAdditionalDigits) {
		this.empPhoneAdditionalDigits = empPhoneAdditionalDigits;
	}

	public String getEmpPosition() {
		return this.empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	public String getEmpRegion() {
		return this.empRegion;
	}

	public void setEmpRegion(String empRegion) {
		this.empRegion = empRegion;
	}

	public String getEmpStreet() {
		return this.empStreet;
	}

	public void setEmpStreet(String empStreet) {
		this.empStreet = empStreet;
	}

	public String getEmpSurname() {
		return this.empSurname;
	}

	public void setEmpSurname(String empSurname) {
		this.empSurname = empSurname;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}