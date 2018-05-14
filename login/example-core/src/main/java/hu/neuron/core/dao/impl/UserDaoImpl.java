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

			String sql = "INSERT INTO user_table (username, password, image, firstname, lastname, email, phone) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setString(3, t.getPictureUrl());
			statement.setString(4, t.getFirstName());
			statement.setString(5, t.getLastName());
			statement.setString(6, t.getUserEmail());
			statement.setString(7, t.getPhoneNumber());

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
	public void update(UserDto t) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			statement = connection.prepareStatement(
					"UPDATE user_table SET username = ? , image = ? , firstname = ?, lastname = ?, email = ?, phone = ? WHERE id = ?");
			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPictureUrl());
			statement.setString(3, t.getFirstName());
			statement.setString(4, t.getLastName());
			statement.setString(5, t.getUserEmail());
			statement.setString(6, t.getPhoneNumber());
			System.out.println(t.getPhoneNumber());
			statement.setLong(7, t.getId());
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
				String password = resultSet.getString("password");
				String gender = resultSet.getString("gender");
				String url = resultSet.getString("image");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				list.add(new UserDto(id, username, firstname, lastname, email, url, password, phone));
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
				result.setPictureUrl(resultSet.getString("image"));
				result.setFirstName(resultSet.getString("firstname"));
				result.setLastName(resultSet.getString("lastname"));
				result.setUserEmail(resultSet.getString("email"));
				result.setPhoneNumber(resultSet.getString("phone"));
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
