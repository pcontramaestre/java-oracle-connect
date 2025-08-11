# Oracle JDBC Connection Test

This project contains a Java application that tests connectivity to an Oracle Autonomous Database using JDBC.

## What does TestOracleJDBC.java do?

The `TestOracleJDBC.java` file is a simple Java application that:

1. **Establishes a secure connection** to an Oracle Autonomous Database in Oracle Cloud Infrastructure (OCI)
2. **Tests the connection** by executing a simple SQL query
3. **Displays connection status** and current database date/time
4. **Handles errors** gracefully with proper exception handling

### Key Features:

- Uses Oracle JDBC driver for database connectivity
- Implements secure SSL/TLS connection with proper certificate validation
- Connects to Oracle Autonomous Database using the `tcps` protocol
- Executes a test query against the `DUAL` table
- Provides clear success/error feedback

## Prerequisites

Before running this application, ensure you have:

1. **Java Development Kit (JDK)** - Version 8 or higher
2. **Oracle JDBC Driver** - The project includes `ojdbc83.jar`
3. **Access to Oracle Autonomous Database** with valid credentials
4. **Network connectivity** to Oracle Cloud Infrastructure

## Database Configuration

The application is currently configured to connect to:

- **Host**: `adb.us-phoenix-1.oraclecloud.com`
- **Port**: `1522`
- **Service Name**: `g153951d94b233b_environment_high.adb.oraclecloud.com`
- **Protocol**: `tcps` (secure)
- **Username**: `GUARDIUM`
- **Password**: `Gu4rd1um2025#`

⚠️ **Security Note**: The credentials are hardcoded for testing purposes. In production, use environment variables or secure configuration files.

## How to Run

### Step 1: Compile the Java file

```bash
javac -cp ojdbc83.jar TestOracleJDBC.java
```

### Step 2: Run the application

```bash
java -cp ".:ojdbc83.jar" TestOracleJDBC
```

**Note**: On Windows, use semicolon (`;`) instead of colon (`:`) as the classpath separator:

```cmd
java -cp ".;ojdbc83.jar" TestOracleJDBC
```

## Expected Output

If the connection is successful, you should see:

```
Connecting to the database...
Connection successful!
Connection successful - Fecha: [current date]
```

If there's an error, you'll see:

```
Connecting to the database...
Error de conexión:
[Error details]
```

## Project Structure

```
windsurf-project/
├── TestOracleJDBC.java     # Main Java application
├── TestOracleJDBC.class    # Compiled Java class
├── ojdbc83.jar            # Oracle JDBC driver (Java 8+)
└── README.md              # This file
```

## Troubleshooting

### Common Issues:

1. **ClassNotFoundException**: Ensure the JDBC driver JAR is in the classpath
2. **Connection timeout**: Check network connectivity and firewall settings
3. **SSL certificate errors**: Verify SSL configuration and certificate validity
4. **Authentication failed**: Verify username and password credentials
5. **Service name not found**: Check the Oracle service name configuration

### SSL Configuration

The application uses these SSL parameters:
- `oracle.net.ssl_server_dn_match=true`: Enables server certificate validation
- `oracle.net.ssl_version=1.2`: Forces TLS 1.2
- `javax.net.ssl.trustStoreType=JKS`: Uses Java KeyStore format

## Customization

To connect to a different Oracle database:

1. Update the `jdbcUrl` with your database connection string
2. Change the `username` and `password` variables
3. Modify SSL parameters if needed
4. Recompile and run the application

## Security Best Practices

For production use:

1. Store credentials in environment variables or secure configuration files
2. Use connection pooling for better performance
3. Implement proper logging instead of console output
4. Add input validation and sanitization
5. Use prepared statements for SQL queries

## Dependencies

- **Oracle JDBC Driver**: `ojdbc83.jar` or `ojdbc11.jar`
- **Java Standard Library**: No additional dependencies required

## License

This is a test application for educational and development purposes.