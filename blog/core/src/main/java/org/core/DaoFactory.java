
import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory { 
	private volatile Connection connection;
	private boolean scopeMarked = false;

	private static DaoFactory instance = null;

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	public RegistrationDao getRegistrationDAO() throws Exception {
		if (connection == null)
			throw new Exception();
		return new RegistrationImpl(connection);
	}

	public void beginConnectionScope() throws Exception {
//		System.out.println(Thread.currentThread().getId() + " "
//				+ this.toString() + " begin");
		if (scopeMarked) {
			throw new Exception("The beginning of scope is already marked.");
		} else {
			try {
				connection = ConnectionFactory.getConnection();
			} catch (Exception e) {
				scopeMarked = false;
				throw new Exception(e);
			}
		}
		scopeMarked = true;
	}

	public void endConnectionScope() throws Exception {
//		System.out.println(Thread.currentThread().getId() + " "
//				+ this.toString() + " closed");
		if (!scopeMarked) {
			throw new Exception(Thread.currentThread().getId()
					+ " The end of scope is already marked.");
		} else {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new Exception(e);
				} finally {
					connection = null;
					scopeMarked = false;
				}
			}
		}
	}

	public void beginTransaction() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void endTransaction() {
		try {

			connection.commit();
			connection.setAutoCommit(true);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void abortTransaction() {
		try {

			connection.rollback();
			connection.setAutoCommit(true);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
