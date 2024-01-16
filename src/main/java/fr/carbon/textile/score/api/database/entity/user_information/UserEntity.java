package fr.carbon.textile.score.api.database.entity.user_information;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "`User`", schema = "`UserInformation`", catalog = "postgres")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`", nullable = false)
    private int _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`Lastname`", nullable = false)
    private String _lastname;
    @OneToOne
    @JoinColumn(name = "`CityId`", nullable = false)
    private CityEntity _city;
    @Basic
    @Column(name = "`Birthdate`", nullable = false)
    private Timestamp _birthdate;
    //TODO Change to OneToOne
    @Basic
    @Column(name = "`QuotaId`", nullable = false)
    private int _quotaId;
    @Basic
    @Column(name = "`ProfilePicture`", nullable = false)
    private byte[] _profilePicture;

    public UserEntity() {
    }

    public UserEntity(
            String name, String lastname, CityEntity city, Timestamp birthdate, int quotaId, byte[] profilePicture
    ) {
        _name = name;
        _lastname = lastname;
        _city = city;
        _birthdate = birthdate;
        _quotaId = quotaId;
        _profilePicture = profilePicture;
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

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String lastname) {
        _lastname = lastname;
    }

    public CityEntity getCity() {
        return _city;
    }

    public void setCity(CityEntity city) {
        _city = city;
    }

    public Timestamp getBirthdate() {
        return _birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        _birthdate = birthdate;
    }

    public int getQuotaId() {
        return _quotaId;
    }

    public void setQuotaId(int quotaId) {
        _quotaId = quotaId;
    }

    public byte[] getProfilePicture() {
        return _profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        _profilePicture = profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return _id == that._id &&
                Objects.equals(_city, that._city) &&
                _quotaId == that._quotaId &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_lastname, that._lastname) &&
                Objects.equals(_birthdate, that._birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _lastname, _city, _birthdate, _quotaId);
    }
}
