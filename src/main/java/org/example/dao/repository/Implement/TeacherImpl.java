package org.example.dao.repository.Implement;

import org.example.config.PostgresConfig;
import org.example.dao.model.Teacher;
import org.example.dao.repository.Interface.TeacherInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherImpl implements TeacherInterface {
    @Override
    public void addNewTeacher(Teacher teacher) {
        String sql = "insert into teacher values(?,?,?,?)";
        try(Connection conn= PostgresConfig.getConnection()){
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,teacher.getTeacherName());
        ps.setString(2,teacher.getTeacherSurname());
        ps.setDate(3, Date.valueOf(teacher.getTeacherBirthdate()));
        ps.setBoolean(4,teacher.isActive());
        ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacher(int id) {
        String sql="delete from teacher where id=?";
        try(Connection conn= PostgresConfig.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateTeacher(int id,Teacher teacher) {
        String sql="update teacher set teacherName=?,teacherSurname=?,teacherBirthDate=? where id=?";
        try(Connection conn= PostgresConfig.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,teacher.getTeacherName());
            ps.setString(2,teacher.getTeacherSurname());
            ps.setDate(3, Date.valueOf(teacher.getTeacherBirthdate()));
            ps.setInt(4,id);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Teacher getTeacher(int id) {
        String sql="select * from teacher where id=?";
        Teacher teacher=new Teacher();

        try(Connection conn= PostgresConfig.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    teacher.setId(rs.getInt("id"));
                    teacher.setTeacherName(rs.getString("teacherName"));
                    teacher.setTeacherSurname(rs.getString("teacherSurname"));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return teacher;
    }

    @Override
    public List<Teacher> getTeachers() {
        String sql="select * from teacher";
        List<Teacher> teachers=new ArrayList<>();
        try(Connection conn= PostgresConfig.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()){
                    Teacher teacher=new Teacher();
                    teacher.setId(rs.getInt("id"));
                    teacher.setTeacherName(rs.getString("teacherName"));
                    teacher.setTeacherSurname(rs.getString("teacherSurname"));
                    teachers.add(teacher);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return teachers;
    }

    @Override
    public List<Teacher> getTeachersByName(String teacherName) {
        String sql="select * from teacher where teacherName=?";
        List<Teacher> teachers=new ArrayList<>();
        try(Connection conn= PostgresConfig.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,teacherName);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()){
                    Teacher teacher=new Teacher();
                    teacher.setId(rs.getInt("id"));
                    teacher.setTeacherName(rs.getString("teacherName"));
                    teacher.setTeacherSurname(rs.getString("teacherSurname"));
                    teachers.add(teacher);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return teachers;
    }
}
