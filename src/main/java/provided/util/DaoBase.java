package provided.util;

import projects.exception.dbexception;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalTime;
import java.util.Objects;

public abstract class DaoBase {
	protected static void startTransaction (Connection conn) throws SQLException {
		conn.setAutoCommit(false);
	}
	
	protected static void commitTransaction (Connection conn) throws SQLException {
		conn.commit();
	}
	
	protected static void rollBackTransaction (Connection conn) throws SQLException {
		conn.rollback();
	}

	protected static void setParameter (PreparedStatement stmt, int parameterIndex, Object value, Class <?> classType) throws SQLException {
		int sqlType = convertJavaClassToSqlType (classType);

		if(Objects.isNull(value)){
			stmt.setNull(parameterIndex, sqlType);
		}else{
			switch (sqlType){
				case Types.DECIMAL-> stmt.setBigDecimal (parameterIndex, (BigDecimal) value);
				case Types.DOUBLE-> stmt.setDouble (parameterIndex, (Double) value);
				case Types.INTEGER-> stmt.setInt (parameterIndex, (Integer) value);
				case Types.OTHER-> stmt.setObject (parameterIndex, value);
				case Types.VARCHAR-> stmt.setString (parameterIndex, (String) value);

				default -> System.out.println ("Unknown parameter type: " + classType);
			}
		}
	}
	private static int convertJavaClassToSqlType (Class<?> classType){
		if (Integer.class.equals (classType)){
			return Types.INTEGER;
		}
		
		if (String.class.equals(classType)){
			return Types.VARCHAR;
		}
		
		if (Double.class.equals (classType)){
			return Types.DOUBLE;
		}
		if (BigDecimal.class.equals(classType)){
			return Types.DECIMAL;
		}
		
		if (LocalTime.class.equals (classType)){
			return Types.OTHER;
		}
		
		throw new dbexception ("Unsupported class type: " + classType.getName());
	}	

	protected static Integer getLastInsertId (Connection conn, String table) throws SQLException{
		String sql = String.format ("SELECT LAST_INSERT_ID() FROM %S", table);

		try (Statement stmt = conn.createStatement ()){
			try (ResultSet rs = stmt.executeQuery(sql)){
				if (rs.next()){
					return rs.getInt (1);
				}
			}
			throw new SQLException ("Unable to retrieve the primary key value. No result set.");
		}
	}
}