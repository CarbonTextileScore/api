package fr.carbon.textile.score.api.database.entity.quota_information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "RetributionRequirement")
@Table(name = "`RetributionRequirement`", schema = "`QuotaInformation`", catalog = "postgres")
public class RetributionRequirementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`MinAge`", nullable = false)
    private int _minAge;
    @Basic
    @Column(name = "`MaxAge`", nullable = false)
    private int _maxAge;

    public RetributionRequirementEntity() {
    }

    public RetributionRequirementEntity(int minAge, int maxAge) {
        _minAge = minAge;
        _maxAge = maxAge;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public int getMinAge() {
        return _minAge;
    }

    public void setMinAge(int minAge) {
        _minAge = minAge;
    }

    public int getMaxAge() {
        return _maxAge;
    }

    public void setMaxAge(int maxAge) {
        _maxAge = maxAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetributionRequirementEntity that = (RetributionRequirementEntity) o;
        return _minAge == that._minAge && _maxAge == that._maxAge && Objects.equals(_id, that._id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _minAge, _maxAge);
    }
}
