package com.ankit.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@SuppressWarnings({ "deprecation", "serial" })
@Data
@Entity
@Table(name = "employee_management")
@SQLDelete(sql="UPDATE employee_management SET STATUS='inactive' WHERE ID=?")
@Where(clause="STATUS<>'inactive'")
public class Employee  implements Serializable{
	@SequenceGenerator(name="gen1",sequenceName = "employee_idgenerater",initialValue = 100,allocationSize = 1)
	@Column(name = "id")
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	@Id
	private Integer id;
	@Column(name="name" ,length = 20)
	private String name;
	@Column(name="profile" ,length = 20)
	private String profile;
	@Column(name="salary")
	private Double salary;
	@Transient
	private String vflag="no";
	private String status="active";
	private String country;
	private String state;
}
