package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`department`")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "department_type_size", nullable = false, length = 45)
    private String departmentTypeSize;
    @Column(name = "city_name", nullable = false, length = 45)
    private String cityName;
    @Column(name = "number", nullable = false)
    private Integer number;
    @Column(name = "address", nullable = false, length = 45)
    private String address;

    public Department() {}

    public Department(String departmentTypeSize, String cityName, Integer number, String address) {
        this.departmentTypeSize = departmentTypeSize;
        this.cityName = cityName;
        this.number = number;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentTypeSize() {
        return departmentTypeSize;
    }

    public void setDepartmentTypeSize(String departmentTypeSize) {
        this.departmentTypeSize = departmentTypeSize;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (departmentTypeSize != null ? !departmentTypeSize.equals(that.departmentTypeSize) : that.departmentTypeSize != null)
            return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (departmentTypeSize != null ? departmentTypeSize.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id=" + id +
                ", departmentTypeSize='" + departmentTypeSize + '\'' +
                ", cityName='" + cityName + '\'' +
                ", number=" + number +
                ", address='" + address + '\'' +
                '}';
    }
}
