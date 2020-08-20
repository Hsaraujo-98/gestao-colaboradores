package br.com.colaboradores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.colaboradores.models.ColaboradorModel;
import br.com.colaboradores.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public List<ColaboradorModel> listarColaboradores() {

		return repository.findAll();
	}

	public ColaboradorModel consultarColaborador(Integer id) {

		return repository.findById(id).orElseThrow(RuntimeException::new);
	}

	public ColaboradorModel inserir(ColaboradorModel model) {

		ColaboradorModel colaborador = new ColaboradorModel(model.getNome(), model.getCargo(), model.getEmail());

		return repository.save(colaborador);
	}

	public ColaboradorModel alterar(ColaboradorModel model, Integer id) {

		ColaboradorModel colaborador = consultarColaborador(id);

		colaborador.editar(model);

		return repository.save(colaborador);
	}

	public void deletar(Integer id) {

		ColaboradorModel colaborador = consultarColaborador(id);

		repository.delete(colaborador);
	}

}
