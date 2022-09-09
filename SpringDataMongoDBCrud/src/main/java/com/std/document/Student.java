package com.std.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	private String stdId;
	private String name;
	private String stream;
	private Double fees;
	private Double marks;
}
