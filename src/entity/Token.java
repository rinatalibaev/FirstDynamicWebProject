package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import converters.ConverterLocalDateTime;

/**
 * The persistent class for the tokens database table.
 * 
 */
@Entity
@Table(name = "tokens")
@NamedQuery(name = "Token.findAll", query = "SELECT t FROM Token t")
public class Token implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date loginTime;

	private String token;

	// bi-directional one-to-one association to User
	@OneToOne(mappedBy = "token")
	private User user;

	public Token() {
		ConverterLocalDateTime converter = new ConverterLocalDateTime();
		loginTime = converter.convertToDatabaseColumn(LocalDateTime.now());
		token = Double.toString(Math.random());
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}