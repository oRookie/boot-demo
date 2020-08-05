package com.study.springboot.es.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "megacorp",type = "employee")
@Data
public class Employee {
    @Id
    private String id;
    @Field
    @JsonProperty("first_name")
    private String firstName;
    @Field
    @JsonProperty("last_name")
    private String lastName;
    @Field
    private Integer age = 0;
    @Field
    private String about;
}
