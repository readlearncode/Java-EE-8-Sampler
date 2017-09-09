package com.readlearncode.reactive;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Path("reactive")
public class ReactiveJaxRs {

    BiFunction<Response, Response, String> concat = (x, y) -> x.readEntity(String.class) + y.readEntity(String.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testReactive() {

        CompletionStage<Response> cs1 = ClientBuilder.newClient()
                .target("http://localhost:8080/jax-rs-2-1/books")
                .request()
                .rx()
                .get();

        CompletionStage<Response> cs2 = ClientBuilder.newClient()
                .target("http://localhost:8080/jax-rs-2-1/books")
                .request()
                .rx()
                .get();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cs1.thenCombine(cs2, (r1, r2) -> r1.readEntity(String.class) + r2.readEntity(String.class)).thenAccept(System.out::println);

        return Response.noContent().build();
    }

}
