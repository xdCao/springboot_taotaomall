package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by xdcao on 2017/6/8.
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {



}
