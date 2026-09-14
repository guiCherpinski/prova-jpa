package br.com.ctw.api_monitoramento_transformadores.repository;

import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Essa é a repository da entity Transformador
 */

@Repository
public interface TransformadorRepository extends JpaRepository<Transformador, Long> {

    /**
     * Consulta personalizada que utiliza do número de série de um transformador para buscá-lo no banco
     * @param numeroSerie
     * @return Transformador
     */
    Optional<Transformador> findByNumeroSerie (String numeroSerie);
}
