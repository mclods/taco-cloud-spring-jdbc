package com.mclods.taco_cloud_spring_jdbc.controllers;

import com.mclods.taco_cloud_spring_jdbc.domain.Ingredient;
import com.mclods.taco_cloud_spring_jdbc.domain.Ingredient.Type;
import com.mclods.taco_cloud_spring_jdbc.domain.Taco;
import com.mclods.taco_cloud_spring_jdbc.domain.TacoOrder;
import com.mclods.taco_cloud_spring_jdbc.services.IngredientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    private final IngredientService ingredientService;

    public DesignTacoController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = ingredientService.findAllIngredients();

        Type[] types = Type.values();
        for(Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterIngredientsByType(ingredients, type));
        }
    }

    @ModelAttribute("tacoOrder")
    public TacoOrder tacoOrder() {
        return new TacoOrder();
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "designForm";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute("tacoOrder") TacoOrder tacoOrder) {
        if(errors.hasErrors()) {
            return "designForm";
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterIngredientsByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(i -> i.getType() == type)
                .collect(Collectors.toList());
    }
}
