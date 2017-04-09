package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the docstatuses database table.
 * 
 */
@Entity
@Table(name="docstatuses")
@NamedQuery(name="Docstatus.findAll", query="SELECT d FROM Docstatus d")
public class Docstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String docStatusName;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="docstatus")
	private List<Document> documents;

	public Docstatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocStatusName() {
		return this.docStatusName;
	}

	public void setDocStatusName(String docStatusName) {
		this.docStatusName = docStatusName;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setDocstatus(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setDocstatus(null);

		return document;
	}

}