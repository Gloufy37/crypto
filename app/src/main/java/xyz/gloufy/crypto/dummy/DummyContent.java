package xyz.gloufy.crypto.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DummyContent {


    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();


    static {

        String [] names_algos = {"Caesar","Vigenère","Playfair","Hill","Homophonique (carré Polybe)","Transposition rectangulaire","DES"};
        for (int i = 1; i <= names_algos.length; i++) {
            addItem(createDummyItem(names_algos[i-1]));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static DummyItem createDummyItem(String name_algo) {
        return new DummyItem(name_algo);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String content;

        public DummyItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
