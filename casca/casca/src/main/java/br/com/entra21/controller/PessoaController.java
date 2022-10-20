package br.com.entra21.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.entra21.casca.casca.CascaApplication;
import br.com.entra21.model.ItemNivel3;
import br.com.entra21.model.Pessoa;

@RestController

@CrossOrigin(origins = "*")

@RequestMapping("/pessoas")
public class PessoaController {

	private final String PATH = "http://localhost:8080/pessoas";

	@GetMapping()

	@ResponseStatus(HttpStatus.OK)

	public List<Pessoa> listAll() {
		return obterListaCompleta();

	}

	private List<Pessoa> obterListaCompleta() {
		List<Pessoa> response = CascaApplication.pessoas.stream().toList();
		response.forEach(pessoa -> {
			setMaturidadeNivel3(pessoa);
		});
		return response;
	}

	private void setMaturidadeNivel3(Pessoa pessoa) {
		ArrayList<String> headers = new ArrayList();
		headers.add("Accept : application/json");
		headers.add("Content-type : application/json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		try {

			pessoa.setLinks(null);

			String json = mapper.writeValueAsString(pessoa);

			pessoa.setLinks(new ArrayList<>());

			pessoa.getLinks().add(new ItemNivel3("GET", PATH, null, null));

			pessoa.getLinks().add(new ItemNivel3("GET", PATH + "/" + pessoa.getName(), null, null));

			pessoa.getLinks().add(new ItemNivel3("POST", PATH, headers, json));

			pessoa.getLinks().add(new ItemNivel3("PUT", PATH + "/" + pessoa.getName(), headers, json));

		} catch (JsonProcessingException e) {

			e.printStackTrace();

		}

	}

}