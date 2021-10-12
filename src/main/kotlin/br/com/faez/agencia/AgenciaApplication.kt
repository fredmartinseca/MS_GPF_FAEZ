package br.com.faez.agencia

import br.com.faez.agencia.entities.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class AgenciaApplication
fun main(args: Array<String>) {
	runApplication<AgenciaApplication>(*args)
}
