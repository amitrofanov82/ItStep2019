package ca.by.project_x.persistence.model.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE subscription_list (
	id bigserial NOT NULL,
	user_id bigint,
	email varchar(128),
	FOREIGN KEY (user_id) REFERENCES users(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="subscription_list")
public class SubscriptionList  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true)
	private Long id;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)
	private User userId;
	
	@Column(name="email", length=128)
	private String email;
	
}
