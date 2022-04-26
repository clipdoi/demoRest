package com.demorest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role", schema = "public")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "account_role", schema = "public", joinColumns = {
			@JoinColumn(name = "roleid", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "accid", nullable = false, updatable = false) })
	private Set<Account> accounts;

}