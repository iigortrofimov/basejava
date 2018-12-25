package basejava.project.webapp.model;

public class TextSection implements Section {
    private String title;
    private String text;

    public TextSection(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        if (!title.equals(that.title)) return false;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
