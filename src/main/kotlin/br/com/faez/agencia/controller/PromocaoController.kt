package br.com.faez.agencia.controller

import br.com.faez.agencia.entities.Promocao
import br.com.faez.agencia.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
@RequestMapping("/promocoes")
class PromocaoController {

    @Autowired
    lateinit var service: PromocaoService

    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>

    @GetMapping
    fun getAll(@RequestParam(required = false, defaultValue = "") descricao: String,
               @RequestParam(required = false, defaultValue = "") local: String) =
        promocoes.filter{
            it.value.descricao.contains(descricao,true) ||
                    it.value.local.contains(local, true)
        }.map(Map.Entry<Long,Promocao>::value).toList()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = promocoes[id]

    @PostMapping
    fun create(@RequestBody promocao: Promocao): Promocao? {
        promocoes.put(promocao.id, promocao)
        return promocoes[promocao.id]
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String{
        promocoes.remove(id)
        return "Promoção com o id $id deletada com sucesso!"
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody promocao: Promocao): Promocao? {
        promocoes.remove(id)
        promocoes.put(id, promocao)
        return promocoes[promocao.id]
    }
}