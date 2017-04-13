package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the MailOrder database table.
 * 
 */
@Entity
@NamedQuery(name = "MailOrder.findAll", query = "SELECT m FROM MailOrder m")
public class MailOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date mailOrdCreateDate;

	private String mailOrdDocuments;

	@Temporal(TemporalType.TIMESTAMP)
	private Date mailOrdReceivedDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date mailOrdSentDate;

	@Temporal(TemporalType.DATE)
	private Date mailOrdToSendDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date mailOrdVizovKurieraDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date mailVizovKurieraDate;

	// bi-directional many-to-one association to Document
	@OneToMany(mappedBy = "mailOrder")
	private List<Document> documents;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "mailOrdEndReceiverNo")
	private Employee employee1;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "mailOrdSenderNo")
	private Employee employee2;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "mailOrdReceiverNo")
	private Employee employee3;

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

	public Date getMailOrdCreateDate() {
		return this.mailOrdCreateDate;
	}

	public void setMailOrdCreateDate(Date mailOrdCreateDate) {
		this.mailOrdCreateDate = mailOrdCreateDate;
	}

	public String getMailOrdDocuments() {
		return this.mailOrdDocuments;
	}

	public void setMailOrdDocuments(String mailOrdDocuments) {
		this.mailOrdDocuments = mailOrdDocuments;
	}

	public Date getMailOrdReceivedDate() {
		return this.mailOrdReceivedDate;
	}

	public void setMailOrdReceivedDate(Date mailOrdReceivedDate) {
		this.mailOrdReceivedDate = mailOrdReceivedDate;
	}

	public Date getMailOrdSentDate() {
		return this.mailOrdSentDate;
	}

	public void setMailOrdSentDate(Date mailOrdSentDate) {
		this.mailOrdSentDate = mailOrdSentDate;
	}

	public Date getMailOrdToSendDate() {
		return this.mailOrdToSendDate;
	}

	public void setMailOrdToSendDate(Date mailOrdToSendDate) {
		this.mailOrdToSendDate = mailOrdToSendDate;
	}

	public Date getMailOrdVizovKurieraDate() {
		return this.mailOrdVizovKurieraDate;
	}

	public void setMailOrdVizovKurieraDate(Date mailOrdVizovKurieraDate) {
		this.mailOrdVizovKurieraDate = mailOrdVizovKurieraDate;
	}

	public Date getMailVizovKurieraDate() {
		return this.mailVizovKurieraDate;
	}

	public void setMailVizovKurieraDate(Date mailVizovKurieraDate) {
		this.mailVizovKurieraDate = mailVizovKurieraDate;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		return document;
	}

	public Employee getEmployee1() {
		return this.employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public Employee getEmployee2() {
		return this.employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

	public Employee getEmployee3() {
		return this.employee3;
	}

	public void setEmployee3(Employee employee3) {
		this.employee3 = employee3;
	}

	public MailOrderStatus getMailOrderStatus() {
		return this.mailOrderStatus;
	}

	public void setMailOrderStatus(MailOrderStatus mailOrderStatus) {
		this.mailOrderStatus = mailOrderStatus;
	}

}