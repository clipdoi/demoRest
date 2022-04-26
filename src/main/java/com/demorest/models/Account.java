package com.demorest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account", schema = "public")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "username", nullable = false, length = 60)
	private String username;

	@Column(name = "password", nullable = false, length = 250)
	private String password;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "email", nullable = false, length = 70)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 13)
	private Date created;

	@Column(name = "status", nullable = false)
	private boolean status;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "account_role", schema = "public", joinColumns = {
			@JoinColumn(name = "accid", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "roleid", nullable = false, updatable = false) })
	private Set<Role> roles;
	
}
