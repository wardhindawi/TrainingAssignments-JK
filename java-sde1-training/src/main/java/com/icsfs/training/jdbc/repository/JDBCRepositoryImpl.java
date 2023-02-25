package com.icsfs.training.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.icsfs.training.jdbc.entities.Student;
import com.icsfs.training.jdbc.service.MyJDBCConnection;

public class JDBCRepositoryImpl {

	/**
	 * @author Ward.Alhindawi
	 * @implNote inserts new student record to students table
	 * @param student
	 */
	public void insertStudent(Student student) {

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = MyJDBCConnection.getConnection();

			String sql = "INSERT INTO students (id, name, average, email) VALUES (?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, student.getId());
			stmt.setString(2, student.getName());
			stmt.setInt(3, student.getAverage());
			stmt.setString(4, student.getEmail());
			stmt.execute();
			System.out.println("A new student was inserted successfully!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author Ward.Alhindawi
	 * @param id
	 * @return false if id exists else true
	 */
	public boolean validateStudentId(int id) {

		String query = "SELECT id FROM Students where id = " + id;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = MyJDBCConnection.getConnection();

			st = con.createStatement();

			rs = st.executeQuery(query);
			if (rs.first()) {
				System.out.println("id already exists");
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;

	}

	/**
	 * @author Ward.Alhindawi
	 * @param id
	 * @return Student information by id
	 */
	public Student retrieveStudentInfo(int id) {

		String query = "SELECT * FROM Students WHERE id = ?";
		ResultSet rs = null;
		PreparedStatement st = null;
		Connection con = null;
		try {
			con = MyJDBCConnection.getConnection();
			st = con.prepareStatement(query);

			st.setInt(1, id);
			rs = st.executeQuery();

			Student student = null;
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAverage(rs.getInt("average"));
				student.setEmail(rs.getString("email"));

			}

			return student;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @author Ward.Alhindawi
	 * @param student
	 * @implNote updates student information
	 */
	public void updateStudentInfo(Student student) {

		String query = "UPDATE Students SET name = ?, average = ?, email = ? WHERE id = ?";
		PreparedStatement st = null;
		Connection con = null;
		try {
			con = MyJDBCConnection.getConnection();
			st = con.prepareStatement(query);

			st.setString(1, student.getName());
			st.setInt(2, student.getAverage());
			st.setString(3, student.getEmail());
			st.setInt(4, student.getId());
			int rowsUpdated = st.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Row updated successfully!");
			} else {
				System.out.println("No rows updated.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author Ward.Alhindawi
	 * @return list of all students in database
	 */
	public List<Student> retrieveAllStudents() {

		String query = "SELECT * FROM Students";
		ResultSet rs = null;
		PreparedStatement st = null;
		Connection con = null;
		List<Student> students = new ArrayList<Student>();
		try {
			con = MyJDBCConnection.getConnection();
			st = con.prepareStatement(query);
			rs = st.executeQuery();

			Student student = null;
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAverage(rs.getInt("average"));
				student.setEmail(rs.getString("email"));
				students.add(student);
			}

			return students;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @author Ward.Alhindawi
	 * @param id
	 * @return deletes student record by id
	 */
	public int deleteStudentRecord(int id) {
		String query = "DELETE FROM students WHERE id = ?";
		PreparedStatement stmt = null;
		Connection connection = null;
		try {
			connection = MyJDBCConnection.getConnection();
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
