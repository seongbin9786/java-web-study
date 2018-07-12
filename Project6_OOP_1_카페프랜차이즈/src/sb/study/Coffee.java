package sb.study;

public class Coffee {

	private String name;
	
	public Coffee(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object object) {
		Coffee another = (Coffee) object;
		
		return another.name.equals(name);
	}
}
