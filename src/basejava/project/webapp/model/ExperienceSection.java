package basejava.project.webapp.model;

import java.util.List;
import java.util.Objects;

public class ExperienceSection implements Section {
    private List<Experience> elementList;

    public ExperienceSection(List<Experience> elementList) {
        Objects.requireNonNull(elementList, "experience must not be null");
        this.elementList = elementList;
    }

    public List<Experience> getElementList() {
        return elementList;
    }

    public void setElementList(List<Experience> elementList) {
        this.elementList = elementList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceSection that = (ExperienceSection) o;

        return elementList.equals(that.elementList);
    }

    @Override
    public int hashCode() {
        return elementList.hashCode();
    }

    @Override
    public String toString() {
        return "ExperienceSection{" +
                "elementList=" + elementList +
                '}';
    }
}
