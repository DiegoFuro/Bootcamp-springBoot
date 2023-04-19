package com.bootcamp.springboot;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(name="name")
	private String name;

	@Column(name="birth_date")
	private LocalDate birth_date;

	public User() {

	}

	public User(String name, LocalDate birth_date) {
		this.name = name;
		this.birth_date = birth_date;
	}

	public User(long id, String name, LocalDate birth_date) {
		this.Id = id;
		this.name = name;
		this.birth_date = birth_date;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}
}
