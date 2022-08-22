package br.com.andrey.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_BOOK")
public class BookEntity implements Serializable {

	private static final long serialVersionUID = -1178398469507976351L;

	@Id
    @Column(name = "BOO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "BOO_AUTHOR")
	private String author;
	
	@Column(name = "BOO_LAUNCHDATE")
	private Date launchDate;
	
	@Column(name = "BOO_PRICE")
	private BigDecimal price;
	
	@Column(name = "BOO_TITLE")
	private String title;
	
	@Transient
	private String currency;
	
	@Transient
	private String environment;
	
	public BookEntity() {}
	
	public BookEntity(Long id, String author, Date launchDate, BigDecimal price,
			String title, String currency, String environment) {
		super();
		this.id = id;
		this.author = author;
		this.launchDate = launchDate;
		this.price = price;
		this.title = title;
		this.currency = currency;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
}
