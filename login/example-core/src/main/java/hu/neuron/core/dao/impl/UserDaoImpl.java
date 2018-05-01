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
		Connection conn = null;
		Long result = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DatasourceUtil.getDatasource().getConnection();
			String sql = "INSERT INTO REGISTRATION (username, firstname, lastname, url, password, email, phone) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, t.getUsername());
			pst.setString(2, t.getFirstname());
			pst.setString(3, t.getLastname());
			pst.setString(4, t.getUrl());
			pst.setString(5, t.getPassword());
			pst.setString(6, t.getEmail());
			pst.setString(7, t.getPhone());

			pst.executeUpdate();

			rs = pst.getGeneratedKeys();

			if (rs.next()) {
				result = rs.getLong(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public void delete(Long id) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DatasourceUtil.getDatasource().getConnection();
			String sql = "DELETE FROM REGISTRATION WHERE ID = ? ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id.toString());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(UserDto t) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DatasourceUtil.getDatasource().getConnection();
			String sql = "UPDATE REGISTRATION SET username=?, firstname=?, lastname=?, url=?, password=?, email=?, phone=? WHERE username=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getFirstname());
			pst.setString(3, t.getLastname());
			pst.setString(4, t.getUrl());
			pst.setString(5, t.getPassword());
			pst.setString(6, t.getEmail());
			pst.setString(7, t.getPhone());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public UserDto find(Long id) {
		Connection conn = null;
		UserDto result = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DatasourceUtil.getDatasource().getConnection();
			String sql = "SELECT * FROM REGISTRATION WHERE id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id.toString());
			pst.executeUpdate();
			rs = pst.executeQuery();
			if (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String url = rs.getString("url");
				result = new UserDto(id, username, firstname, lastname, url, password, email, phone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<UserDto> findAll() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<UserDto> result = new ArrayList<UserDto>();
		try {
			conn = DatasourceUtil.getDatasource().getConnection();
			String sql = "SELECT * FROM REGISTRATION";
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
			rs = pst.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String url = rs.getString("url");
				Long id = rs.getLong("id");
				result.add(new UserDto(id, username, firstname, lastname, url, password, email, phone));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public UserDto findByName(String name) {
		try {
			return findAll().stream()
					.filter(f -> name.equals((f.getFirstname() + " " + f.getLastname())))
					.findFirst()
					.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
