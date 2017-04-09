package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mailorder database table.
 * 
 */
@Entity
@NamedQuery(name="Mailorder.findAll", query="SELECT m FROM Mailorder m")
public class Mailorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="mailorder")
	private List<Document> documents;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="mailOrdEndReceiverNo")
	private Employee employee1;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="mailOrdSenderNo")
	private Employee employee2;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="mailOrdReceiverNo")
	private Employee employee3;

	//bi-directional many-to-one association to Mailorderstatus
	@ManyToOne
	@JoinColumn(name="mailOrdStatus")
	private Mailorderstatus mailorderstatus;

	public Mailorder() {
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
		document.setMailorder(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setMailorder(null);

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

	public Mailorderstatus getMailorderstatus() {
		return this.mailorderstatus;
	}

	public void setMailorderstatus(Mailorderstatus mailorderstatus) {
		this.mailorderstatus = mailorderstatus;
	}

}