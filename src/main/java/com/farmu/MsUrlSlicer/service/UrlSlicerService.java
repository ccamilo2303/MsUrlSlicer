package com.farmu.MsUrlSlicer.service;

/**
 * @author Cristian Camilo Beltrán
 * @since  19/12/2022
 */
public interface UrlSlicerService {
   
    /**
     * @param url
     * @return 
     */
    public String generateSlicer(String url) throws Exception;
    
    /**
     * @param shortUrl
     * @return 
     */
    public String queryShortUrl(String shortUrl);
    
}
