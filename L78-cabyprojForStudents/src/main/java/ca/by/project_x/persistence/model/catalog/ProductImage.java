package ca.by.project_x.persistence.model.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE catalog_product_images (
    id bigserial NOT NULL,
    product_id bigint NOT NULL,
    image_link varchar(512) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="catalog_product_images")
public class ProductImage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="product_id", referencedColumnName="id", nullable=false, updatable = false)
	private Product product;
	
	@Column(name="image_link", nullable=false)
	private String imageLink;
	
}
