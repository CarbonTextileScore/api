package fr.carbon.textile.score.api.database.entity.market.information;

import fr.carbon.textile.score.api.database.entity.user.information.CountryEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Fabric")
@Table(name = "`Fabric`", schema = "`MarketInformation`", catalog = "postgres")
public class FabricEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`WaterConsumptionCubicCentimeterPerGram`", nullable = false, precision = 4)
    private double _waterConsumptionCubicCentimeterPerGram;
    @Basic
    @Column(name = "`KilogramCO2EquivalentPerSquareMetre`", nullable = false, precision = 4)
    private double _kilogramCO2EquivalentPerSquareMetre;
    @OneToOne
    @JoinColumn(name = "`FabricAnimalOriginId`", nullable = false)
    private FabricAnimalOriginEntity _fabricAnimalOrigin;
    @OneToOne
    @JoinColumn(name = "`CountryId`", nullable = false)
    private CountryEntity _country;

    public FabricEntity() {
    }

    public FabricEntity(
            String name,
            double waterConsumptionCubicCentimeterPerGram,
            double kilogramCO2EquivalentPerSquareMetre,
            FabricAnimalOriginEntity fabricAnimalOrigin,
            CountryEntity country
    ) {
        _name = name;
        _waterConsumptionCubicCentimeterPerGram = waterConsumptionCubicCentimeterPerGram;
        _kilogramCO2EquivalentPerSquareMetre = kilogramCO2EquivalentPerSquareMetre;
        _fabricAnimalOrigin = fabricAnimalOrigin;
        _country = country;
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

    public double getWaterConsumptionCubicCentimeterPerGram() {
        return _waterConsumptionCubicCentimeterPerGram;
    }

    public void setWaterConsumptionCubicCentimeterPerGram(double waterConsumptionCubicCentimeterPerGram) {
        _waterConsumptionCubicCentimeterPerGram = waterConsumptionCubicCentimeterPerGram;
    }

    public double getKilogramCO2EquivalentPerSquareMetre() {
        return _kilogramCO2EquivalentPerSquareMetre;
    }

    public void setKilogramCO2EquivalentPerSquareMetre(double kilogramCo2EquivalentPerSquareMetre) {
        _kilogramCO2EquivalentPerSquareMetre = kilogramCo2EquivalentPerSquareMetre;
    }

    public FabricAnimalOriginEntity getFabricAnimalOrigin() {
        return _fabricAnimalOrigin;
    }

    public void setFabricAnimalOrigin(FabricAnimalOriginEntity fabricAnimalOriginId) {
        _fabricAnimalOrigin = fabricAnimalOriginId;
    }

    public CountryEntity getCountry() {
        return _country;
    }

    public void setCountry(CountryEntity countryId) {
        _country = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FabricEntity that = (FabricEntity) o;
        return Double.compare(
                _waterConsumptionCubicCentimeterPerGram,
                that._waterConsumptionCubicCentimeterPerGram
        ) == 0 &&
                Double.compare(_kilogramCO2EquivalentPerSquareMetre, that._kilogramCO2EquivalentPerSquareMetre) == 0 &&
                Objects.equals(_id, that._id) && Objects.equals(_name, that._name) &&
                Objects.equals(_fabricAnimalOrigin, that._fabricAnimalOrigin) &&
                Objects.equals(_country, that._country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                _id,
                _name,
                _waterConsumptionCubicCentimeterPerGram,
                _kilogramCO2EquivalentPerSquareMetre,
                _fabricAnimalOrigin,
                _country
        );
    }
}
