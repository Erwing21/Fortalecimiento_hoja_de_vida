CREATE DATABASE IF NOT EXISTS hoja_de_vida
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE hoja_de_vida;

DROP TABLE IF EXISTS habilidades;
CREATE TABLE habilidades (
                             id     INT AUTO_INCREMENT PRIMARY KEY,
                             nombre VARCHAR(60) NOT NULL,
                             nivel  ENUM('Básico', 'Intermedio', 'Avanzado') NOT NULL
);

INSERT INTO habilidades (nombre, nivel) VALUES
                                            ('HTML5',               'Avanzado'),
                                            ('CSS3',                'Intermedio'),
                                            ('JavaScript',          'Avanzado'),
                                            ('Java',                'Básico'),
                                            ('SQL',                 'Básico'),
                                            ('Git',                 'Intermedio'),
                                            ('Trabajo en equipo',   'Avanzado');

-- Verificacion
SELECT * FROM habilidades;
