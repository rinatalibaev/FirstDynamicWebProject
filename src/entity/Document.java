package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documents database table.
 * 
 */
@Entity
@Table(name="documents")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String docDate;

	private String docInsertedDate;

	private String docName;

	private String docServerPath;

	//bi-directional many-to-one association to Docstatus
	@ManyToOne
	@JoinColumn(name="DocStatusName")
	private Docstatus docstatus;

	//bi-directional many-to-one association to Doctype
	@ManyToOne
	@JoinColumn(name="docType")
	private Doctype doctype;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="docInsertedEmployee")
	private Employee employee1;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="docEndReceiverEmployee")
	private Employee employee2;

	//bi-directional many-to-one association to Mailorder
	@ManyToOne
	@JoinColumn(name="mailOrdDocuments")
	private Mailorder mailorder;

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

	public Docstatus getDocstatus() {
		return this.docstatus;
	}

	public void setDocstatus(Docstatus docstatus) {
		this.docstatus = docstatus;
	}

	public Doctype getDoctype() {
		return this.doctype;
	}

	public void setDoctype(Doctype doctype) {
		this.doctype = doctype;
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

	public Mailorder getMailorder() {
		return this.mailorder;
	}

	public void setMailorder(Mailorder mailorder) {
		this.mailorder = mailorder;
	}

}