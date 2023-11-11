package com.rocha.app.a.product.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDto implements Serializable{
	private static final long serialVersionUID = 2303630736817614195L;
	private Long id;
	private String rating;
	private String description;
	private Long courseId;

}
