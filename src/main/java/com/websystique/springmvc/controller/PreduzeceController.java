package com.websystique.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.websystique.springmvc.model.Preduzece;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.Mesto;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.EnergentService;
import com.websystique.springmvc.service.MestoService;
import com.websystique.springmvc.service.PreduzeceService;
import com.websystique.springmvc.service.UserService;


@Controller
@RequestMapping("/preduzece")
public class PreduzeceController {
	
	@Autowired
	PreduzeceService servicePreduzece;
	
	@Autowired
	MestoService serviceMesto;
	
	@Autowired
	UserService serviceUser;
	
	@Autowired
	EnergentService serviceEnergent;
	
	
	/*
	 * metoda koja poziva view za azuriranje
	 * 
	 * 
	 */
	@RequestMapping(value="/{preduzeceId}")
	public String pregledpreduzeca(Model model, @PathVariable("preduzeceId") int preduzeceId){
		model.addAttribute("preduzece", servicePreduzece.findById(preduzeceId));
		model.addAttribute("mesta",serviceMesto.findAllMesto());
		return "preduzece_azuriranje";
	}
	
	/*
	 * metoda za prikaz preduzeca na view "preduzeca"
	 * 
	 */
	
	@RequestMapping(method=RequestMethod.GET)
	public String prikaziPreduzece(Model model){
		System.out.println("invoking prikaziPreduzece");
		List <Preduzece> preduzeca = servicePreduzece.findAllPreduzece();
		for (Preduzece pred : preduzeca) {
			System.out.println(pred);
		}
		model.addAttribute("preduzeca",servicePreduzece.findAllPreduzece());
		return "preduzeca";
	}
	
	/* dodatni komentar
	 * metoda za pretragu preduzeca na view "preduzeca"
	 */
	
	@RequestMapping(method=RequestMethod.POST)
	public String nadjiPreduzece(Model model, @RequestParam("naziv") String naziv){
		System.out.println("invoking nadjiPreduzece");
		model.addAttribute("preduzeca",servicePreduzece.findPreduzeceBy("%"+naziv+"%"));
		return "preduzeca";
	}
	
	/*
	 * iz view-a "preduzeca" salje na "preduzece_dodaj"
	 * 
	 */
	
	@RequestMapping(method=RequestMethod.POST, params="dodaj")
	public String nadjiPreduzece(Model model){
		System.out.println("invoking dodajPreduzece");
		model.addAttribute("mesta",serviceMesto.findAllMesto());
		return "preduzece_dodaj";
	}
	
	/*
	 * odustajanje sa view-a preduzece_dodaj
	 * 
	 */
	@RequestMapping(value="/dodaj", method=RequestMethod.POST, params="odustani")
	public String odustaniPreduzece(){
				
		return "redirect:/preduzece";
	}	
	/*
	 * dodavanje novog preduzeca u view dodaj_preduzece
	 * 
	 */
	
	@RequestMapping(value="/dodaj", method=RequestMethod.POST)
	public String sacuvajPreduzece(@ModelAttribute Preduzece preduzece, @ModelAttribute User user,  @RequestParam("type") Integer idMesto){
		
		System.out.println("invoking sacuvajPreduzece");
		System.out.println("invoking sacuvajMesto");
		System.out.println(idMesto);
		System.out.println(preduzece.getNaziv());
		Mesto mesto = (Mesto) serviceMesto.findById(idMesto);
		System.out.println(mesto.getNazivMesta());
		System.out.println(user.getFirstName());
		
		preduzece.setUser(user);
		user.getPreduzece().add(preduzece);
		preduzece.setMesto(mesto);
//		mesto.getPreduzeca().add(preduzece);
//		serviceMesto.saveMesto(mesto);
		serviceUser.saveUser(user);
		servicePreduzece.savePreduzece(preduzece);
		

		return "redirect:/preduzece";
	}
	/*
	 * 
	 * odustajanje sa azuriranja preduzeca
	 */
	@RequestMapping(value="/azuriranje", method=RequestMethod.POST, params="odustani")
	public String odustaniAzuriranje(){
				
		return "redirect:/preduzece";
	}
	
	/*
	 * snimanje novog preduzeca
	 * 
	 */
	@RequestMapping(value="/azuriranje", method=RequestMethod.POST, params="sacuvaj")
	public String sacuvajPreduzeceAzur(@ModelAttribute Preduzece preduzece, @ModelAttribute User user,  @RequestParam("type") Integer idMesto){
		
		System.out.println("invoking sacuvajPreduzece");
		System.out.println("invoking sacuvajMesto");
		System.out.println(idMesto);
		System.out.println(preduzece.getNaziv());
		Mesto mesto = (Mesto) serviceMesto.findById(idMesto);
		System.out.println(mesto.getNazivMesta());
		System.out.println(user.getFirstName());
		
		preduzece.setUser(user);
		user.getPreduzece().add(preduzece);
		preduzece.setMesto(mesto);
//		mesto.getPreduzeca().add(preduzece);
//		serviceMesto.saveMesto(mesto);
		serviceUser.updateUser(user);
		servicePreduzece.updatePreduzece(preduzece);
		

		return "redirect:/preduzece";
	}
	
	/*
	 * brisanje preduzeca
	 * 
	 * 
	 */
	@RequestMapping(value="/azuriranje", method=RequestMethod.POST, params="obrisi")
	public String obrisiPreduzeceAzur(@ModelAttribute Preduzece preduzece){
		
		System.out.println("invoking obrisiPreduzece");
		
		System.out.println(preduzece.getNaziv());
		System.out.println("Id preduzeca koje se brise je: " + preduzece.getPreduzeceId());
		
		servicePreduzece.deletePreduzeceById(preduzece.getPreduzeceId());
		
		return "redirect:/preduzece";
	}
	
	/*
	 * slanje na formu za dodavanje vozila preduzecu
	 * 
	 */
	
	@RequestMapping(value="/azuriranje", method=RequestMethod.POST, params="dodaj_vozilo")
	public String dodajVozilo(Model model, @RequestParam("preduzeceId") Integer preduzeceId){
		model.addAttribute("predId", preduzeceId);
		model.addAttribute("energenti", serviceEnergent.findAllEnergent());
		return "vozilo_dodaj";
	}
	
	/*
	 * 
	 * prikazivanje svih vozila u preduzecu
	 * 
	 */
	
	@RequestMapping(value="/azuriranje", method=RequestMethod.POST, params="prikazi_vozila")
	public String prikaziVozila(Model model, @RequestParam("preduzeceId") Integer preduzeceId){
		
		Preduzece preduzece = (Preduzece) servicePreduzece.findById(preduzeceId);
		
		model.addAttribute("vozila", preduzece.getVozila());
		model.addAttribute("preduzece", preduzece);
		model.addAttribute("predId", preduzece.getPreduzeceId());
		return "vozila";
	}
	
	

}
