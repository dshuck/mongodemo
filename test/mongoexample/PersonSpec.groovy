package mongoexample

import spock.lang.*


/**
 * Created by b032596 on 9/3/2014.
 */
class PersonSpec extends Specification {

    def "load person"()  {
        given:

        when:
        Person person = new Person( 'Dave', 21 )
        person.id = 123
        person.things = [ new Thing( 'foo' ), new Thing( 'bar' ) ]

        then:
        assert person.toString() == 'Person [id=123, name=Dave, age=21]'
        assert person.things[1].name == 'bar'


    }


}
