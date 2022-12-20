package com.farmu.MsUrlSlicer.dao;


public interface UrlSlicerDao {
    /**
     * @param originalUrl
     * @param shortUrl 
     */
    public void saveUrlSlicer(String originalUrl, String shortUrl);
    
    /**
     * @param shortUrl
     * @return 
     */
    public String queryShortUrl(String shortUrl);
    
}
