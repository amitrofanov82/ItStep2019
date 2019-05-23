package ca.by.project_x.persistence.model.relations;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import ca.by.project_x.persistence.model.users.Shop;
import ca.by.project_x.persistence.model.users.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE user_shop_management_relation (
	id bigserial NOT NULL,
	user_id bigint NOT NULL,
	shop_id bigint NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (shop_id) REFERENCES shops(id)
);
*/

@Getter @Setter @NoArgsConstructor  @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="user_shop_management_relation")
public class UserShopManagementRelation implements Serializable {

	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserShopManagementRelationId id;
	
	@ManyToOne
	@MapsId("userId")
	private User user;
	
	@ManyToOne
	@MapsId("shopId")
	private Shop shop;

}

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode
@Embeddable
class UserShopManagementRelationId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
    private Long userId;
 
    @Column(name = "shop_id")
    private Long shopId;
    
}

