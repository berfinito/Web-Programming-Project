package sen3004.project.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import sen3004.project.model.Post;
import sen3004.project.service.MyService;
import sen3004.project.validator.CustomValidator;

@Controller
public class MyController {

	@Autowired
	MyService service;

	@Autowired
	CustomValidator validator;

	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@RequestMapping(value = { "/", "create.html" }, method = RequestMethod.GET)
	public ModelAndView displayForm() {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("post", new Post());
		return mv;
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ModelAndView processForm(@Valid @ModelAttribute Post post, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("post", post);

		if (result.hasErrors())
			mv.setViewName("form");
		else {
			mv.setViewName("result");
			service.create(post);
			mv.addObject("posts", service.findAll());
		}

		return mv;
	}

	/*@RequestMapping(value = {"/edit","create.html"}, method = RequestMethod.GET)
	public ModelAndView displayEditForm(Post post) {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("post", post);
		return mv;
	}*/

	@RequestMapping(value = {"/list-posts", "list.html"}, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("posts", service.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("result");
		service.delete(id);
		mv.addObject("posts", service.findAll());
			
		return mv;
	}

}
