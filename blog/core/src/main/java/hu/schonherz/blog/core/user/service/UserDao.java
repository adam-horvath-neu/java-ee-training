package hu.schonherz.blog.core.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDao implements GenericDao<UserDto> {

	@Override
	public void update(UserDto t) throws Exception {
		// TODO Auto-generated method stub
		Context initContext = null;
		Context envContext = null;
		PreparedStatement ps = null;
		DataSource ds = null;
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/Users");
			String sql = "UPDATE REGISTRATION set username=? ,firstname=?, lastname=?, password=? email=?, phone=?, where id=?";
			ps = ds.getConnection().prepareStatement(sql);

			ps.setString(1, t.getUsername());
			ps.setString(2, t.getFirstName());
			ps.setString(3, t.getLastName());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getPhoneNumber());
			ps.setLong(7, t.getId());
			int i = ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		PreparedStatement ps = null;
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/Users");
			String sql = "DELETE FROM REGISTRATION where id=? ";
			ps = ds.getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public UserDto find(Long id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDto rv = null;
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/TestDB");
			conn = ds.getConnection();
			String sql = "select * from REGISTRATION where id = ?";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Long rvid = rs.getLong("id");
				String username = rs.getString("username");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				rv = new UserDto(rvid, username, firstname, lastname, password, email, phone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rv;
	}

	@Override
	public Long save(UserDto t) throws NamingException, SQLException {
		// TODO Auto-generated method stub
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Long rv = null;

		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/Users");
			String sql = "INSERT INTO REGISTRATION( username, firstname,lastname,password,email,phone ) VALUES ( ?,?,?,?,?,?) ";
			ps = ds.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, t.getUsername());
			ps.setString(2, t.getFirstName());
			ps.setString(3, t.getLastName());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getPhoneNumber());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				rv = rs.getLong(1);
			}
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rv;

	}

	@Override
	public List<UserDto> findAll() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserDto> rv = new ArrayList<UserDto>();
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/Users");
			conn = ds.getConnection();
			String sql = "select * from REGISTRATION";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Long rvid = rs.getLong("id");
				String username = rs.getString("username");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				rv.add(new UserDto(rvid, username, firstname, lastname, password, email, phone));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rv;
	}

}
