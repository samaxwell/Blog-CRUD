package com.blog.crud;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@EnableJpaAuditing
@SpringBootApplication
public class BlogCrudApplication {

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BlogCrudApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("local.server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if ("".equals(contextPath) || contextPath == null) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}{}\n\t" +
                "External: \t{}://{}:{}{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol, serverPort, contextPath,
            protocol, hostAddress, serverPort, contextPath,
            env.getActiveProfiles());
    }


}
