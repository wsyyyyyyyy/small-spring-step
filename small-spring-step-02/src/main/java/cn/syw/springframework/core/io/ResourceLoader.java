package cn.syw.springframework.core.io;

public interface ResourceLoader {
    Resource getResource(String location);
    String ClASSPATH_URL_PREFIX = "classpath:";
}
