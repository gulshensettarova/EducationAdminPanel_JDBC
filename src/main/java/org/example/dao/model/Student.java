package org.example.dao.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String studentName;
    private String studentSurname;
    private LocalDate studentBirthdate;
    private int studentGroupId;
    private boolean isActive;
}
