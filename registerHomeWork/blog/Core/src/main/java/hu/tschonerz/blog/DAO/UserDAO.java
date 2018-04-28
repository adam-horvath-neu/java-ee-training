package hu.tschonerz.blog.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserDAO implements GenericDAO<UserDTO>{
	
	Connection connection;

	public UserDAO(Connection connection) {
		this.connection = connection;

	}
//	
//	Context initContext = new InitialContext();
//	Context envContext  = (Context)initContext.lookup("java:/comp/env");
//	DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
//	Connection conn = ds.getConnection();
//	//etc.
	@Override
	// Kell egy User tábla
	// a UserDTO mezőit kezeljük, át kell forgatni Userre
	// A DAO-ban kell átforgatni valahol
	// A service-nek kell függőség : core
	// new UserDAO
	// service rétegben kell egy converter, ami átalakit 1 vagy több DTO-t Userré, és / vagy forditva
	public Long save(UserDTO t) {
		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO REGISTRATION(username, firstname, lastname, password, url, email, phone ) VALUES ( ?,?,?,?,?,?,? ) ";
			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(2, t.getLastname());
			statement.setString(3, t.getFirstname());
			statement.setString(4, t.getPassword());
			statement.setString(5, t.getUrl());
			statement.setString(1, t.getUsername());
			statement.setString(6, t.getEmail());
			statement.setString(7, t.getPhone());
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(1);
			}

		}catch (SQLException e) {
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
	public void update(UserDTO t) {
		PreparedStatement statement = null;
		try {
			String sql = "UPDATE REGISTRATION set username=? ,firstname=?, lastname=?, password=?, url=?, email=?, phone=? where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(2, t.getLastname());
			statement.setString(3, t.getFirstname());
			statement.setString(4, t.getPassword());
			statement.setString(5, t.getUrl());
			statement.setString(1, t.getUsername());
			statement.setString(6, t.getEmail());
			statement.setString(7, t.getPhone());
			statement.setLong(8, t.getId());
			
		
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
	public void delete(Long id) {
		PreparedStatement statement = null;
		try {
			String sql = "DELETE FROM REGISTRATION where id=? ";
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
	public List<UserDTO> findAll() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<UserDTO> rv = new ArrayList<UserDTO>();
		try {

			String sql = "select * from REGISTRATION";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String password = resultSet.getString("password");
				String url = resultSet.getString("url");
				
				
				rv.add(new UserDTO(username, firstName, lastName, password, url, email, phone, id));
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
	public UserDTO find(Long id) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDTO rv = null;
		try {
			

			String sql = "select * from REGISTRATION where id = ?";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String password = resultSet.getString("password");
				String url = resultSet.getString("url");
				
				rv= new UserDTO(username, firstName, lastName, password, url, email, phone, rvid);
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