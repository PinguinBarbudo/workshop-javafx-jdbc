package model.entities;

import java.io.Serializable;

public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	
	public Department() {}
	public Department(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	/*
	 * End of constructors
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/*
	 * End of getters and setters
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}//end of hashCode
	
	public boolean equals(Object obj) {
		if (this == obj) {return true;}
		if (obj == null) {return false;}
		if (getClass() != obj.getClass()) {return false;}
		Department other = (Department) obj;
		if(id == null) {
			if(other.id != null) {return false;}
		}else{
			return false;
		}//end of external if/else
		return true;
	}//end of equals
	@Override
	public String toString() {
		return "Department\nid = " + id + "\nname = " + name;
	}//end of toString
	
}//end of class