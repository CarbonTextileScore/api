package fr.carbon.textile.score.api.database.entity.training.information;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity(name = "Training")
@Table(name = "`Training`", schema = "`TrainingInformation`", catalog = "postgres")
public class TrainingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`Video`", nullable = false)
    private String _video;
    @Basic
    @Column(name = "`Stars`", nullable = false)
    private int _stars;
    @Basic
    @Column(name = "`UserFullName`", nullable = false)
    private String _userFullName;
    @Basic
    @Column(name = "`UserPicture`", nullable = false)
    private byte[] _userPicture;
    @OneToOne
    @JoinColumn(name = "`CategoryId`", nullable = false)
    private VideoCategoryEntity _videoCategory;

    public TrainingEntity() {
    }

    public TrainingEntity(
            String name,
            String video,
            int stars,
            String userFullName,
            byte[] userPicture,
            VideoCategoryEntity videoCategory
    ) {
        this._name = name;
        this._video = video;
        this._stars = stars;
        this._userFullName = userFullName;
        this._userPicture = userPicture;
        this._videoCategory = videoCategory;
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

    public String getVideo() {
        return _video;
    }

    public void setVideo(String video) {
        this._video = video;
    }

    public VideoCategoryEntity getVideoCategory() {
        return _videoCategory;
    }

    public void setVideoCategory(VideoCategoryEntity categoryId) {
        this._videoCategory = categoryId;
    }

    public int getStars() {
        return _stars;
    }

    public void setStars(int stars) {
        this._stars = stars;
    }

    public String getUserFullName() {
        return _userFullName;
    }

    public void setUserFullName(String userFullName) {
        this._userFullName = userFullName;
    }

    public byte[] getUserPicture() {
        return _userPicture;
    }

    public void setUserPicture(byte[] userPicture) {
        this._userPicture = userPicture;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingEntity that = (TrainingEntity) o;
        return _stars == that._stars &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_video, that._video) &&
                Objects.equals(_userFullName, that._userFullName) &&
                Objects.equals(_videoCategory, that._videoCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _video, _stars, _userFullName, _videoCategory);
    }
}
