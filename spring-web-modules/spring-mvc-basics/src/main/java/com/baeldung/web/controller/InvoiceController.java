package com.baeldung.web.controller;

import com.baeldung.model.Employee;
import com.baeldung.model.Invoice;
import com.baeldung.services.InvoiceTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller

public class InvoiceController {

    private final InvoiceTaxService invoiceTaxService;

    @Autowired
    public InvoiceController(InvoiceTaxService invoiceTaxService) {
        this.invoiceTaxService = invoiceTaxService;
    }


    Map<Long, Invoice> invoiceMap = new HashMap<>();

    @ModelAttribute("invoices")
    public void initEmployees() {
        invoiceMap.put(1L, new Invoice(1L, "Tornillos", 100, 12));
        invoiceMap.put(2L, new Invoice(2L, "Maquinaria", 150, 13));
        invoiceMap.put(3L, new Invoice(3L, "Ordenadores", 200, 10));
    }


    @RequestMapping(value = "invoice", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("invoiceHome", "invoice", new Invoice());
    }

    @RequestMapping(value = "/showInvoices", method = RequestMethod.GET)
    public ModelAndView showAllInvoices() {
        ModelAndView modelAndView = new ModelAndView("invoicesList");
        Map<Long, Double> finalAmounts = new HashMap<>();

        // Calcula el monto final para cada factura y lo almacena en el mapa
        for (Invoice invoice : invoiceMap.values()) {
            double finalAmount = invoiceTaxService.calculateFinalAmount(invoice.getAmount(), invoice.getRetentionPercentage());
            finalAmounts.put(invoice.getId(), finalAmount);
        }

        // Añade la lista de facturas y los montos finales al objeto ModelAndView
        modelAndView.addObject("invoices", invoiceMap.values());
        modelAndView.addObject("finalAmounts", finalAmounts);
        return modelAndView;
    }

    @RequestMapping(value = "/invoice/edit/{Id}", method = RequestMethod.GET)
    public ModelAndView editInvoiceForm(@PathVariable final Long Id) {
        Invoice invoice = invoiceMap.get(Id);
        if (invoice == null) {
            return new ModelAndView("redirect:/errorPage");
        }
        ModelAndView modelAndView = new ModelAndView("editInvoice");
        modelAndView.addObject("invoice", invoice);
        return modelAndView;
    }



    @RequestMapping(value = "/addInvoice", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("invoice") final Invoice invoice, final BindingResult result, final ModelMap model) {
        if (result.hasErrors()) {
            return "invoiceHome";
        }
        // Calcular el nuevo ID
        Long newId = invoiceMap.keySet().stream().max(Long::compare).orElse(0L) + 1;

        // Asignar el nuevo ID a la factura
        invoice.setId(newId);

        // Calcular el monto después de aplicar el porcentaje de retención
        double finalAmount = invoiceTaxService.calculateFinalAmount(invoice.getAmount(), invoice.getRetentionPercentage());
        // Agregar atributos al modelo
        model.addAttribute("id", invoice.getId());
        model.addAttribute("concept",invoice.getConcept());
        model.addAttribute("amount", invoice.getAmount());
        model.addAttribute("retentionPercentage", invoice.getRetentionPercentage());
        model.addAttribute("finalAmount", finalAmount);

        invoiceMap.put(invoice.getId(), invoice);

        return "invoiceView";
    }


    @RequestMapping(value = "/invoice/update", method = RequestMethod.POST)
    public String updateInvoice(@Valid @ModelAttribute("invoice") final Invoice invoice, final BindingResult result, final ModelMap model) {
        if (result.hasErrors()) {
            return "editInvoice";
        }
        // Asumiendo que ya validaste y preparaste el objeto 'invoice'
        invoiceMap.put(invoice.getId(), invoice); // Actualiza la factura existente
        return "redirect:/showInvoices"; // Redirige a la vista de lista de facturas
    }



    @PostMapping("/invoice/delete/{Id}")
    public String deleteInvoice(@PathVariable("Id") Long id) {
        invoiceMap.remove(id);
        return "redirect:/showInvoices";
    }


}
