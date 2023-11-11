package com.rocha.app.a.product.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto implements Serializable{
	private static final long serialVersionUID = 2666526593807016777L;
	private Long id;
	private String name;
}