package ca.by.project_x.persistence.model.relations;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import ca.by.project_x.persistence.model.users.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE user_user_follow_relation (
	id bigserial NOT NULL,
	follower_id bigint,
	followee_id bigint,
	PRIMARY KEY(id),
	FOREIGN KEY (follower_id) REFERENCES users(id),
	FOREIGN KEY (followee_id) REFERENCES users(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="user_user_follow_relation")
public class UserUserFollowRelation implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @EmbeddedId
    private UserUserFollowRelationId id;
	
	@ManyToOne
	@MapsId("followerId")
    private User follower;
	
	@ManyToOne
	@MapsId("followeeId")
    private User followee;
	
}


@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode
@Embeddable
class UserUserFollowRelationId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "follower_id")
    private Long followerId;
 
    @Column(name = "followee_id")
    private Long followeeId;
    
}


