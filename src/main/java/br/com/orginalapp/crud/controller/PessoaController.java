package br.com.orginalapp.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orginalapp.crud.entity.Pessoa;
import br.com.orginalapp.crud.exception.RecursoNaoEncontradoException;
import br.com.orginalapp.crud.service.PessoaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/pessoas")
	public List<Pessoa> getTodasPessoas() {
		return pessoaService.getTodasPessoas();
	}

	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> obterPessoaById(@PathVariable(value = "id") Long pessoaId)
			throws RecursoNaoEncontradoException {
		Pessoa pessoa = pessoaService.obterPessoaById(pessoaId);
		return ResponseEntity.ok().body(pessoa);
	}

	@PostMapping("/pessoas")
	public Pessoa criarPessoa(@Valid @RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}

	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable(value = "id") Long pessoaId,
			@Valid @RequestBody Pessoa pessoaDetalhes) throws RecursoNaoEncontradoException {
		
		Pessoa pessoa = pessoaService.obterPessoaById(pessoaId);
		pessoa.setNome(pessoaDetalhes.getNome());
		pessoa.setEmail(pessoaDetalhes.getEmail());		
		return ResponseEntity.ok(pessoaService.salvar(pessoa));
	}

	@DeleteMapping("/pessoas/{id}")
	public Map<String, Boolean> excluirPessoa(@PathVariable(value = "id") Long pessoaId)
			throws RecursoNaoEncontradoException {
		
		pessoaService.excluir(pessoaService.obterPessoaById(pessoaId));
		Map<String, Boolean> response = new HashMap<>();
		response.put("excluido", Boolean.TRUE);
		return response;
	}
}
