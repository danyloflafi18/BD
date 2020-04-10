package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`department_type`")
public class DepartmentType {
    @Id
    @Column(name = "size", nullable = false, length = 45)
    private String size;
    @Column(name = "max_weight", nullable = false)
    private Integer maxWeight;

    public DepartmentType() {}

    public DepartmentType(String size, Integer maxWeight) {
        this.size = size;
        this.maxWeight = maxWeight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentType that = (DepartmentType) o;

        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (maxWeight != null ? !maxWeight.equals(that.maxWeight) : that.maxWeight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = size != null ? size.hashCode() : 0;
        result = 31 * result + (maxWeight != null ? maxWeight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DepartmentTypeEntity{" +
                "size='" + size + '\'' +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
