
package br.edu.exemplo.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.exemplo.calculadora.service.CalculadoraService;

@Controller
public class PaginaInicialController {

    private final CalculadoraService calculadoraService;

    public PaginaInicialController(
            CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @PostMapping("/calcular")
    public String calcular(
            @RequestParam String numero1,
            @RequestParam String numero2,
            @RequestParam String operacao,
            Model model) {

        model.addAttribute("numero1", numero1);
        model.addAttribute("numero2", numero2);
        model.addAttribute("operacao", operacao);

        try {
            double a = Double.parseDouble(numero1);
            double b = Double.parseDouble(numero2);

            if (!Double.isFinite(a) || !Double.isFinite(b)) {
                throw new NumberFormatException();
            }

            double resultado =
                calculadoraService.calcular(a, b, operacao);

            model.addAttribute("resultado", resultado);

        } catch (NumberFormatException ex) {
            model.addAttribute(
                "erro", "Informe dois números válidos."
            );

        } catch (IllegalArgumentException ex) {
            model.addAttribute("erro", ex.getMessage());
        }

        return "index";
    }
}
