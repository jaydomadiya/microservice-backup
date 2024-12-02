package com.jay.RatingService.Entites;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("user_ratings")
public class Rating {

    @Id
    private String ratingId;

    private Integer userId;

    private Integer hotelId;

    private Integer rating;

    private String feedback;

}
