package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the MailOrder database table.
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONE)
@Table(name = "MailOrder")
@NamedQuery(name = "MailOrder.findAll", query = "SELECT m FROM MailOrder m")
public class MailOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime mailOrdCreateDate;

	private String mailOrdDocuments;

	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime mailOrdReceivedDate;

	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime mailOrdSentDate;

	// @Temporal(TemporalType.DATE)
	private LocalDate mailOrdToSendDate;

	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime mailOrdVizovKurieraDate;

	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime mailVizovKurieraDate;

	// // bi-directional many-to-one association to Document
	// @OneToMany(mappedBy = "mailOrder")
	// private List<Document> documents;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "mailOrdEndReceiverNo")
	private Employee employee1;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "mailOrdSenderNo")
	private Employee mailOrderSender;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "mailOrdReceiverNo")
	private Employee mailOrderReceiver;

	// bi-directional many-to-one association to MailOrderStatus
	@ManyToOne
	@JoinColumn(name = "mailOrdStatus")
	private MailOrderStatus mailOrderStatus;

	public MailOrder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getMailOrdCreateDate() {
		return this.mailOrdCreateDate;
	}

	public void setMailOrdCreateDate(LocalDateTime mailOrdCreateDate) {
		this.mailOrdCreateDate = mailOrdCreateDate;
	}

	public String getMailOrdDocuments() {
		return this.mailOrdDocuments;
	}

	public void setMailOrdDocuments(String mailOrdDocuments) {
		this.mailOrdDocuments = mailOrdDocuments;
	}

	public LocalDateTime getMailOrdReceivedDate() {
		return this.mailOrdReceivedDate;
	}

	public void setMailOrdReceivedDate(LocalDateTime mailOrdReceivedDate) {
		this.mailOrdReceivedDate = mailOrdReceivedDate;
	}

	public LocalDateTime getMailOrdSentDate() {
		return this.mailOrdSentDate;
	}

	public void setMailOrdSentDate(LocalDateTime mailOrdSentDate) {
		this.mailOrdSentDate = mailOrdSentDate;
	}

	public LocalDate getMailOrdToSendDate() {
		return this.mailOrdToSendDate;
	}

	public void setMailOrdToSendDate(LocalDate mailOrdToSendDate) {
		this.mailOrdToSendDate = mailOrdToSendDate;
	}

	public LocalDateTime getMailOrdVizovKurieraDate() {
		return this.mailOrdVizovKurieraDate;
	}

	public void setMailOrdVizovKurieraDate(LocalDateTime mailOrdVizovKurieraDate) {
		this.mailOrdVizovKurieraDate = mailOrdVizovKurieraDate;
	}

	public LocalDateTime getMailVizovKurieraDate() {
		return this.mailVizovKurieraDate;
	}

	public void setMailVizovKurieraDate(LocalDateTime mailVizovKurieraDate) {
		this.mailVizovKurieraDate = mailVizovKurieraDate;
	}

	// public List<Document> getDocuments() {
	// return this.documents;
	// }
	//
	// public void setDocuments(List<Document> documents) {
	// this.documents = documents;
	// }

	// public Document addDocument(Document document) {
	// getDocuments().add(document);
	// return document;
	// }
	//
	// public Document removeDocument(Document document) {
	// getDocuments().remove(document);
	// return document;
	// }

	public Employee getEmployee1() {
		return this.employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public Employee getEmployee2() {
		return this.mailOrderSender;
	}

	public void setEmployee2(Employee employee2) {
		this.mailOrderSender = employee2;
	}

	public Employee getEmployee3() {
		return this.mailOrderReceiver;
	}

	public void setEmployee3(Employee employee3) {
		this.mailOrderReceiver = employee3;
	}

	public MailOrderStatus getMailOrderStatus() {
		return this.mailOrderStatus;
	}

	public void setMailOrderStatus(MailOrderStatus mailOrderStatus) {
		this.mailOrderStatus = mailOrderStatus;
	}

}