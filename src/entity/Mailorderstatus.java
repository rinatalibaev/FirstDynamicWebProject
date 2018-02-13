package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the MailOrderStatuses database table.
 * 
 */
@Entity
@Table(name = "MailOrderStatuses")
@NamedQuery(name = "MailOrderStatus.findAll", query = "SELECT m FROM MailOrderStatus m")
public class MailOrderStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "MailOrderStatus")
	private String mailOrderStatus;

	// //bi-directional many-to-one association to MailOrder
	// @OneToMany(mappedBy="mailOrderStatus")
	// private List<MailOrder> mailOrders;

	public MailOrderStatus() {
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

	// public List<MailOrder> getMailOrders() {
	// return this.mailOrders;
	// }
	//
	// public void setMailOrders(List<MailOrder> mailOrders) {
	// this.mailOrders = mailOrders;
	// }

	// public MailOrder addMailOrder(MailOrder mailOrder) {
	// getMailOrders().add(mailOrder);
	// mailOrder.setMailOrderStatus(this);
	// return mailOrder;
	// }
	//
	// public MailOrder removeMailOrder(MailOrder mailOrder) {
	// getMailOrders().remove(mailOrder);
	// mailOrder.setMailOrderStatus(null);
	// return mailOrder;
	// }

}