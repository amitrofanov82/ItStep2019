package ca.by.project_x.persistence.model.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE shop_templates (
	id bigserial NOT NULL,
	name varchar(64),
	html_template text,
	PRIMARY KEY(id)
);
*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="shop_templates")
public class ShopTemplate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable=false, length=64)
	private String name;

	@Column(name="html_template")
	@Lob
	private String htmlTemplate;
	
	
}
