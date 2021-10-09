package org.acme;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/hello")
public class ExampleResource {

    @Inject
    Template test;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy Reactive";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/qute")
    public TemplateInstance helloQute() {
        return test.data("name", "abcdef");
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/calc/{pow}")
    public BigDecimal calc(@PathParam("pow") int pow) {
        BigDecimal tmp = BigDecimal.valueOf(1.234567756735467456734567356);
        tmp = tmp.pow(pow).divide(tmp).divide(tmp);
        return tmp;
    }

    private static void generatePDFFromHTML(String filename) {
//        Document document = new Document();
//        PdfWriter writer = PdfWriter.getInstance(document,
//                new FileOutputStream("src/output/html.pdf"));
//        document.open();
//        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//                new FileInputStream(filename));
//        document.close();
    }
}