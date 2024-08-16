package org.example.dao.repository.Interface;

import org.example.dao.model.Teacher;

import java.util.List;

public interface TeacherInterface {
    public void addNewTeacher(Teacher teacher);
    public void deleteTeacher(int id);
    public void updateTeacher(int id,Teacher teacher);
    public Teacher getTeacher(int id);
    public List<Teacher> getTeachers();
    public List<Teacher> getTeachersByName(String teacherName);
}
