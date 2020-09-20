package person.hong.json.gson.deserialization;

import java.util.Arrays;

/**
 * 我们需要将其序列化为下面这个 JSON 对象
 * {
 * "title": "Java Puzzlers: Traps, Pitfalls, and Corner Cases",
 * "isbn": "032133678X",
 * "authors": [
 * {
 * "id": 1,
 * "name": "Joshua Bloch"
 * },
 * {
 * "id": 2,
 * "name": "Neal Gafter"
 * }
 * ]
 * }
 *
 * @author 洪晓鸿
 * @version V1.0
 * @date 2019年4月27日 下午2:39:41
 */
public class EBook {

    private Author[] authors;
    private String isbn;
    private String title;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "EBook [authors=" + Arrays.toString(authors) + ", isbn=" + isbn + ", title=" + title + "]";
    }

}
