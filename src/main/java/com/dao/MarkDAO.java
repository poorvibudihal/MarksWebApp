package com.dao;

import java.sql.*;
import java.util.*;
import com.model.StudentMark;

public class MarkDAO {

    private String url = "jdbc:mysql://localhost:3306/markdb";
    private String user = "root";
    private String password = "root";

    // INSERT
    public void addMark(StudentMark s) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO studentmarks VALUES(?,?,?,?,?)");

            ps.setInt(1, s.getStudentID());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getSubject());
            ps.setInt(4, s.getMarks());
            ps.setDate(5, s.getExamDate());

            ps.executeUpdate();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT
    public List<StudentMark> getAllMarks() {

        List<StudentMark> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM studentmarks");

            while(rs.next()) {
                StudentMark s = new StudentMark();

                s.setStudentID(rs.getInt("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setSubject(rs.getString("Subject"));
                s.setMarks(rs.getInt("Marks"));
                s.setExamDate(rs.getDate("ExamDate"));

                list.add(s);
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}