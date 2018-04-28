package hu.schonherz.blog.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDTO implements GenericDao<UserDTO> {
	
	
	
	public Long save(UserDTO user) {
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
		
		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO REGISTRATION( last,first,age ) VALUES ( ?,?,? ) ";
			statement = ds.getConnection().prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, dto.getLastName());
			statement.setString(2, dto.getFirstName());
			statement.setInt(3, dto.getAge());
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
	}

	@Override
	public UserDTO update(UserDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO find(Long i) {
		// TODO Auto-generated method stub
		return null;
	}

}
