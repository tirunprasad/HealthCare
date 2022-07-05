package com.kenrigtechservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="spec_tab")
public class Specialization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="spec_id_col ")
	private Integer id;
	@Column(name="spec_code_col ")
	private String specCode;
	@Column(name="spec_name_col ")
	private String specName;
	@Column(name="spec_note_col ")
	private String specNote;

}
