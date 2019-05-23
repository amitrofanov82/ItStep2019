package ca.by.project_x.persistence.model.catalog;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import ca.by.project_x.persistence.model.users.Shop;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE catalog_products (
    id bigserial NOT NULL,
    name varchar(128) NOT NULL,
    description text,
    shop_id bigint NOT NULL,
    price int,

    PRIMARY KEY(id),
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="catalog_products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable=false, length=128)
	private String name;
	
	@Column(name="description")
	@Lob
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="shop_id", referencedColumnName = "id", nullable = false)
	private Shop shop;
	
	@ManyToMany(cascade = 
		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, 
			fetch = FetchType.EAGER)
	@Where(clause = "is_category = true")
    @JoinTable(name = "product_category_relation",  
    	joinColumns = { @JoinColumn(name = "product_id") }, 
    	inverseJoinColumns = { @JoinColumn(name = "label_id") })
	private List<Label> categories;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductImage> productImages;
	
	/** DB standard is Canadian cents: */
	@Column(name="price")
	private Integer price;

}
