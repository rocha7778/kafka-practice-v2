package com.rocha.app.a.product.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.a.product.dto.CoursesDto;
import com.rocha.app.a.product.dto.ReviewDto;
import com.rocha.app.a.product.entity.jpa.course.Course;
import com.rocha.app.a.product.entity.jpa.course.Review;
import com.rocha.app.a.product.repository.jpa.course.CourseRepositoryJpa;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseRepositoryJpa courseRepository;

	@PostMapping
	public Course createProduct(@RequestBody Course course) {
		return courseRepository.save(course);
	}

	@GetMapping
	public List<CoursesDto> findAll() {
		List<Course> courses = courseRepository.findAll();
		return mapperCourses(courses);
	}

	private List<CoursesDto> mapperCourses(List<Course> courses) {

		List<CoursesDto> coursesDto = courses.stream().map(
				c -> new CoursesDto(c.getId(), c.getName(),	c.getReviews().stream()
						.map(CourseController::mapperReview).toList()))
				        .toList();
		return coursesDto;

	}

	private static ReviewDto mapperReview(Review rew) {
		return new ReviewDto(rew.getId(), rew.getRating(), rew.getDescription(), rew.getCourse().getId());
	}

}
