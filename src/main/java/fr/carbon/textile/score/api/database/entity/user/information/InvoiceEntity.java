package fr.carbon.textile.score.api.database.entity.user.information;

import fr.carbon.textile.score.api.database.entity.market.information.ProductTypeEntity;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "Invoice")
@Table(name = "`Invoice`", schema = "`UserInformation`", catalog = "postgres")
public class InvoiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Date`", nullable = false)
    private Timestamp _date;
    @Basic
    @Column(name = "`Quota`", nullable = false)
    private int _quota;
    @Basic
    @Column(name = "`ProductPrice`", nullable = false, precision = 4)
    private double _productPrice;
    @ManyToOne
    @JoinColumn(name = "`UserId`", nullable = false)
    private UserEntity _user;
    @OneToOne
    @JoinColumn(name = "`ProductTypeId`", nullable = false)
    private ProductTypeEntity _productType;

    public InvoiceEntity() {
    }

    public InvoiceEntity(
            Timestamp date, int quota, UserEntity user, ProductTypeEntity productType, double productPrice
    ) {
        _date = date;
        _quota = quota;
        _user = user;
        _productType = productType;
        _productPrice = productPrice;
    }

    public int getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public Timestamp getDate() {
        return _date;
    }

    public void setDate(Timestamp date) {
        _date = date;
    }

    public int getQuota() {
        return _quota;
    }

    public void setQuota(int quota) {
        _quota = quota;
    }

    public UserEntity getUser() {
        return _user;
    }

    public void setUser(UserEntity userId) {
        _user = userId;
    }

    public ProductTypeEntity getProductType() {
        return _productType;
    }

    public void setProductType(ProductTypeEntity productType) {
        _productType = productType;
    }

    public double getProductPrice() {
        return _productPrice;
    }

    public void setProductPrice(double productPrice) {
        _productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity entity = (InvoiceEntity) o;
        return _quota == entity._quota &&
                Double.compare(_productPrice, entity._productPrice) == 0 &&
                Objects.equals(_id, entity._id) &&
                Objects.equals(_date, entity._date) &&
                Objects.equals(_user, entity._user) &&
                Objects.equals(_productType, entity._productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _date, _quota, _productPrice, _user, _productType);
    }
}
