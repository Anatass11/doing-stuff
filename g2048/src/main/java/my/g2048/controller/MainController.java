package my.g2048.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import my.g2048.services.FieldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class MainController {

    private final FieldService service;

    @GetMapping("/state")
    @Operation(summary = "Получение поля игры")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный запрос")
    })
    public String getInfo() {
        return service.getField().toString();
    }

    @GetMapping("/init")
    @Operation(summary = "Получение поля игры")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный запрос")
    })
    public String setField() {
        return service.init().toString();
    }

    @GetMapping("/moveR")
    @Operation(summary = "Получение поля игры")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный запрос")
    })
    public String moveRight() {
        return service.moveRight().toString();
    }

    @GetMapping("/moveL")
    @Operation(summary = "Получение поля игры")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный запрос")
    })
    public String moveLeft() {
        return service.moveLeft().toString();
    }

    @GetMapping("/moveU")
    @Operation(summary = "Получение поля игры")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный запрос")
    })
    public String moveUp() {
        return service.moveUp().toString();
    }

    @GetMapping("/moveD")
    @Operation(summary = "Получение поля игры")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный запрос")
    })
    public String moveDown() {
        return service.moveDown().toString();
    }

}
