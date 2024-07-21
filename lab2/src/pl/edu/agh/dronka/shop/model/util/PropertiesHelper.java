package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.Book;
import pl.edu.agh.dronka.shop.model.items.Electronics;
import pl.edu.agh.dronka.shop.model.items.Food;
import pl.edu.agh.dronka.shop.model.items.Music;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		switch (item.getCategory()) {
			case BOOKS -> {
				Book book = (Book)item;
				propertiesMap.put("Liczba stron", book.getPagesNo());
				propertiesMap.put("Twarda okładna", book.getHasHardcover());
			}
			case ELECTRONICS -> {
				Electronics electronics = (Electronics)item;
				propertiesMap.put("Urządzenie mobilne", electronics.getIsMobile());
				propertiesMap.put("Gwarancja", electronics.getHasWarranty());
			}
			case FOOD -> {
				Food food = (Food)item;
				propertiesMap.put("Spożyć do", food.getExpirationDate());
			}
			case MUSIC -> {
				Music music = (Music)item;
				propertiesMap.put("Gatunek", music.getGenre().getRepr());
				propertiesMap.put("Dołączone video", music.hasVideo());
			}
		}
		
		return propertiesMap;
	}
}
