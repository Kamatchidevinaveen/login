package com.someco.helloworld.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;


	@Entity
	//@Table(name="User")
	@Table(name = "COMPANY")
	public class Company implements Serializable {

		private static final long serialVersionUID = 7389856880644171123L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		@NotEmpty
		@Column(name = "companyname", nullable = false)
		private String companyName;
		
		@Column(name = "employeecount")
		private int employeeCount;
		 
		 @NotEmpty
		 @OneToMany(fetch = FetchType.EAGER)
		    @JoinTable(name="COMPANY_USER", joinColumns={@JoinColumn(name="COMPANY_ID")}
		    , inverseJoinColumns={@JoinColumn(name="USER_ID")})
		private Set<User> userDetails = new HashSet<User>();

		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		
		public Integer getEmployeeCount() {
			return employeeCount;
		}

		public void setEmployeeCount(Integer employeeCount) {
			this.employeeCount = employeeCount;
		}
		
		public Set<User> getUser() {
			return userDetails;
		}

		public void setUser(Set<User> userDetails) {
			this.userDetails = userDetails;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Company))
				return false;
			Company other = (Company) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (companyName == null) {
				if (other.companyName != null)
					return false;
			} else if (!companyName.equals(other.companyName))
				return false;
			return true;
		}
        

	    @Override
	    public String toString() {
	        return "Company [id=" + id + ", companyName=" + companyName + ", EmployeeCount=" + employeeCount +"]";
	    }


}
