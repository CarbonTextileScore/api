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
    private Double _area;
    @Basic
    @Column(name = "`IsSecondHand`", nullable = false)
    private boolean _isSecondHand = false;
    @OneToOne(mappedBy = "_product")
    private FabricsToProductEntity _fabric;

    public ProductEntity() {
    }

    public ProductEntity(
            String name,
            Double area,
            boolean isSecondHand,
            FabricsToProductEntity fabric
    ) {
        _name = name;
        _area = area;
        _isSecondHand = isSecondHand;
        _fabric = fabric;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
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

    public Double getArea() {
        return _area;
    }

    public void setArea(Double area) {
        _area = area;
    }

    public boolean isSecondHand() {
        return _isSecondHand;
    }

    public void setSecondHand(boolean secondHand) {
        _isSecondHand = secondHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return _isSecondHand == that._isSecondHand &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_area, that._area) &&
                Objects.equals(_fabric, that._fabric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _area, _isSecondHand, _fabric);
    }
}
