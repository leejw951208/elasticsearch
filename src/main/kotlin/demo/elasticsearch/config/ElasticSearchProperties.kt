package demo.elasticsearch.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "elasticsearch")
class ElasticSearchProperties(
    private val host: String,
    private val port: Int
) {
    fun getHostAndPort(): String {
        return "$host:$port"
    }
}