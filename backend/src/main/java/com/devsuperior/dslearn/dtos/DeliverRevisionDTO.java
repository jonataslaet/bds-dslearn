package com.devsuperior.dslearn.dtos;

import java.io.Serializable;

import com.devsuperior.dslearn.entities.enums.DeliverStatus;

public class DeliverRevisionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private DeliverStatus status;

	private String feedback;

	private Integer correctCount;

	public DeliverRevisionDTO() {

	}

	public DeliverRevisionDTO(Long id, DeliverStatus status, String feedback, Integer correctCount) {
		super();
		this.id = id;
		this.status = status;
		this.feedback = feedback;
		this.correctCount = correctCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DeliverStatus getStatus() {
		return status;
	}

	public void setStatus(DeliverStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(Integer correctCount) {
		this.correctCount = correctCount;
	}

}
