package com.rajeev.aws_docker_ecs_fargate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private int id;
    private String name;
    private double price;
}