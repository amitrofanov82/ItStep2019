package ca.by.project_x.persistence.model.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE catalog_labels (
    id bigserial NOT NULL,
    parent_id bigint,
    name varchar(128) NOT NULL,
    is_category boolean DEFAULT false,
    description text,
    PRIMARY KEY(id)
    FOREIGN KEY(parent_id) REFERENCES catalog_labels(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="catalog_labels")
public class Label implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable=false, length=128)
	private String name;
	
	@Column(name="parent_id")
	private Long parentId;
	
	@Column(name="is_category")
	private Boolean isCategory;
	
	@Column(name="description")
	@Lob
	private String description;
	
	@Column(name="img_url", length=128)
	private String imgUrl;
	
	//@OneToMany(fetch = FetchType.LAZY)
	//private Product[] products;

}
