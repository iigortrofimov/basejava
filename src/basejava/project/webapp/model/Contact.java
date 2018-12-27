package basejava.project.webapp.model;

public class Contact {

    private String text;
    private Link link;

    public Contact(String text, Link link) {
        this.text = text;
        this.link = link;
    }

    public Contact(String text) {
        this.text = text;
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

        Contact contact = (Contact) o;

        if (text != null ? !text.equals(contact.text) : contact.text != null) return false;
        return link != null ? link.equals(contact.link) : contact.link == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "text='" + text + '\'' +
                ", link=" + link +
                '}';
    }
}
