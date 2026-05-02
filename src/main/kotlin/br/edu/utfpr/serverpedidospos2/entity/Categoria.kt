package br.edu.utfpr.serverpedidospos2.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Categoria {
    @Id
    var id : Int = 0
    var nome : String = ""
}

/*
INSERT INTO CATEGORIA VALUES (1, 'Categoria 1');
INSERT INTO CATEGORIA VALUES (2, 'Categoria 2');
INSERT INTO CATEGORIA VALUES (3, 'Categoria 3');
*/