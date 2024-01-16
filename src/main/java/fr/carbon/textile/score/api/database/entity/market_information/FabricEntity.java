package fr.carbon.textile.score.api.database.entity.market_information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Fabric")
@Table(name = "`Fabric`", schema = "`MarketInformation`", catalog = "postgres")
public class FabricEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`", nullable = false)
    private int _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`CostPerGram`", nullable = false)
    private int _costPerGram;

    public FabricEntity() {
    }

    public FabricEntity(String name, int costPerGram) {
        this._name = name;
        this._costPerGram = costPerGram;
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

    public int getCostPerGram() {
        return _costPerGram;
    }

    public void setCostPerGram(int costPerGram) {
        this._costPerGram = costPerGram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FabricEntity that = (FabricEntity) o;
        return _id == that._id && _costPerGram == that._costPerGram && Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _costPerGram);
    }
}
