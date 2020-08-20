package br.com.colaboradores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.colaboradores.models.ColaboradorModel;
import br.com.colaboradores.services.ColaboradorService;

@Controller
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;

	@RequestMapping("/colaboradores")
	public ModelAndView listagemColaborador() {

		ModelAndView mav = new ModelAndView("index");

		List<ColaboradorModel> colaboradores = service.listarColaboradores();

		mav.addObject("colaboradores", colaboradores);

		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cadastroColaborador")
	String cadastroColaborador() {

		return "/cadastro/cadastroColaborador";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cadastroColaborador")
	String formCadastroColaborador(ColaboradorModel model) {

		service.inserir(model);

		return "redirect:/colaboradores";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/editarColaborador")
	public String editarColaborador(@PathVariable(name = "id") Integer id) {

		return "editar/editarColaborador";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}/editarColaborador")
	public String alterarColaborador(@PathVariable(name = "id") Integer id, ColaboradorModel model) {

		service.alterar(model, id);

		return "redirect:/colaboradores";
	}

	@RequestMapping("/excluir")
	public String deletarColaborador(Integer id) {

		service.deletar(id);

		return "redirect:/colaboradores";
	}

}
