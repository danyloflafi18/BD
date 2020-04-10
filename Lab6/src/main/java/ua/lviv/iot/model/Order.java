package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "from_department_id", nullable = false)
    private Integer fromDepartmentId;
    @Column(name = "to_department_id", nullable = false)
    private Integer toDepartmentId;
    @Column(name = "from_operator_id", nullable = false)
    private Integer fromOperatorId;
    @Column(name = "to_operator_id", nullable = false)
    private Integer toOperatorId;
    @Column(name = "from_courier_id", nullable = true)
    private Integer fromCourierId;
    @Column(name = "to_courier_id", nullable = true)
    private Integer toCourierId;
    @Column(name = "from_client_id", nullable = false)
    private Integer fromClientId;
    @Column(name = "to_client_id", nullable = false)
    private Integer toClientId;
    @Column(name = "delivery_price", nullable = false)
    private BigDecimal deliveryPrice;
    @Column(name = "product_price", nullable = true)
    private BigDecimal productPrice;
    @Column(name = "weight", nullable = false)
    private Integer weight;
    @Column(name = "sending_date", nullable = false)
    private Date sendingDate;
    @Column(name = "approximate_arrival_date", nullable = false)
    private Date approximateArrivalDate;
    @Column(name = "fixed_arrival_date", nullable = true)
    private Date fixedArrivalDate;

    public Order() {}

    public Order(Integer fromDepartmentId, Integer toDepartmentId, Integer fromOperatorId, Integer toOperatorId,
                 Integer fromCourierId, Integer toCourierId, Integer fromClientId, Integer toClientId,
                 BigDecimal deliveryPrice, BigDecimal productPrice, Integer weight, Date sendingDate,
                 Date approximateArrivalDate, Date fixedArrivalDate) {
        this.fromDepartmentId = fromDepartmentId;
        this.toDepartmentId = toDepartmentId;
        this.fromOperatorId = fromOperatorId;
        this.toOperatorId = toOperatorId;
        this.fromCourierId = fromCourierId;
        this.toCourierId = toCourierId;
        this.fromClientId = fromClientId;
        this.toClientId = toClientId;
        this.deliveryPrice = deliveryPrice;
        this.productPrice = productPrice;
        this.weight = weight;
        this.sendingDate = sendingDate;
        this.approximateArrivalDate = approximateArrivalDate;
        this.fixedArrivalDate = fixedArrivalDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromDepartmentId() {
        return fromDepartmentId;
    }

    public void setFromDepartmentId(Integer fromDepartmentId) {
        this.fromDepartmentId = fromDepartmentId;
    }

    public Integer getToDepartmentId() {
        return toDepartmentId;
    }

    public void setToDepartmentId(Integer toDepartmentId) {
        this.toDepartmentId = toDepartmentId;
    }

    public Integer getFromOperatorId() {
        return fromOperatorId;
    }

    public void setFromOperatorId(Integer fromOperatorId) {
        this.fromOperatorId = fromOperatorId;
    }

    public Integer getToOperatorId() {
        return toOperatorId;
    }

    public void setToOperatorId(Integer toOperatorId) {
        this.toOperatorId = toOperatorId;
    }

    public Integer getFromCourierId() {
        return fromCourierId;
    }

    public void setFromCourierId(Integer fromCourierId) {
        this.fromCourierId = fromCourierId;
    }

    public Integer getToCourierId() {
        return toCourierId;
    }

    public void setToCourierId(Integer toCourierId) {
        this.toCourierId = toCourierId;
    }

    public Integer getFromClientId() {
        return fromClientId;
    }

    public void setFromClientId(Integer fromClientId) {
        this.fromClientId = fromClientId;
    }

    public Integer getToClientId() {
        return toClientId;
    }

    public void setToClientId(Integer toClientId) {
        this.toClientId = toClientId;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public Date getApproximateArrivalDate() {
        return approximateArrivalDate;
    }

    public void setApproximateArrivalDate(Date approximateArrivalDate) {
        this.approximateArrivalDate = approximateArrivalDate;
    }

    public Date getFixedArrivalDate() {
        return fixedArrivalDate;
    }

    public void setFixedArrivalDate(Date fixedArrivalDate) {
        this.fixedArrivalDate = fixedArrivalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fromDepartmentId != null ? !fromDepartmentId.equals(that.fromDepartmentId) : that.fromDepartmentId != null)
            return false;
        if (toDepartmentId != null ? !toDepartmentId.equals(that.toDepartmentId) : that.toDepartmentId != null)
            return false;
        if (fromOperatorId != null ? !fromOperatorId.equals(that.fromOperatorId) : that.fromOperatorId != null)
            return false;
        if (toOperatorId != null ? !toOperatorId.equals(that.toOperatorId) : that.toOperatorId != null) return false;
        if (fromCourierId != null ? !fromCourierId.equals(that.fromCourierId) : that.fromCourierId != null)
            return false;
        if (toCourierId != null ? !toCourierId.equals(that.toCourierId) : that.toCourierId != null) return false;
        if (fromClientId != null ? !fromClientId.equals(that.fromClientId) : that.fromClientId != null) return false;
        if (toClientId != null ? !toClientId.equals(that.toClientId) : that.toClientId != null) return false;
        if (deliveryPrice != null ? !deliveryPrice.equals(that.deliveryPrice) : that.deliveryPrice != null)
            return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (sendingDate != null ? !sendingDate.equals(that.sendingDate) : that.sendingDate != null) return false;
        if (approximateArrivalDate != null ? !approximateArrivalDate.equals(that.approximateArrivalDate) : that.approximateArrivalDate != null)
            return false;
        if (fixedArrivalDate != null ? !fixedArrivalDate.equals(that.fixedArrivalDate) : that.fixedArrivalDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fromDepartmentId != null ? fromDepartmentId.hashCode() : 0);
        result = 31 * result + (toDepartmentId != null ? toDepartmentId.hashCode() : 0);
        result = 31 * result + (fromOperatorId != null ? fromOperatorId.hashCode() : 0);
        result = 31 * result + (toOperatorId != null ? toOperatorId.hashCode() : 0);
        result = 31 * result + (fromCourierId != null ? fromCourierId.hashCode() : 0);
        result = 31 * result + (toCourierId != null ? toCourierId.hashCode() : 0);
        result = 31 * result + (fromClientId != null ? fromClientId.hashCode() : 0);
        result = 31 * result + (toClientId != null ? toClientId.hashCode() : 0);
        result = 31 * result + (deliveryPrice != null ? deliveryPrice.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (sendingDate != null ? sendingDate.hashCode() : 0);
        result = 31 * result + (approximateArrivalDate != null ? approximateArrivalDate.hashCode() : 0);
        result = 31 * result + (fixedArrivalDate != null ? fixedArrivalDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", fromDepartmentId=" + fromDepartmentId +
                ", toDepartmentId=" + toDepartmentId +
                ", fromOperatorId=" + fromOperatorId +
                ", toOperatorId=" + toOperatorId +
                ", fromCourierId=" + fromCourierId +
                ", toCourierId=" + toCourierId +
                ", fromClientId=" + fromClientId +
                ", toClientId=" + toClientId +
                ", deliveryPrice=" + deliveryPrice +
                ", productPrice=" + productPrice +
                ", weight=" + weight +
                ", sendingDate=" + sendingDate +
                ", approximateArrivalDate=" + approximateArrivalDate +
                ", fixedArrivalDate=" + fixedArrivalDate +
                '}';
    }
}
