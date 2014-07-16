package com.vini.mysite.core.ec;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Discussion")
public class Discussion extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private Long id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="category")
	private String category;
	
	@Column(name="description")
	private String description;
	
	@Column(name="tags", nullable=false)
	private String tags;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="question")
	private List<Reply> replies;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String pageTags) {
		this.tags = pageTags;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	public List<Reply> getReplies() {
		return replies;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	
	@Override
	public String toString() {
		return "Discussion [category=" + category + ", description="
				+ description + ", id=" + id + ", replies=" + replies
				+ ", tags=" + tags + ", title=" + title 
				+ ", "+ super.toString() + "]";
	}

}
