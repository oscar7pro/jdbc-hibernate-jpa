
package com.mycompany.invoise.invoice.controller;

import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InvoiceControllerWeb {
/*
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }



    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {
        if(results.hasErrors()) {
            return "invoice-create-form";
        }

        Invoice invoice = new Invoice();
        invoice.setCustomer(invoice.getCustomer());
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceService.createInvoice(invoice);
        return "invoice-created";

    }*/
    
/*@RequestMapping(value="/invoice-home")
    public String displayHome(HttpServletRequest request ) {
        System.out.println("La methode invoise-home a été invoqué" );
        List<Invoice> invoices = invoiceService.getInvoiceList();
        request.setAttribute("invoiceListe", invoices);
        return  "index";

    }*//*


   */
/* @RequestMapping(value="/home")
    public ModelAndView  displayHome() {
        System.out.println("La methode invoise-home a été invoqué" );
        ModelAndView modelAndView = new ModelAndView("invoice-home");
        modelAndView.addObject("invoices",invoiceService.getInvoiceList());
        return  modelAndView;

    }*/


    @RequestMapping(value="/home")
    public String  displayHome(Model model) {
        System.out.println("La methode display home de customer a été invoqué" );
        return  "invoice-home";

    }

/* @RequestMapping(value="/{id}")
    public ModelAndView displayInvoice(@PathVariable("id") String number) {
        System.out.println("La methode invoise-home a été invoqué" );
        ModelAndView modelAndView = new ModelAndView("invoice-details");
        modelAndView.addObject("invoice", invoiceService.getInvoiceByNumber(number));

      //  List<Invoice> invoices = invoiceService.getInvoiceList();
        return  modelAndView;

    }*//*

   @RequestMapping(value="/{id}")
   public String displayInvoice(@PathVariable("id") String number, Model model) {
       System.out.println("La methode invoise-home a été invoqué" );
       model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));

       //  List<Invoice> invoices = invoiceService.getInvoiceList();
       return  "invoice-details";

   }

    @RequestMapping(value="/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        System.out.println("La methode add a été invoqué" );
        return  "invoice-create-form";
    }
   */
/* @RequestMapping(value="/create-form")
    public String displayInvoiceCreateForm(Model model) {
       model.addAttribute("invoice", new Invoice());
        System.out.println("La methode add a été invoqué" );
        return  "invoice-create-form";

    }*//*




*/
}
