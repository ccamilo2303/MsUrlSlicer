package com.farmu.MsUrlSlicer.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UrlSlicerDaoImpl implements UrlSlicerDao{
    
    @Autowired
    @Qualifier("JdbcTemplateUrlSlicer")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplateOne;
    
    @Override
    public void saveUrlSlicer(String originalUrl, String shortUrl) {
        String sql = "insert into url_slicer(original_url, short_url, date_creation) values (:originalUrl, :shortUrl, now())";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("originalUrl", originalUrl);
        params.put("shortUrl", shortUrl);
        namedParameterJdbcTemplateOne.update(sql, params);
    }
    
    @Override
    public String queryShortUrl(String shortUrl) {
        try{
            String sql = "select original_url from url_slicer where short_url = :short_url";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("short_url", shortUrl);
            return namedParameterJdbcTemplateOne.queryForObject(sql, params, String.class);
        } catch (EmptyResultDataAccessException e) {
            return "";
        }
    }
    
}
