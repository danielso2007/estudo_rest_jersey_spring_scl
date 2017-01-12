package br.com.scl.domain;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = -788018586220029981L;

    public enum StatusBookEnum {

        PUBLISHED("PUBLISHED"), DRAFT("DRAFT");

        private String description;

        StatusBookEnum(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

    }

    private Long id;
    private String title;
    private String description;
    private String author;
    private Long totalPage;
    private String isbn;
    private StatusBookEnum status;
    private String yearPublished;
    private String coverUrl;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public StatusBookEnum getStatus() {
        return status;
    }

    public void setStatus(StatusBookEnum status) {
        this.status = status;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getId() != null ? !getId().equals(book.getId()) : book.getId() != null) return false;
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        if (getDescription() != null ? !getDescription().equals(book.getDescription()) : book.getDescription() != null)
            return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        if (getTotalPage() != null ? !getTotalPage().equals(book.getTotalPage()) : book.getTotalPage() != null)
            return false;
        if (getIsbn() != null ? !getIsbn().equals(book.getIsbn()) : book.getIsbn() != null) return false;
        if (getStatus() != book.getStatus()) return false;
        if (getYearPublished() != null ? !getYearPublished().equals(book.getYearPublished()) : book.getYearPublished() != null)
            return false;
        return getCoverUrl() != null ? getCoverUrl().equals(book.getCoverUrl()) : book.getCoverUrl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getTotalPage() != null ? getTotalPage().hashCode() : 0);
        result = 31 * result + (getIsbn() != null ? getIsbn().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getYearPublished() != null ? getYearPublished().hashCode() : 0);
        result = 31 * result + (getCoverUrl() != null ? getCoverUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", totalPage=" + totalPage +
                ", isbn='" + isbn + '\'' +
                ", status=" + status +
                ", yearPublished='" + yearPublished + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                '}';
    }
}
