package by.gavrilik.restApi.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "ads")
@Getter
@Setter
@ToString
public class Ads {

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "image_url")
    private String imageUrl;

}
