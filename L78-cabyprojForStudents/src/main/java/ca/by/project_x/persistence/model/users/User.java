package ca.by.project_x.persistence.model.users;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE users (
    id bigserial NOT NULL,
    nickname varchar(64) NOT NULL,
    email varchar(128),
    phone varchar(16),
    registered timestamp,
    logged timestamp,
    password varchar(64),
    facebook_id varchar(64),
    google_id varchar(64),
    user_type varchar(32),
    PRIMARY KEY(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true)
	private Long id;
	
	@Column(name="nickname", nullable=false, unique=true, length=64)
	private String nickname;
	
	@Column(name="email", length=128)
	private String email;
	
	@Column(name="phone", length=32)
	private String phone;
	
	@Column(name="registered")
	private LocalDateTime registered;
	
	@Column(name="logged")
	private LocalDateTime logged;
	
	@Column(name="password", length=64)
	private String password;
	
	@Column(name="facebook_id", length=64)
	private String facebookId;

	@Column(name="google_id", length=64)
	private String googleId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="user_type", length=32)
	private UserType userType;
	
}
