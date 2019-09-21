package com.stockagent.service;

import java.util.ArrayList;
import java.text.Normalizer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockagent.model.Product;
import com.stockagent.repository.ProductRepository;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> searchProduct(String name) {
		
		List<Product> products = productRepository.findAll();
		List<Product> productsSelection = new ArrayList<>();
		String namedb;
		String categorydb;
		String manufacturerdb;
		String namesearch;
		namesearch = stripAccents(name.toLowerCase());
		String[] wordsnamesearch = namesearch.split("\\s+");
		for (Product p : products) {
			namedb = stripAccents(p.getName().toLowerCase());
			String[] wordsnamedb = namedb.split("\\s+");

			for (int i = 0; i < wordsnamedb.length; i++) {
				for (int j = 0; j < wordsnamesearch.length; j++) {
					if (wordsnamedb[i].startsWith(wordsnamesearch[j])) {
						int rep = 0;
						for (Product p2 : productsSelection) {
							if (p.getId() == p2.getId()) {
								rep++;
							}
						}
						if (rep == 0) {
							productsSelection.add(p);
						}
					}
				}
			}
			

			categorydb = stripAccents(p.getCategory().getName().toLowerCase());
			String[] wordscategorydb = categorydb.split("\\s+");
			for (int i = 0; i < wordscategorydb.length; i++) {
				for (int j = 0; j < wordsnamesearch.length; j++) {
					if (wordscategorydb[i].startsWith(wordsnamesearch[j])) {
						int rep = 0;
						for (Product p2 : productsSelection) {
							if (p.getId() == p2.getId()) {
								rep++;
							}
						}
						if (rep == 0) {
							productsSelection.add(p);
						}
					}
				}
			}
			manufacturerdb = stripAccents(p.getManufacturer().toLowerCase());
			String[] wordsmanufacturerdb = manufacturerdb.split("\\s+");
			for (int i = 0; i < wordsmanufacturerdb.length; i++) {
				for (int j = 0; j < wordsnamesearch.length; j++) {
					if (wordsmanufacturerdb[i].startsWith(wordsnamesearch[j])) {
						int rep = 0;

						for (Product p2 : productsSelection) {
							if (p.getId() == p2.getId()) {
								rep++;
							}
						}
						if (rep == 0) {
							productsSelection.add(p);
						}
					}
				}
			}
		}
		return productsSelection;
	}
	
	
	public static String stripAccents(String input) {
		return input == null ? null
				: Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}
