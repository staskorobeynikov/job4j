package ru.job4j.magnet;

import java.io.File;
import java.util.List;

public class Application {

    public int parse(int generate) {
        Config config = new Config();
        StoreSQL str = new StoreSQL(config.init("url"));
        str.generate(generate);
        List<Entry> result = str.load();
        StoreXML st = new StoreXML(new File(config.get("fileXML")));
        st.save(result);
        ConvertXSQT cont = new ConvertXSQT(new File(config.get("fileXML")),
                new File(config.get("convertFileXML")), new File(config.get("schemaXSTL")));
        cont.convert();
        Parser parser = new Parser();
        return parser.parseSax(new File(config.get("convertFileXML")));
    }

    public static void main(String[] args) {
        Application application = new Application();
        System.out.println(application.parse(10000));
    }
}
