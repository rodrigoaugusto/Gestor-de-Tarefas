package br.com.supero.tarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supero.tarefas.model.Tarefa;
import br.com.supero.tarefas.repository.Tarefas;

@Service
public class TarefaService {

	@Autowired
	private Tarefas tarefas;

	public Tarefa save(Tarefa tarefa) {
		return tarefas.save(tarefa);
	}

	public List<Tarefa> findAll() {
		return tarefas.findAll();
	}

}
