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

			String sql = "INSERT INTO T_USER (username, password, firstname, lastname, email, phone ) VALUES ( ?, ?, ?, ?, ?, ?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setString(3, t.getFirstname());
			statement.setString(4, t.getLastname());
			statement.setString(5, t.getEmail());
			statement.setString(6, t.getPhone());

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(7);
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
			String sql = "DELETE FROM T_USER where id=? ";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	}

	@Override
	public void upadte(UserDto t) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "UPDATE T_USER set password=?, firstname=?, lastname=?, email=?, phone=? where username=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, t.getPassword());
			statement.setString(2, t.getFirstname());
			statement.setString(3, t.getLastname());
			statement.setString(4, t.getEmail());
			statement.setString(5, t.getPhone());
			statement.setString(6, t.getUsername());
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// throw new Exception();

		} finally {
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
		List<UserDto> rv = new ArrayList<UserDto>();
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select * from T_USER";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				Long id = resultSet.getLong("id");
				rv.add(new UserDto(username, password, firstname, lastname, phone, email, id));
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
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDto rv = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "select * from T_USER where username = ?";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String username = resultSet.getString("username");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String password = resultSet.getString("password");
				rv = new UserDto(username, password, firstname, lastname, phone, email, rvid);
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

}
