package com.pedromcarrion.hexagonalsample.infrastructure.repository.ad;

import com.pedromcarrion.hexagonalsample.domain.ad.Ad;
import com.pedromcarrion.hexagonalsample.domain.ad.AdId;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Optional;

public class PostgreAdRepository implements AdRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PostgreAdRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Ad> find(AdId adId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", adId.asString());

        try {
            Ad ad = jdbcTemplate.queryForObject(
                    "SELECT id, title, status FROM ads WHERE id = :id",
                    mapSqlParameterSource,
                    mapResultSetToAd()
            );
            return Optional.of(ad);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return Optional.empty();
        }
    }

    private RowMapper<Ad> mapResultSetToAd() {
        return (rs, index) -> {
            AdId adId = new AdId(rs.getString("id"));
            String title = rs.getString("title");
            return new Ad(adId, title);
        };
    }

    @Override
    public void save(Ad ad) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", ad.getId().asString());
        mapSqlParameterSource.addValue("title", ad.getTitle());
        mapSqlParameterSource.addValue("status", ad.getStatus().toString());
        jdbcTemplate.update(
                "INSERT INTO ads (id, title, status) " +
                        "VALUES (:id, :title, :status) " +
                        "ON CONFLICT(id) DO " +
                        "UPDATE SET status = :status ",
                mapSqlParameterSource
        );
    }
}
