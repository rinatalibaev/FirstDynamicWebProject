package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the examp database table.
 * 
 */
@Entity
@NamedQuery(name="Examp.findAll", query="SELECT e FROM Examp e")
public class Examp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	public Examp() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}