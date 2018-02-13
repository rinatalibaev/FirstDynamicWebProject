package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Psswrds database table.
 * 
 */
@Entity
@Table(name="Psswrd")
@NamedQuery(name="Psswrd.findAll", query="SELECT p FROM Psswrd p")
public class Psswrd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int employee;

	private String login;

	private String psw;

	public Psswrd() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee() {
		return this.employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPsw() {
		return this.psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}