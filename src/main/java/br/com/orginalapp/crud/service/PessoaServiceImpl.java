package br.com.orginalapp.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.orginalapp.crud.entity.Pessoa;
import br.com.orginalapp.crud.exception.RecursoNaoEncontradoException;
import br.com.orginalapp.crud.repository.PessoaRepository;

@Service
@Transactional(readOnly = true)
public class PessoaServiceImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public List<Pessoa> getTodasPessoas() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa obterPessoaById(Long pessoaId) throws RecursoNaoEncontradoException {
		return pessoaRepository.findById(pessoaId).orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada para este id :: " + pessoaId));
	}

	@Override
	@Transactional(readOnly = false)
	public Pessoa salvar(Pessoa pessoa) {		
		return pessoaRepository.save(pessoa);
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}

}
