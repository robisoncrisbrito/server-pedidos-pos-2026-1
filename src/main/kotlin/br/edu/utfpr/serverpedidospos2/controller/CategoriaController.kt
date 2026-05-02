package br.edu.utfpr.serverpedidospos2.controller

import br.edu.utfpr.serverpedidospos2.entity.Categoria
import br.edu.utfpr.serverpedidospos2.repository.CategoriaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/categorias")
class CategoriaController(private val categoriaRepository: CategoriaRepository) {

    @GetMapping
    fun list(): List<Categoria> {
        return categoriaRepository.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Int): ResponseEntity<Categoria>{
        val categoria = categoriaRepository.findById(id).getOrNull()?:
            return ResponseEntity.notFound().build()

        return ResponseEntity.ok(categoria)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Int): ResponseEntity<Unit>{
        categoriaRepository.findById(id).getOrNull()?.let { registro ->
            categoriaRepository.delete(registro)
        }

        return ResponseEntity.noContent().build()

    }

    @PostMapping
    fun save(@RequestBody categoria: Categoria): Categoria {
        return categoriaRepository.save(categoria)
    }



}