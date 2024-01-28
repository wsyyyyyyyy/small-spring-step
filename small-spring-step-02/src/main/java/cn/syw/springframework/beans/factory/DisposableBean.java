package cn.syw.springframework.beans.factory;

public interface DisposableBean {

    void destroy() throws Exception;

}