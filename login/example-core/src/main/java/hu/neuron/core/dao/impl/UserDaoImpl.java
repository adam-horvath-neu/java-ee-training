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

			String sql = "INSERT INTO USER_TABLE ( username, password, image, firstname, lastname, email, phone) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setString(3, t.getUrl());
			statement.setString(4, t.getFirstname());
			statement.setString(5, t.getLastname());
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
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			statement = connection.prepareStatement("DELETE FROM user_table WHERE id = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		try {
			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (connection != null) {
				connection.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserDto update(UserDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<UserDto> list = new ArrayList<>();
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			statement = connection.prepareStatement("SELECT * FROM user_table");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String username = resultSet.getString("username");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String url = resultSet.getString("image");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				list.add(new UserDto(id, username, firstname, lastname, url, password, email, phone));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public UserDto findByName(String name) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		UserDto result = new UserDto();

		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			statement = connection.prepareStatement("SELECT * FROM user_table WHERE username = ?");
			statement.setString(1, name);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				result.setUsername(resultSet.getString("username"));
				result.setUrl(resultSet.getString("image"));
				result.setFirstname(resultSet.getString("firstname"));
				result.setLastname(resultSet.getString("lastname"));
				result.setEmail(resultSet.getString("email"));
				result.setPhone(resultSet.getString("phone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
