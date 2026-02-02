package org.example.weather_app.Repository;

import org.example.weather_app.Entity.FavoriteCity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<FavoriteCity, Long> {
    Optional<FavoriteCity> findByCityName(String cityName);
}
