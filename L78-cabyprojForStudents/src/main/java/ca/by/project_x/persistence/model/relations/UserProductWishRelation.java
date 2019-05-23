package ca.by.project_x.persistence.model.relations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import ca.by.project_x.persistence.model.catalog.Product;
import ca.by.project_x.persistence.model.users.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
CREATE TABLE user_product_wish_relation (
	id bigserial NOT NULL,
	user_id bigint,
	product_id bigint,
	PRIMARY KEY(id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (product_id) REFERENCES products(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="user_product_wish_relation")
public class UserProductWishRelation  implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @EmbeddedId
    private UserProductWishRelationId id;
	
	@ManyToOne
	@MapsId("userId")
	private User user;
	
	@ManyToOne
	@MapsId("productId")
	private Product product;
}

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode
@Embeddable
class UserProductWishRelationId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
    private Long userId;
 
    @Column(name = "product_id")
    private Long productId;
    
}









