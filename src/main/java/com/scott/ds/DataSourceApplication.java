package com.scott.ds;

import com.scott.ds.aop.DynamicDataSourceAnnotationAdvisor;
import com.scott.ds.aop.DynamicDataSourceAnnotationInterceptor;
import com.scott.ds.register.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import(DynamicDataSourceRegister.class)
@MapperScan("com.scott.ds.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class DataSourceApplication {
    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }
    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class, args);
    }
}
