package tel.ran.group.cvbank.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoAuditing/*
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Value("${spring.data.mongodb.host}")
    private String databaseHost;

    @Value("${spring.data.mongodb.port}")
    private Integer databasePort;

    @Override
    protected String getDatabaseName() {
        return this.databaseName;
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        return new MongoClient(databaseHost, databasePort);
    }

}

*/


//@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    public MongoClient mongoClient() {
        MongoClientURI mongoClientURI = new MongoClientURI("");
        return new MongoClient(mongoClientURI);
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
}