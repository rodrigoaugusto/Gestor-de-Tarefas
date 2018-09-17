package br.com.supero.tarefas.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.supero.tarefas.model.Tarefa;
import br.com.supero.tarefas.repository.Tarefas;

/**
 * Classe responsável por receber e tratar todos os requests de Tarefa
 *
 * @author Rodrigo Augusto Benedicto
 * @version 1.0
 * @since 2018-09-16
 */

@Controller
@RequestMapping("/tarefas")
public class TarefasController {

	@Autowired
	private Tarefas tarefas;

	/**
     * GET - Recurso responsavel por retornar a pagina de lista de tarefas
     * @return view com a lista de tarefas
     */
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaTarefas");
		modelAndView.addObject(new Tarefa());
		modelAndView.addObject("tarefas", tarefas.findByRemovido(false));
		return modelAndView;
	}

	/**
     * GET - Recurso responsavel por retornar a pagina de cadastro de tarefa
     * @return view de cadastro de tarefa
     */
	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("CadTarefa");
		modelAndView.addObject(new Tarefa());
		return modelAndView;
	}

	/**
     * GET - Recurso responsavel por retornar a pagina de edicao de tarefa
     * @param id - id da tarefa a ser editada
     * @return view de edicao de tarefa
     */
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("CadTarefa");
		Tarefa tarefa = tarefas.findById(id).orElse(new Tarefa());
		modelAndView.addObject(tarefa);
		return modelAndView;
	}

	/**
     * DELETE - Recurso responsavel por excluir registro de tarefa
     * @param id - id da tarefa a ser excluida
     * @return redirect para lista de tarefas
     */
	@DeleteMapping("/{id}")
	public String excluir(@PathVariable("id") Long id) {
		Tarefa tarefa = tarefas.findById(id).orElse(null);

		if (tarefa != null) {
			tarefa.setDataExclusao(Calendar.getInstance());
			tarefa.setRemovido(true);
			this.tarefas.save(tarefa);
			// tarefas.deleteById(id);
		}

		return "redirect:/tarefas";
	}

	/**
     * PUT - Recurso responsavel por editar registro de tarefa
     * @param tarefa
     * @return redirect para lista de tarefas
     */
	@PutMapping("/{id}")
	public String editar(Tarefa tarefa) {
		tarefa.setDataEdicao(Calendar.getInstance());
		this.tarefas.save(tarefa);
		return "redirect:/tarefas";
	}

	/**
     * POST - Recurso responsavel por salvar registro de tarefa
     * @param tarefa
     * @return redirect para lista de tarefas
     */
	@PostMapping("/novo")
	public String salvar(Model model, @Valid Tarefa tarefa, BindingResult result) {

		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ": " + error.getDefaultMessage());
			}
			model.addAttribute("tarefa", tarefa);
			return "CadTarefa";
		}

		this.tarefas.save(tarefa);
		return "redirect:/tarefas";
	}

}
