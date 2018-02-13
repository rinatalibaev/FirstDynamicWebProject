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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the Documents database table.
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONE)
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
	private DocType docType;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "docInsertedEmployee")
	private Employee docInsertedEmployee;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "docEndReceiverEmployee")
	private Employee docEndReceiverEmployee;

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
		return this.docType;
	}

	public void setDocTypeBean(DocType docTypeBean) {
		this.docType = docTypeBean;
	}

	public Employee getEmployee1() {
		return this.docInsertedEmployee;
	}

	public void setEmployee1(Employee employee1) {
		this.docInsertedEmployee = employee1;
	}

	public Employee getEmployee2() {
		return this.docEndReceiverEmployee;
	}

	public void setEmployee2(Employee employee2) {
		this.docEndReceiverEmployee = employee2;
	}

	public MailOrder getMailOrder() {
		return this.mailOrder;
	}

	public void setMailOrder(MailOrder mailOrder) {
		this.mailOrder = mailOrder;
	}

}