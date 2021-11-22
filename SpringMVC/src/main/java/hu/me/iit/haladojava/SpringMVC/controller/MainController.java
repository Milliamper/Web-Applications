package hu.me.iit.haladojava.SpringMVC.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hu.me.iit.haladojava.SpringMVC.service.MainService;
import hu.me.iit.haladojava.SpringMVC.service.SzamologepService;

@Controller // innen fogja tudni a SpringBootApplication osztály, hogy ez egy controller.//
			// Ezt a @ComponentSCan végzi
public class MainController {

	// bevezetett függőség. Azért final hogy ne tudja senki lecserélni
//	private final MainService mainService;
	private final SzamologepService szamologepService;

	public MainController(SzamologepService szamologepService) {
		super();
		this.szamologepService = szamologepService;
	}

	@ResponseBody
	@GetMapping("/hello") // ?nev=Márton
	String hello(@RequestParam String nev) {
		return "hello " + nev;
	}

//	@ResponseBody
//	@GetMapping("/mennyi") //?nev=Márton //visszaküldi a formot, user kitölti
//	String hello(@RequestParam int adat) {
//		return String.valueOf(mainService.mennyi(adat)); 
//	}

	// Ide bejön a kérés, és visszaad egy szimbolikus nevet, a szamologepFormot
	// Így megkeresi a html file-t, és visszaküldi a kliensnek
	@GetMapping("/szamologep")
	String szamologep() {
		return "szamologepForm";
	}

	@PostMapping("/szamologep") // A @Valid-al lehet azt elérni, hogy ne lehessen null a mező -> nem lehet
								// üresen elküldeni
	ModelAndView szamologepFeldolgozas(@Valid SzamologepRequestDTO dto, BindingResult result) {

		// A BindingResult be fogja engedni a megadott adatokat, akkor is ha rosszak, és
		// ellenörzi a @Valid DTO-t

		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) { // DTO-ban megadtuk a szabályokat, és az alapján vannak hibák:
			mav.setViewName("szamologepForm"); // Ha volt hiba visszaadjuk a formot, hogy töltse ki a user újra
		} else {

			String operator = dto.getOperator();

			switch (operator) {
			case "+":
				mav.addObject("eredmeny", szamologepService.osszead(dto.getA(), dto.getB()));
				break;
			case "-":
				mav.addObject("eredmeny", szamologepService.kivon(dto.getA(), dto.getB()));
				break;
			case "*":
				mav.addObject("eredmeny", szamologepService.szoroz(dto.getA(), dto.getB()));
				break;
			case "/":
				mav.addObject("eredmeny", szamologepService.oszt(dto.getA(), dto.getB()));
				break;
			}
			mav.setViewName("eredmeny");
		}

		return mav;
	}

}
