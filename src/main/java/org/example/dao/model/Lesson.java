package org.example.dao.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lesson {
    private int id;
    private int studenGroupId;
    private int subjectId;
    private int teacherId;
    private boolean isActive;
}
