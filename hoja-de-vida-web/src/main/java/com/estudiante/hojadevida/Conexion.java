package com.estudiante.hojadevida;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class Conexion {

    private static final String ARCHIVO = "db.properties";

    private Conexion() { }

    public static Connection obtener() throws SQLException {
        Properties config = new Properties();
        try (InputStream in = Conexion.class.getClassLoader().getResourceAsStream(ARCHIVO)) {
            if (in == null) {
                throw new SQLException("No se encontro " + ARCHIVO + " en src/main/resources");
            }
            config.load(in);
        } catch (IOException e) {
            throw new SQLException("No se pudo leer " + ARCHIVO, e);
        }

        try {
            Class.forName(config.getProperty("db.driver", "com.mysql.cj.jdbc.Driver"));
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC no encontrado: revisa la dependencia en pom.xml", e);
        }

        return DriverManager.getConnection(
                config.getProperty("db.url"),
                config.getProperty("db.user"),
                config.getProperty("db.password", ""));
    }
}
