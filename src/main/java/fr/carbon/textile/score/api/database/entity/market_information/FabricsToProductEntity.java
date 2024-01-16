package fr.carbon.textile.score.api.database.entity.market_information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "FabricToProduct")
@Table(name = "`FabricsToProduct`", schema = "`MarketInformation`", catalog = "postgres")
public class FabricsToProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @OneToOne
    @JoinColumn(name = "`ProductId`", nullable = false)
    private ProductEntity _product;
    @ManyToOne
    @JoinColumn(name = "`FabricId`", nullable = false)
    private FabricEntity _fabric;

    public FabricsToProductEntity() {
    }

    public FabricsToProductEntity(ProductEntity product, FabricEntity fabric) {
        _product = product;
        _fabric = fabric;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public ProductEntity getProduct() {
        return _product;
    }

    public void setProduct(ProductEntity product) {
        _product = product;
    }

    public FabricEntity getFabric() {
        return _fabric;
    }

    public void setFabric(FabricEntity fabric) {
        _fabric = fabric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FabricsToProductEntity that = (FabricsToProductEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_product, that._product) &&
                Objects.equals(_fabric, that._fabric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _product, _fabric);
    }
}
