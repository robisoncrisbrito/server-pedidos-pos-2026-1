package br.edu.utfpr.serverpedidospos2.repository

import br.edu.utfpr.serverpedidospos2.entity.Categoria
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository : JpaRepository<Categoria, Int>