package ca.by.project_x.persistence.model.users;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
CREATE TABLE shops (
    id bigserial NOT NULL,
    admin_id bigint NOT NULL,
    opening_date date,
    location text,
    template_id bigint,
    PRIMARY KEY(id),
    FOREIGN KEY (admin_id) REFERENCES users(id),
    FOREIGN KEY (template_id) REFERENCES shop_templates(id)
);

*/

@Getter @Setter @NoArgsConstructor @ToString
@EqualsAndHashCode(of={"id"})
@Entity
@Table(name="shops")
public class Shop implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false, updatable = false)
    private User ownerId;
	
	@Column(name="opening_date")
	private LocalDate openingDate;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	@Lob
	private String location;
	
	@OneToOne
    @JoinColumn(name = "template_id", referencedColumnName = "id", nullable = true, updatable = false)
	private ShopTemplate templateId;
	
}
