package com.concretepage.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="college_bag")
public class College implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public College(){
		
	}
	
	
/*	@Id
	@Column(name="college_id")
	@GeneratedValue(strategy=GenerationType.AUTO)*/
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(
		name="course_seq",
		sequenceName="course_sequence",
		allocationSize=20
	)
    private int collegeId;	
	
	@Column(name="name")
	private String collegeName;
	
	@ElementCollection(targetClass=Student.class)
	@CollectionTable(name="student_bag", joinColumns=@JoinColumn(name="college_id"))
	private Collection<Student> students = new ArrayList<Student>();
	 
	public College(String collegeName){
		this.collegeName=collegeName;
	}
	
	

	public Collection<Student> getStudents() {
		return students;
	}



	public void setStudents(Collection<Student> students) {
		this.students = students;
	}



	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}