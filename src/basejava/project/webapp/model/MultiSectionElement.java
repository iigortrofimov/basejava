package basejava.project.webapp.model;

public class MultiSectionElement {
    private String title;
    private String period;
    private String text;
    private Link link;

    public MultiSectionElement(String title, String period, String text, Link link) {
        this.title = title;
        this.period = period;
        this.text = text;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultiSectionElement that = (MultiSectionElement) o;

        if (!title.equals(that.title)) return false;
        if (!period.equals(that.period)) return false;
        if (!text.equals(that.text)) return false;
        return link != null ? link.equals(that.link) : that.link == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + period.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MultiSectionElement{" +
                "title='" + title + '\'' +
                ", period='" + period + '\'' +
                ", text='" + text + '\'' +
                ", link=" + link +
                '}';
    }
}
