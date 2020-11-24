package br.com.orginalapp.crud.service;

import java.util.List;

import br.com.orginalapp.crud.entity.Pessoa;
import br.com.orginalapp.crud.exception.RecursoNaoEncontradoException;

public interface PessoaService {

	public List<Pessoa> getTodasPessoas();
	
	public Pessoa obterPessoaById(Long pessoaId) throws RecursoNaoEncontradoException;
	
	public Pessoa salvar(Pessoa pessoa);
	
	public void excluir(Pessoa pessoa);
	
	
	
	
	
}
