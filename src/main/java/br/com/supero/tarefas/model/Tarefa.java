package br.com.supero.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe responsável por moldar as Tarefas
 *
 * @author Rodrigo Augusto Benedicto
 * @version 1.0
 * @since 2018-09-16
 */

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 5, max = 150, message = "Título deve conter de 5 a 150 caracteres!")
	private String titulo;

	@Size(max = 500)
	private String descricao;

	private boolean concluido = false;

	private boolean removido = false;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao = Calendar.getInstance();

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataConclusao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEdicao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataExclusao;

	public Tarefa() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public boolean isRemovido() {
		return removido;
	}

	public void setRemovido(boolean removido) {
		this.removido = removido;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Calendar dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Calendar getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Calendar dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public Calendar getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Calendar dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", concluido=" + concluido
				+ ", removido=" + removido + ", dataCriacao=" + dataCriacao + ", dataConclusao=" + dataConclusao
				+ ", dataEdicao=" + dataEdicao + ", dataExclusao=" + dataExclusao + "]";
	}

}
