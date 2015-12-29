package es;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.DisMaxQueryBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Desc:
 * Created by wanggen on 2015-12-09 上午9:34.
 */
public class EsClient {


    public static void main(String[] args) throws UnknownHostException, JsonProcessingException, ExecutionException, InterruptedException {


        Gson gson = new Gson();

        Client client = TransportClient.builder().build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));


        IndexResponse indexResponse = client.prepareIndex("sns", "comment")
                .setSource(gson.toJson(
                        ImmutableMap.of("id", "1", "user", "100101", "name", "王根", "content", "hello ok", "age", 23)
                )).setId(String.valueOf("wg".hashCode()))
                .get();

        System.out.println(indexResponse);


        DisMaxQueryBuilder multiQuery = disMaxQuery()
                .add(rangeQuery("age").from(20).to(40))
                .add(boolQuery());


        SearchResponse searchResponse = client
                .prepareSearch("sns")
                .setTypes("comment")
                .setQuery(multiQuery)
                .execute().actionGet();

        System.out.println(searchResponse);

    }



}
