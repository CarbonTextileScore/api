package fr.carbon.textile.score.api.database.entity.quota.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Quota")
@Table(name = "`Quota`", schema = "`QuotaInformation`", catalog = "postgres")
public class QuotaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @OneToOne
    @JoinColumn(name = "`PunishmentRequirementId`", nullable = false)
    private RetributionRequirementEntity _punishmentRequirement;
    @Basic
    @Column(name = "`MaxQuotaQuarterly`", nullable = false)
    private int _maxQuotaQuarterly;

    public QuotaEntity() {
    }

    public QuotaEntity(RetributionRequirementEntity punishmentRequirement, int maxQuotaQuarterly) {
        _punishmentRequirement = punishmentRequirement;
        _maxQuotaQuarterly = maxQuotaQuarterly;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public RetributionRequirementEntity getPunishmentRequirement() {
        return _punishmentRequirement;
    }

    public void setPunishmentRequirement(RetributionRequirementEntity characteristicId) {
        _punishmentRequirement = characteristicId;
    }

    public int getMaxQuotaQuarterly() {
        return _maxQuotaQuarterly;
    }

    public void setMaxQuotaQuarterly(int maxQuotaQuarterly) {
        _maxQuotaQuarterly = maxQuotaQuarterly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuotaEntity that = (QuotaEntity) o;
        return _maxQuotaQuarterly == that._maxQuotaQuarterly &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_punishmentRequirement, that._punishmentRequirement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _punishmentRequirement, _maxQuotaQuarterly);
    }
}
