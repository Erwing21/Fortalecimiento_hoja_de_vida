USE hoja_de_vida;

CREATE TABLE IF NOT EXISTS experiencias (
                                            id       INT AUTO_INCREMENT PRIMARY KEY,
                                            puesto   VARCHAR(100) NOT NULL,
    empresa  VARCHAR(100) NOT NULL,
    duracion VARCHAR(50)  NOT NULL
    );


SELECT id, puesto, empresa, duracion FROM experiencias ORDER BY id;
