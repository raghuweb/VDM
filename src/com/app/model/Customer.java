package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer7")
public class Customer {
	@Id
	@Column(name="c_id")
	private int custId;
	@Column(name="c_name")
	private String custName;
	@Column(name="c_email")
	private String custEmail;
	@Column(name="c_type")
	private String custType;
	@Column(name="c_addr")
	private String custAddr;
	@Column(name="c_pwd")
	private String custPwd;
	@Column(name="c_tock")
	private String custAccTock;
	
	//code generated
	
	public Customer() {
	}
	public Customer(int custId) {
		this.custId = custId;
	}
	public Customer(int custId, String custName, String custEmail,
			String custType, String custAddr, String custPwd, String custAccTock) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custType = custType;
		this.custAddr = custAddr;
		this.custPwd = custPwd;
		this.custAccTock = custAccTock;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getCustPwd() {
		return custPwd;
	}
	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}
	public String getCustAccTock() {
		return custAccTock;
	}
	public void setCustAccTock(String custAccTock) {
		this.custAccTock = custAccTock;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custType=" + custType
				+ ", custAddr=" + custAddr + ", custPwd=" + custPwd
				+ ", custAccTock=" + custAccTock + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((custAccTock == null) ? 0 : custAccTock.hashCode());
		result = prime * result
				+ ((custAddr == null) ? 0 : custAddr.hashCode());
		result = prime * result
				+ ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + custId;
		result = prime * result
				+ ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custPwd == null) ? 0 : custPwd.hashCode());
		result = prime * result
				+ ((custType == null) ? 0 : custType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (custAccTock == null) {
			if (other.custAccTock != null)
				return false;
		} else if (!custAccTock.equals(other.custAccTock))
			return false;
		if (custAddr == null) {
			if (other.custAddr != null)
				return false;
		} else if (!custAddr.equals(other.custAddr))
			return false;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custId != other.custId)
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custPwd == null) {
			if (other.custPwd != null)
				return false;
		} else if (!custPwd.equals(other.custPwd))
			return false;
		if (custType == null) {
			if (other.custType != null)
				return false;
		} else if (!custType.equals(other.custType))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
}
