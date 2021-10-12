package br.com.faez.agencia.service

import br.com.faez.agencia.entities.Promocao
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl: PromocaoService {
    companion object{
        val initialPromocoes = arrayOf(
            Promocao(1,"Site por R$ 1.000,00", "Web", false, 1000.0),
            Promocao(2,"App por R$ 5.000,00", "Mobile", false, 5000.0),
            Promocao(3,"Sistema por R$ 25.000,00", "Sistema", false, 25000.0)
        )
    }
    var promocoes = ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))
}

