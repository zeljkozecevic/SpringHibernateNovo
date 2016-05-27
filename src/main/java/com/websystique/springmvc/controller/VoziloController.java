package com.websystique.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.websystique.springmvc.model.Energent;
import com.websystique.springmvc.model.Mesto;
import com.websystique.springmvc.model.Preduzece;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.Vozilo;
import com.websystique.springmvc.service.EnergentService;
import com.websystique.springmvc.service.PreduzeceService;
import com.websystique.springmvc.service.VoziloService;

@Controller
@RequestMapping("/vozilo")
public class VoziloController {
	
	@Autowired
	PreduzeceService servicePreduzece;
	
	@Autowired
	VoziloService serviceVozilo;
	
	@Autowired
	EnergentService serviceEnergent;
	
	@RequestMapping(value="/dodaj", method=RequestMethod.POST, params="sacuvaj")
	public String sacuvajVozilo(
			Model model, 
			@ModelAttribute Vozilo vozilo, 
			@RequestParam("preduzeceId") Integer preduzeceId,
			@RequestParam("energetici") Integer idEnergent
			){
		
		System.out.println("Ulazak u harEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEM");
		model.addAttribute("predId",preduzeceId);
		Preduzece preduzece = (Preduzece) servicePreduzece.findById(preduzeceId);
		
		System.out.println(preduzece.getNaziv());
		System.out.println(vozilo.getMarka());
		

		Energent en = (Energent) serviceEnergent.findById(idEnergent);
		
//		vozilo.setEmisionaKlasa(emisionaKlasa);
		System.out.println(en.getNaziv());
		

		
		vozilo.getEnergenti().add(en);
		en.getVozila().add(vozilo);
		
		// e pa stvarno
		
		
//		serviceVozilo.saveVozilo(vozilo);
		
//		preduzece.getVozila().add(vozilo);
//		vozilo.setPreduzece(preduzece);
		
		serviceVozilo.saveVozilo(vozilo);
		serviceEnergent.sacuvajEnergent(en);
//		Evo i komentara	fffffffffff ffff	
			
//		servicePreduzece.updatePreduzece(preduzece);
		

		return "vozilo_dodaj";
	}
	
	@RequestMapping(value="/dodaj", method=RequestMethod.POST, params="odustani")
	public String odustaniAzuriranje(Model model, @RequestParam("preduzeceId") Integer preduzeceId){
		
		System.out.println("Ulazak u PMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
		Preduzece preduzece = (Preduzece) servicePreduzece.findById(preduzeceId);
		model.addAttribute("preduzece", preduzece);
		return "preduzece_azuriranje";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="dodaj_vozilo")
	public String dodajAuto(Model model, @RequestParam("preduzeceId") Integer preduzeceId){
		
//		Preduzece preduzece = (Preduzece) servicePreduzece.findById(preduzeceId);
		model.addAttribute("predId", preduzeceId);
		return "vozilo_dodaj";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="nazad")
	public String nazadIzVozila(Model model, @RequestParam("preduzeceId") Integer preduzeceId){
		
		Preduzece preduzece = (Preduzece) servicePreduzece.findById(preduzeceId);
		model.addAttribute("preduzece", preduzece);
		return "preduzece_azuriranje";
	}
	
	
	
	@RequestMapping(value="/{voziloId}")
	public String pregledpreduzeca(Model model, @PathVariable("voziloId") int voziloId){

		System.out.println("PROOOOOOBA");
		model.addAttribute("vozilo", serviceVozilo.findById(voziloId));
		model.addAttribute("predId", serviceVozilo.findById(voziloId).getPreduzece().getPreduzeceId());
//		model.addAttribute("mesta",serviceVozilo.findAllVozilo());
		return "vozilo_azuriranje";
	}
	
	@RequestMapping(value="/azuriranje", method=RequestMethod.POST, params="sacuvaj")
	public String azurirajVozilo(Model model, @ModelAttribute Vozilo vozilo, @RequestParam("preduzeceId") Integer preduzeceId){
		
		serviceVozilo.updateVozilo(vozilo);
		
		Preduzece preduzece = (Preduzece) servicePreduzece.findById(preduzeceId);
		
		model.addAttribute("vozila", preduzece.getVozila());
		model.addAttribute("preduzece", preduzece);
		model.addAttribute("predId", preduzece.getPreduzeceId());
		
		
		
		return "vozila";
	}
	
	@RequestMapping(value="/azuriranje", method=RequestMethod.POST, params="odustani")
	public String odustaniAzurirajVozilo(Model model, @ModelAttribute Vozilo vozilo, @RequestParam("preduzeceId") Integer preduzeceId){
		
		Preduzece preduzece = (Preduzece) servicePreduzece.findById(preduzeceId);
		
		model.addAttribute("vozila", preduzece.getVozila());
		model.addAttribute("preduzece", preduzece);
		model.addAttribute("predId", preduzece.getPreduzeceId());
		
				
		return "vozila";
	}


}
