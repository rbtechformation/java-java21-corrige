package java25.ex01;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import java25.data.Data;
import java25.data.Person;
import org.junit.jupiter.api.Test;

/**
 * Exercice 02 - Filter, Map
 */
public class Optional_01_Test {
	
	class NotPresentException extends RuntimeException {
		
	}

    @Test
    public void test_optional_ifPresent() throws Exception {
    	
    	List<Person> persons = Data.buildPersonList(100);

        // TODO rechercher dans la liste ci-dessus la 1ère personne ayant 18 ans
        // TODO utiliser la méthode "findFirst"
        Optional<Person> optPerson = persons.stream().filter(p->p.getAge()==18).findFirst();
        assertThat(optPerson.isPresent(), is(true));
        
        // TODO afficher la personne en question si l'optional contient une personne
    }

    @Test
    public void test_optional_notPresent() throws Exception {
    	List<Person> persons = Data.buildPersonList(50);

        // TODO rechercher dans la liste ci-dessus la 1ère personne ayant 75 ans
        // TODO utiliser la méthode "findFirst"
        Optional<Person> optPerson = persons.stream().filter(p->p.getAge()==75).findFirst();
        assertThat(optPerson.isPresent(), is(false));
        
        // TODO si la personne n'existe pas, jeter une exception NotPresentException
        // TODO utiliser la méthode "orElseThrow"
        assertThrows(NotPresentException.class, () -> persons.stream().filter(p->p.getAge()==75).findFirst().orElseThrow(()->new NotPresentException()));

    }
}
