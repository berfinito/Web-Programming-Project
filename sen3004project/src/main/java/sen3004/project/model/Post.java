package sen3004.project.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min=3, max=50)
	@Column(name="title")
	private String title;

	@NotNull
	@Size(min=3, max=50)
	@Column(name="msg")
	private String msg;

	@NotNull
	@DateTimeFormat(pattern="dd.MM.yyyy")
	@Column(name="cd")
	private LocalDate cd;

	@NotNull
	@Column(name = "nol")
	private int numberOfLikes;


	@Column(name = "tags")
	private String tags; //it can be null

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDate getCd() {
		return cd;
	}

	public void setCd(LocalDate cd) {
		this.cd = cd;
	}

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
