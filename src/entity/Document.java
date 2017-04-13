package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the Documents database table.
 * 
 */
@Entity
@Table(name = "Documents")
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String docDate;

	private String docInsertedDate;

	private String docName;

	private String docServerPath;

	// bi-directional many-to-one association to DocStatus
	@ManyToOne
	@JoinColumn(name = "DocStatusName")
	private DocStatus docStatus;

	// bi-directional many-to-one association to DocType
	@ManyToOne
	@JoinColumn(name = "docType")
	private DocType docTypeBean;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "docInsertedEmployee")
	private Employee employee1;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "docEndReceiverEmployee")
	private Employee employee2;

	// bi-directional many-to-one association to MailOrder
	@ManyToOne
	@JoinColumn(name = "mailOrdDocuments")
	private MailOrder mailOrder;

	public Document() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocDate() {
		return this.docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public String getDocInsertedDate() {
		return this.docInsertedDate;
	}

	public void setDocInsertedDate(String docInsertedDate) {
		this.docInsertedDate = docInsertedDate;
	}

	public String getDocName() {
		return this.docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocServerPath() {
		return this.docServerPath;
	}

	public void setDocServerPath(String docServerPath) {
		this.docServerPath = docServerPath;
	}

	public DocStatus getDocStatus() {
		return this.docStatus;
	}

	public void setDocStatus(DocStatus docStatus) {
		this.docStatus = docStatus;
	}

	public DocType getDocTypeBean() {
		return this.docTypeBean;
	}

	public void setDocTypeBean(DocType docTypeBean) {
		this.docTypeBean = docTypeBean;
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

	public MailOrder getMailOrder() {
		return this.mailOrder;
	}

	public void setMailOrder(MailOrder mailOrder) {
		this.mailOrder = mailOrder;
	}

}