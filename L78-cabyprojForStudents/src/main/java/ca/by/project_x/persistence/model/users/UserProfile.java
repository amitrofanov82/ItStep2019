package ca.by.project_x.persistence.model.users;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE user_profiles (
    user_id bigint NOT NULL,
    birthdate date,
    location varchar(512),
    avatar_link varchar(512),
    about text,
    twitter_id varchar(64),
    instagram_id varchar(64),
    PRIMARY KEY(user_id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"user"})
@Entity
@Table(name="user_profiles")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
	private User user;
	
	@Column(name="birthdate")
	private LocalDate birthdate;
	
	@Column(name="location")
	private String location;
	
	@Column(name="avatar_link")
	private String avatarLink;

	@Column(name="about")
	@Lob
	private String about;

	@Column(name="twitter_id", length=50)
	private String twitterId;
	
	@Column(name="instagram_id", length=50)
	private String instagramId;
	
}
