
package com.mycompany.invoise.invoiseweb.api;

import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/invoice")
public class InvoiceResource {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }



    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        System.out.println("La methode get a été invoqué" );
       return   invoiceService.getInvoiceByNumber(number);

    }

    @GetMapping
    public Iterable<Invoice> list() {
        System.out.println("La methode list a été invoqué" );
        return invoiceService.getInvoiceList();
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        System.out.println("La methode create a été invoqué" );

        return invoiceService.createInvoice(invoice);
    }

}
