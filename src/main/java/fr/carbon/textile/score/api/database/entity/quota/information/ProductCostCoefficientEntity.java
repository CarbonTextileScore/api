package fr.carbon.textile.score.api.database.entity.quota.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "ProductCostCoefficient")
@Table(name = "`ProductCostCoefficient`", schema = "`QuotaInformation`", catalog = "postgres")
public class ProductCostCoefficientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`PenaltyCoefficient`", nullable = false, precision = 4)
    private double _penaltyCoefficient;

    public ProductCostCoefficientEntity() {
    }

    public ProductCostCoefficientEntity(
            String name,
            double penaltyCoefficient
    ) {
        this._name = name;
        this._penaltyCoefficient = penaltyCoefficient;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public double getPenaltyCoefficient() {
        return _penaltyCoefficient;
    }

    public void setPenaltyCoefficient(double penaltyCoefficient) {
        this._penaltyCoefficient = penaltyCoefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCostCoefficientEntity that = (ProductCostCoefficientEntity) o;
        return Double.compare(_penaltyCoefficient, that._penaltyCoefficient) == 0 &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _penaltyCoefficient);
    }
}
