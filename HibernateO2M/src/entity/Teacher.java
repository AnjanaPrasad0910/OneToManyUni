
package entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="f_name")
	private String f_name;
	
	@Column(name="l_name")
	private String l_name;
	
	@Column(name="email")  
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_detail_id")
	private TeacherDetails teacherDetails;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	//helps in printing the value correctly
	@Override
	public String toString() {
		return "Teacher [id =" +id +", firstName =" +f_name + ", LastName =" +l_name+
				 ", email =" +email  +", teacherDetails =" +teacherDetails +"]";
	}
	
    public Teacher() {
		
	}

	public Teacher(String f_name, String l_name, String email) {
		
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
	}

	public TeacherDetails getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherDetails teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//Add this in Teacher.java
	public void add(Course tempCourse) {
		if(courses ==null) {
			courses = new ArrayList<>();
		}
		courses.add(tempCourse);
		tempCourse.setTeacher(this);
	}
	
	

}
