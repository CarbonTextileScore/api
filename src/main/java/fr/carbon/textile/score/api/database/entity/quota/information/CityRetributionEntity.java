package fr.carbon.textile.score.api.database.entity.quota.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "CityRetribution")
@Table(name = "`CityRetribution`", schema = "`QuotaInformation`", catalog = "postgres")
public class CityRetributionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Retribution`", nullable = false)
    private String _retribution;
    @Basic
    @Column(name = "`TriggerPercentage`", nullable = false)
    private int _triggerPercentage;

    public CityRetributionEntity() {
    }

    public CityRetributionEntity(String retribution, int triggerPercentage) {
        _retribution = retribution;
        _triggerPercentage = triggerPercentage;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public String getRetribution() {
        return _retribution;
    }

    public void setRetribution(String retribution) {
        _retribution = retribution;
    }

    public int getTriggerPercentage() {
        return _triggerPercentage;
    }

    public void setTriggerPercentage(int triggerPercentage) {
        _triggerPercentage = triggerPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityRetributionEntity that = (CityRetributionEntity) o;
        return _triggerPercentage == that._triggerPercentage &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_retribution, that._retribution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _retribution, _triggerPercentage);
    }
}
