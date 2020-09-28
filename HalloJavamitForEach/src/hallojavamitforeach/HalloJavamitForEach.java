/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hallojavamitforeach;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lisa
 */
public class HalloJavamitForEach {

    private List<String> liste = new ArrayList<>();

    public static void main(String[] args) {
        HalloJavamitForEach he = new HalloJavamitForEach();
        for (int i = 0; i < he.liste.size(); i++) {
            System.out.println(he.liste.get(i));
        }

        he.liste.forEach((String s) -> System.out.println());

    }

}
