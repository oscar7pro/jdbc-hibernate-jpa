
package com.mycompany.invoise.invoice.api;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    private static final String URL_CUSTOMER = "/customer/";
    private static final String BASE_URL = "http://customer-service";
    private static final String URL_ADDRESS = "/address/";
    @Autowired
    private InvoiceServiceInterface invoiceService;

 /*   @Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private WebClient.Builder webClientBuilder;


/*    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        System.out.println("La methode get a été invoqué" );
       Invoice invoice = invoiceService.getInvoiceByNumber(number);
      final Customer customer =restTemplate.getForObject(URL_CUSTOMER_COMPLETE + invoice.getIdCustomer(), Customer.class);
      final Address address =restTemplate.getForObject(URL_CUSTOMER_COMPLETE + customer.getAddress().getId(), Address.class);
      customer.setAddress(address);
      invoice.setCustomer(customer);
       return  invoice;

    }*/
@GetMapping("/{id}")
public Invoice get(@PathVariable("id") String number) {
    System.out.println("La methode get a été invoqué" );
    Invoice invoice = invoiceService.getInvoiceByNumber(number);

    final WebClient webClient = webClientBuilder.baseUrl(BASE_URL).build();

    final Customer customer =webClient.get().uri(URL_CUSTOMER + invoice.getIdCustomer())
            .retrieve()
            .bodyToMono(Customer.class)
            .block();

    final Address address =webClient.get().uri(URL_ADDRESS + customer.getAddress().getId())
            .retrieve()
            .bodyToMono(Address.class)
            .block();
    customer.setAddress(address);
    invoice.setCustomer(customer);
    return  invoice;

}
    @GetMapping
    public ParallelFlux<Invoice> list() {
        System.out.println("La methode list a été invoqué" );
        List<Mono<Invoice>> invoiceMonos = new ArrayList<>();
        final WebClient webClient = webClientBuilder.baseUrl(BASE_URL).build();

        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        invoices.forEach(invoice ->
           invoiceMonos.add(webClient.get()
                    .uri(URL_CUSTOMER + invoice.getIdCustomer())
                    .retrieve()
                    .bodyToMono(Customer.class)
                    .map(customer -> {
                        invoice.setCustomer(customer);
                        return invoice;
                    }))
            /*invoice.setCustomer(
                    restTemplate.getForObject(URL_CUSTOMER +invoice.getIdCustomer(), Customer.class));*/
        );
        final Flux<Invoice> invoiceFlux = Flux.concat(invoiceMonos);
        return invoiceFlux.parallel().runOn(Schedulers.elastic());
    }

/*    @GetMapping
    public Iterable<Invoice> list() {
        System.out.println("La methode list a été invoqué" );
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        invoices.forEach(invoice -> {
            invoice.setCustomer(
                    restTemplate.getForObject(URL_CUSTOMER +invoice.getIdCustomer(), Customer.class));
        });
          return invoices;
    }*/
/*

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        System.out.println("La methode create a été invoqué" );

        return invoiceService.createInvoice(invoice);
    }
*/

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
/*
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/
}
