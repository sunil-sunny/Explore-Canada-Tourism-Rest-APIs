/*
 * package com.ExploreCanada.packages.config; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.Profile; import
 * org.springframework.web.servlet.config.annotation.CorsRegistry; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * 
 * @Configuration
 * 
 * @Profile("development") public class CorsConfig implements WebMvcConfigurer {
 * 
 * @Override public void addCorsMappings(CorsRegistry registry) {
 * System.out.println("cors getting enabled");
 * registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
 * .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
 * .exposedHeaders("security"); } }
 */