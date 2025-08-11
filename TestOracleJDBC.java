import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//javac -cp ojdbc83.jar TestOracleJDBC.java
//java -cp ".:ojdbc83.jar" TestOracleJDBC

public class TestOracleJDBC {
    public static void main(String[] args) {
        // Configuración de la conexión
        //String jdbcUrl = "jdbc:oracle:thin:@//adb.us-phoenix-1.oci.oraclecloud.com:1522/g153951d94b233b_environment_high.adb.oraclecloud.com";
        //String jdbcUrl = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcps)(HOST=adb.us-phoenix-1.oraclecloud.com)(PORT=1522))(CONNECT_DATA=(SERVICE_NAME=g153951d94b233b_environment_high.adb.oraclecloud.com))(SECURITY=(SSL_SERVER_DN_MATCH=yes)))";
        String jdbcUrl = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcps)(HOST=adb.us-phoenix-1.oraclecloud.com)(PORT=1522))(CONNECT_DATA=(SERVICE_NAME=g153951d94b233b_environment_high.adb.oraclecloud.com))(SECURITY=(SSL_SERVER_DN_MATCH=yes)))";
        //
        String username = "GUARDIUM";
        String password = "Gu4rd1um2025#";
        
        // Parámetros de conexión segura
        String connectionProps = "oracle.net.ssl_server_dn_match=true&" +
                               "oracle.net.ssl_version=1.2&" +
                               "javax.net.ssl.trustStoreType=JKS";
        
        jdbcUrl += "?" + connectionProps;

        try {
            // Cargar el driver
            Class.forName("oracle.jdbc.OracleDriver");
            
            // Establecer conexión
            System.out.println("Connecting to the database...");
            try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
                System.out.println("Connection successful!");
                // Ejecutar consulta de prueba
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT 'Connection successful' AS mensaje, SYSDATE AS fecha FROM DUAL")) {
                    
                    while (rs.next()) {
                        System.out.println(rs.getString("mensaje") + " - Fecha: " + rs.getDate("fecha"));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error de conexión:");
            e.printStackTrace();
        }
    }
}
