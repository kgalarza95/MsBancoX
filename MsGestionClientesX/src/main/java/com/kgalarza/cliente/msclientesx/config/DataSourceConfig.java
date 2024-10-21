package com.kgalarza.cliente.msclientesx.config;

import com.kgalarza.cliente.msclientesx.util.EncryptionUtil;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author usuario
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String encryptedPassword;

    @Bean
    public DataSource dataSource() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);

        
        String decryptedPassword = EncryptionUtil.decrypt(encryptedPassword);
        dataSource.setPassword(decryptedPassword);

        return dataSource;
    }
}
