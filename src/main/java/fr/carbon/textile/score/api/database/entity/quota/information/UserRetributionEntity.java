package fr.carbon.textile.score.api.database.entity.quota.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "UserRetribution")
@Table(name = "`UserRetribution`", schema = "`QuotaInformation`", catalog = "postgres")
public class UserRetributionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`QuotaGains`", nullable = false)
    private int _quotaGains;
    @Basic
    @Column(name = "`Retribution`", nullable = false)
    private String _retribution;

    public UserRetributionEntity() {
    }

    public UserRetributionEntity(int quotaGains, String retribution) {
        _quotaGains = quotaGains;
        _retribution = retribution;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getQuotaGains() {
        return _quotaGains;
    }

    public void setQuotaGains(int quotaGains) {
        _quotaGains = quotaGains;
    }

    public String getRetribution() {
        return _retribution;
    }

    public void setRetribution(String punishment) {
        _retribution = punishment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRetributionEntity that = (UserRetributionEntity) o;
        return Objects.equals(_id, that._id) &&
                _quotaGains == that._quotaGains &&
                Objects.equals(_retribution, that._retribution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _quotaGains, _retribution);
    }
}
