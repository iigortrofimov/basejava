package basejava.project.webapp.model;

import java.util.List;

public class MultiSection implements Section {
    private String title;
    private List<MultiSectionElement> elementList;

    public MultiSection(String title, List<MultiSectionElement> elementList) {
        this.title = title;
        this.elementList = elementList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MultiSectionElement> getElementList() {
        return elementList;
    }

    public void setElementList(List<MultiSectionElement> elementList) {
        this.elementList = elementList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultiSection that = (MultiSection) o;

        if (!title.equals(that.title)) return false;
        return elementList.equals(that.elementList);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + elementList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MultiSection{" +
                "title='" + title + '\'' +
                ", elementList=" + elementList +
                '}';
    }
}
