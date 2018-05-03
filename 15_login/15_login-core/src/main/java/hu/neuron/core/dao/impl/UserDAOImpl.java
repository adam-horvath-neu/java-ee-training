package hu.neuron.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.neuron.core.dao.UserDAO;
import hu.neuron.core.dao.util.DatasourceUtil;
import hu.neuron.core.dto.UserDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public Long save(UserDTO t) {
		Connection connection = null;
		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "INSERT INTO \"T_USER\"( username,password,firstname,lastname,url,email,phone ) VALUES ( ?,?,?,?,?,?,? ) ";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setString(3, t.getFirstname());
			statement.setString(4, t.getLastname());
			statement.setString(5, t.getUrl());
			statement.setString(6, t.getEmail());
			statement.setString(7, t.getPhone());
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
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
	public void delete(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "DELETE FROM \"T_USER\" where user_id=? ";
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
	public UserDTO update(UserDTO t) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "UPDATE \"T_USER\" set username=?, password=?, firstname=?, lastname=?, url=?, email=?, phone=? where user_id=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setString(3, t.getFirstname());
			statement.setString(4, t.getLastname());
			statement.setString(5, t.getUrl());
			statement.setString(6, t.getEmail());
			statement.setString(7, t.getPhone());
			statement.setLong(8, t.getId());

			// int i = statement.executeUpdate();
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

		return t;
	}

	@Override
	public UserDTO find(Long user_id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDTO rv = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select * from \"T_USER\" where user_id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, user_id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("user_id");
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String url = resultSet.getString("url");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				rv = new UserDTO(id, userName, password, firstName, lastName, url, email, phone);
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
	public List<UserDTO> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<UserDTO> rv = new ArrayList<UserDTO>();
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select * from \"T_USER\"";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("user_id");
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String url = resultSet.getString("url");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				rv.add(new UserDTO(id, userName, password, firstName, lastName, url, email, phone));
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
	public UserDTO findByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDTO rv = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select * from \"T_USER\" where username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("user_id");
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String url = resultSet.getString("url");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				rv = new UserDTO(id, userName, password, firstName, lastName, url, email, phone);
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
