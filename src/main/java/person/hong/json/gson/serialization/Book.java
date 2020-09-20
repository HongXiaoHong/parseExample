package person.hong.json.gson.serialization;

import java.util.Arrays;
/**
 * 我们需要将其序列化为下面这个 JSON 对象
{
  "title": "Java Puzzlers: Traps, Pitfalls, and Corner Cases",
  "isbn-10": "032133678X",
  "isbn-13": "978-0321336781",
  "authors": [
    "Joshua Bloch",
    "Neal Gafter"
  ]
}
 * @author 洪晓鸿     
 * @date   2019年4月27日 下午2:39:41   
 * @version V1.0
 */
public class Book {

	private String[] authors;
	private String isbn10;
	private String isbn13;
	private String title;
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public String getIsbn10() {
		return isbn10;
	}
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [authors=" + Arrays.toString(authors) + ", isbn10=" + isbn10 + ", isbn13=" + isbn13 + ", title="
				+ title + "]";
	}
	
}
