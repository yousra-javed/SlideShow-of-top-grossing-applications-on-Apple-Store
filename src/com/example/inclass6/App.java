package com.example.inclass6;

public class App {
String name, category,price,summary,link;

public App() {
	super();
	// TODO Auto-generated constructor stub
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getSummary() {
	return summary;
}

public void setSummary(String summary) {
	this.summary = summary;
}

public String getLink() {
	return link;
}

public void setLink(String link) {
	this.link = link;
}

@Override
public String toString() {
	return "App [name=" + name + ", category=" + category + ", price=" + price
			+ ", summary=" + summary + ", link=" + link + "]";
}


}
