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
    @OneToOne(mappedBy = "_product")
    FabricsToProductEntity _fabric;

    public ProductEntity() {
    }

    public ProductEntity(String name, FabricsToProductEntity fabrics) {
        _name = name;
        _fabric = fabrics;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_fabric, that._fabric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _fabric);
    }
}
