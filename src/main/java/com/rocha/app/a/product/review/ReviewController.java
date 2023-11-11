package com.rocha.app.a.product.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.a.product.dto.ReviewDto;
import com.rocha.app.a.product.entity.jpa.course.Course;
import com.rocha.app.a.product.entity.jpa.course.Review;
import com.rocha.app.a.product.repository.jpa.course.CourseRepositoryJpa;
import com.rocha.app.a.product.repository.jpa.review.ReviewRepositoryJpa;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewRepositoryJpa reviewRepositoy;

	@Autowired
	private CourseRepositoryJpa courseRepository;

	@PostMapping("/{id}")
	public ReviewDto registerReview(@PathVariable Long id, @RequestBody Review rewview) {

		Course course = courseRepository.findById(id).get();
		rewview.setCourse(course);
		rewview = reviewRepositoy.save(rewview);
		return mapper(id, rewview);
	}

	private ReviewDto mapper(Long courseId, Review rewview) {

		ReviewDto reviewDto = new ReviewDto();

		reviewDto.setDescription(rewview.getDescription());
		reviewDto.setId(rewview.getId());
		reviewDto.setRating(rewview.getRating());
		reviewDto.setCourseId(courseId);

		return reviewDto;

	}

}
