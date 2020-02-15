package pl.wk.teai_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Response response;

    @Autowired
    public Controller( Response response ) {
        this.response = response;
    }

    @GetMapping
    public String getResponseHTML() {
        StringBuilder stringBuilder = new StringBuilder();
        response.getResponseHTML(stringBuilder);
        return stringBuilder.toString();
    }
}
