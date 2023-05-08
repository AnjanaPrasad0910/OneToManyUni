package entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	//we should not use cascade type delete here
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH	
	})
	@JoinColumn(name ="teacher_id")
	private Teacher teacher;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@JoinColumn(name ="course_id")
	private List<Review> reviews;
	
	public Course() {
		
	}
	
	public Course(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

		//Add this in Course.java
		public void addReview(Review tempReview) {
			if(reviews ==null) {
				reviews  = new ArrayList<>();
			}
			reviews.add(tempReview);
			
		}

	
	

}
