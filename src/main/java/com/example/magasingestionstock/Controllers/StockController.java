package com.example.magasingestionstock.Controllers;

import com.example.magasingestionstock.Entities.Stock;
import com.example.magasingestionstock.Entities.Stock;
import com.example.magasingestionstock.Services.StockService;
import com.example.magasingestionstock.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stock")
@RestController
public class StockController {
@Autowired
StockService stockService;
        


    @GetMapping("/getAll")
    public List<Stock> getAll() {
return stockService.retrieveAllStock();
    }
    @PostMapping ("/addStock")
    public Stock addStock (@RequestBody Stock e) {
        return stockService.addStock(e);
    }

    @PutMapping ("/updateStock")
    public Stock updateStock (@RequestBody Stock e) {
        return stockService.updateStock(e);
    }

    @GetMapping("/getStock/{id}")
    public Stock retrieveStock(@PathVariable(value="id") Long id) {
        return stockService.retrieveStock(id);

    }

    @DeleteMapping("/deleteStock/{id}")
    public void removeStock(@PathVariable(value ="id") Long id) {
        stockService.deleteStock(id);
    }


}
