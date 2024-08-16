package org.example.dao.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    private int id;
    private String teacherName;
    private String teacherSurname;
    private Date teacherBirthdate;
    private boolean isActive;
}
