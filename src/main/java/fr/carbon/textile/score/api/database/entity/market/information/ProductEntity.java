package fr.carbon.textile.score.api.database.entity.market.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Product")
@Table(name = "`Product`", schema = "`MarketInformation`", catalog = "postgres")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`Area`", nullable = false, precision = 4)
    private double _area;
    @Basic
    @Column(name = "`IsSecondHand`", nullable = false)
    private boolean _isSecondHand = false;
    @Basic
    @Column(name = "`IsSold`", nullable = false)
    private boolean _isSold = false;
    @OneToOne
    @JoinColumn(name = "`ProductTypeId`", nullable = false)
    ProductTypeEntity _productType;
    @OneToOne(mappedBy = "_product")
    private FabricsToProductEntity _fabric;

    public ProductEntity() {
    }

    public ProductEntity(
            String name,
            Double area,
            boolean isSecondHand,
            FabricsToProductEntity fabric,
            ProductTypeEntity productType
    ) {
        _name = name;
        _area = area;
        _isSecondHand = isSecondHand;
        _fabric = fabric;
        _productType = productType;
    }

    public int getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public FabricsToProductEntity getFabric() {
        return _fabric;
    }

    public void setFabric(FabricsToProductEntity fabric) {
        _fabric = fabric;
    }

    public double getArea() {
        return _area;
    }

    public void setArea(double area) {
        _area = area;
    }

    public boolean isSecondHand() {
        return _isSecondHand;
    }

    public void setSecondHand(boolean secondHand) {
        _isSecondHand = secondHand;
    }

    public boolean isSold() {
        return _isSold;
    }

    public void setSold(boolean sold) {
        _isSold = sold;
    }

    public ProductTypeEntity getProductType() {
        return _productType;
    }

    public void setProductType(ProductTypeEntity productType) {
        _productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Double.compare(_area, that._area) == 0 &&
                _isSecondHand == that._isSecondHand &&
                _isSold == that._isSold &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_productType, that._productType) &&
                Objects.equals(_fabric, that._fabric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _area, _isSecondHand, _isSold, _productType, _fabric);
    }
}
