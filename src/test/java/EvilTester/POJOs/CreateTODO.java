package EvilTester.POJOs;

import java.util.HashMap;
import java.util.Map;

public class CreateTODO {

    // This class is for creatin a new TODO
    public static Map<String, Object> createTODOs(String title, Boolean doneStatus, String description){
        Map<String, Object> myNewTODO = new HashMap<>();
        myNewTODO.put("title",title);
        myNewTODO.put("doneStatus",doneStatus);
        myNewTODO.put("description",description);
        return myNewTODO;
    }
}
