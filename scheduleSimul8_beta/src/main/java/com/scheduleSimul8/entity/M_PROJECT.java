package com.scheduleSimul8.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "m_project")
public class M_PROJECT {

	@Id
	@Column(name = "project_id")
	private String projectId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "insert_date")
	private String insertDate;

	@Column(name = "update_date")
	private String updateDate;
}
