package com.zymr.MovieManagement.entity;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "movies")
@AllArgsConstructor
public class Movie {


//    id: string (UUID or auto-generated)
//● title: string (required)
//● director: string
//● releaseYear: number (e.g., 1994)
//● genre: string
//● rating: number (1 to 10)

    @Id
    private String id;

    @NonNull
    private String title;

    private String director;

    private int releaseYear;

    private String genre;

    private double rating;


    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';

    }
}
