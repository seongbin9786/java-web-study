package sb.study;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	public List<MenuItem> itemList = new ArrayList<>();
	
	public MenuItem findByName(String coffeeName) {
		for (MenuItem item : itemList) {
			if (item.getName().equals(coffeeName))
				return item;
		}
		return null;
	}

	public void addMenu(MenuItem menuItem) {
		itemList.add(menuItem);
	}
}
