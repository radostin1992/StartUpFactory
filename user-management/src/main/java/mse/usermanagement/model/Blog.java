package mse.usermanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Model containing blogs data.
 * 
 * @author Radostin Ivanov
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Blog.getBlogs", query = "from Blog order by id desc"),
		@NamedQuery(name = "Blog.delete", query = "delete Blog where id=:id"),
		@NamedQuery(name = "Blog.count", query = "select count(b.id) from Blog b"),
		@NamedQuery(name = "Blog.getBlogByTitle", query = "from Blog where title=:title") })
@Table(indexes = { @Index(columnList = "title") })
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String author;

	private String title;

	private Date date;

	private Date lastModified;

	@Column(columnDefinition = "TEXT")
	private String content;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
