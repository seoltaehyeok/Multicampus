package study.db.jdbc;

import java.sql.Timestamp;

public class EmpVO {
	private int empCode;
	private String deptCode;
	private String empName;
	private int empAge;
	private Timestamp empHiredate;
	private int empSalary;

	public EmpVO(int empCode,  String empName, int empAge, Timestamp empHiredate, int empSalary, String deptCode) {
		this.empCode = empCode;
		this.deptCode = deptCode;
		this.empName = empName;
		this.empAge = empAge;
		this.empHiredate = empHiredate;
		this.empSalary = empSalary;
	}

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public Timestamp getEmpHiredate() {
		return empHiredate;
	}

	public void setEmpHiredate(Timestamp empHiredate) {
		this.empHiredate = empHiredate;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	@Override
	public String toString() {
		return "EmpVO [empCode=" + empCode + ", empName=" + empName + ", empAge=" + empAge + ", empHiredate="
				+ empHiredate + ", empSalary=" + empSalary + ", deptCode=" + deptCode + "]";
	}
	
}
