package br.com.andrey.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_CAMBIO")
public class CambioEntity implements Serializable {
	private static final long serialVersionUID = -2386169227146766467L;
	
	@Id
    @Column(name = "CAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CAM_FROM", nullable = false)
	private String from;
	
	@Column(name = "CAM_TO", nullable = false)
	private String to;
	
	@Column(name = "CAM_CONVERSION", nullable = false)
	private BigDecimal conversionFactor;
	
	@Transient
	private BigDecimal convertedValue;
	
	@Transient
	private String environment;
	
	public CambioEntity() {}
	
	public CambioEntity(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.convertedValue = convertedValue;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public BigDecimal getConvertedValue() {
		return convertedValue;
	}
	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
}
