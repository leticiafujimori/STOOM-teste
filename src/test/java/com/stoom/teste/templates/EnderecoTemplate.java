package com.stoom.teste.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.stoom.teste.model.Endereco;

public class EnderecoTemplate implements TemplateLoader {
    public static final String VALIDO_NUMBER_ATUALIZADO = "valido_number_atualizado";
    public static final String VALIDO = "valido";

    @Override
    public void load() {
        Fixture.of(Endereco.class)
                .addTemplate(VALIDO, new Rule() {{
                    add("id", 1L);
                    add("streetName", "Nome da rua");
                    add("number", 1234);
                    add("complement", "Complemento");
                    add("neighbourhood", "Bairro");
                    add("city", "Cidade");
                    add("state", "Estado");
                    add("country", "País");
                    add("zipcode", "12345-678");
                    add("latitude", "Latitude");
                    add("longitude", "Longitude");

                }})
                .addTemplate(VALIDO_NUMBER_ATUALIZADO).inherits(VALIDO, new Rule() {{
                    add("number", 567);
                }});
    }
}
