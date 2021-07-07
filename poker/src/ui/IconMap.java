package poker.src.ui;

import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Image;

import poker.src.logic.Suit;
import poker.src.logic.CardNumber;
import java.net.URL;


public class IconMap {
    private static IconMap instance = new IconMap();

    private HashMap<String, Icon> theMap;

    private IconMap() {
        String key;
        theMap = new HashMap<>();
        String resource = "";
        for(Suit s : Suit.values()) {
            for(CardNumber n: CardNumber.values()) {
                key = n.toString()+s.toString();
                resource = "poker/assets/"+ key +".png";
                URL res = getClass().getClassLoader().getResource(resource);
                ImageIcon icon = new ImageIcon(res);
                Image image = icon.getImage(); // transform it 
                Image newimg = image.getScaledInstance(40, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                icon = new ImageIcon(newimg);
                theMap.put(key, icon);
            }
        }
    }

    public static IconMap getInstance(){
        if(instance == null) {
            instance = new IconMap();
        }
        return instance;
     }

    public Icon get(String key) {
        return theMap.get(key);
    }

}