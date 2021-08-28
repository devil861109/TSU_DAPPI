# Tema 05: Conexión a Base de Datos

Aqui vemos la introducción a JDBC y sus métodos de conexión.
Utilizaremos ejemplos con BD MySQL y MSSQL.
Trabajaremos con una BD genérica
https://github.com/datacharmer/test_db

Se enseña lo relevante al manejo de datos:
* DriverManager
* Connection
* Statement
* PreparedStatement
* Resultset
* ResultsetMetadata
* Datasource

## Conexión con MySQL 5.7

```java
	import java.sql.*;
	public class Connection57 {
	    public static void main(String[] args) {
	        try (Connection conn = DriverManager.getConnection(
	            "jdbc:mysql://127.0.0.1:3306/employees", "user", "password")) {
	            if (conn != null) {
	                System.out.println("Connected to the database!");
	            } else {
	                System.out.println("Failed to make connection!");
	            }
	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
```

## Conexión con MySQL 8.0

```java
	public class Connection80 {
	    public static void main(String[] args) {
	        try (Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "username", "password")) {
	            if (conn != null) {
	                System.out.println("Connected to the database!");
	            } else {
	                System.out.println("Failed to make connection!");
	            }
	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
```

## Otra Conexión con MySQL 8.0

```java

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;        
        String dbUrl = "jdbc:mysql://localhost:3306/demo_sqli?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "username";
        String pass = "password";
        try {
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            if (myConn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


```

## Creación de Statement

```java
	public Statement createStatement() throws SQLException  
	Statement stmt=con.createStatement();   
```

## Ejecución de la Query

```java
	import java.sql.*;
	…
	String dbUrl = "jdbc:mysql://localhost:3306/demo";
	String user = "student";
	String pass = "student";

	Connection myConn = DriverManager.getConnection(dbUrl, user, pass);
	Statement myStmt = myConn.createStatement();
	ResultSet myRs = myStmt.executeQuery("SELECT * FROM employees");
```

## Procesar ResultSet

```java
	import java.sql.*;
	…
	String dbUrl = "jdbc:mysql://localhost:3306/demo";
	String user = "student";
	String pass = "student";
	Connection myConn = DriverManager.getConnection(dbUrl, user, pass);
	Statement myStmt = myConn.createStatement();
	ResultSet myRs = myStmt.executeQuery("SELECT * FROM employees");
	while (myRs.next()) {
	    //leer los datos de cada fila
	    System.out.println(myRs.getInt("id"));
	    System.out.println(myRs.getString("last_name"));
}
```

## Ejemplo completo

```java
	import java.sql.*;
	public class ExampleConnStatement {
	    public static void main(String args[]) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "user", "password");
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select count(*) as count from employees");
	        while (rs.next()) {
	            int count = rs.getInt("count");
	            System.out.println(count + " total records");
	        }
	        stmt.close();
	        conn.close();
	    }
	}
```

## Trabajando con PreparedStatement

```java
	public class ExampleConnPrepared{
	    public static void main(String args[]){
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "user", "password");
	            PreparedStatement stmt = conn.prepareStatement("insert into employees values (?,?,?,?,?,?)");
	            //LocalDateTime now = LocalDateTime.now();
	            //Timestamp sqlNow = Timestamp.valueOf(now);
	            java.util.Date today = new java.util.Date();
	            java.sql.Date date = new java.sql.Date(today.getTime());
	            String sDate1="01/01/2019";
	            java.util.Date datest = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
	            java.sql.Date date1 = new java.sql.Date(datest.getTime());
	            stmt.setInt(1, 500000);//1 specifies the first parameter in the query
	            stmt.setDate(2, date);
	            stmt.setString(3, "Alfonso");
	            stmt.setString(4, "Rivero");
	            stmt.setString(5, "M");
	            stmt.setDate(6, date1);
	            int i = stmt.executeUpdate();
	            System.out.println(i + " records inserted");
	            stmt.close();
	            conn.close();
	        } catch(Exception e) {
	            System.out.println(e);
	        }
	    }
	}
```

## Ejemplo ResultSet

```java
	public class ExampleConnResultSet{
	    public static void main(String args[]){
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", “user", “password");
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery("select * from employees order by emp_no desc limit 10");
	            while (rs.next()) {
	                int id = rs.getInt("emp_no");
	                Date birth = rs.getDate("birth_date");
	                String first = rs.getString("first_name");
	                String last = rs.getString("last_name");
	                String gender = rs.getString("gender");
	                Date hire = rs.getDate("hire_date");
	                System.out.format("%s, %s, %s, %s, %s, %s\n", id, birth, first, last, gender, hire);
	            }
	            st.close();
	            conn.close();
	        } catch(Exception e) {
	            System.out.println(e);
	        }
	    }
	}
```

## Ejemplo ResultSetMetadata

```java
	import java.sql.*;
	public class ExampleConnResultSetMetadata{
	    public static void main(String args[]){
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "user", "password");
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery("select * from employees order by emp_no desc limit 10");
	            ResultSetMetaData rsmd = rs.getMetaData();
	            System.out.println("Total columns: " + rsmd.getColumnCount());
	            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
	            System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));
	            st.close();
	            conn.close();
	        } catch(Exception e) {
	            System.out.println(e);
	        }
	    }
	}
```

## CRUD

### Create

```java
	String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setString(1, "bill");
	statement.setString(2, "secretpass");
	statement.setString(3, "Bill Gates");
	statement.setString(4, "bill.gates@microsoft.com");
	int rowsInserted = statement.executeUpdate();
	if (rowsInserted > 0) {
	    System.out.println("A new user was inserted successfully!");
	}
```

### Read

```java
	String sql = "SELECT * FROM Users";
	Statement statement = conn.createStatement();
	ResultSet result = statement.executeQuery(sql); 
	int count = 0;
	while (result.next()){
		String name = result.getString(2);
		String pass = result.getString(3);
		String fullname = result.getString("fullname");
		String email = result.getString("email");
		String output = "User #%d: %s - %s - %s - %s";
		System.out.println(String.format(output, ++count, name, pass, fullname, email));
	}
```

### Update

```java
	String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setString(1, "123456789");
	statement.setString(2, "William Henry Bill Gates");
	statement.setString(3, "bill.gates@microsoft.com");
	statement.setString(4, "bill");
	int rowsUpdated = statement.executeUpdate();
	if (rowsUpdated > 0) {
	    System.out.println("An existing user was updated successfully!");
	}
```

### Delete

```java
	String sql = "DELETE FROM Users WHERE username=?";
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setString(1, "bill");
	int rowsDeleted = statement.executeUpdate();
	if (rowsDeleted > 0) {
	    System.out.println("A user was deleted successfully!");
	}
```
