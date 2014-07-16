package com.vini.mysite.core.ec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reply")
public class Reply extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="userId", nullable=false)
	private User user;
	
	@Column(name="text")
	private String text;
	
	@ManyToOne
    @JoinColumn(name="questionId", nullable=false)
    private Question question;
	
	public Reply() {
		super();
	}
		
	public Reply(User user, String text, Question question) {
		super();
		this.user = user;
		this.text = text;
		this.setPage(question);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setPage(Question question) {
		this.question = question;
	}
	public Question getPage() {
		return question;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", user=" + user + ", text=" + text
				+ ", question=" + question + ", toString()=" + super.toString() + "]";
	}

}
