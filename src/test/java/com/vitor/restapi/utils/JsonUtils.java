import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonUtils {
    public static <T> T lerJsonComoObjeto(String caminho, Class<T> tipo) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("src/test/resources/" + caminho), tipo);
    }
}
