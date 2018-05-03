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

			String sql = "INSERT INTO REGISTRATION (username, firstname, lastname, url, password, email, phone) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

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
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "DELETE FROM REGISTRATION WHERE ID = ? ";

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
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "UPDATE REGISTRATION SET username=?, firstname=?, lastname=?, url=?, password=?, email=?, phone=? WHERE id=?";

			statement = connection.prepareStatement(sql);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getFirstname());
			statement.setString(3, t.getLastname());
			statement.setString(4, t.getUrl());
			statement.setString(5, t.getPassword());
			statement.setString(6, t.getEmail());
			statement.setString(7, t.getPhone());
			statement.setLong(8, t.getId());

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
	public UserDto find(Long id) {
		Connection connection = null;
		UserDto rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "SELECT * FROM REGISTRATION WHERE id=?";

			statement = connection.prepareStatement(sql);

			statement.setString(1, id.toString());

			statement.executeUpdate();

			rs = statement.executeQuery(); // !

			if (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String url = rs.getString("url");
				rv = new UserDto(id, username, firstname, lastname, url, password, email, phone);
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
	public List<UserDto> findAll() {
		Connection connection = null;
		List<UserDto> rv = new ArrayList<UserDto>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "SELECT * FROM REGISTRATION ORDER BY id";

			statement = connection.prepareStatement(sql);

			rs = statement.executeQuery(); // !

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String url = rs.getString("url");
				Long id = rs.getLong("id");
				rv.add(new UserDto(id, username, firstname, lastname, url, password, email, phone));
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
	public UserDto findByName(String name) {
		Connection connection = null;
		UserDto rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "SELECT * FROM REGISTRATION WHERE username=?";

			statement = connection.prepareStatement(sql);

			statement.setString(1, name);

			statement.executeUpdate();

			rs = statement.executeQuery(); // !

			if (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String url = rs.getString("url");
				Long id = rs.getLong("id");
				rv = new UserDto(id, username, firstname, lastname, url, password, email, phone);
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

}
