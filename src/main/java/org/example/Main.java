package org.example;

import org.example.dao.model.Teacher;
import org.example.dao.repository.Implement.TeacherImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TeacherImpl obyektini yaratmaq
        TeacherImpl teacherImpl = new TeacherImpl();

        // Yeni müəllim əlavə etmək
        Teacher newTeacher = new Teacher();
        newTeacher.setTeacherName("Mahammad");
        newTeacher.setTeacherSurname("Niyazli");
        newTeacher.setTeacherBirthdate(LocalDate.of(1996, 6, 1));
        newTeacher.setActive(true);
        teacherImpl.addNewTeacher(newTeacher);
        System.out.println("Yeni müəllim əlavə edildi.");

        // Müəllimi ID ilə gətirmək
        Teacher fetchedTeacher = teacherImpl.getTeacher(1);
        System.out.println("Seçilən müəllim: " + fetchedTeacher.getTeacherName() + " " + fetchedTeacher.getTeacherSurname());

        // Müəllimi yeniləmək
        fetchedTeacher.setTeacherName("Gulshan");
        fetchedTeacher.setTeacherSurname("Sattarova");
        teacherImpl.updateTeacher(1, fetchedTeacher);
        System.out.println("Müəllim yeniləndi.");

        // Bütün müəllimləri gətirmək
        List<Teacher> allTeachers = teacherImpl.getTeachers();
        System.out.println("Bütün müəllimlər:");
        for (Teacher teacher : allTeachers) {
            System.out.println(teacher.getTeacherName() + " " + teacher.getTeacherSurname());
        }

        // Müəllimi adı ilə axtarmaq
        List<Teacher> teachersByName = teacherImpl.getTeachersByName("Gulshan");
        System.out.println("Axtarış nəticəsi:");
        for (Teacher teacher : teachersByName) {
            System.out.println(teacher.getTeacherName() + " " + teacher.getTeacherSurname());
        }

        // Müəllimi silmək
        teacherImpl.deleteTeacher(1);
        System.out.println("Müəllim silindi.");
    }
}