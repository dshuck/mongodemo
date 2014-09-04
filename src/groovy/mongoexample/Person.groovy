package mongoexample

/**
 * Created by b032596 on 9/3/2014.
 */

class Person {

    String id
    String name
    Integer age
    Thing[] things

    Person( String name, Integer age ) {
        this.name = name
        this.age = age
    }

    @Override
    String toString() {
        'Person [id=' + id + ', name=' + name + ', age=' + age + ']'
    }
}


