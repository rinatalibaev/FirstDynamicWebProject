package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DocStatuses database table.
 * 
 */
@Entity
@Table(name="DocStatuses")
@NamedQuery(name="DocStatus.findAll", query="SELECT d FROM DocStatus d")
public class DocStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="DocStatusName")
	private String docStatusName;

	public DocStatus() {
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

}