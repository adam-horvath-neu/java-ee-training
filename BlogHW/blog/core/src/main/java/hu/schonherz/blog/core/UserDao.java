package hu.schonherz.blog.core;

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
	public Long save(UserDto t) throws NamingException, SQLException {

		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/TestDB");
			String sql = "INSERT INTO REGISTRATION( username, firstname,lastname,password,email,phone ) VALUES ( ?,?,?,?,?,?) ";
			statement = ds.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getFirstname());
			statement.setString(3, t.getLastname());
			statement.setString(4, t.getPassword());
			statement.setString(5, t.getEmail());
			statement.setString(6, t.getPhone());
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(1);
			}

		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rv;
	}

	@Override
	public void update(UserDto t) throws Exception {
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		PreparedStatement statement = null;
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/TestDB");
			String sql = "UPDATE REGISTRATION set username=? ,firstname=?, lastname=?, password=? email=?, phone=?, where id=?";
			statement = ds.getConnection().prepareStatement(sql);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getFirstname());
			statement.setString(3, t.getLastname());
			statement.setString(4, t.getPassword());
			statement.setString(5, t.getEmail());
			statement.setString(6, t.getPhone());
			statement.setLong(7, t.getId());
			int i = statement.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Long id) throws Exception{
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		PreparedStatement statement = null;
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/TestDB");
			String sql = "DELETE FROM REGISTRATION where id=? ";
			statement = ds.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public UserDto find(Long id) throws Exception{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDto rv = null;
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/TestDB");
			connection = ds.getConnection();
			String sql = "select * from REGISTRATION where id = ?";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String username = resultSet.getString("username");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				rv = new UserDto(rvid, username, firstname, lastname, password, email, phone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rv;
	}

	@Override
	public List<UserDto> findAll() throws Exception{
		Connection connection = null;
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<UserDto> rv = new ArrayList<UserDto>();
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/TestDB");
			connection = ds.getConnection();
			String sql = "select * from REGISTRATION";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String username = resultSet.getString("username");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				rv.add(new UserDto(rvid, username, firstname, lastname, password, email, phone));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rv;
	}

}
