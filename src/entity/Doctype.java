package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DocTypes database table.
 * 
 */
@Entity
@Table(name="DocTypes")
@NamedQuery(name="DocType.findAll", query="SELECT d FROM DocType d")
public class DocType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="DocType")
	private String docType;

	@Column(name="DocTypeName")
	private String docTypeName;

	public DocType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocTypeName() {
		return this.docTypeName;
	}

	public void setDocTypeName(String docTypeName) {
		this.docTypeName = docTypeName;
	}

}