package br.com.aulabancosqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("R. Itapicuru, 167 - Jardim Pres. Dutra, Guarulhos");
        cricket.add("Av. Florianópolis, 371 - São João, Guarulhos");
        cricket.add("R. Jati, 266 - Cidade Jardim Cumbica, Guarulhos");
        cricket.add("R. Prof. Antônio de Castro Lopes, 1421 - Ermelino Matarazzo, SP");
        cricket.add("R. Manuel da Silva, 210 - Vila Buenos Aires, São Paulo");

        List<String> servicos = new ArrayList<String>();
        servicos.add("CLAREAMENTO DENTAL");
        servicos.add("IMPLANTE DENTÁRIO");
        servicos.add("TRATAMENTO DE CÁRIE");
        servicos.add("TRATAMENTO DE GENGIVITE");
        servicos.add("RESTAURAÇÕES");

        expandableListDetail.put("Consultórios", cricket);
        expandableListDetail.put("Serviços", servicos);
        return expandableListDetail;
    }
}
