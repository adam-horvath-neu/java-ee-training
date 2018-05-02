package hu.neuron.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.neuron.core.dao.UserDao;
import hu.neuron.core.dao.util.DatasourceUtil;
import hu.neuron.core.dto.UserDto;

public class UserDaoImpl implements UserDao {

	@Override
	public Long save(UserDto t) {
		Connection connection = null;
		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "INSERT INTO employee (username, firstname, lastname, password, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

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
		} catch (SQLException e) {
			e.printStackTrace();
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
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rv;
	}

	@Override
	public void delete(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "DELETE FROM employee where id=? ";
			statement = connection.prepareStatement(sql);
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
	public UserDto upadte(UserDto t) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "UPDATE employee set username=? ,firstname=?, lastname=?, password=? email=?, phone=?, where id=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getFirstname());
			statement.setString(3, t.getLastname());
			statement.setString(4, t.getPassword());
			statement.setString(5, t.getEmail());
			statement.setString(6, t.getPhone());
			statement.setLong(7, t.getId());
			int i = statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public UserDto find(Long id) {
		if (findAll().stream().filter(f -> id.equals(f.getId())).findFirst().isPresent()) {
			return findAll().stream().filter(f -> id.equals(f.getId())).findFirst().get();
		}
		return null;
	}

	public List<UserDto> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<UserDto> rv = new ArrayList<UserDto>();
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select * from employee";
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

	@Override
	public UserDto findByName(String name) {
		if (findAll().stream().filter(f -> name.equals(f.getUsername())).findFirst().isPresent()) {
			return findAll().stream().filter(f -> name.equals(f.getUsername())).findFirst().get();
		}
		return null;
	}
}
