package hu.neuron.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

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

			String sql = "INSERT INTO Own_User " + "(username, firstname, lastname,url,password,email,phone)"
					+ " VALUES ( ?,?,?,?,?,?,?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getFirstname());
			statement.setString(3, t.getLastname());
			statement.setString(4, t.getUrl());
			statement.setString(5, t.getPassword());
			statement.setString(6, t.getEmail());
			statement.setString(7, t.getPhone());

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
		// TODO Auto-generated method stub

	}

	@Override
	public UserDto upadte(UserDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> findAll() throws Exception {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<UserDto> rv = new ArrayList<UserDto>();
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select * from Own_User";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String username = resultSet.getString("username");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String url = resultSet.getString("url");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				rv.add(new UserDto(rvid, username, firstname, lastname, url, password, email, phone));
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

		try {
			return findAll().stream().filter(f -> name.equals((f.getFirstname() + " " + f.getLastname()))).findFirst()
					.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
