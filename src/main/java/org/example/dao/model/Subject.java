package org.example.dao.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subject {
    private int id;
    private String subjectName;
    private boolean isActive;
}
