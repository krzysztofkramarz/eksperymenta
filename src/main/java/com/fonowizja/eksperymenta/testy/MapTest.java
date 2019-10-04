package com.fonowizja.eksperymenta.testy;


import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author krzysztof.kramarz+
 */

public class MapTest {

    @Test
    public void aaa() {

        //given
        List<String> expected = List.of("a", "b", "c");
        List<String> expected2 = List.of("d", "e", "f");
        List<String> expected3 = List.of("a", "b", "c", "d", "e", "f");
        // when
        ConcurrentMap<String, List<String>> topicPatternsForAlgorithms = new ConcurrentHashMap<>();
        topicPatternsForAlgorithms.put("a", List.of("a", "b", "c"));
        topicPatternsForAlgorithms.put("b", List.of("d", "e", "f"));
        topicPatternsForAlgorithms.put("c", List.of("g"));
        // then

        //to przejdzie, nie wyłapie że jest trzeci klucz
        assertThat(topicPatternsForAlgorithms.values()).contains(expected, expected2);


//            to nie przejdzie, bo mapa ma zawierać tylko dwie listy, a zawiera trzy
//        java.lang.AssertionError:
//        Expecting:
//        <[["a", "b", "c"], ["d", "e", "f"], ["g"]]>
//        to contain only:
//         <[["a", "b", "c"], ["d", "e", "f"]]>
//        but the following elements were unexpected:
//        <[["g"]]>
//        assertThat(topicPatternsForAlgorithms.values()).containsOnly(expected, expected2);

//            to nie przejdzie, bo mapa ma zawierać tylko dwa klucze, na dodatek sprawdzana jest kolejność
//        java.lang.AssertionError:
//        Expecting:
//      <[["a", "b", "c"], ["d", "e", "f"], ["g"]]>
//        to contain exactly (and in same order):
//      <[["a", "b", "c"], ["d", "e", "f"]]>
//        but some elements were not expected:
//      <[["g"]]>
//        assertThat(topicPatternsForAlgorithms.values()).containsExactly(expected, expected2);

//      to przejdzie, nie wylapie, że jest trzeci klucz "c"
        assertThat(topicPatternsForAlgorithms).containsValues(expected, expected2);

        //to nie przejdzie, bo mapa zawiera listy stringów, a nie stringi
        //ponizsza asercja zadziała, jak będzie tylko jedna lista w mapie
        //jesli jednak bedzie kilka kluczy z listami i wszystkie te wartości zgromadzimy w jednej liście, to nie prejdzie
//        java.lang.AssertionError:
//        Expecting:
//        <{"a"=["a", "b", "c"], "b"=["d", "e", "f"], "c"=["g"]}>
//        to contain value:
//        <["a", "b", "c", "d", "e", "f"]>
//        assertThat(topicPatternsForAlgorithms).containsValue(expected3);

//      to nie przejdzie oczywiscie, bo jest trzeci klucz
//        java.lang.AssertionError:
//        Expecting:
//        <{"a"=["a", "b", "c"], "b"=["d", "e", "f"], "c"=["g"]}>
//        to contain only following keys:
//         <["a", "b"]>
//        keys not found:
//         <[]>
//        and keys not expected:
//        <["c"]>
//        assertThat(topicPatternsForAlgorithms).containsOnlyKeys("a", "b");
    }


}