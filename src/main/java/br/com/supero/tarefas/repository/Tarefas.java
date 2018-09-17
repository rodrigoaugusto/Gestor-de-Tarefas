package br.com.supero.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supero.tarefas.model.Tarefa;

public interface Tarefas extends JpaRepository<Tarefa, Long> {

	/**
	 * Busca todas as tarefas de acordo com o parametro removio
	 * 
	 * @param value - boolean
	 * @return List<Tarefa> - Lista de tarefas
	 */
	List<Tarefa> findByRemovido(boolean value);

}
