package fr.carbon.textile.score.api.database.entity.market_information;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Product")
@Table(name = "`Product`", schema = "`MarketInformation`", catalog = "postgres")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`", nullable = false)
    private int _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @OneToMany(mappedBy = "_fabric")
    List<FabricsToProductEntity> _fabrics = new ArrayList<>();

    public ProductEntity() {
    }

    public ProductEntity(String _name, List<FabricsToProductEntity> fabrics) {
        this._name = _name;
        this._fabrics = fabrics;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public List<FabricsToProductEntity> getFabrics() {
        return _fabrics;
    }

    public void setFabrics(List<FabricsToProductEntity> fabrics) {
        this._fabrics = fabrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return _id == that._id && Objects.equals(_name, that._name) && Objects.equals(_fabrics, that._fabrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _fabrics);
    }
}
