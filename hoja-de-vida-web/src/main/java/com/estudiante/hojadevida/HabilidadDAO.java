package com.estudiante.hojadevida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDAO {

    private static final String SELECT_BASE = "SELECT id, nombre, nivel FROM habilidades";

    public List<Habilidad> listar() throws SQLException {
        String sql = SELECT_BASE + " ORDER BY nombre";
        List<Habilidad> habilidades = new ArrayList<>();

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                habilidades.add(convertir(rs));
            }
        }
        return habilidades;
    }

    public List<Habilidad> listarPorNivel(String nivel) throws SQLException {
        String sql = SELECT_BASE + " WHERE nivel = ? ORDER BY nombre";
        List<Habilidad> habilidades = new ArrayList<>();

        try (Connection cn = Conexion.obtener();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nivel);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    habilidades.add(convertir(rs));
                }
            }
        }
        return habilidades;
    }

    private Habilidad convertir(ResultSet rs) throws SQLException {
        return new Habilidad(rs.getInt("id"), rs.getString("nombre"), rs.getString("nivel"));
    }
}
