package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mailorderstatuses database table.
 * 
 */
@Entity
@Table(name="mailorderstatuses")
@NamedQuery(name="Mailorderstatus.findAll", query="SELECT m FROM Mailorderstatus m")
public class Mailorderstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String mailOrderStatus;

	//bi-directional many-to-one association to Mailorder
	@OneToMany(mappedBy="mailorderstatus")
	private List<Mailorder> mailorders;

	public Mailorderstatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMailOrderStatus() {
		return this.mailOrderStatus;
	}

	public void setMailOrderStatus(String mailOrderStatus) {
		this.mailOrderStatus = mailOrderStatus;
	}

	public List<Mailorder> getMailorders() {
		return this.mailorders;
	}

	public void setMailorders(List<Mailorder> mailorders) {
		this.mailorders = mailorders;
	}

	public Mailorder addMailorder(Mailorder mailorder) {
		getMailorders().add(mailorder);
		mailorder.setMailorderstatus(this);

		return mailorder;
	}

	public Mailorder removeMailorder(Mailorder mailorder) {
		getMailorders().remove(mailorder);
		mailorder.setMailorderstatus(null);

		return mailorder;
	}

}